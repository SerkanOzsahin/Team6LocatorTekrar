package SecondPrac;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Merve3 extends BaseDriver {

    @Test
    public void Test(){
        driver.get("https://www.snapdeal.com/");
        MyFunc.Wait(2);

        String text="teddy bear";
        WebElement searchBox=driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper'] input"));
        searchBox.sendKeys(text);
        MyFunc.Wait(2);

        WebElement searchBoxClick=driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper'] button"));
        searchBoxClick.click();
        MyFunc.Wait(2);

        WebElement controlText=driver.findElement(By.cssSelector("div[id='searchMessageContainer'] span"));
        Assert.assertTrue("Böyle bir text bulunamadı",controlText.getText().contains("We've got 63 results for teddy bear"));
        MyFunc.Wait(2);
        BekleKapat();

    }
}
