package _Sefa;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev2 extends BaseDriver {
    @Test
    public void Test1(){
        String fullNameStr = "Automation";
        String emailStr = "Testing@gmail.com";
        String currentAddressStr = "Testing Current Address";
        String permanentAddressStr = "Testing permanent address";

        driver.get("http://demoqa.com/text-box");
        MyFunc.Wait(2);

        WebElement fullName = driver.findElement(By.xpath("//input[@type='text']"));
        fullName.sendKeys(fullNameStr);
        MyFunc.Wait(2);

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(emailStr);
        MyFunc.Wait(2);

        WebElement currentAddress = driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
        currentAddress.sendKeys(currentAddressStr);
        MyFunc.Wait(2);

        WebElement permanentAddress = driver.findElement(By.xpath("(//textarea[@class='form-control'])[2]"));
        permanentAddress.sendKeys(permanentAddressStr);
        MyFunc.Wait(2);

        WebElement submitBtn = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        submitBtn.click();
        MyFunc.Wait(2);

        WebElement fullNameControl = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='name']"));
        Assert.assertTrue("Fullname testi başarısız", fullNameControl.getText().contains("Automation"));

        WebElement emailControl = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='email']"));
        Assert.assertTrue("email testi başarısız", emailControl.getText().contains("Testing"));

        BekleKapat();
    }

    @Test
    public void Test2(){
        /*
        1) Bu siteye gidin. -> https://demo.applitools.com/
        2) Username kısmına "ttechno@gmail.com" girin.
        3) Password kısmına "techno123." girin.
        4) "Sign in" buttonunan tıklayınız.
        5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.
         */
        String usernameStr="ttechno@gmail.com";
        String passwordStr="techno123.";

        driver.get("https://demo.applitools.com/");
        MyFunc.Wait(1);

        WebElement username=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        username.sendKeys(usernameStr);
        MyFunc.Wait(1);

        WebElement password=driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        password.sendKeys(passwordStr);
        MyFunc.Wait(1);

        WebElement singInClick=driver.findElement(By.xpath("//div[@class='buttons-w']/a"));
        singInClick.click();
        MyFunc.Wait(1);

        WebElement control=driver.findElement(By.xpath("(//div[@class='content-w']//h6)[1]"));
        Assert.assertTrue("Siteye giriş başarısız oldu",control.getText().contains("Your nearest branch closes in: 30m 5s"));

        BekleKapat();
    }

    @Test
    public void Test3(){
         /*
        1) Bu siteye gidin. -> https://www.snapdeal.com/
        2) "teddy bear" aratın ve Search butonuna tıklayın.
        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.
       */
        String searchConfirm ="teddy bear";

        driver.get("https://www.snapdeal.com/");
        MyFunc.Wait(1);

        WebElement searchBox=driver.findElement(By.xpath("(//div[@class='topBar  top-bar-homepage  top-freeze-reference-point']//input)[1]"));
        searchBox.sendKeys(searchConfirm);
        MyFunc.Wait(1);

        WebElement searchBtn=driver.findElement(By.xpath("//span[@class='searchTextSpan']"));
        searchBtn.click();
        MyFunc.Wait(1);

        WebElement control=driver.findElement(By.xpath("//div[@id='searchMessageContainer']//span"));
        Assert.assertTrue("Sayfaya giriş yapılamadı",control.getText().contains("We've got 63 results for teddy bear"));

        BekleKapat();
    }

    @Test
    public void Test4(){
         /*
        Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        Calculate'e tıklayınız.
        İlk input'a herhangi bir sayı giriniz.
        İkinci input'a herhangi bir sayı giriniz.
        Calculate button'una tıklayınız.
        Sonucu alınız.
        Sonucu yazdırınız.
      */
        String number1Str="5";
        String number2Str="5";

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(1);

        WebElement clickCalculator=driver.findElement(By.xpath("//div[@class='thumbdesclist']//a[@id='calculatetest']"));
        clickCalculator.click();
        MyFunc.Wait(1);

        WebElement number1=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        number1.sendKeys(number1Str);
        MyFunc.Wait(1);

        WebElement number2=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        number2.sendKeys(number2Str);
        MyFunc.Wait(1);

        WebElement calculator=driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
        calculator.click();
        MyFunc.Wait(1);

        WebElement answer=driver.findElement(By.xpath("//span[@id='answer']"));
        String answerStr=answer.getText();

        int number1Int=Integer.parseInt(number1Str);
        int number2Int=Integer.parseInt(number2Str);
        int total=number1Int+number2Int;
        String numbers=String.valueOf(total);

        Assert.assertTrue("Test başarısız",answerStr.contains(numbers));

        BekleKapat();
    }

    @Test
    public void Test5(){
          /*
        Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        Fake Alerts' tıklayınız.
        Show Alert Box'a tıklayınız.
        Ok'a tıklayınız.
        Alert kapanmalıdır.
         */
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(1);

        WebElement fakeAlerts=driver.findElement(By.xpath("//a[text()='Fake Alerts']"));
        fakeAlerts.click();
        MyFunc.Wait(1);

        WebElement alertBox=driver.findElement(By.xpath("//input[@onclick='show_alert()']"));
        alertBox.click();
        MyFunc.Wait(1);

        WebElement okBtn=driver.findElement(By.xpath("//div[@role='dialog']//button"));
        okBtn.click();

        BekleKapat();
    }

    @Test
    public void Test6(){
         /*
       Bu siteye gidiniz. https://testpages.herokuapp.com/styled/index.html
       Fake Alerts'e tıklayınız.
       Show modal dialog buttonuna tıklayınız.
       Ok'a tıklayınız.
       Alert kapanmalıdır.
        */
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(1);

        WebElement fakeAlerts=driver.findElement(By.xpath("(//div[@class='page-body']//ul//a)[8]"));
        fakeAlerts.click();
        MyFunc.Wait(1);

        WebElement modalDialogBtn=driver.findElement(By.xpath("(//div[@class='centered']//input)[2]"));
        modalDialogBtn.click();
        MyFunc.Wait(1);

        WebElement okBtn=driver.findElement(By.xpath("//div[@class='dialog-actions']//button"));
        okBtn.click();

        BekleKapat();
    }
}
