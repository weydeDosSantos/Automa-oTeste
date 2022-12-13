package br.com.automacao.core;

import static br.com.automacao.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	public void clica(By by) {
		getDriver().findElement(by).click();

	}
	
	public void escreve(String id,String texto) {
		getDriver().findElement(By.id(id)).sendKeys(texto);
	}
	
	public void selecionarCombo(String id,String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public String obterTexto(By by) {
		return  getDriver().findElement(by).getText();
	}
}
