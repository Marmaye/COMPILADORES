// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.la.semantico;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LaSemanticoParser}.
 */
public interface LaSemanticoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LaSemanticoParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LaSemanticoParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(LaSemanticoParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(LaSemanticoParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(LaSemanticoParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(LaSemanticoParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(LaSemanticoParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(LaSemanticoParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(LaSemanticoParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(LaSemanticoParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(LaSemanticoParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(LaSemanticoParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(LaSemanticoParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(LaSemanticoParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(LaSemanticoParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(LaSemanticoParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(LaSemanticoParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(LaSemanticoParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(LaSemanticoParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(LaSemanticoParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(LaSemanticoParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(LaSemanticoParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(LaSemanticoParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(LaSemanticoParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(LaSemanticoParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(LaSemanticoParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(LaSemanticoParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(LaSemanticoParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(LaSemanticoParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(LaSemanticoParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(LaSemanticoParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(LaSemanticoParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(LaSemanticoParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(LaSemanticoParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LaSemanticoParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LaSemanticoParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(LaSemanticoParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(LaSemanticoParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(LaSemanticoParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(LaSemanticoParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(LaSemanticoParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(LaSemanticoParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(LaSemanticoParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(LaSemanticoParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(LaSemanticoParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(LaSemanticoParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(LaSemanticoParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(LaSemanticoParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(LaSemanticoParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(LaSemanticoParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(LaSemanticoParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(LaSemanticoParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(LaSemanticoParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(LaSemanticoParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(LaSemanticoParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(LaSemanticoParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(LaSemanticoParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(LaSemanticoParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(LaSemanticoParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(LaSemanticoParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(LaSemanticoParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(LaSemanticoParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(LaSemanticoParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(LaSemanticoParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(LaSemanticoParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(LaSemanticoParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(LaSemanticoParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(LaSemanticoParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(LaSemanticoParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(LaSemanticoParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(LaSemanticoParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(LaSemanticoParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(LaSemanticoParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(LaSemanticoParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(LaSemanticoParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(LaSemanticoParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(LaSemanticoParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(LaSemanticoParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(LaSemanticoParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(LaSemanticoParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(LaSemanticoParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(LaSemanticoParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(LaSemanticoParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(LaSemanticoParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(LaSemanticoParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(LaSemanticoParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#op_logico1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico1(LaSemanticoParser.Op_logico1Context ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#op_logico1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico1(LaSemanticoParser.Op_logico1Context ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#op_logico2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico2(LaSemanticoParser.Op_logico2Context ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#op_logico2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico2(LaSemanticoParser.Op_logico2Context ctx);
	/**
	 * Enter a parse tree produced by {@link LaSemanticoParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(LaSemanticoParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaSemanticoParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(LaSemanticoParser.Op_relacionalContext ctx);
}