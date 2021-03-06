package br.com.frameworkQA.steps;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import com.github.javafaker.Faker;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import br.com.frameworkQA.frontutils.PropertiesHelper;
import br.com.frameworkQA.pages.NewUserPage;

/**
 * A Classe Register é responsável por executar
 * as ações de um Registro de uma Conta.
 *
 * @author XXXX <email@mail.com>
 * @version 1.0
 */
public class RegisterSteps {

    private Properties properties = new PropertiesHelper().getProperties();
    private Faker faker = new Faker();
    private NewUserPage newUser;

    public RegisterSteps() {
        newUser = new NewUserPage(Hooks.driver);
    }

    // Acessa a URL de cadastro da aplicação do Sr Barriga

    @Dado("^que estou na página de cadastro do SrBarriga através da url \"([^\"]*)\"$")
    public void que_estou_na_página_de_cadastro_do_SrBarriga_através_da_url(String url) throws Throwable {
        newUser.setUrl(properties.getProperty(url));
    }

    /* Preenche o campo Nome com uma condição:
     * se estiver preenchido com a palavra aleatório no arquivo Register.feature
     * o teste utiliza o JavaFaker para preencher o campo Nome com Nome randomico
     * se estiver preenchido com qualquer nome diferente da palavra aleatório
     * o teste utiliza o nome que vier na feature.
     */

    @Quando("^preencho o campo nome com o valor \"([^\"]*)\"$")
    public void preencho_o_campo_nome_com_o_valor(String nome) throws Throwable {
        newUser.setNameField(nome.equals("aleatório") ? faker.name().firstName() + " " + faker.name().lastName() : nome);
    }

    /* Preenche o campo E-mail com uma condição:
     * se estiver preenchido com a palavra aleatório no arquivo Register.feature
     * o teste utiliza o JavaFaker para preencher o campo E-mail com E-mail randomico
     * se estiver preenchido com qualquer E-mail diferente da palavra aleatório
     * o teste utiliza o E-mail que vier na feature.
     */

    @Quando("^preencho o campo email com o valor \"([^\"]*)\"$")
    public void preencho_o_campo_email_com_o_valor(String email) throws Throwable {
        newUser.setMailField(email.equals("aleatório") ? faker.internet().emailAddress() : email);
    }

    // Preenche o campo senha na tela de registro

    @Quando("^preencho o campo senha com o valor \"([^\"]*)\"$")
    public void preencho_o_campo_senha_com_o_valor(String senha) throws Throwable {
        newUser.setFieldPassword(senha);
    }

    // Clica no botão Cadastrar na tela de registro

    @Quando("^clico no botão Cadastrar$")
    public void clico_no_botão_Cadastrar() throws Throwable {
        newUser.submitFieldCreate();
    }

    // Compara com assertEquals se a mensagem exibida na tela é a mesma que foi documentada no arquivo .feature

    @Então("^a aplicação exibe a mensagem de sucesso \"([^\"]*)\"$")
    public void a_aplicação_exibe_a_mensagem_de_sucesso(String mensagem) throws Throwable {
        assertEquals(mensagem, newUser.getMessageSucess());
    }

    // Compara com assertEquals se a mensagem exibida na tela é a mesma que foi documentada no arquivo .feature

    @Então("^a aplicação exibe a mensagem de erro \"([^\"]*)\"$")
    public void a_aplicação_exibe_a_mensagem_de_erro(String mensagem) throws Throwable {
        assertEquals(mensagem, newUser.getMessageDanger());
    }

}
