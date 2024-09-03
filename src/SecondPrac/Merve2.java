package SecondPrac;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Merve2 extends BaseDriver {

    @Test
    public void Test(){
        driver.get("https://demo.applitools.com/");
        MyFunc.Wait(2);

        String fullname="ttechno@gmail.com";
        WebElement fullnameBox=driver.findElement(By.cssSelector("div[class='form-group']>:nth-child(2)"));
        fullnameBox.sendKeys(fullname);
        MyFunc.Wait(2);

        String password="techno123.";
        WebElement passwordBox=driver.findElement(By.cssSelector("div[class='form-group'] input[type='password']"));
        passwordBox.sendKeys(password);
        MyFunc.Wait(2);

        WebElement signIn=driver.findElement(By.cssSelector("div[class='buttons-w'] a"));
        signIn.click();
        MyFunc.Wait(2);

        WebElement kontrolText=driver.findElement(By.cssSelector("div[class='element-wrapper compact pt-4'] h6"));
        Assert.assertTrue("Beklenen yazıya ulaşılamadı.",kontrolText.getText().equals("Your nearest branch closes in: 30m 5s"));
        MyFunc.Wait(2);
        BekleKapat();
    }
}
