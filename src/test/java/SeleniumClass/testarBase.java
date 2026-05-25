package SeleniumClass;

import org.junit.Test;
import org.openqa.selenium.By;

import SeleniumClass.pages.HomePage;
import SeleniumClass.pages.LoginPage;
import SeleniumClass.pages.baseTest;
import junit.framework.Assert;

public class testarBase extends baseTest{
    private LoginPage loginPage;
    private HomePage homePage;

    
    @Test
    public void validarLoginSucesso(){
        loginPage = new LoginPage(driver);
        loginPage.realizarLogin("admin","123456");

        //Validar se realizou login com sucesso
        
        Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
        String mensagem = driver.findElement(By.xpath("//div[@id=\"success-message\"]//p")).getText();
        Assert.assertEquals("Bem-vindo à área autenticada do sistema.",mensagem);

    }

    @Test
    public void realizarLoginSenhaErrada(){
        loginPage = new LoginPage(driver);
        loginPage.realizarLogin("admin", "123");

        //Validar exibição da mensagem de erro
        Assert.assertTrue(driver.findElement(By.id("login-result")).isDisplayed());
    }

     @Test
    public void realizarLogout(){
         loginPage = new LoginPage(driver);
         homePage = new HomePage(driver);
        //Realiza o login primeiro
        loginPage.realizarLogin("admin", "123456");

        //driver.findElement(By.xpath("//button[@id=\"logout-button\"]")).click();
        homePage.clicarEmLogout();

        //Validar Não exibição da mensagem de sucesso
        Assert.assertFalse(driver.findElement(By.id("success-message")).isDisplayed());
    }



}
