package SeleniumClass;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumClass.pages.HomePage;
import SeleniumClass.pages.LoginPage;
import junit.framework.Assert;

public class validacoes {
    private final String URL = "file:///C:/Users/dfelix/Downloads/jornada_selenium.html";
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;


    @Before
    public final void iniciar(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
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
        /*driver.findElement(By.id("login-user")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("123456");
        driver.findElement(By.id("login-button")).click();*/
        loginPage.realizarLogin("admin","123456");

        //Validar se realizou login com sucesso
        
        Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
        String mensagem = driver.findElement(By.xpath("//div[@id=\"success-message\"]//p")).getText();
        Assert.assertEquals("Bem-vindo à área autenticada do sistema.",mensagem);

    }

    @Test
    public void realizarLogout(){
        //Realiza o login primeiro
        loginPage.realizarLogin("admin", "123456");

        //driver.findElement(By.xpath("//button[@id=\"logout-button\"]")).click();
        homePage.clicarEmLogout();

        //Validar Não exibição da mensagem de sucesso
        Assert.assertFalse(driver.findElement(By.id("success-message")).isDisplayed());
    }

    @Test
    public void uploadArquivo() throws InterruptedException {
        // Logar na aplicação
        validarLoginSucesso();
 
        // elemento de upload
        WebElement botaoInput = driver.findElement(By.id("file-upload"));
 
        // // Enviando o arquivo para o input
        // Trocar o caminho
        botaoInput.sendKeys("C:\\Users\\ermartins\\Downloads\\jornada_selenium.html");
 
        // Validar se o nome do arquivo foi carregado no input
        String nomeArquivo = botaoInput.getAttribute("value");
 
        // Validar que o nome do arquivo não está vazio
        Assert.assertFalse("Nenhum arquivo escolhido", nomeArquivo.isEmpty());

        //Exercicio: Realizar a validação do nome do arquivo após o upload
 
        // pausa para visualizar o resultado do upload
        Thread.sleep(3000);
    }

    @Test
    public void validarTabela(){
        //Realizar login
        validarLoginSucesso();

        List<WebElement> linhas = driver.findElements(By.xpath("//table[@id=\"users-table\"]//tbody//tr"));

        //Validar quantidade de linhas na tabela
        Assert.assertEquals(2, linhas.size());

        //Validar se na linha 1 tem o nome Alice
        Assert.assertTrue(linhas.get(0).getText().contains("Alice"));
        System.out.println("Linha 1: " + linhas.get(0).getText());

        //Validando se a linha 1 tem o conteúdo esperado: Alice alice@email.com
        Assert.assertEquals("Alice alice@email.com", linhas.get(0).getText());
    }

    @Test
    public void validarBotaoDesabilitado(){
        validarLoginSucesso();

        WebElement botaoDesabilitado = driver.findElement(By.id("disabled-button"));

        Assert.assertFalse(botaoDesabilitado.isEnabled());
    }

    @Test
    public void realizarLoginSenhaErrada(){
        loginPage.realizarLogin("admin", "123");

        //Validar exibição da mensagem de erro
        Assert.assertTrue(driver.findElement(By.id("login-result")).isDisplayed());
    }

}
