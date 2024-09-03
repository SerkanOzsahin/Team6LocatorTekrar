package SecondPrac;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task1 extends BaseDriver {
//1) Bu siteye gidin. -> http://demoqa.com/text-box
//
//  2) Full Name kısmına "Automation" girin.
//
//  3) Email kısmına "Testing@gmail.com" girin.
//
//  4) Current Address kısmına "Testing Current Address" girin.
//
//  5) Permanent Address kısmına "Testing Permanent Address" girin.
//
//  6) Submit butonuna tıklayınız.
//
//  7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
//
//  8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.

    @Test
    public void Test(){
        driver.get("http://demoqa.com/text-box");
        MyFunc.Wait(2);
        WebElement fulname= driver.findElement(By.cssSelector("input[autocomplete='off'][type='text']"));
        fulname.sendKeys("Automation");
        MyFunc.Wait(2);
        WebElement email= driver.findElement(By.cssSelector("input[autocomplete='off'][type='email']"));
        email.sendKeys("Testing@gmail.com");
        MyFunc.Wait(2);
        WebElement submitBtn= driver.findElement(By.cssSelector("div[class='text-right col-md-2 col-sm-12'] button"));
        submitBtn.click();
        MyFunc.Wait(2);
        String ad="Automation";
        String email1="Testing@gmail.com";
        WebElement namecontrol= driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>[ id='name']"));
         if (namecontrol.getText().contains(ad)){
             System.out.println("Test passed");
         }else
             System.out.println("Test failed");

         MyFunc.Wait(1);

         WebElement emailcontrol= driver.findElement(By.cssSelector("[class='mb-1'][id='email']"));
         if (emailcontrol.getText().contains(email1)){
             System.out.println("Test passed");
         }else
             System.out.println("Test failled");
         MyFunc.Wait(1);

        driver.quit();
    }

}
