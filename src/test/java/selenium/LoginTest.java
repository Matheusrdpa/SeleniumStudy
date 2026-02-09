package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pom.InventoryPage;
import pom.LoginPage;

public class LoginTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    WebDriver webDriver;

    @BeforeEach
    void setup(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    void Should_Login_Successfully(){
        webDriver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(webDriver);
        InventoryPage inventoryPage = new InventoryPage(webDriver);

        loginPage.login("standard_user", "secret_sauce");
        String title = inventoryPage.readTitle();
        Assertions.assertEquals("Swag Labs",title);
    }

    @Test
    void Should_Throw_Error_When_Unsuccessful(){
        webDriver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("standard_user", "wrong_password");
        String error = loginPage.catchErrormessage();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",error);
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
