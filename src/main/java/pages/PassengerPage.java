package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassengerPage {
    private WebDriver driver;
    private By screenTitleTest = By.cssSelector("[data-hrl-bo='screen_title']");

    public PassengerPage(WebDriver driver) {
        this.driver=driver;
    }


    public String getTestPageTitle() {
      return (driver.findElement(screenTitleTest).getText());
    }

    public boolean checkUrl(){
       return (driver.getCurrentUrl().equals("https://digital.harel-group.co.il/travel-policy/wizard/travelers"));

    }
}
