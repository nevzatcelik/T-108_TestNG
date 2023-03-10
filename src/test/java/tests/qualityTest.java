package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QualityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class qualityTest {

    QualityPage qualityPage=new QualityPage();

    // Kullanici https://qualitydemy.com/ sayfasina gider
   // Siteye basarili bir sekilde giris yapar
   // sag taraf bulunan kullanici menusunden User Profile kismina gider
  // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
  // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular


    @Test
    public void qualityProfilTest(){
        // Kullanici https://qualitydemy.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        // Siteye basarili bir sekilde giris yapar
        qualityPage.loginMethod();
        // sag taraf bulunan kullanici menusunden User Profile kismina gider
        ReusableMethods.bekle(6);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(qualityPage.kullaniciLogo).click(qualityPage.userProfile).build().perform();
        // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
        System.out.println(qualityPage.profileFirstNameBox.getAttribute("value"));
        String firstname=qualityPage.profileFirstNameBox.getAttribute("value");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(firstname.contains("nevzat"));
        softAssert.assertAll();

    }
}
