package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StateSelectionPage {
 private WebDriver driver;
 private By stateSelectionBtn=By.id("destination-2");
 private By chooseDateBtn=By.cssSelector("[data-hrl-bo='wizard-next-button']");
    public StateSelectionPage(WebDriver driver) {
        this.driver = driver;
    }



    public void clickStateSelection(){
        stateSelectionBtn.findElement(driver).click();
    }

    public  void  clickChooseDate(){
        chooseDateBtn.findElement(driver).click();
    }

}
