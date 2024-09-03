package SecondPrac.Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev3 extends BaseDriver {
    //1) Bu siteye gidin. -> https://www.snapdeal.com/
    //2) "teddy bear" aratın ve Search butonuna tıklayın.
    //3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
    //Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

    @Test
    public void Test3()
    {
        driver.get("https://www.snapdeal.com/");

        String teddyBear="teddy bear";

        WebElement searchButton=driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper'] [name='keyword']"));
        searchButton.sendKeys(teddyBear);
        MyFunc.Wait(2);

        WebElement searchBox=driver.findElement(By.cssSelector("button[class='searchformButton col-xs-4 rippleGrey'] span"));
        searchBox.click();
        MyFunc.Wait(2);

        WebElement viewPostControl=driver.findElement(By.cssSelector("div[class='search-result-txt-section  marT12'] span"));
        Assert.assertTrue("ekranda yazı eşleşmesi bulunamadı", viewPostControl.getText().contains("teddy bear"));

        BekleKapat();

    }
}
