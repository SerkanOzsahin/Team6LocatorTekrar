import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Ummuhan {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        String fullName = "Ümmühan Teke";
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

        if (fullnameBox.getText().contains(fullName)) {
            fullnameBox.sendKeys(fullName);
            System.out.println("isim soyisim eklendi");
        } else
            System.out.println("doğrulanmadı");
        MyFunc.Wait(1);

        if (email.getText().contains(emailMe)) {
            email.sendKeys(emailMe);
            System.out.println("email eklendi");
        } else
            System.out.println("doğrulanmadı");
        MyFunc.Wait(1);

        if (currentAddress.getText().contains(address)) {
            currentAddress.sendKeys(address);
            System.out.println("adres eklendi");
        } else
            System.out.println("doğrulanmadı");
        MyFunc.Wait(1);

        if (permanentAddress.getText().contains(pAddress)) {
            permanentAddress.sendKeys(address);
            System.out.println("adres eklendi");
        } else
            System.out.println("doğrulanmadı");
        MyFunc.Wait(1);

        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();

        MyFunc.Wait(2);

        WebElement homeBox = driver.findElement(By.className("rct-checkbox"));
        homeBox.click();

        MyFunc.Wait(2);

        WebElement buttonsBox = driver.findElement(By.id("item-4"));
        buttonsBox.click();

        MyFunc.Wait(2);

        WebElement links = driver.findElement(By.id("item-5"));
        links.click();

        WebElement homeLink = driver.findElement(By.id("simpleLink"));
        homeLink.click();

        MyFunc.Wait(2);
        driver.quit();


    }
}


