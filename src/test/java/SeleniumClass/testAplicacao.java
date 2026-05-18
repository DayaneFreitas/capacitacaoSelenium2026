package SeleniumClass;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testAplicacao {
    private final String URL = "file:///C:/Users/dfelix/Downloads/jornada_selenium.html";

    @Test
    public void validarCheckBox() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        WebElement checkbox = driver.findElement(By.id("java-checkbox"));
        checkbox.click();
        Thread.sleep(3000);
        driver.quit();       
    }

    @Test
    public void clicarEmVariosCheckboxes() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type = \"checkbox\"]"));

        for(WebElement cb : checkboxes){
            if(!cb.isSelected()){
                cb.click();
            }
        }
        Thread.sleep(4000);

        driver.quit();
    }

    @Test
    public void validaRadioButton() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(By.id("junior-radio")).click();
        Thread.sleep(4000);

        driver.quit();
    }
    

}
