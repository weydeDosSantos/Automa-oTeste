package br.com.automacao.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.automacao.core.BaseTest;
import br.com.automacao.pages.FormularioPage;
import br.com.automacao.pages.InicialPage;

public class AutomacaoTest extends BaseTest {

	InicialPage inicialPage = new InicialPage();
	FormularioPage formularioPage = new FormularioPage();

	@Test
	public void Desafio1() {

		inicialPage.selecionarCombo("Bootstrap V4 Theme");
		inicialPage.botaoAddCliente();
		formularioPage.nomeCliente("Teste Sicredi");
		formularioPage.sobreNome("Teste");
		formularioPage.nomeDoContato("weyde");
		formularioPage.telefone("51 9999-9999");
		formularioPage.enderecoLinha1("Av Assis Brasil, 3970");
		formularioPage.enderecoLinha2("Torre D");
		formularioPage.cidade("Porto Alegre");
		formularioPage.estado("RS");
		formularioPage.codigoPostal("91000-000");
		formularioPage.pais("Brasil");
		formularioPage.doEmpregador("Fixter");
		formularioPage.limiteCredito("200");
		formularioPage.salvar();
		formularioPage.esperaLink();
		Assert.assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list",
				formularioPage.mensagem());
	}

	@Test
	public void Desafio2() {

		inicialPage.selecionarCombo("Bootstrap V4 Theme");
		inicialPage.botaoAddCliente();
		formularioPage.nomeCliente("Teste Sicredi");
		formularioPage.sobreNome("Teste");
		formularioPage.nomeDoContato("weyde");
		formularioPage.telefone("51 9999-9999");
		formularioPage.enderecoLinha1("Av Assis Brasil, 3970");
		formularioPage.enderecoLinha2("Torre D");
		formularioPage.cidade("Porto Alegre");
		formularioPage.estado("RS");
		formularioPage.codigoPostal("91000-000");
		formularioPage.pais("Brasil");
		formularioPage.doEmpregador("Fixter");
		formularioPage.limiteCredito("200");
		formularioPage.salvar();
		formularioPage.esperaLink();
		formularioPage.clicarLink();
		inicialPage.procurarCliente("Teste Sicredi");
		formularioPage.esperaCheckBox();
		inicialPage.checkBox();
		inicialPage.botaoDeleta();
		Assert.assertEquals("Are you sure that you want to delete this 1 item?", inicialPage.obterTextoCaixaDialogo());
		inicialPage.botaoDeletaCaixaDialogo();
		inicialPage.esperaPopUp();
		Assert.assertEquals("Your data has been successfully deleted from the database.", inicialPage.obterTextoPopUp());
	}
}