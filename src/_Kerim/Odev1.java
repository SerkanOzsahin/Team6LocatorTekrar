package _Kerim;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev1 {
    public static void main(String[] args) {

        //demoqa.com/text-box a gidin
        //Full Name, Email, Current Adress ve Permanent Adress bilgilerini doldurup Submit e tıklayın
        //Çıkan kutucuktaki bilgilerin, girdiğiniz bilgilerle aynı olduğunu kontrol edin
        //Sol Menüden check box a tıklayın
        //Home a tıklayın
        //Sol Menüden Buttons a tıklayın
        //Click Me ye tıklayın
        //Sol Menüden Links e tıklayın
        //Home linkine tıklayın
        //driver ı kapatın

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        String name = "_Kerim.Kerim";
        String email = "a.kerim1990@hotmail.com";
        String curAddress = "Bağcılar/İstanbul";
        String perAddress = "Antakya/Hatay";

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("_Kerim.Kerim");
        MyFunc.Wait(2);
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("a.kerim1990@hotmail.com");
        MyFunc.Wait(2);
        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        currentAdress.sendKeys("Bağcılar/İstanbul");
        MyFunc.Wait(2);
        WebElement permanentAdress = driver.findElement(By.id("permanentAddress"));
        permanentAdress.sendKeys("Antakya/Hatay");
        MyFunc.Wait(2);
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();
        WebElement namelabel = driver.findElement(By.id("name"));

        if (namelabel.getText().contains(name)) {
            System.out.println("isim eklendi");
        } else
            System.out.println("Eklenemedi");

        MyFunc.Wait(1);

        WebElement emailelement = driver.findElement(By.id("email"));

        if (emailelement.getText().contains(email)) {
            System.out.println("Mail eklendi");
        } else
            System.out.println("Eklenemedi");

        MyFunc.Wait(1);

        WebElement btnCheckBox = driver.findElement(By.id("item-1"));
        btnCheckBox.click();
        MyFunc.Wait(2);
        WebElement btnHome = driver.findElement(By.className("rct-checkbox"));
        btnHome.click();
        MyFunc.Wait(2);
        WebElement btnButtons = driver.findElement(By.id("item-4"));
        btnButtons.click();
        MyFunc.Wait(2);
        WebElement btnClickMe = driver.findElement(By.className("mt-4"));
        btnClickMe.click();
        MyFunc.Wait(2);
        WebElement btnLinks = driver.findElement(By.id("item-5"));
        btnLinks.click();
        MyFunc.Wait(2);
        WebElement btnHomeLinks = driver.findElement(By.id("simpleLink"));
        btnHomeLinks.click();
        MyFunc.Wait(2);
        driver.quit();
    }
}
