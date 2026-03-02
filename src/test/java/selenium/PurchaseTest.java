package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.CartPage;
import pom.LoginPage;

public class PurchaseTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void should_Add_Item_To_Cart_Successfully() {
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);


        loginPage.login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();


        driver.findElement(By.className("shopping_cart_link")).click();


        Assertions.assertEquals("Sauce Labs Backpack", cartPage.getFirstItemName());
    }


}