package SecondPrac.Sefa;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev1 extends BaseDriver {
    @Test
    public void Test1() {
        /*
       1) Bu siteye gidin. -> http://demoqa.com/text-box
       2) Full Name kısmına "Automation" girin.
       3) Email kısmına "Testing@gmail.com" girin.
       4) Current Address kısmına "Testing Current Address" girin.
       5) Permanent Address kısmına "Testing Permanent Address" girin.
       6) Submit butonuna tıklayınız.
       7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
       8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
       */

        String fullNameStr="Automation";
        String emailStr="Testing@gmail.com";
        String currentAddresStr="Testing Current Address";
        String permanentAddressStr="Testing permanent address";

        driver.get("http://demoqa.com/text-box");
        MyFunc.Wait(2);

        WebElement fullname=driver.findElement(By.cssSelector("[placeholder='Full Name']"));
        fullname.sendKeys(fullNameStr);
        MyFunc.Wait(2);

        WebElement email=driver.findElement(By.cssSelector("[placeholder='name@example.com']"));
        email.sendKeys(emailStr);
        MyFunc.Wait(2);

        WebElement currentAddress=driver.findElement(By.cssSelector("[placeholder='Current Address']"));
        currentAddress.sendKeys(currentAddresStr);
        MyFunc.Wait(2);

        WebElement permanentAddress=driver.findElement(By.cssSelector("div[id='permanentAddress-wrapper'] textarea"));
        permanentAddress.sendKeys(permanentAddressStr);
        MyFunc.Wait(2);

        WebElement submitBtn=driver.findElement(By.cssSelector("div[class='mt-2 justify-content-end row']>:nth-child(1)"));
        submitBtn.click();
        MyFunc.Wait(2);

        WebElement fullnameControl=driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(1)"));
        Assert.assertTrue("Fullname testi başarısız",fullnameControl.getText().contains("Automation"));

        WebElement emailControl=driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(2)"));
        Assert.assertTrue("email testi başarısız",emailControl.getText().contains("Testing"));

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
        String userNameStr="ttechno@gmail.com";
        String passwordStr="techno123.";

        driver.get("https://demo.applitools.com/");
        MyFunc.Wait(2);

        WebElement userName=driver.findElement(By.cssSelector("input[type='text']"));
        userName.sendKeys(userNameStr);
        MyFunc.Wait(2);

        WebElement password=driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys(passwordStr);
        MyFunc.Wait(2);

        WebElement singIn=driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        singIn.click();
        MyFunc.Wait(2);

        WebElement message=driver.findElement(By.cssSelector("div[class='content-w'] h6"));
        Assert.assertTrue("Giriş başarısız",message.getText().contains("Your nearest branch closes in: 30m 5s"));

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
        String searchStr="teddy bear";
        driver.get("https://www.snapdeal.com/");
        MyFunc.Wait(2);

        WebElement search=driver.findElement(By.cssSelector("input[placeholder='Search products & brands']"));
        search.sendKeys(searchStr);
        MyFunc.Wait(2);

        WebElement searchClick=driver.findElement(By.cssSelector("button[onclick^='submitSearchForm']"));
        searchClick.click();
        MyFunc.Wait(2);

       WebElement control=driver.findElement(By.cssSelector("div[id='searchMessageContainer'] span"));
       Assert.assertTrue("Test başarısız oldu",control.getText().contains("We've got 63 results for teddy bear"));

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
        MyFunc.Wait(2);

        WebElement calculatorClick=driver.findElement(By.linkText("Calculator"));
        calculatorClick.click();
        MyFunc.Wait(2);

        WebElement number1=driver.findElement(By.cssSelector("input[type='text'][name='number1']"));
        number1.sendKeys(number1Str);
        MyFunc.Wait(2);

        WebElement number2=driver.findElement(By.cssSelector("input[type='text'][name='number2']"));
        number2.sendKeys(number2Str);
        MyFunc.Wait(2);

        WebElement calculate=driver.findElement(By.cssSelector("[type='submit']"));
        calculate.click();
        MyFunc.Wait(2);

        WebElement answer=driver.findElement(By.cssSelector("div[class='page-body'] span"));
        System.out.println("cevap.getText() = " + answer.getText());

        int number1Int=Integer.parseInt(number1Str);
        int number2Int=Integer.parseInt(number2Str);
        int total=number1Int+number2Int;
        String totalStr=String.valueOf(total);
        Assert.assertTrue("Test başarısız",answer.getText().contains(totalStr));

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
        MyFunc.Wait(2);

        WebElement fakeAlerts=driver.findElement(By.cssSelector("a[id='fakealerttest']"));
        fakeAlerts.click();
        MyFunc.Wait(2);

        WebElement fakeAlertBoxBtn=driver.findElement(By.cssSelector("input[onclick='show_alert()']"));
        fakeAlertBoxBtn.click();
        MyFunc.Wait(2);

        WebElement control=driver.findElement(By.cssSelector("div[role='dialog'] h2"));
        Assert.assertTrue("Sayfa açılamadı",control.getText().contains("I am a fake alert box!"));

        WebElement okButton=driver.findElement(By.cssSelector("button[class='dialog-button']"));
        okButton.click();

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
        MyFunc.Wait(2);

        WebElement fakeAlerts=driver.findElement(By.cssSelector("a[id='fakealerttest']"));
        fakeAlerts.click();
        MyFunc.Wait(2);

        WebElement showModalDialogBtn=driver.findElement(By.cssSelector("input[onclick='show_modal()']"));
        showModalDialogBtn.click();
        MyFunc.Wait(2);

        WebElement control=driver.findElement(By.cssSelector("div[role='dialog'] h2"));
        Assert.assertTrue("Sayfa açılamadı",control.getText().contains("I am a modal div!"));

        WebElement okButton=driver.findElement(By.cssSelector("button[class='dialog-button']"));
        okButton.click();

        BekleKapat();
    }
}
