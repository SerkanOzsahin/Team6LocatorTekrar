package SecondPrac.Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class Odev4 extends BaseDriver {
     //Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
     //Calculate'e tıklayınız.
     // İlk input'a herhangi bir sayı giriniz.
     //İkinci input'a herhangi bir sayı giriniz.
     //Calculate button'una tıklayınız.
     //Sonucu alınız.
     //Sonucu yazdırınız.


    @Test
    public void Test4()
    {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculator=driver.findElement(By.cssSelector("div[class='titledesc'] [id='calculatetest']"));
        calculator.click();
        MyFunc.Wait(2);

        String inputFirst="8";
        WebElement firstinput=driver.findElement(By.cssSelector("div[class='form-label'] [name='number1']"));
        firstinput.sendKeys(inputFirst);
        MyFunc.Wait(2);

        String inputSecond="12";
        WebElement secondinput=driver.findElement(By.cssSelector("div[class='form-label'] [name='number2']"));
        secondinput.sendKeys(inputSecond);
        MyFunc.Wait(2);

        WebElement calculateButton=driver.findElement(By.cssSelector("form[action='calculator'] > :nth-child(2)"));
        calculateButton.click();
        MyFunc.Wait(2);

        WebElement cevap=driver.findElement(By.cssSelector("div[class='centered']  > :nth-child(2)"));
        System.out.println("Cevap: " + cevap.getText());
        MyFunc.Wait(2);

        BekleKapat();


    }
}
