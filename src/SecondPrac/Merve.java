package SecondPrac;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Merve extends BaseDriver {
    @Test
    public void Test(){
        driver.get("http://demoqa.com/text-box");
        MyFunc.Wait(2);

        String fullname="Automation";
        WebElement fullnameBox=driver.findElement(By.cssSelector("div[id='userName-wrapper'] input"));
        fullnameBox.sendKeys(fullname);
        MyFunc.Wait(2);

        String email="Testing@gmail.com";
        WebElement emailBox=driver.findElement(By.cssSelector("div[id='userEmail-wrapper'] input"));
        emailBox.sendKeys(email);
        MyFunc.Wait(2);

        String currentAdress="Testing Current Address";
        WebElement currentAdressBox=driver.findElement(By.cssSelector("div[id='currentAddress-wrapper'] textarea"));
        currentAdressBox.sendKeys(currentAdress);
        MyFunc.Wait(2);

        String permanentAdress="Testing Permanent Address";
        WebElement permanentAdressBox=driver.findElement(By.cssSelector("div[id='permanentAddress-wrapper'] textarea"));
        permanentAdressBox.sendKeys(permanentAdress);
        MyFunc.Wait(2);

        WebElement submitButton=driver.findElement(By.cssSelector("div[class='text-right col-md-2 col-sm-12']>button"));
        submitButton.click();
        MyFunc.Wait(2);

        WebElement kontrolName=driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(1)"));
        Assert.assertTrue("Beklenen isime ulaşılamadı.",kontrolName.getText().contains(fullname));
        MyFunc.Wait(2);

        WebElement kontrolEmail=driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(2)"));
        Assert.assertTrue("Beklenen e-maile ulaşılamadı.",kontrolEmail.getText().contains(email));
        MyFunc.Wait(2);
        BekleKapat();

    }
}
