package SecondPrac;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Merve4 extends BaseDriver {

    @Test
    public void Test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement calClick=driver.findElement(By.cssSelector("div[class='titledesc'] a[href='calculator']"));
        calClick.click();
        MyFunc.Wait(2);

        String no1="9";
        WebElement number1=driver.findElement(By.cssSelector("div[class='form-label'] >:nth-child(1)"));
        number1.sendKeys(no1);
        MyFunc.Wait(2);

        String no2="7";
        WebElement number2=driver.findElement(By.cssSelector("div[class='form-label'] >:nth-child(3)"));
        number2.sendKeys(no2);
        MyFunc.Wait(2);

        WebElement calculateClick=driver.findElement(By.cssSelector("input[class='styled-click-button']"));
        calculateClick.click();
        MyFunc.Wait(2);

        WebElement result=driver.findElement(By.cssSelector("div[class='centered'] span"));
        Assert.assertTrue("Result is not true",result.getText().contains("16"));
        MyFunc.Wait(2);
        BekleKapat();

    }
}
