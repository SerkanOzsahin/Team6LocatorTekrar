import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Merve {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        MyFunc.Wait(3);

        WebElement fullNameBox=driver.findElement(By.id("userName"));
        fullNameBox.sendKeys("Merve Kaya");
        MyFunc.Wait(3);

        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("kayaamerve01@gmail.com");
        MyFunc.Wait(3);

        WebElement currentAdress=driver.findElement(By.id("currentAddress"));
        currentAdress.sendKeys("İstanbul/Turkey");
        MyFunc.Wait(3);

        WebElement permanentAdress=driver.findElement(By.id("permanentAddress"));
        permanentAdress.sendKeys("Güzelyalı mah. Adana/Turkey");
        MyFunc.Wait(3);

        WebElement buttonSubmit=driver.findElement(By.id("submit"));
        buttonSubmit.click();

        WebElement kontrolName=driver.findElement(By.id("name"));
        if (fullNameBox.getText().equals(kontrolName)){
            System.out.println("Doğrulandı");
        }else {
            System.out.println("Doğrulanmadı!");
        }

        WebElement kontrolEmail=driver.findElement(By.id("email"));
        if (email.getText().equals(kontrolEmail)){
                System.out.println("Doğrulandı");
        }else {
            System.out.println("Doğrulanmadı!");
        }

        WebElement kontrolCurrentAdress=driver.findElement(By.id("currentAddress"));
        if (currentAdress.getText().equals(kontrolCurrentAdress)){
            System.out.println("Doğrulandı");
        }else {
            System.out.println("Doğrulanmadı!");
        }

        WebElement kontrolPermanentAdress=driver.findElement(By.id("permanentAdress"));
        if (permanentAdress.getText().equals(kontrolPermanentAdress)){
            System.out.println("Doğrulandı");
        }else {
            System.out.println("Doğrulanmadı!");
        }

        WebElement buttonCheckBox=driver.findElement(By.id("item-1"));
        buttonSubmit.click();
        MyFunc.Wait(3);

        WebElement buttonHome=driver.findElement(By.className("rct-title"));
        buttonHome.click();
        MyFunc.Wait(3);

        WebElement buttonButtons=driver.findElement(By.className("item-4"));
        buttonButtons.click();
        MyFunc.Wait(3);

        WebElement buttonLinks=driver.findElement(By.id("item-5"));
        buttonLinks.click();
        MyFunc.Wait(3);

        WebElement homeButton=driver.findElement(By.id("simpleLink"));
        buttonHome.click();
        MyFunc.Wait(3);
        driver.quit();

    }
}
