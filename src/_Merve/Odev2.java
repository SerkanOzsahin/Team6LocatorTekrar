package _Merve;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Odev2 extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("http://demoqa.com/text-box");
        MyFunc.Wait(2);

        String fullName = "Automation";
        WebElement fullnameBox = driver.findElement(By.xpath("//input[@autocomplete='off' and@type='text' ]"));
        fullnameBox.sendKeys(fullName);
        MyFunc.Wait(2);

        String email = "Testing@gmail.com";
        WebElement emailBox = driver.findElement(By.xpath("//input[@autocomplete='off' and@type='email' ]"));
        emailBox.sendKeys(email);
        MyFunc.Wait(2);

        String currentAddress = "Testing Current Address";
        WebElement currentAdressBox = driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12']//textarea)[1]"));
        currentAdressBox.sendKeys(currentAddress);

        String permanentAddress = "Testing Permanent Address";
        WebElement permanentAddressBox = driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12' ]//textarea)[2]"));
        permanentAddressBox.sendKeys(permanentAddress);
        MyFunc.Wait(2);

        WebElement submitButton = driver.findElement(By.xpath("//div[@class='text-right col-md-2 col-sm-12' ]/button"));
        submitButton.click();
        MyFunc.Wait(2);

        WebElement kontrolName = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12' ]//p[1]"));
        Assert.assertTrue("Beklenen isime ulaşılamadı.", kontrolName.getText().contains(fullName));
        MyFunc.Wait(2);

        WebElement kontrolEmail = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12' ]//p[2]"));
        Assert.assertTrue("Beklenen e-maile ulaşılamadı!", kontrolEmail.getText().contains(email));
        BekleKapat();
    }

    @Test
    public void Test2() {
        driver.get("https://demo.applitools.com/");
        MyFunc.Wait(2);

        String fullname = "ttechno@gmail.com";
        WebElement fullnameBox = driver.findElement(By.xpath("(//div[@class='form-group' ]/input)[1]"));
        fullnameBox.sendKeys(fullname);
        MyFunc.Wait(2);

        String password = "techno123.";
        WebElement passwordBox = driver.findElement(By.xpath("(//div[@class='form-group' ]/input)[2]"));
        passwordBox.sendKeys(password);
        MyFunc.Wait(2);

        WebElement signIn = driver.findElement(By.xpath("//div[@class='buttons-w' ]/a"));
        signIn.click();
        MyFunc.Wait(2);

        WebElement kontrolText = driver.findElement(By.xpath("(//div[@class='element-wrapper compact pt-4' ])//h6[1]"));
        Assert.assertTrue("Beklenen yazıya ulaşılamadı.", kontrolText.getText().equals("Your nearest branch closes in: 30m 5s"));
        MyFunc.Wait(2);
        BekleKapat();
    }

    @Test
    public void Test3() {
        driver.get("https://www.snapdeal.com/");
        MyFunc.Wait(2);

        String text = "teddy bear";
        WebElement searchBox = driver.findElement(By.xpath("(//div[@class='col-xs-14 search-box-wrapper' ])/input"));
        searchBox.sendKeys(text);
        MyFunc.Wait(2);

        WebElement searchBoxClick = driver.findElement(By.xpath("(//div[@class='col-xs-14 search-box-wrapper' ])//button"));
        searchBoxClick.click();
        MyFunc.Wait(2);

        WebElement controlText = driver.findElement(By.xpath("(//div[@id='searchMessageContainer' ])/div"));
        Assert.assertTrue("Böyle bir text bulunamadı", controlText.getText().contains("We've got 63 results for teddy bear"));
        MyFunc.Wait(2);
        BekleKapat();
    }

    @Test
    public void Test4() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement calClick = driver.findElement(By.xpath("//div[@class='titledesc' ]//a[@href='calculator']"));
        calClick.click();
        MyFunc.Wait(2);

        String no1 = "9";
        WebElement number1 = driver.findElement(By.xpath("//div[@class='form-label' ]/input[1]"));
        number1.sendKeys(no1);
        MyFunc.Wait(2);

        String no2 = "7";
        WebElement number2 = driver.findElement(By.xpath("//div[@class='form-label' ]/input[2]"));
        number2.sendKeys(no2);
        MyFunc.Wait(2);

        WebElement calculateClick = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateClick.click();
        MyFunc.Wait(2);

        WebElement result = driver.findElement(By.xpath("//div[@class='centered']//div//p"));
        result.getText();
        MyFunc.Wait(2);

        int Number1 = Integer.parseInt(no1);
        int Number2 = Integer.parseInt(no2);
        int Result = Number1 + Number2;
        String multiple = String.valueOf(Result);
        Assert.assertTrue("Result is not true", result.getText().contains(multiple));
        BekleKapat();
    }

    @Test
    public void Test5() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement clickFakeAlert = driver.findElement(By.xpath("//a[@href='alerts/fake-alert-test.html' ]"));
        clickFakeAlert.click();
        MyFunc.Wait(2);

        WebElement clickShowAlert = driver.findElement(By.xpath("//div[@class='centered' ]//input[@onclick='show_alert()' ]"));
        clickShowAlert.click();
        MyFunc.Wait(2);

        WebElement controlText = driver.findElement(By.xpath("//div[@role='dialog' ]/h2"));
        Assert.assertTrue("Text görüntülenemedi!", controlText.getText().contains("I am a fake alert box!"));

        WebElement clickOk = driver.findElement(By.xpath("//div[@class='dialog-actions' ]/button"));
        clickOk.click();
        BekleKapat();
    }

    @Test
    public void Test6() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement clickFakeAlert = driver.findElement(By.xpath("//a[@href='alerts/fake-alert-test.html' ]"));
        clickFakeAlert.click();
        MyFunc.Wait(2);

        WebElement showModelDialogClick = driver.findElement(By.xpath("//div[@class='centered' ]/input[@onclick='show_modal()' ]"));
        showModelDialogClick.click();
        MyFunc.Wait(2);

        WebElement controlText = driver.findElement(By.xpath("//div[@role='dialog' ]/h2"));
        Assert.assertTrue("Texte ulaşılamadı!", controlText.getText().contains("I am a modal div!"));

        WebElement okClick = driver.findElement(By.xpath("//div[@class='dialog-actions' ]/button"));
        okClick.click();
        BekleKapat();
    }
    @Test
    public void DiffirentFormFromTest4(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement clickCalculate=driver.findElement(By.xpath("//div[@class='titledesc' ]//a[@href='calculator' ]"));
        clickCalculate.click();
        MyFunc.Wait(2);

        String no1="5";
        WebElement number1=driver.findElement(By.xpath("//div[@class='form-label' ]/input[@type='text' ][1]"));
        number1.sendKeys(no1);
        MyFunc.Wait(2);

        WebElement select=driver.findElement(By.xpath("//div[@class='form-label' ]/select"));
        Select selectMenu=new Select(select);
        selectMenu.selectByIndex(1);
        MyFunc.Wait(2);

        String no2="7";
        WebElement number2=driver.findElement(By.xpath("//div[@class='form-label' ]/input[2]"));
        number2.sendKeys(no2);
        MyFunc.Wait(2);

        WebElement clickButton=driver.findElement(By.cssSelector("div>:nth-child(1) input[class='styled-click-button' ]"));
        clickButton.click();
        MyFunc.Wait(2);

        WebElement text=driver.findElement(By.xpath("//p[text()='Answer : ']/span"));
        System.out.println("Text :" +text.getText());

        int sayi1=Integer.parseInt(no1);
        int sayi2=Integer.parseInt(no2);
        int carpim=sayi1*sayi2;

        String carpim2=String.valueOf(carpim);
        Assert.assertTrue("Sonuç doğru değil!",text.getText().contains(carpim2));
        BekleKapat();


    }
}
