package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private By userField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void fillUserField(String username){
        webDriver.findElement(userField).sendKeys(username);
    }

    public void fillPasswordField(String password){
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        webDriver.findElement(loginButton).click();
    }

    public void login(String username,String password){
        fillUserField(username);
        fillPasswordField(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userField));
        clickLoginButton();
    }

    public String catchErrormessage(){
        return webDriver.findElement(errorMessage).getText();
    }
}
