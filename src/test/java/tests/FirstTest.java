package tests;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChooseDatePage;
import pages.HomePage;
import pages.PassengerPage;
import pages.StateSelectionPage;



public class FirstTest extends BaseTest {
        @Test
        public void firstFlow() {
            step1_enterHomePage();
            step2_3_StateSelection();
            step4_chooseDate();
            step5_passengerPageChecks();
        }

        public void step1_enterHomePage () {
            HomePage homePage = new HomePage(driver);
            homePage.clickFirstEnter();
        }
        @Step ("STEP 2-3: בחירת מדינה והקלקה הבאה")
        public void step2_3_StateSelection () {
            StateSelectionPage stateSelect = new StateSelectionPage(driver);
            stateSelect.clickStateSelection();
            stateSelect.clickChooseDate();
        }

        @Step ("STEP 4: בחירת תאריכי טיסה לפי 7 ימים מהיום +30 ולבדוק שמופיע 30 יום")
        public void step4_chooseDate () {
            ChooseDatePage chooseDate = new ChooseDatePage(driver);
            chooseDate.clickSelectionDates(6, 29);
            int totalNumber = chooseDate.getTotalTest();
            Assert.assertEquals(totalNumber, 30, "סה\"כ: 30 ימים");
            chooseDate.clickContinuBtn();
        }

        @Step ("STEP 5: בדיקת כותרת ודף נוסעים")
        public void step5_passengerPageChecks() {
            PassengerPage passengerPage = new PassengerPage(driver);
            // passengerPage.getTestPageTitle();
            String actualText = passengerPage.getTestPageTitle();
            Assert.assertEquals(
                    actualText.trim(),
                    "נשמח להכיר את הנוסעים שנבטח הפעם",
                    "הטקסט בדף הנוסעים אינו תואם"
            );
            Assert.assertTrue(passengerPage.checkUrl(), "לא תקין ולא נפתח דף נוסעים");

        }


}
