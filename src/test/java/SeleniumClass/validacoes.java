package SeleniumClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class validacoes {
     private final String URL = "file:///C:/Users/dfelix/Downloads/jornada_selenium.html";
    private WebDriver driver;

    @Before
    public final void iniciar(){
        driver = new ChromeDriver();
        driver.get(URL);
        Assert.assertTrue(driver.findElement(By.id("page-title")).isDisplayed());
    }

    @After
    public void fechar() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void botaoCliqueAqui(){
        driver.findElement(By.id("click-button")).click();

        //Validar exibição da mensagem
        WebElement mensagemSucesso = driver.findElement(By.id("click-message"));
        Assert.assertTrue(mensagemSucesso.isDisplayed());

        //Validar conteúdo da mensagem
        Assert.assertEquals("✅ Botão clicado com sucesso!",mensagemSucesso.getText());
    }

    @Test
    public void validarLoginSucesso(){
        //Usuário: admin
        //Senha: 123456
        driver.findElement(By.id("login-user")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("123456");
        driver.findElement(By.id("login-button")).click();

        //Validar se realizou login com sucesso
        
        Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
        String mensagem = driver.findElement(By.xpath("//div[@id=\"success-message\"]//p")).getText();
        Assert.assertEquals("Bem-vindo à área autenticada do sistema.",mensagem);

    }

    @Test
    public void realizarLogout(){
        //Realiza o login primeiro
        validarLoginSucesso();

        driver.findElement(By.xpath("//button[@id=\"logout-button\"]")).click();

        //Validar Não exibição da mensagem de sucesso
        Assert.assertFalse(driver.findElement(By.id("success-message")).isDisplayed());
    }

}
