package br.com.frameworkQA.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.frameworkQA.functionality.ControleListaProdutoFuncionalidade;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import io.restassured.response.Response;

/**
 * 
 * @author XXXX
 *
 */
public class ListaProdutosSteps {

	private ControleListaProdutoFuncionalidade registerProductFuncionalidade;
	private Response response;
	
	public ListaProdutosSteps() {
		this.registerProductFuncionalidade = new ControleListaProdutoFuncionalidade();
		
	}

	@Dado("^que faco uma requisicao GET/products$")
	public void queFacoUmaRequisicaoGETProducts() throws Throwable {
		response = registerProductFuncionalidade.getMapping();
	}

	@Entao("^retorno dos produtos$")
	public void retornoDosProdutos() throws Throwable {
	}

	@Entao("^devo receber um status code '(\\d+)'$")
	public void devoReceberUmStatusCode(int code) throws Throwable {
		assertEquals(code, response.statusCode());
		System.out.println(response.statusCode());
	}

	@Entao("^retorno dos produtos registrado$")
	public void retornoProductsRegister() throws Throwable {
		String body = response.body().asString();
		assertTrue(body != null || body != "");
	}

}
