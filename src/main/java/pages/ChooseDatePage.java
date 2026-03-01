package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.LocalDate;

public class ChooseDatePage {
    private WebDriver driver;

    private  LocalDate plusDate;
    String dateValue;
    private By chooseDateBtn;
    private By cLickNextMonthBtn=By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[1]/button[2]");//כפתור מעבר לחודש הבא
    private  By totalDayTest=By.cssSelector("[data-hrl-bo='total-days']"); //בדיקה סך הכל ימים שנבחרו (30)
    private  By continueBtn=By.cssSelector("[data-hrl-bo='wizard-next-button']");


    public ChooseDatePage(WebDriver driver) {
        this.driver=driver;
    }
    //בחירת תאריך יציאה וחזרה
    public void clickSelectionDates(int departurePlusDays,int returnPlusDays) {
        plusDate=LocalDate.now().plusDays(departurePlusDays);
        dateValue=plusDate.toString();
        chooseDateBtn = By.xpath("//button[@data-hrl-bo='" + dateValue+ "']");
        chooseDateBtn.findElement(driver).click();//תאריך יציאה

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(9000));
        plusDate=LocalDate.now().plusDays(departurePlusDays+returnPlusDays);
        dateValue=plusDate.toString();
        chooseDateBtn = By.xpath("//button[@data-hrl-bo='" + dateValue+ "']");
        while (driver.findElements(chooseDateBtn).isEmpty()) {
            driver.findElement(cLickNextMonthBtn).click();
            // המתנה קצרה כדי שהטקסט של החודש יתעדכן
            try { Thread.sleep(999999); } catch (InterruptedException e) {}
        }
        chooseDateBtn.findElement(driver).click();

    }
   //הדפסת סה"כ הימים שנבחרו
   public int getTotalTest(){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
       String  text=driver.findElement(totalDayTest).getText();
       String onlyNumber = text.replaceAll("[^0-9]", "");
       return Integer.parseInt(onlyNumber);
   }
    //לחיצה על כפתור הלאה...
    public void clickContinuBtn (){

      continueBtn.findElement(driver).click();
    }


}