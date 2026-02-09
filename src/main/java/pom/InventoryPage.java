package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    private By title = By.className("app_logo");
    private By title2 = By.className("title");

    public InventoryPage(WebDriver webDriver){
        this.driver = webDriver;
    }

    public String readTitle(){
        return driver.findElement(title).getText();
    }

    public String readTitle2(){
        return driver.findElement(title2).getText();
    }

}
