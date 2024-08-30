import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Merve {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        MyFunc.Wait(3);

        String ad="Merve Kaya";
        WebElement fullNameBox=driver.findElement(By.id("userName"));
        fullNameBox.sendKeys(ad);
        MyFunc.Wait(3);

        String eMail="kayaamervee01@gmail.com";
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys(eMail);
        MyFunc.Wait(3);

        String adress="İstanbul/Turkey";
        WebElement currentAdress=driver.findElement(By.id("currentAddress"));
        currentAdress.sendKeys(adress);
        MyFunc.Wait(3);

        String pAdress="Güzelyalı mah. Adana/Turkey";
        WebElement permanentAdress=driver.findElement(By.id("permanentAddress"));
        permanentAdress.sendKeys(pAdress);
        MyFunc.Wait(3);

        WebElement buttonSubmit=driver.findElement(By.id("submit"));
        buttonSubmit.click();
        MyFunc.Wait(3);

        WebElement kontrolName=driver.findElement(By.id("name"));
        if (kontrolName.getText().contains(ad)){
            System.out.println("Doğrulandı");
        }else {
            System.out.println("Doğrulanmadı!");
        }
        MyFunc.Wait(3);

        WebElement kontrolEmail=driver.findElement(By.id("email"));
        if (kontrolEmail.getText().contains(eMail)){
                System.out.println("Doğrulandı");
        }else {
            System.out.println("Doğrulanmadı!");
        }
        MyFunc.Wait(3);

        WebElement buttonCheckBox=driver.findElement(By.id("item-1"));
        buttonCheckBox.click();
        MyFunc.Wait(3);

        WebElement buttonHome=driver.findElement(By.className("rct-checkbox"));
        buttonHome.click();
        MyFunc.Wait(3);

        WebElement buttonButtons=driver.findElement(By.id("item-4"));
        buttonButtons.click();
        MyFunc.Wait(3);

        WebElement buttonLinks=driver.findElement(By.id("item-5"));
        buttonLinks.click();
        MyFunc.Wait(3);

        WebElement homeButton=driver.findElement(By.id("simpleLink"));
        homeButton.click();
        MyFunc.Wait(3);
        driver.quit();

    }
}
