package SeleniumClass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(id = "login-user")
    public WebElement campoUsername;

    @FindBy(id = "login-password")
    public WebElement campoPassword;

    @FindBy(id = "login-button")
    public WebElement botaoEntrar;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void realizarLogin(String user, String pass){
        campoUsername.sendKeys(user);
        campoPassword.sendKeys(pass);
        botaoEntrar.click();
    }

}
