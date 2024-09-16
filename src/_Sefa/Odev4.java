package _Sefa;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Odev4 extends BaseDriver {
    @Test
    public void Test1(){
        //Ödev 1 : http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
        // buradaki ülke ve şehirleri findElements ile topluca bularak
        // bir döngü ile bütün şehirleri doğru ülkere dağıtınız.
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        MyFunc.Wait(2);
        Actions actions = new Actions(driver);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        List<WebElement> countries = driver.findElements(By.cssSelector("[class='dragDropSmallBox'][id^='q']"));
        List<WebElement> cities = driver.findElements(By.cssSelector("#answerDiv > div"));

        for (WebElement city : cities) {
            for (WebElement country : countries) {
                actions.moveToElement(city).clickAndHold(city).build().perform();
                MyFunc.Wait(1);
                actions.moveToElement(country).release().build().perform();
                if (city.getCssValue("background-color").contains("rgba(0, 128, 0, 1)")) {
                    break;
                }
            }
        }
        MyFunc.Wait(1);
        driver.quit();
    }
}
