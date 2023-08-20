grammar LA;

programa: declaracoes 'algoritmo' corpo 'fim_algoritmo';

declaracoes: decl_local_global*;

decl_local_global: declaracao_local | declaracao_global;

declaracao_local: 'declare' variavel | 'constante' IDENT ':' tipo_basico '=' valor_constante
                  | 'tipo' IDENT ':' tipo;

variavel: identificador (',' identificador)* ':' tipo;

identificador: ident1=IDENT ('.' idents+=IDENT)* dimensao;

dimensao: ('[' exp_aritmetica ']')*;

tipo: registro | tipo_estendido;

tipo_basico: 'literal' | 'inteiro' | 'real' | 'logico';

tipo_basico_ident: tipo_basico | IDENT;

tipo_estendido: (OP_PONTEIRO)? tipo_basico_ident;

valor_constante: CADEIA | NUM_INT | NUM_REAL | 'verdadeiro' | 'falso';

registro: 'registro' variavel* 'fim_registro';

declaracao_global: 'procedimento' IDENT '('(parametros)?')' declaracao_local* cmd* 'fim_procedimento'
                | 'funcao' IDENT '('(parametros)?')' ':' tipo_estendido declaracao_local* cmd* 'fim_funcao';

parametro: 'var'? identificador (',' identificador)* ':' tipo_estendido;

parametros: parametro (',' parametro)*;

corpo: (declaracao_local)* (cmd)*;

cmd: cmdLeia | cmdEscreva | cmdSe | cmdCaso | cmdPara | cmdEnquanto | cmdFaca 
    | cmdAtribuicao | cmdChamada | cmdRetorne;

cmdLeia: 'leia' '(' OP_PONTEIRO? identificador (',' OP_PONTEIRO? identificador)*')';

cmdEscreva: 'escreva' '(' expressao (',' expressao)* ')';

cmdSe: 'se' expressao 'entao' cmdsEntao+=cmd* ('senao' cmdsSenao+=cmd*)? 'fim_se';

cmdCaso: 'caso' exp_aritmetica 'seja' selecao ('senao' cmd*)? 'fim_caso';

cmdPara: 'para' IDENT '<-' expParaIni=exp_aritmetica 'ate' expParaFim=exp_aritmetica 'faca' cmd* 'fim_para';

cmdEnquanto: 'enquanto' expressao 'faca' cmd* 'fim_enquanto';

cmdFaca: 'faca' cmd* 'ate' expressao;

cmdAtribuicao: OP_PONTEIRO? identificador '<-' expressao;

cmdChamada: IDENT '(' expressao (',' expressao)* ')';

cmdRetorne: 'retorne' expressao;

selecao: item_selecao*;

item_selecao: constantes ':' cmd*;

constantes: numero_intervalo (',' numero_intervalo)*;

numero_intervalo: opUnarInic=OP_UNARIO? numInterIni=NUM_INT ('..' opUnarFim=OP_UNARIO? numInterFim=NUM_INT)?;

exp_aritmetica: termo1=termo (operadores+=('+' | '-') termos+=termo)*;

termo: fator1=fator (OP2 fatores+=fator)*;

fator: parcela1=parcela (OP3 parcelas+=parcela)*;

parcela: opUnar=OP_UNARIO? parcela_unario | parcela_nao_unario;

parcela_unario: OP_PONTEIRO? identificador | IDENT '('expressoes+=expressao (',' expressoes+=expressao)*')'
                | NUM_INT | NUM_REAL | '('expressaoParam=expressao')';

parcela_nao_unario: '&' identificador | CADEIA;

exp_relacional: expArit1=exp_aritmetica (op_relacional expArit2=exp_aritmetica)?;

expressao: termoLog1=termo_logico (op_logico1 termosLog+=termo_logico)*;

termo_logico: fatorLog1=fator_logico (op_logico2 fatoresLog+=fator_logico)*;

fator_logico: ('nao')? parcela_logica;

parcela_logica: exp_relacional | ('verdadeiro' | 'falso');

OP_UNARIO: '-';
//Operadores aritméticos
OP1: '+' | '-';
OP2:'*' | '/';
OP3: '%';

//Operadores logicos
op_logico1: 'ou';

op_logico2: 'e';

//Operadores relacionais
op_relacional: '='| '<>' | '<' | '>' | '<=' | '>=';

//Operador ponteiro
OP_PONTEIRO: '^';

 //Identificadores, nomes das variáveis
IDENT: ('a'..'z' | 'A'..'Z' | '_')('a'..'z'| 'A'..'Z' | '0'..'9' | '_')*;

//Números inteiros
NUM_INT: ('0'..'9')+;

//Números reais
NUM_REAL: ('0'..'9')+('.'('0'..'9')+)?;

//Cadeia de letras e caracteres entre aspas duplas
CADEIA: '"' ( ESC_SEQ | ~('"' | '\\' | '\n') )* '"';

//Sequência de escape para aspas duplas
fragment
ESC_SEQ:  '\\"' | '\\';

//Espaços em branco: pular linha, tabulação
WS: (' ' | '\n' | '\r' | '\t') {skip();};

//Comentários dentro do programa
COMENTARIO: '{' ( ~('\n') )*? '}' {skip();};

//Qualquer caractere que não faça parte do conjunto léxico
DESCONHECIDO: .+?;
