// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.la.semantico;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LaSemanticoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LaSemanticoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LaSemanticoParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(LaSemanticoParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(LaSemanticoParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(LaSemanticoParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(LaSemanticoParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(LaSemanticoParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(LaSemanticoParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(LaSemanticoParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(LaSemanticoParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(LaSemanticoParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(LaSemanticoParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(LaSemanticoParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(LaSemanticoParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(LaSemanticoParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(LaSemanticoParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(LaSemanticoParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(LaSemanticoParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(LaSemanticoParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(LaSemanticoParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(LaSemanticoParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(LaSemanticoParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(LaSemanticoParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(LaSemanticoParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(LaSemanticoParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(LaSemanticoParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(LaSemanticoParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(LaSemanticoParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(LaSemanticoParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(LaSemanticoParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(LaSemanticoParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(LaSemanticoParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(LaSemanticoParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(LaSemanticoParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(LaSemanticoParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(LaSemanticoParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(LaSemanticoParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(LaSemanticoParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(LaSemanticoParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(LaSemanticoParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(LaSemanticoParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(LaSemanticoParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(LaSemanticoParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(LaSemanticoParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#op_logico1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico1(LaSemanticoParser.Op_logico1Context ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#op_logico2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico2(LaSemanticoParser.Op_logico2Context ctx);
	/**
	 * Visit a parse tree produced by {@link LaSemanticoParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(LaSemanticoParser.Op_relacionalContext ctx);
}