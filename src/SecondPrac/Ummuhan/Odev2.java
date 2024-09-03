package SecondPrac.Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev2 extends BaseDriver {
    //1) Bu siteye gidin. -> https://demo.applitools.com/
    //2) Username kısmına "ttechno@gmail.com" girin.
    //3) Password kısmına "techno123." girin.
    //4) "Sign in" buttonunan tıklayınız.
    //5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.


    @Test
    public void Test2()
    {
        driver.get("https://demo.applitools.com/");

        String email="techno@gmail.com";
        String passwordStr="techno123.";

        WebElement userName=driver.findElement(By.cssSelector("div[class='form-group'] input"));
        userName.sendKeys(email);
        MyFunc.Wait(2);

        WebElement password=driver.findElement(By.cssSelector("div[class='form-group'] [id='password']"));
        password.sendKeys(passwordStr);
        MyFunc.Wait(2);

        WebElement button=driver.findElement(By.cssSelector("div[class='buttons-w'] a"));
        button.click();
        MyFunc.Wait(2);

        WebElement viewPostControl=driver.findElement(By.cssSelector("div[class='element-wrapper compact pt-4'] [id='time']"));
        Assert.assertTrue("ekranda yazı eşleşmesi bulunamadı", viewPostControl.getText().contains("nearest"));

        BekleKapat();






    }
}
