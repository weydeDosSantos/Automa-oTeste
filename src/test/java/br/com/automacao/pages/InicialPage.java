package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.core.DSL;

public class InicialPage {

	DSL dsl = new DSL();

	
	public void selecionarCombo(String texto) {
		dsl.selecionarCombo("switch-version-select", texto);
	}
	
	public void botaoAddCliente() {
		dsl.clica(By.linkText("Add Record"));

	}
}
