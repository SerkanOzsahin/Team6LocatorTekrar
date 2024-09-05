package _Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev2 extends BaseDriver {
    //sorular ödev1 ile aynıdır.

    @Test
    public void Test1()
    {

        driver.get("https://demoqa.com/text-box");

        String fullName = "Ümmühan Teke";
        WebElement fullnameBox = driver.findElement(By.xpath("//input[@type='text']"));
        fullnameBox.sendKeys(fullName);
        MyFunc.Wait(2);

        String emailMe = "ummuhantekeee@gmail.com";
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(emailMe);
        MyFunc.Wait(2);

        String address = "Mimar Sinan Mahallesi / Aydın ";
        WebElement currentAddress = driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12']//textarea)[1]"));
        currentAddress.sendKeys(address);
        MyFunc.Wait(2);

        String pAddress = "Erenler Mahallesi / İstanbul ";
        WebElement permanentAddress = driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12']//textarea)[2]"));
        permanentAddress.sendKeys(pAddress);
        MyFunc.Wait(2);

        WebElement buttonSubmit = driver.findElement(By.xpath("//div[@class='text-right col-md-2 col-sm-12']/button"));
        buttonSubmit.click();
        MyFunc.Wait(2);

        WebElement fullNameControl = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='name']"));
        Assert.assertTrue("FullName eşleşme doğrulanamadı", fullNameControl.getText().contains(fullName));

        WebElement emailControl = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='email']"));
        Assert.assertTrue("Email eşleşme doğrulanamadı", emailControl.getText().contains(emailMe));

        BekleKapat();
    }

    @Test
    public void Test2()
    {
        driver.get("https://demo.applitools.com/");

        String email = "techno@gmail.com";
        String passwordStr = "techno123.";

        WebElement userName = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='username']"));
        userName.sendKeys(email);
        MyFunc.Wait(2);

        WebElement password = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='password']"));
        password.sendKeys(passwordStr);
        MyFunc.Wait(2);

        WebElement button = driver.findElement(By.xpath("//div[@class='buttons-w']/a"));
        button.click();
        MyFunc.Wait(2);

        WebElement viewPostControl = driver.findElement(By.xpath("(//div[@class='content-w']//h6)[1]"));
        Assert.assertTrue("ekranda yazı eşleşmesi bulunamadı", viewPostControl.getText().contains("nearest"));

        BekleKapat();
    }

    @Test
    public void Test3()
    {
        driver.get("https://www.snapdeal.com/");

        String teddyBear = "teddy bear";

        WebElement searchButton = driver.findElement(By.xpath("//div[@class='col-xs-14 search-box-wrapper']/input"));
        searchButton.sendKeys(teddyBear);
        MyFunc.Wait(2);

        WebElement searchBox = driver.findElement(By.xpath("//span[@class='searchTextSpan']/i"));
        searchBox.click();
        MyFunc.Wait(2);

        WebElement viewPostControl = driver.findElement(By.xpath("//div[@id='searchMessageContainer']//span"));
        Assert.assertTrue("ekranda yazı eşleşmesi bulunamadı", viewPostControl.getText().contains("teddy bear"));

        BekleKapat();
    }

    @Test
    public void Test4()
    {
        String inputFirst = "15";
        String inputSecond = "27";

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculator = driver.findElement(By.xpath("//a[@id='calculatetest']"));
        calculator.click();
        MyFunc.Wait(2);

        WebElement firstinput = driver.findElement(By.xpath("//div[@class='form-label']//input[@name='number1']"));
        firstinput.sendKeys(inputFirst);
        MyFunc.Wait(2);

        WebElement secondinput = driver.findElement(By.xpath("//div[@class='form-label']//input[@name='number2']"));
        secondinput.sendKeys(inputSecond);
        MyFunc.Wait(2);

        WebElement calculateButton = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();
        MyFunc.Wait(2);

        WebElement answer = driver.findElement(By.xpath("//div[@class='centered']//div//p"));
        Assert.assertTrue("Doğru sonuç ekrana gelmedi", answer.getText().contains((String.valueOf(Integer.parseInt(inputFirst) + Integer.parseInt(inputSecond)))));
        System.out.println(answer.getText());
        MyFunc.Wait(2);

        BekleKapat();
    }

    @Test
    public void Test5()
    {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement fakeAlertts = driver.findElement(By.xpath("//a[@id='fakealerttest']"));
        fakeAlertts.click();
        MyFunc.Wait(2);

        WebElement showAlertts = driver.findElement(By.xpath("//div[@class='centered']//input[@id='fakealert']"));
        showAlertts.click();
        MyFunc.Wait(2);

        WebElement okButton = driver.findElement(By.xpath("//div[@id='dialog']//button"));
        okButton.click();
        MyFunc.Wait(2);

        BekleKapat();
    }

    @Test
    public void Test6()
    {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement fakeAlertts = driver.findElement(By.xpath("//a[@id='fakealerttest']"));
        fakeAlertts.click();
        MyFunc.Wait(2);

        WebElement showModal = driver.findElement(By.xpath("//div[@class='centered']//input[@id='modaldialog']"));
        showModal.click();
        MyFunc.Wait(2);

        WebElement okButton = driver.findElement(By.xpath("//div[@id='dialog']//button"));
        okButton.click();
        MyFunc.Wait(2);

        BekleKapat();

    }
}




