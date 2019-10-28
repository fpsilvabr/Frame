package br.com.frameworkQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.frameworkQA.utils.BaseWebPageFactory;


/**
 * @author fredi.roldan
 * @version 1.0
 *
 */
public class CadastrarClientePage extends BaseWebPageFactory {
	
    //Locators

    @FindBy(how = How.LINK_TEXT, using = "QA")
    private WebElement submitMenuQA;

    @FindBy(how = How.LINK_TEXT, using = "Clientes")
    private WebElement submitSubMenuClientes;
    
    @FindBy(how = How.LINK_TEXT, using = "Incluir")
    private WebElement submitSubMenuIncluir;

    @FindBy(how = How.ID, using = "nome")
    private WebElement setFieldName;
    
    @FindBy(how = How.ID, using = "cpf")
    private WebElement setFieldCPF;
    
    @FindBy(how = How.ID, using = "status")
    private WebElement setFieldAtivo;
    
    @FindBy(how = How.ID, using = "saldoCliente")
    private WebElement setFieldSaldoDisponivel;

    @FindBy(how = How.XPATH, using = "//button[@type='submit' and @class='btn btn-primary']")
    private WebElement submitBtnSave;

    @FindBy(how = How.XPATH, using = "//div[@id='alertMessage']//following::strong[1]")
    private WebElement validateMessagemSucess;


    public CadastrarClientePage(WebDriver driver) {
        super(driver);
    }

    public void setUrl(String pUrl) {
        driver.navigate().to(pUrl);
    }

    public void menuQA() throws InterruptedException {
        submitMenuQA.click();
    }

    public void subMenuClientes() throws InterruptedException {
        submitSubMenuClientes.click();
    }
    
    public void subMenuIncluir() throws InterruptedException {
    	submitSubMenuIncluir.click();
    }

    public String setFieldName(String pName) {
        setFieldName.sendKeys(pName);
        return pName;
    }
    
    public String setFieldCPF(String pCPF) {
    	setFieldCPF.sendKeys(pCPF);
        return pCPF;
    }
    
    public String setFieldAtivo(String pAtivo) {
    	setFieldAtivo.sendKeys(pAtivo);
        return pAtivo;
    }
    
    public String setFieldSaldoDisponivel(String pSaldo) {
    	setFieldSaldoDisponivel.sendKeys(pSaldo);
        return pSaldo;
    }

    public void submitBtndSave() {
        submitBtnSave.click();
    }

    public String getMessageSucess() throws InterruptedException {
        waitUntilElementIsVisible(validateMessagemSucess);
        return validateMessagemSucess.getText();
    }

    
}
