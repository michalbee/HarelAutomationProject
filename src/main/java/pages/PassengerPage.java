package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassengerPage {
    private WebDriver driver;
    private By screenTitleTest = By.cssSelector("[data-hrl-bo='screen_title']");

    public PassengerPage(WebDriver driver) {
        this.driver=driver;
    }

     //בדיקה שנכנס למסך בחירת נוסעים ע"י טקסט
    public String getTestPageTitle() {
      System.out.println(driver.findElement(screenTitleTest).getText());
      return (driver.findElement(screenTitleTest).getText());
    }
    //בדיקה שנכנס למסך בחירת נוסעים ע"י URL
    public boolean checkUrl(){
       return (driver.getCurrentUrl().equals("https://digital.harel-group.co.il/travel-policy/wizard/travelers"));

    }
}
