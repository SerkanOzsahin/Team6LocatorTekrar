package _Ummuhan;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Odev5 extends BaseDriver {

     public static WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

    @Test
    public void Soru1(){
        //    1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
        //    2- random 100 e kadar 2 sayı üretiniz.
        //    3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
        //    4- Sonuçları Assert ile kontrol ediniz.
        //    5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        wait.until(ExpectedConditions.urlToBe("https://testsheepnz.github.io/BasicCalculator.html"));

        int total=0;
        int numberOne=(int) (Math.random() * 100);
        int numberTwo=(int) (Math.random() * 100);

        String numberOneStr=String.valueOf(numberOne);
        String numberTwoStr=String.valueOf(numberTwo);
        String totalStr;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='number1Field']")));
        WebElement firstNumber=driver.findElement(By.xpath("//input[@id='number1Field']"));
        firstNumber.sendKeys(numberOneStr);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='number2Field']")));
        WebElement secondNumber=driver.findElement(By.xpath("//input[@id='number2Field']"));
        secondNumber.sendKeys(numberTwoStr);

        for (int i = 0; i <= 4; i++) {
            WebElement selectMenu = driver.findElement(By.id("selectOperationDropdown"));
            Select select = new Select(selectMenu);
            select.selectByIndex(i);

            switch (i) {
                case 0: total = numberOne + numberTwo; break;
                case 1: total = numberOne - numberTwo; break;
                case 2: total = numberOne * numberTwo; break;
                case 3: total = numberOne / numberTwo; break;
                case 4: totalStr = numberOneStr = numberOneStr.concat(numberTwoStr);break;
            }
            totalStr = String.valueOf(total);
            System.out.println("totalStr = " + totalStr);

            WebElement calculate = driver.findElement(By.cssSelector("[id='calculateButton']"));
            wait.until(ExpectedConditions.elementToBeClickable(calculate));
            calculate.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberAnswerField")));
            WebElement answer = driver.findElement(By.id("numberAnswerField"));
            System.out.println("answer.getAttribute(Value) = " + answer.getAttribute("value"));
            Assert.assertTrue("Toplam yanlış", answer.getAttribute("value").contains(totalStr));

            WebElement clearBtn = driver.findElement(By.id("clearButton"));
            clearBtn.click();
        }
        BekleKapat();
    }
    @Test
    public void Soru2(){
        //1- google.com ile sayfayı açınız.
        //2- Bu açılan yeni sayfada facebook.com u açınız.
        //3- Bu sayfanın açıldığını URL sinden kontrol ediniz.
        //4- Daha sonra facebook.com sayfasını kapatınız.

        driver.get("https://www.google.com/");

        //SORU İPTAL EDİLDİ !
    }

    @Test
    public void Soru3(){
        //1) https://demoqa.com/browser-windows adresine gidin
        //2) Alerts’e tiklayin
        //3) On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
        //4) Allert’in gorunur olmasini bekleyin
        //5) Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
        //6) Ok diyerek alerti kapatin

        driver.get("https://demoqa.com/browser-windows");
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/browser-windows"));

        WebElement alertsButton=driver.findElement(By.xpath("(//li[@id='item-1'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(alertsButton));
        alertsButton.click();

        WebElement clickMe=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        wait.until(ExpectedConditions.elementToBeClickable(clickMe));
        clickMe.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue("Alert yazısı eşleşmiyor", driver.switchTo().alert().getText().contains("5 seconds"));
        driver.switchTo().alert().accept();

        BekleKapat();
    }

    @Test
    public void Soru4(){
        //1) https://demoqa.com/dynamic-properties adresine gidin
        //2) “Will enable 5 seconds” butonunun enable olmasini bekleyin
        //3) “Will enable 5 seconds” butonunun enable oldugunu test edin
        driver.get("https://demoqa.com/dynamic-properties");
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/dynamic-properties"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='enableAfter']")));
        WebElement willEnableButton=driver.findElement(By.xpath("//button[@id='enableAfter']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='enableAfter']")));
        Assert.assertTrue("'Will enable 5 seconds' butonu etkin değil", willEnableButton.isEnabled() );

        BekleKapat();
    }

    @Test
    public void Soru5(){
        //https://demoqa.com/dynamic-properties adresine gidin
        //1) “Visible After 5 seconds” butonunun gorunur olmasini bekleyin
        //2) “Visible After 5 seconds” butonunun gorunur oldugunu test edin
        driver.get("https://demoqa.com/dynamic-properties");
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/dynamic-properties"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        WebElement visibleAfter=driver.findElement(By.id("visibleAfter"));
        Assert.assertTrue("Buton görünür değil !", visibleAfter.isDisplayed());

        BekleKapat();
    }

    @Test
    public void Soru6(){
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //1) “Add Element” butona basin
        //2) “Delete” butonu gorunur oluncaya kadar bekleyin
        //3) “Delete” butonunun gorunur oldugunu test edin
        //4) Delete butonuna basarak butonu silin
        //5) Delete butonunun gorunmedigini test edin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/add_remove_elements/"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='addElement()']")));
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='deleteElement()']")));
        WebElement deleteButton=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertTrue("Delete butonu görünür değil", deleteButton.isDisplayed());
        new Actions(driver).moveToElement(deleteButton).click().build().perform();

        WebElement controlDelete=driver.findElement(By.id("elements"));
        Assert.assertTrue("Delete butonu görünür durumda", controlDelete.getText().isEmpty());

        BekleKapat();
    }
}
