package br.com.automacaoWeb.core;

import static br.com.automacaoWeb.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	/********* Click **********/

	public void clica(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarCheckBox(By by) {
		getDriver().findElement(by).click();

	}

	/********* Click **********/

	/********* Escreve **********/

	public void escreve(String id, String texto) {
		escreve(By.id(id), texto);
	}

	public void escreve(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	/********* Escreve **********/

	/********* Combo **********/

	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	/********* Combo **********/

	/********* Retornos **********/

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	/********* Retornos **********/

	/********* Esperas **********/

	public void espera(int tempo, By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public void espera2(int tempo, By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

	}

	/********* Esperas **********/

}
