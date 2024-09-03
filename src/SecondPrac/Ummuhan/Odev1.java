package SecondPrac.Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev1 extends BaseDriver {

    @Test
    public void Test1() {
        //  1) Bu siteye gidin. -> http://demoqa.com/text-box
        //  2) Full Name kısmına "Automation" girin.
        //  3) Email kısmına "Testing@gmail.com" girin.
        //  4) Current Address kısmına "Testing Current Address" girin.
        //  5) Permanent Address kısmına "Testing Permanent Address" girin.
        //  6) Submit butonuna tıklayınız.
        //  7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
        //  8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.

        driver.get("https://demoqa.com/text-box");

        String fullName = "Ümmühan Teke";
        WebElement fullnameBox = driver.findElement(By.cssSelector("div[id='userName-wrapper'] input"));
        fullnameBox.sendKeys(fullName);
        MyFunc.Wait(2);

        String emailMe = "ummuhantekeee@gmail.com";
        WebElement email = driver.findElement(By.cssSelector("div[id='userEmail-wrapper'] input"));
        email.sendKeys(emailMe);
        MyFunc.Wait(2);

        String address = "Mimar Sinan Mahallesi / Aydın ";
        WebElement currentAddress = driver.findElement(By.cssSelector("div[id='currentAddress-wrapper'] textarea"));
        currentAddress.sendKeys(address);
        MyFunc.Wait(2);

        String pAddress = "Erenler Mahallesi / İstanbul ";
        WebElement permanentAddress = driver.findElement(By.cssSelector("div[id='permanentAddress-wrapper'] textarea"));
        permanentAddress.sendKeys(pAddress);
        MyFunc.Wait(2);

        WebElement buttonSubmit = driver.findElement(By.cssSelector("div[class='mt-2 justify-content-end row'] button"));
        buttonSubmit.click();
        MyFunc.Wait(2);

        WebElement fullNameControl = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12'] > :nth-child(1)"));
        Assert.assertTrue("FullName eşleşme doğrulanamadı", fullNameControl.getText().contains(fullName));

        WebElement emailControl = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12'] > :nth-child(2)"));
        Assert.assertTrue("Email eşleşme doğrulanamadı", emailControl.getText().contains(emailMe));

        BekleKapat();


    }

}
