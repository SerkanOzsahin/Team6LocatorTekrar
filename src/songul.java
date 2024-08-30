import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class songul {
    public static void main(String[] args) {


//        demoqa.com/text-box a gidin
//        Full Name, Email, Current Adress ve Permanent Adress bilgilerini doldurup Submit e tıklayın
//        Çıkan kutucuktaki bilgilerin, girdiğiniz bilgilerle aynı olduğunu kontrol edin
//        Sol Menüden check box a tıklayın
//        Home a tıklayın
//        Sol Menüden Buttons a tıklayın
//        Click Me ye tıklayın
//        You have done a dynamic click yazısının geldiğini doğrulayın
//        Sol Menüden Links e tıklayın
//        Home linkine tıklayın
//        driver ı kapatın
        String emailstr = "songull@gmail.com";
        String songulstr = "songull";

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        MyFunc.Wait(3);


        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys(songulstr);
        MyFunc.Wait(2);


        WebElement email =driver.findElement(By.id("userEmail"));
        email.sendKeys(emailstr);
        MyFunc.Wait(3);

        WebElement currentadress = driver.findElement(By.id("currentAddress"));
        currentadress.sendKeys("Narduzu street,HATAY");
        MyFunc.Wait(3);

        WebElement permanentadress =driver.findElement(By.id("permanentAddress"));
        permanentadress.sendKeys("ISKENDERUN");
        MyFunc.Wait(2);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        MyFunc.Wait(2);

        WebElement fullnamebox = driver.findElement(By.id("name"));

        if (fullnamebox.getText().contains(songulstr)){
            System.out.println("Ad ve soyad eklendi");
        } else System.out.println("hatalı");
        MyFunc.Wait(2);

        WebElement email2 = driver.findElement(By.id("email"));
        if (email2.getText().contains(emailstr)) {
            System.out.println("E-mail eklendi");
        } else
            MyFunc.Wait(2);


        MyFunc.Wait(5);
        driver.quit();


    }
}
