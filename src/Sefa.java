import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sefa {
    public static void main(String[] args) {
        String fullnameStr="Sefa Kahraman";
        String emailStr="SefaKahraman0001@gmail.com";
        String currentAddressStr="Samsun";
        String permanentAddressStr="Samsun yerli";

        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName=driver.findElement(By.id("userName"));
        fullName.sendKeys(fullnameStr);
        MyFunc.Wait(2);

        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys(emailStr);
        MyFunc.Wait(2);

        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(currentAddressStr);
        MyFunc.Wait(2);

        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(permanentAddressStr);
        MyFunc.Wait(2);

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();
        MyFunc.Wait(2);

        WebElement name=driver.findElement(By.id("name"));
        if (name.getText().contains(fullnameStr)){
            System.out.println("Full name doğrulandı");
        }
        MyFunc.Wait(1);
        WebElement email2=driver.findElement(By.id("email"));
        if (email2.getText().contains(emailStr)){
            System.out.println("Email doğrulandı");
        }
        MyFunc.Wait(2);

        WebElement checkBox=driver.findElement(By.id("item-1"));
        checkBox.click();
        MyFunc.Wait(2);

        WebElement home=driver.findElement(By.className("rct-checkbox"));
        home.click();
        MyFunc.Wait(2);

        WebElement buttons=driver.findElement(By.id("item-4"));
        buttons.click();
        MyFunc.Wait(2);

        WebElement links=driver.findElement(By.id("item-5"));
        links.click();
        MyFunc.Wait(2);

        WebElement home2=driver.findElement(By.id("simpleLink"));
        home2.click();
        MyFunc.Wait(2);

        driver.quit();
    }
}
