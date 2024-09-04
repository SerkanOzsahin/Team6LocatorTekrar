package SecondPrac;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;

public class Merve5 extends BaseDriver {
    @Test
    public void Test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement clickFakeAlert=driver.findElement(By.cssSelector("a[href='alerts/fake-alert-test.html']"));
        clickFakeAlert.click();
        MyFunc.Wait(2);

        WebElement clickShowAlert=driver.findElement(By.cssSelector("div[class='centered'] input"));
        clickShowAlert.click();
        MyFunc.Wait(2);

        WebElement controlText=driver.findElement(By.cssSelector("div[role='dialog'] h2"));
        Assert.assertTrue("Text görüntülenemedi!",controlText.getText().contains("I am a fake alert box!"));

        WebElement clickOk=driver.findElement(By.cssSelector("div[class='dialog-actions'] button"));
        clickOk.click();
        BekleKapat();

    }
}
