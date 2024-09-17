package _Sefa;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Odev5 extends BaseDriver {

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public static Actions actions;


    @Test
    public void Test1() {
        // Senaryo
        //1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
        //2- random 100 e kadar 2 sayı üretiniz.
        //3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
        //4- Sonuçları Assert ile kontrol ediniz.
        //5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        wait.until(ExpectedConditions.urlToBe("https://testsheepnz.github.io/BasicCalculator.html"));

        int total=0;
        int number = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);
        String numberStr = String.valueOf(number);
        String number2Str = String.valueOf(number2);
        String totalStr;

        WebElement inputNumber1 = driver.findElement(By.cssSelector("[id='number1Field']"));
        wait.until(ExpectedConditions.visibilityOf(inputNumber1));
        inputNumber1.sendKeys(numberStr);

        WebElement inputNumber2 = driver.findElement(By.cssSelector("[id='number2Field']"));
        wait.until(ExpectedConditions.visibilityOf(inputNumber2));
        inputNumber2.sendKeys(number2Str);

        for (int i = 0; i <= 4; i++) {
            WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
            Select select = new Select(operation);
            select.selectByIndex(i);

            switch (i){
                case 0 : total=number+number2; break;
                case 1 : total=number-number2; break;
                case 2 : total=number*number2; break;
                case 3 : total=number/number2; break;
                case 4 : totalStr=numberStr=numberStr.concat(number2Str); break;
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
    public void Test2() {
        //Senaryo
        //1- google.com ile sayfayı açınız.
        //2- Daha sonra Yeni bir TAB (ctrl+T) açınız.
        //3- Bu açılan yeni sayfada facebook.com u açınız.
        //4- Bu sayfanın açıldığını URL sinden kontrol ediniz.
        //5- Daha sonra facebook.com sayfasını kapatınız.

        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.urlToBe("https://www.google.com/"));

        WebElement search=driver.findElement(By.name("q"));

        BekleKapat();
    }

    @Test
    public void Test3() {
        //Senaryo
        //1) https://demoqa.com/browser-windows adresine gidin
        //2) Alerts’e tiklayin
        //3) On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
        //4) Allert’in gorunur olmasini bekleyin
        //5) Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
        //6) Ok diyerek alerti kapatin

        driver.get("https://demoqa.com/browser-windows");
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/browser-windows"));

        WebElement alertBtn=driver.findElement(By.xpath("(//li[@id='item-1'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(alertBtn));
        alertBtn.click();

        WebElement alert5SecondBtn=driver.findElement(By.cssSelector("[id='timerAlertButton']"));
        wait.until(ExpectedConditions.elementToBeClickable(alert5SecondBtn));
        alert5SecondBtn.click();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertText=driver.switchTo().alert().getText();
        Assert.assertTrue("Alertte bulunan yazılar eşleşmiyor",alertText.contains("after 5 seconds"));
        driver.switchTo().alert().accept();

        BekleKapat();
    }

    @Test
    public void Test4() {
        //Senaryo
        //1) https://demoqa.com/dynamic-properties adresine gidin
        //2) “Will enable 5 seconds” butonunun enable olmasini bekleyin
        //3) “Will enable 5 seconds” butonunun enable oldugunu test edin
        driver.get("https://demoqa.com/dynamic-properties");
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/dynamic-properties"));

        WebElement afterEnableBtn=driver.findElement(By.cssSelector("[id='enableAfter']"));
        wait.until(ExpectedConditions.elementToBeClickable(afterEnableBtn));
        Assert.assertTrue("Button Tıklanabilir değil ",afterEnableBtn.isEnabled());

        BekleKapat();
    }

    @Test
    public void Test5() {
        //Senaryo
        //https://demoqa.com/dynamic-properties adresine gidin
        //1) “Visible After 5 seconds” butonunun gorunur olmasini bekleyin
        //2) “Visible After 5 seconds” butonunun gorunur oldugunu test edin
        driver.get("https://demoqa.com/dynamic-properties");
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/dynamic-properties"));

        WebElement visibleBtn=driver.findElement(By.cssSelector("[id='visibleAfter']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='visibleAfter']")));
        Assert.assertTrue("Button Gözükürmür", visibleBtn.isDisplayed());

        BekleKapat();
    }

    @Test
    public void Test6() {
        //Senaryo
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //1) “Add Element” butona basin
        //2) “Delete” butonu gorunur oluncaya kadar bekleyin
        //3) “Delete” butonunun gorunur oldugunu test edin
        //4) Delete butonuna basarak butonu silin
        //5) Delete butonunun gorunmedigini test edin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/add_remove_elements/"));

        WebElement addElement=driver.findElement(By.cssSelector("[onclick='addElement()']"));
        addElement.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[onclick='deleteElement()']")));
        WebElement deleteBtn=driver.findElement(By.cssSelector("[onclick='deleteElement()']"));
        Assert.assertTrue("Delete buton göürünür durumda değil ",deleteBtn.isDisplayed());
        deleteBtn.click();

        WebElement deleteControl=driver.findElement(By.id("elements"));
        Assert.assertTrue("Delete button görünür durumda",deleteControl.getText().isEmpty());

        BekleKapat();
    }
}
