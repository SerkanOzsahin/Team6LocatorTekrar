package _Merve;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;

public class Odev1 extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement clickFakeAlert = driver.findElement(By.cssSelector("a[href='alerts/fake-alert-test.html']"));
        clickFakeAlert.click();
        MyFunc.Wait(2);

        WebElement clickShowAlert = driver.findElement(By.cssSelector("div[class='centered'] input"));
        clickShowAlert.click();
        MyFunc.Wait(2);

        WebElement controlText = driver.findElement(By.cssSelector("div[role='dialog'] h2"));
        Assert.assertTrue("Text görüntülenemedi!", controlText.getText().contains("I am a fake alert box!"));

        WebElement clickOk = driver.findElement(By.cssSelector("div[class='dialog-actions'] button"));
        clickOk.click();
        BekleKapat();
    }

    @Test
    public void Test2() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement clickFakeAlert = driver.findElement(By.cssSelector("a[href='alerts/fake-alert-test.html']"));
        clickFakeAlert.click();
        MyFunc.Wait(2);

        WebElement showModelDialogClick = driver.findElement(By.cssSelector("input[onclick='show_modal()']"));
        showModelDialogClick.click();
        MyFunc.Wait(2);

        WebElement controlText = driver.findElement(By.cssSelector("div[role='dialog'] h2"));
        Assert.assertTrue("Texte ulaÅŸÄ±lamadÄ±!", controlText.getText().contains("I am a modal div!"));

        WebElement okClick = driver.findElement(By.cssSelector("button[class='dialog-button']"));
        okClick.click();
        BekleKapat();
    }

    @Test
    public void Test3() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement calClick = driver.findElement(By.cssSelector("div[class='titledesc'] a[href='calculator']"));
        calClick.click();
        MyFunc.Wait(2);

        String no1 = "9";
        WebElement number1 = driver.findElement(By.cssSelector("div[class='form-label'] >:nth-child(1)"));
        number1.sendKeys(no1);
        MyFunc.Wait(2);

        String no2 = "7";
        WebElement number2 = driver.findElement(By.cssSelector("div[class='form-label'] >:nth-child(3)"));
        number2.sendKeys(no2);
        MyFunc.Wait(2);

        WebElement calculateClick = driver.findElement(By.cssSelector("input[class='styled-click-button']"));
        calculateClick.click();
        MyFunc.Wait(2);

        WebElement result = driver.findElement(By.cssSelector("div[class='centered'] span"));
        Assert.assertTrue("Result is not true", result.getText().contains("16"));
        MyFunc.Wait(2);
        BekleKapat();
    }

    @Test
    public void Test4() {
        driver.get("https://www.snapdeal.com/");
        MyFunc.Wait(2);

        String text = "teddy bear";
        WebElement searchBox = driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper'] input"));
        searchBox.sendKeys(text);
        MyFunc.Wait(2);

        WebElement searchBoxClick = driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper'] button"));
        searchBoxClick.click();
        MyFunc.Wait(2);

        WebElement controlText = driver.findElement(By.cssSelector("div[id='searchMessageContainer'] span"));
        Assert.assertTrue("Böyle bir text bulunamadı", controlText.getText().contains("We've got 63 results for teddy bear"));
        MyFunc.Wait(2);
        BekleKapat();
    }

    @Test
    public void Test5() {
        driver.get("https://demo.applitools.com/");
        MyFunc.Wait(2);

        String fullname = "ttechno@gmail.com";
        WebElement fullnameBox = driver.findElement(By.cssSelector("div[class='form-group']>:nth-child(2)"));
        fullnameBox.sendKeys(fullname);
        MyFunc.Wait(2);

        String password = "techno123.";
        WebElement passwordBox = driver.findElement(By.cssSelector("div[class='form-group'] input[type='password']"));
        passwordBox.sendKeys(password);
        MyFunc.Wait(2);

        WebElement signIn = driver.findElement(By.cssSelector("div[class='buttons-w'] a"));
        signIn.click();
        MyFunc.Wait(2);

        WebElement kontrolText = driver.findElement(By.cssSelector("div[class='element-wrapper compact pt-4'] h6"));
        Assert.assertTrue("Beklenen yazıya ulaşılamadı.", kontrolText.getText().equals("Your nearest branch closes in: 30m 5s"));
        MyFunc.Wait(2);
        BekleKapat();
    }

    @Test
    public void Test6() {
        driver.get("http://demoqa.com/text-box");
        MyFunc.Wait(2);

        String fullname = "Automation";
        WebElement fullnameBox = driver.findElement(By.cssSelector("div[id='userName-wrapper'] input"));
        fullnameBox.sendKeys(fullname);
        MyFunc.Wait(2);

        String email = "Testing@gmail.com";
        WebElement emailBox = driver.findElement(By.cssSelector("div[id='userEmail-wrapper'] input"));
        emailBox.sendKeys(email);
        MyFunc.Wait(2);

        String currentAdress = "Testing Current Address";
        WebElement currentAdressBox = driver.findElement(By.cssSelector("div[id='currentAddress-wrapper'] textarea"));
        currentAdressBox.sendKeys(currentAdress);
        MyFunc.Wait(2);

        String permanentAdress = "Testing Permanent Address";
        WebElement permanentAdressBox = driver.findElement(By.cssSelector("div[id='permanentAddress-wrapper'] textarea"));
        permanentAdressBox.sendKeys(permanentAdress);
        MyFunc.Wait(2);

        WebElement submitButton = driver.findElement(By.cssSelector("div[class='text-right col-md-2 col-sm-12']>button"));
        submitButton.click();
        MyFunc.Wait(2);

        WebElement kontrolName = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(1)"));
        Assert.assertTrue("Beklenen isime ulaşılamadı.", kontrolName.getText().contains(fullname));
        MyFunc.Wait(2);

        WebElement kontrolEmail = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>:nth-child(2)"));
        Assert.assertTrue("Beklenen e-maile ulaşılamadı.", kontrolEmail.getText().contains(email));
        MyFunc.Wait(2);
        BekleKapat();
    }
}
