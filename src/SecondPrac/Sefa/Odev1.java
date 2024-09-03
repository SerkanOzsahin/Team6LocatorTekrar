package SecondPrac.Sefa;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev1 extends BaseDriver {
    @Test
    public void Test1() {
        String fullName="Automation";
        String email="Testing@gmail.com";
        String currentAddres="Testing Current Address";
        String permanentAddress="Testing permanent address";
        /*
       1) Bu siteye gidin. -> http://demoqa.com/text-box
       2) Full Name kısmına "Automation" girin.
       3) Email kısmına "Testing@gmail.com" girin.
       4) Current Address kısmına "Testing Current Address" girin.
       5) Permanent Address kısmına "Testing Permanent Address" girin.
       6) Submit butonuna tıklayınız.
       7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
       8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
       */

        driver.get("http://demoqa.com/text-box");
        MyFunc.Wait(2);

        WebElement fullnameSend=driver.findElement(By.cssSelector("[placeholder='Full Name']"));
        fullnameSend.sendKeys(fullName);
        MyFunc.Wait(2);

        WebElement emailSend=driver.findElement(By.cssSelector("[placeholder='name@example.com']"));
        emailSend.sendKeys(email);
        MyFunc.Wait(2);

        WebElement currentAddressSend=driver.findElement(By.cssSelector("[placeholder='Current Address']"));
        currentAddressSend.sendKeys(currentAddres);
        MyFunc.Wait(2);

        WebElement permanentAddressSend=driver.findElement(By.cssSelector("div[id='permanentAddress-wrapper'] textarea"));
        permanentAddressSend.sendKeys(permanentAddress);
        MyFunc.Wait(2);

        WebElement submitBtn=driver.findElement(By.cssSelector("div[class='mt-2 justify-content-end row']>:nth-child(1)"));
        submitBtn.click();
        MyFunc.Wait(2);

        WebElement fullnameControl=driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(1)"));
        Assert.assertTrue("Fullname testi başarısız",fullnameControl.getText().contains("Automation"));

        WebElement emailControl=driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(2)"));
        Assert.assertTrue("email testi başarısız",emailControl.getText().contains("Testing"));

        BekleKapat();
    }
}
