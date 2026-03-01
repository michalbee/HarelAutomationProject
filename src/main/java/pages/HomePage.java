package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By firstEnterBtn = By.cssSelector("[data-hrl-bo='purchase-for-new-customer']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("STEP 1: כניסה לדף הבית והקלקה על כניסה ראשונה")
    public void clickFirstEnter(){
        driver.findElement(firstEnterBtn).click();
     }

}
