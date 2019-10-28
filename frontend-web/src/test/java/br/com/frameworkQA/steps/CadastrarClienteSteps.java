package br.com.frameworkQA.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.github.javafaker.Faker;

import br.com.frameworkQA.pages.CadastrarClientePage;
import br.com.frameworkQA.pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
/**
 * Classe IncluirClientes, responsável por executar as ações de um cadastro de cliente.
 * @author XXXX
 * @version 1.0
 */
public class CadastrarClienteSteps {

    private LoginPage loginPage = new LoginPage(Hooks.driver);
    private CadastrarClientePage addClientes = new CadastrarClientePage(Hooks.driver);
    private Faker faker = new Faker();
    private String account;

    // Preenche os campos necessários para realizar o login
    @Dado("^preencho os campos para logar$")
    public void preenchoCamposParaLogar(DataTable userCredentials) throws Throwable {
        List<List<String>> data = userCredentials.raw();
        loginPage.setFieldMail(data.get(0).get(0));
        loginPage.setFieldPassword(data.get(0).get(1));
    }

    // Clica no menu QA > Clientes
    @Quando("^clico no menu QA > Clientes$")
	public void clicoMenuQAClientes() throws Throwable {
    	addClientes.menuQA();
    	addClientes.subMenuClientes();
	}

    // Clica no subMenu Incluir
    @Quando("^seleciono a opção Incluir$")
    public void selecionoOpcaoIncluir() throws Throwable {
    	addClientes.subMenuIncluir();
    }

    // Preenche o campo Nome da Conta
    @Quando("^preencho o campo nome \"([^\"]*)\" cpf (\\d+) status \"([^\"]*)\" saldo (\\d+)$")
    public void preenchoCampo_Nome_Cpf_Ativo_Saldo(String Name, String Cpf, String Status, String Saldo) throws Throwable {
    	account = addClientes.setFieldName(Name.equals("aleatório") ? faker.name().firstName() + faker.number().randomDigit() : Name);
    	addClientes.setFieldCPF(Cpf);
    	addClientes.setFieldAtivo(Status);
    	addClientes.setFieldSaldoDisponivel(Saldo);
    }

    // Clica no botão "Salvar" a inclusão de cliente
    @Quando("^clico no botão salvar$")
    public void clicoBotaoSalvar() throws Throwable {
    	addClientes.submitBtndSave();
    }

    // Compara com assertEquals se a mensagem exibida na tela é igual a mensagem documentada na feature

    @Entao("^a aplicação exibe a mensagem \"([^\"]*)\"$")
    public void aplicacaoExibeMensagem(String mensagem) throws Throwable {
        assertEquals(mensagem, addClientes.getMessageSucess());
    }

        
}
