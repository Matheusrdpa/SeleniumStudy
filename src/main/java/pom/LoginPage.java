package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver webDriver;

    private By userField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
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
        clickLoginButton();
    }

    public String catchErrormessage(){
        return webDriver.findElement(errorMessage).getText();
    }
}
