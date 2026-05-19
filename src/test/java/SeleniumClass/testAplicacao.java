package SeleniumClass;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testAplicacao {
    private final String URL = "file:///C:/Users/dfelix/Downloads/jornada_selenium.html";
    private WebDriver driver;

    @Before
    public final void iniciar(){
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    public void fechar() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void validarCheckBox() throws InterruptedException{
        WebElement checkbox = driver.findElement(By.id("java-checkbox"));
        checkbox.click();
       // Thread.sleep(3000);     
    }

    @Test
    public void clicarEmVariosCheckboxes() throws InterruptedException{
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type = \"checkbox\"]"));

        for(WebElement cb : checkboxes){
            if(!cb.isSelected()){
                cb.click();
            }
        }
        Thread.sleep(4000);
    }

    @Test
    public void validaRadioButton() throws InterruptedException{
        driver.findElement(By.id("junior-radio")).click();

        Thread.sleep(4000);
    }

    @Test
    public void clicarVariosRadios() throws InterruptedException{
        List<WebElement> radios = driver.findElements(By.cssSelector("input[type=\"radio\"]"));

        for(WebElement rb : radios){
            if(!rb.isSelected()){
                rb.click();
            }
        }
        Thread.sleep(4000);
    }

    @Test
    public void validarSelect() throws InterruptedException{
        WebElement selectLinguagem = driver.findElement(By.id("language-select"));
        Select selectOpcao = new Select(selectLinguagem);
        selectOpcao.selectByValue("csharp");

        Thread.sleep(4000);
    }
    

}
