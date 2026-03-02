package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By checkoutButton = By.id("checkout");
    private By inventoryItemName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstItemName() {
        return driver.findElement(inventoryItemName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}