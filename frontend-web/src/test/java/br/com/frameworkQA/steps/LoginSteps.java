package br.com.frameworkQA.steps;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import br.com.frameworkQA.frontutils.PropertiesHelper;
import br.com.frameworkQA.pages.LoginPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * Classe Login, responsável por executar as ações de um Acesso de Usuário.
 * @author XXXX
 * @version 1.0
 * 
 */

public class LoginSteps {

    private Properties properties = new PropertiesHelper().getProperties();
    private LoginPage loginPage;

    
    public LoginSteps() {
        loginPage = new LoginPage(Hooks.driver);
    }

    // Acessa a URL de login da aplicação do Sr Barriga
    @Dado("^que estou na página de login através da url \"([^\"]*)\"$")
	public void estouPaginaLoginAtravesUrl(String url) throws Throwable {
        loginPage.setUrl(properties.getProperty(url));
	}

    // Preenche o campo Login na tela de SignIn
    @Quando("^preencho o campo login \"([^\"]*)\"$")
	public void preenchoCampoLogin(String login) throws Throwable {
   		 loginPage.setFieldMail(login);
	}

    // Preenche o campo Password na tela de SignIn
    @Quando("^preencho o campo password \"([^\"]*)\"$")
	public void preenchoCampoPassword(String password) throws Throwable {
   		loginPage.setFieldPassword(password);
	}

    // Clica no botão SignIn
    @Quando("^clico no botão Signin$")
	public void clicoBotaoSignin() throws Throwable {
		loginPage.submitFieldLogin();
	}

    // Compara com assertEquals se a mensagem exibida na tela é a mesma que foi documentada no arquivo (*.feature)
    @Então("^a aplicação exibe a mensagem \"([^\"]*)\" de bem vindo$")
	public void aplicacaoExibeMensagemBemVindo(String mensagem) throws Throwable {
   		 assertEquals(mensagem, loginPage.getMessageLoginSuccess());
	}

    // Clica no botão Sair no menu principal
    @Então("^clico no botão Sair$")
    public void clicoBotaoSair() throws Throwable {
        loginPage.submitFieldLogout();
    }

}
