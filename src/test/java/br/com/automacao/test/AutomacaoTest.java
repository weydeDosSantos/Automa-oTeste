package br.com.automacao.test;

import static br.com.automacao.core.DriverFactory.getDriver;
import static br.com.automacao.core.DriverFactory.killDriver;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.automacao.core.DSL;
import br.com.automacao.pages.FormularioPage;
import br.com.automacao.pages.InicialPage;

public class AutomacaoTest {

	DSL dsl = new DSL();
	InicialPage inicPage = new InicialPage();
	FormularioPage formPage = new FormularioPage();

	@Before
	public void acessaPagina() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		getDriver().get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void fecharBrowser() {
		killDriver();
	}

	@Test
	public void test() {

		inicPage.selecionarCombo("Bootstrap V4 Theme");
		inicPage.botaoAddCliente();
		formPage.nomeCliente("Teste Sicredi");
		formPage.sobreNome("Teste");
		formPage.nomeDoContato("weyde");
		formPage.telefone("51 9999-9999");
		formPage.enderecoLinha1("Av Assis Brasil, 3970");
		formPage.enderecoLinha2("Torre D");
		formPage.cidade("Porto Alegre");
		formPage.estado("RS");
		formPage.codigoPostal("91000-000");
		formPage.pais("Brasil");
		formPage.doEmpregador("Fixter");
		formPage.limiteCredito("200");
		formPage.salvar();
		Assert.assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list",
				formPage.mensagem());
		System.out.println();
	}
}