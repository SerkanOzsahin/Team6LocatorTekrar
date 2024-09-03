package FirstPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Utility.MyFunc;


public class Ümmühan {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        String fullName = "FirstPrac.Ümmühan Teke";
        WebElement fullnameBox = driver.findElement(By.id("userName"));
        fullnameBox.sendKeys(fullName);
        MyFunc.Wait(2);

        String emailMe = "ummuhantekeee@gmail.com";
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys(emailMe);
        MyFunc.Wait(2);

        String address = "Mimar Sinan Mahallesi / Aydın ";
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(address);
        MyFunc.Wait(2);

        String pAddress = "Erenler Mahallesi / İstanbul ";
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(pAddress);
        MyFunc.Wait(2);

        WebElement buttonSubmit = driver.findElement(By.id("submit"));
        buttonSubmit.click();
        MyFunc.Wait(2);

        // TODO getText : mesaj al.
        // Kullanıcı bilgileri girdikten sonra submit yapıp  kontrol edilen yer, bu kısmın getTexti alınır.

        WebElement name=driver.findElement(By.id("name"));
        if (name.getText().contains(fullName)) {
            System.out.println("İsim soyisim eşleşmesi doğrulandı");
        } else {
            System.out.println("Doğrulanma Bulunamadı");
        }
        MyFunc.Wait(1);

        WebElement email2=driver.findElement(By.id("email"));
        if (email2.getText().contains(emailMe)) {
            System.out.println("E-mail adresi doğrulandı");
        } else {
            System.out.println("E-mail adresi doğrulanamadı");
        }
        MyFunc.Wait(1);

        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();
        MyFunc.Wait(2);

        WebElement homeBox = driver.findElement(By.className("rct-checkbox"));
        homeBox.click();
        MyFunc.Wait(3);

        WebElement buttonsBox = driver.findElement(By.id("item-4"));
        buttonsBox.click();
        MyFunc.Wait(3);

        WebElement links = driver.findElement(By.id("item-5"));
        links.click();
        MyFunc.Wait(3);

        WebElement homeLink = driver.findElement(By.id("simpleLink"));
        homeLink.click();

        MyFunc.Wait(3);
        driver.quit();


    }
}


