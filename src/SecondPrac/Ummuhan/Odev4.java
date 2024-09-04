package SecondPrac.Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class Odev4 extends BaseDriver {

    @Test
    public void Test4()
    {
        //Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        //Calculate'e tıklayınız.
        // İlk input'a herhangi bir sayı giriniz.
        //İkinci input'a herhangi bir sayı giriniz.
        //Calculate button'una tıklayınız.
        //Sonucu alınız.
        //Sonucu yazdırınız.

        String inputFirst="15";
        String inputSecond="27";

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculator=driver.findElement(By.cssSelector("div[class='titledesc'] [id='calculatetest']"));
        calculator.click();
        MyFunc.Wait(2);

        WebElement firstinput=driver.findElement(By.cssSelector("div[class='form-label'] [name='number1']"));
        firstinput.sendKeys(inputFirst);
        MyFunc.Wait(2);

        WebElement secondinput=driver.findElement(By.cssSelector("div[class='form-label'] [name='number2']"));
        secondinput.sendKeys(inputSecond);
        MyFunc.Wait(2);

        WebElement calculateButton=driver.findElement(By.cssSelector("form[action='calculator'] > :nth-child(2)"));
        calculateButton.click();
        MyFunc.Wait(2);

        WebElement answer=driver.findElement(By.cssSelector("div[class='centered']  > :nth-child(2)"));
        Assert.assertTrue("Doğru sonuç ekrana gelmedi", answer.getText().contains((String.valueOf(Integer.parseInt(inputFirst) + Integer.parseInt(inputSecond)))));
        System.out.println(answer.getText());
        MyFunc.Wait(2);

        BekleKapat();
    }

    @Test
    public void Test5()
    {
        //Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        //Fake Alerts' tıklayınız.
        //Show Alert Box'a tıklayınız.
        //Ok'a tıklayınız.
        //Alert kapanmalıdır.

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement fakeAlertts=driver.findElement(By.cssSelector("a[id='fakealerttest']"));
        fakeAlertts.click();
        MyFunc.Wait(2);

        WebElement showAlertts=driver.findElement(By.cssSelector("div[class='centered'] [id='fakealert']"));
        showAlertts.click();
        MyFunc.Wait(2);

        WebElement okButton=driver.findElement(By.cssSelector("div[class='dialog-actions'] [id='dialog-ok']"));
        okButton.click();
        MyFunc.Wait(2);

        BekleKapat();
    }

    @Test
    public void Test6()
    {
        //Bu siteye gidiniz. https://testpages.herokuapp.com/styled/index.html
        //Fake Alerts'e tıklayınız.
        //Show modal dialog buttonuna tıklayınız.
        //Ok'a tıklayınız.
        //Alert kapanmalıdır.

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement fakeAlertts=driver.findElement(By.cssSelector("a[id='fakealerttest']"));
        fakeAlertts.click();
        MyFunc.Wait(2);

        WebElement showModal=driver.findElement(By.cssSelector("div[class='centered'] [id='modaldialog']"));
        showModal.click();
        MyFunc.Wait(2);

        WebElement okButton=driver.findElement(By.cssSelector("div[class='dialog-actions'] button"));
        okButton.click();
        MyFunc.Wait(2);

        BekleKapat();
    }
}
