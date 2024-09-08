package SecondPrac;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task2 extends BaseDriver {
    //) Bu siteye gidin. -> https://demo.applitools.com/
    //
    //2) Username kısmına "ttechno@gmail.com" girin.
    //
    //3) Password kısmına "techno123." girin.
    //
    //4) "Sign in" buttonunan tıklayınız.
    //
    //5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.

    @Test
    public void Test1(){
        driver.get("https://demo.applitools.com/");
        WebElement username= driver.findElement(By.cssSelector("input[id='username']"));
        username.sendKeys("ttechno@gmail.com");
        WebElement password= driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("techno123.");
        WebElement signinbtn= driver.findElement(By.cssSelector("div[class='buttons-w']>:nth-child(1)"));
        signinbtn.click();
        MyFunc.Wait(1);
        WebElement headerText= driver.findElement(By.cssSelector("[id='time']"));
        Assert.assertTrue("Yazı göründü",headerText.getText().contains("Your nearest branch closes in: 30m 5s"));
        //2.yol
        Assert.assertTrue(headerText.getText().equals("Your nearest branch closes in: 30m 5s"));


        driver.quit();


    }





}
