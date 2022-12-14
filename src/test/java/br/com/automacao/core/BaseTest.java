package br.com.automacao.core;

import static br.com.automacao.core.DriverFactory.getDriver;
import static br.com.automacao.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Before
	public void acessaPagina() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		getDriver().get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		getDriver().manage().window().setSize(new Dimension(1200, 765));
	}

	@Rule
	public TestName testName = new TestName();

	@After
	public void fecharBrowser() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator
				+ testName.getMethodName() + "screenshot.jpg"));
		killDriver();
	}
}
