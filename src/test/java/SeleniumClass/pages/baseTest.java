package SeleniumClass.pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class baseTest {
    private final String URL = "file:///C:/Users/dfelix/Downloads/jornada_selenium.html";
    protected WebDriver driver;

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

}
