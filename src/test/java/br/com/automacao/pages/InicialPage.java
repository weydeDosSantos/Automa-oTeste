package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.core.BasePage;

public class InicialPage extends BasePage {

	public void selecionarCombo(String texto) {
		selecionarCombo("switch-version-select", texto);
	}

	public void botaoAddCliente() {
		clica(By.linkText("Add Record"));

	}

	public void procurarCliente(String texto) {
		escreve(By.xpath("//input[@name='customerName']"), texto);
	}

	public void checkBox() {
		clicarCheckBox(By.xpath("//tbody/tr/td/input"));
	}

	public void botaoDeleta() {
		clica(By.xpath("//div[@class='floatL']/a"));
	}

	public void botaoDeletaCaixaDialogo() {
		clica(By.xpath("//*[@class='btn btn-danger delete-multiple-confirmation-button']"));

	}

	public String obterTextoCaixaDialogo() {
		return obterTexto(By.xpath("//p[@class='alert-delete-multiple-one']"));
	}

	public String obterTextoPopUp() {
		return obterTexto(By.xpath("//*[@data-growl='container']//p"));

	}

	public void esperaPopUp() {
		espera2(10, By.xpath("//*[@data-growl='container']//p"));
	}
}
