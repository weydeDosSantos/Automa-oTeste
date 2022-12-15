package br.com.automacaoWeb.pages;

import org.openqa.selenium.By;

import br.com.automacaoWeb.core.BasePage;

public class FormularioPage extends BasePage {

	public void nomeCliente(String nome) {
		escreve("field-customerName", nome);
	}

	public void sobreNome(String sobreNome) {
		escreve("field-contactLastName", sobreNome);
	}

	public void nomeDoContato(String nomeDoContato) {
		escreve("field-contactFirstName", nomeDoContato);
	}

	public void telefone(String fone) {
		escreve("field-phone", fone);
	}

	public void enderecoLinha1(String endereco) {
		escreve("field-addressLine1", endereco);
	}

	public void enderecoLinha2(String endereco) {
		escreve("field-addressLine2", endereco);
	}

	public void cidade(String cidade) {
		escreve("field-city", cidade);
	}

	public void estado(String estado) {
		escreve("field-state", estado);
	}

	public void codigoPostal(String postal) {
		escreve("field-postalCode", postal);
	}

	public void pais(String pais) {
		escreve("field-country", pais);
	}

	public void doEmpregador(String doEmpregador) {
		escreve("field-salesRepEmployeeNumber", doEmpregador);
	}

	public void limiteCredito(String credito) {
		escreve("field-creditLimit", credito);
	}

	public void salvar() {
		clica(By.id("form-button-save"));
	}

	public void clicarLink() {
		clica(By.linkText("Go back to list"));

	}

	public String mensagem() {
		return obterTexto(By.tagName("p"));
	}

	public void esperaLink() {
		espera(10, By.linkText("Go back to list"));
	}

	public void esperaCheckBox() {
		espera(10, By.xpath("//tbody/tr/td/input"));
	}

}
