package SecondPrac;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Merve6 extends BaseDriver {

    @Test
    public void Test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement clickFakeAlert = driver.findElement(By.cssSelector("a[href='alerts/fake-alert-test.html']"));
        clickFakeAlert.click();
        MyFunc.Wait(2);

        WebElement showModelDialogClick=driver.findElement(By.cssSelector("input[onclick='show_modal()']"));
        showModelDialogClick.click();
        MyFunc.Wait(2);

        WebElement controlText = driver.findElement(By.cssSelector("div[role='dialog'] h2"));
        Assert.assertTrue("Texte ulaÅŸÄ±lamadÄ±!",controlText.getText().contains("I am a modal div!"));

        WebElement okClick=driver.findElement(By.cssSelector("button[class='dialog-button']"));
        okClick.click();
        BekleKapat();


    }
}
