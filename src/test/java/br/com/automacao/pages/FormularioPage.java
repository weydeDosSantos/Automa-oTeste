package br.com.automacao.pages;

import org.openqa.selenium.By;

import br.com.automacao.core.DSL;

public class FormularioPage {

	DSL dsl = new DSL();

	public void nomeCliente(String nome) {
		dsl.escreve("field-customerName", nome);
	}

	public void sobreNome(String sobreNome) {
		dsl.escreve("field-customerName", sobreNome);
	}

	public void nomeDoContato(String nomeDoContato) {
		dsl.escreve("field-contactFirstName", nomeDoContato);
	}

	public void telefone(String fone) {
		dsl.escreve("field-phone", fone);
	}

	public void enderecoLinha1(String endereco) {
		dsl.escreve("field-addressLine1", endereco);
	}

	public void enderecoLinha2(String endereco) {
		dsl.escreve("field-addressLine2", endereco);
	}

	public void cidade(String cidade) {
		dsl.escreve("field-city", cidade);
	}

	public void estado(String estado) {
		dsl.escreve("field-state", estado);
	}

	public void codigoPostal(String postal) {
		dsl.escreve("field-postalCode", postal);
	}

	public void pais(String pais) {
		dsl.escreve("field-country", pais);
	}

	public void doEmpregador(String doEmpregador) {
		dsl.escreve("field-salesRepEmployeeNumber", doEmpregador);
	}

	public void limiteCredito(String credito) {
		dsl.escreve("field-creditLimit", credito);
	}

	public void salvar() {
		dsl.clica(By.id("form-button-save"));
	}
	
	public String mensagem () {
		return dsl.obterTexto(By.tagName("p"));
	}

}
