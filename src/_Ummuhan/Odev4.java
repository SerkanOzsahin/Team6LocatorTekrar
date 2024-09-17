package _Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Odev4 extends BaseDriver {

    @Test
    public void Test1() {

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        MyFunc.Wait(2);
        Actions actions = new Actions(driver);

        List<WebElement> countries = driver.findElements(By.cssSelector("[class='dragDropSmallBox'][id^='q'] "));
        List<WebElement> cities = driver.findElements(By.cssSelector("#answerDiv > div"));

        for (WebElement city : cities) {
            for (WebElement country : countries) {

                actions.moveToElement(city).clickAndHold(city).build().perform();
                MyFunc.Wait(1);
                actions.moveToElement(country).release().build().perform();

                if(city.getCssValue("background-color").contains("rgba(0, 128, 0, 1)")){
                    break;
                }
            }
        }
        BekleKapat();
    }

    @Test
    public void Test2(){

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        MyFunc.Wait(2);

        Actions actions = new Actions(driver);

        List<WebElement> studentList = driver.findElements(By.cssSelector("[id^='node']"));
        List<WebElement> teamList = driver.findElements(By.cssSelector("[id^='box']"));

        for (WebElement students: studentList) {
            for (WebElement team : teamList) {

                 actions.moveToElement(students).clickAndHold(students).build().perform();
                 MyFunc.Wait(1);
                 actions.moveToElement(team).release().build().perform();
            }
        }
        BekleKapat();
    }
}
