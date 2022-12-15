package br.com.api.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.github.javafaker.Faker;

import br.com.api.core.BaseTeste;

public class ApiTest extends BaseTeste {
	
	static Faker aleatorio = new Faker();
	private static String CONTA_NAME = "conta" + System.nanoTime();
	private static Integer CONTA_ID ;
	private static String CONTA_CPF =  aleatorio.number().digits(11);


		@Test
		public void cpfPossuiRestricao() {
			given()
			.when()
				.get("restricoes/60094146012")
			.then()
				.statusCode(200)
				.body("mensagem",is("O CPF 60094146012 tem problema"));
		}
		
		@Test
		public void cpfNaoPossuiRestricao() {
			given()
			.when()
				.get("restricoes/"+CONTA_CPF)
			.then()
				.statusCode(204);
		}
	
		@Test
		public void deveCriarSimulacao() {
		CONTA_ID =	given()
			    .body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+", \"email\": \"email@email.com\", \"valor\": 1200, \"parcelas\": 3, \"seguro\": true}")	
			.when()
				.post("simulacoes")
			.then()
				.log().all()
				.statusCode(201)
				.extract().path("id");

			given()
			.when()
				.delete("simulacoes/"+CONTA_ID)
			.then()
				.statusCode(200);

		}
		
		@Test
		public void erroRegra() {
			given()
				.body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+", \"email\": \"\", \"valor\": 1200, \"parcelas\": 3, \"seguro\": true}")
			.when()
				.post("simulacoes")
			.then()
				.statusCode(400)
				.body("erros.email",is("E-mail deve ser um e-mail válido"));
		}
		
		@Test
		public void cpfExistente() {
			CONTA_ID =	given()
				.body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+", \"email\": \"email@email.com\", \"valor\": 1200, \"parcelas\": 3, \"seguro\": true}")	
			.when()
				.post("simulacoes")
			.then()
				.extract().path("id");
				
			given()
				.body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+",\"email\": \"email@email.com\", \"valor\": 1200,\"parcelas\": 3,\"seguro\": true}")
			.when()
				.post("/simulacoes")
			.then()
				.statusCode(400)
				.body("mensagem",is("CPF duplicado"));
			
			given()
			.when()
				.delete("simulacoes/"+CONTA_ID)
			.then()
				.log().all()
				.statusCode(200);
		}
		
		@Test
		public void alterarSimulacao() {
		CONTA_ID =	given()
				.body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+", \"email\": \"email@email.com\", \"valor\": 1200, \"parcelas\": 3, \"seguro\": true}")	
			.when()
				.post("simulacoes")
			.then()
				.extract().path("id");
			
			given()
				.body("{ \"nome\": \""+CONTA_NAME+" alterada\", \"cpf\": "+CONTA_CPF+",\"email\": \"tt@email.com\", \"valor\": 1200,\"parcelas\": 3,\"seguro\": true}")
			.when()
				.put("simulacoes/"+CONTA_CPF)
			.then()
				.statusCode(200);
			
			given()
			.when()
				.delete("simulacoes/"+CONTA_ID)
			.then()
				.log().all()
				.statusCode(200);
			
		}
		
		@Test
		public void cpfInexistente() {
			
			given()
				.body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+",\"email\": \"email@email.com\", \"valor\": 1200,\"parcelas\": 3,\"seguro\": true}")
			.when()
				.put("simulacoes/"+CONTA_CPF)
			.then()
				.statusCode(404)
				.body("mensagem",is("CPF "+CONTA_CPF+" não encontrado"));
			
		}
		
		@Test
		public void consultarTodasSimulacoes() {
			
			given()
			.when()
				.get("simulacoes")
			.then()
				.log().all()
				.statusCode(200);
		}
		
		@Test
		public void consultarSimulacao() {
			
		CONTA_ID =	given()
				.body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+", \"email\": \"email@email.com\", \"valor\": 1200, \"parcelas\": 3, \"seguro\": true}")	
			.when()
				.post("simulacoes")
			.then()
				.extract().path("id");
				
			given()
			.when()
				.get("simulacoes/"+CONTA_CPF)
			.then()
				.log().all()
				.statusCode(200);
			
			given()
			.when()
				.delete("simulacoes/"+CONTA_ID)
			.then()
				.log().all()
				.statusCode(200);
		}
		
		@Test
		public void consultarSimulacaoNaoCadastrada() {
			given()
			.when()
				.get("simulacoes/95093636013")
			.then()
				.statusCode(404)
				.log().all()
				.body("mensagem",is("CPF 95093636013 não encontrado"));
		}
		
		@Test
		public void deletarSimulacao() {
	 
			CONTA_ID =	given()
				.body("{ \"nome\": \""+CONTA_NAME+"\", \"cpf\": "+CONTA_CPF+",\"email\": \"email@email.com\", \"valor\": 1200,\"parcelas\": 10,\"seguro\": true}")
			.when()
				.post("simulacoes")
			.then()
				.extract().path("id");
			
			given()
			.when()
				.delete("simulacoes/"+CONTA_ID)
			.then()
				.log().all()
				.statusCode(200);

		}
			
		@Test
		public void tentarDeletarSimulacaoInexistente() {
			given()
			.when()
				.delete("simulacoes/"+CONTA_ID)
			.then()
			.log().all()
				.statusCode(200);
		}

	}
