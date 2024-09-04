package _Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odev1 extends BaseDriver {

    @Test
    public void Test1() {

        //  1) Bu siteye gidin. -> http://demoqa.com/text-box
        //  2) Full Name kısmına "Automation" girin.
        //  3) Email kısmına "Testing@gmail.com" girin.
        //  4) Current Address kısmına "Testing Current Address" girin.
        //  5) Permanent Address kısmına "Testing Permanent Address" girin.
        //  6) Submit butonuna tıklayınız.
        //  7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
        //  8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.

        driver.get("https://demoqa.com/text-box");

        String fullName = "Ümmühan Teke";
        WebElement fullnameBox = driver.findElement(By.cssSelector("div[id='userName-wrapper'] input"));
        fullnameBox.sendKeys(fullName);
        MyFunc.Wait(2);

        String emailMe = "ummuhantekeee@gmail.com";
        WebElement email = driver.findElement(By.cssSelector("div[id='userEmail-wrapper'] input"));
        email.sendKeys(emailMe);
        MyFunc.Wait(2);

        String address = "Mimar Sinan Mahallesi / Aydın ";
        WebElement currentAddress = driver.findElement(By.cssSelector("div[id='currentAddress-wrapper'] textarea"));
        currentAddress.sendKeys(address);
        MyFunc.Wait(2);

        String pAddress = "Erenler Mahallesi / İstanbul ";
        WebElement permanentAddress = driver.findElement(By.cssSelector("div[id='permanentAddress-wrapper'] textarea"));
        permanentAddress.sendKeys(pAddress);
        MyFunc.Wait(2);

        WebElement buttonSubmit = driver.findElement(By.cssSelector("div[class='mt-2 justify-content-end row'] button"));
        buttonSubmit.click();
        MyFunc.Wait(2);

        WebElement fullNameControl = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12'] > :nth-child(1)"));
        Assert.assertTrue("FullName eşleşme doğrulanamadı", fullNameControl.getText().contains(fullName));

        WebElement emailControl = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12'] > :nth-child(2)"));
        Assert.assertTrue("Email eşleşme doğrulanamadı", emailControl.getText().contains(emailMe));

        BekleKapat();
    }

    @Test
    public void Test2() {
        driver.get("https://demo.applitools.com/");

        String email = "techno@gmail.com";
        String passwordStr = "techno123.";

        WebElement userName = driver.findElement(By.cssSelector("div[class='form-group'] input"));
        userName.sendKeys(email);
        MyFunc.Wait(2);

        WebElement password = driver.findElement(By.cssSelector("div[class='form-group'] [id='password']"));
        password.sendKeys(passwordStr);
        MyFunc.Wait(2);

        WebElement button = driver.findElement(By.cssSelector("div[class='buttons-w'] a"));
        button.click();
        MyFunc.Wait(2);

        WebElement viewPostControl = driver.findElement(By.cssSelector("div[class='element-wrapper compact pt-4'] [id='time']"));
        Assert.assertTrue("ekranda yazı eşleşmesi bulunamadı", viewPostControl.getText().contains("nearest"));

        BekleKapat();
    }

    @Test
    public void Test3() {
        driver.get("https://www.snapdeal.com/");

        String teddyBear = "teddy bear";

        WebElement searchButton = driver.findElement(By.cssSelector("div[class='col-xs-14 search-box-wrapper'] [name='keyword']"));
        searchButton.sendKeys(teddyBear);
        MyFunc.Wait(2);

        WebElement searchBox = driver.findElement(By.cssSelector("button[class='searchformButton col-xs-4 rippleGrey'] span"));
        searchBox.click();
        MyFunc.Wait(2);

        WebElement viewPostControl = driver.findElement(By.cssSelector("div[class='search-result-txt-section  marT12'] span"));
        Assert.assertTrue("ekranda yazı eşleşmesi bulunamadı", viewPostControl.getText().contains("teddy bear"));

        BekleKapat();
    }

    @Test
    public void Test4() {
        String inputFirst = "15";
        String inputSecond = "27";

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculator = driver.findElement(By.cssSelector("div[class='titledesc'] [id='calculatetest']"));
        calculator.click();
        MyFunc.Wait(2);

        WebElement firstinput = driver.findElement(By.cssSelector("div[class='form-label'] [name='number1']"));
        firstinput.sendKeys(inputFirst);
        MyFunc.Wait(2);

        WebElement secondinput = driver.findElement(By.cssSelector("div[class='form-label'] [name='number2']"));
        secondinput.sendKeys(inputSecond);
        MyFunc.Wait(2);

        WebElement calculateButton = driver.findElement(By.cssSelector("form[action='calculator'] > :nth-child(2)"));
        calculateButton.click();
        MyFunc.Wait(2);

        WebElement answer = driver.findElement(By.cssSelector("div[class='centered']  > :nth-child(2)"));
        Assert.assertTrue("Doğru sonuç ekrana gelmedi", answer.getText().contains((String.valueOf(Integer.parseInt(inputFirst) + Integer.parseInt(inputSecond)))));
        System.out.println(answer.getText());
        MyFunc.Wait(2);

        BekleKapat();
    }

    @Test
    public void Test5() {

        //Bu websitesine gidiniz. [https://testpages.herokuapp.com/styled/index.html]
        //Fake Alerts' tıklayınız.
        //Show Alert Box'a tıklayınız.
        //Ok'a tıklayınız.
        //Alert kapanmalıdır.

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement fakeAlertts = driver.findElement(By.cssSelector("a[id='fakealerttest']"));
        fakeAlertts.click();
        MyFunc.Wait(2);

        WebElement showAlertts = driver.findElement(By.cssSelector("div[class='centered'] [id='fakealert']"));
        showAlertts.click();
        MyFunc.Wait(2);

        WebElement okButton = driver.findElement(By.cssSelector("div[class='dialog-actions'] [id='dialog-ok']"));
        okButton.click();
        MyFunc.Wait(2);

        BekleKapat();
    }

    @Test
    public void Test6() {

        //Bu siteye gidiniz. https://testpages.herokuapp.com/styled/index.html
        //Fake Alerts'e tıklayınız.
        //Show modal dialog buttonuna tıklayınız.
        //Ok'a tıklayınız.
        //Alert kapanmalıdır.

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        MyFunc.Wait(2);

        WebElement fakeAlertts = driver.findElement(By.cssSelector("a[id='fakealerttest']"));
        fakeAlertts.click();
        MyFunc.Wait(2);

        WebElement showModal = driver.findElement(By.cssSelector("div[class='centered'] [id='modaldialog']"));
        showModal.click();
        MyFunc.Wait(2);

        WebElement okButton = driver.findElement(By.cssSelector("div[class='dialog-actions'] button"));
        okButton.click();
        MyFunc.Wait(2);

        BekleKapat();
    }
}
