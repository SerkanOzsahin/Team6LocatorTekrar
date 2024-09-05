package _Sefa;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Odev3 extends BaseDriver {

    @Test
    public void Test1() {
        driver.navigate().to("https://www.amazon.com.tr/");
        MyFunc.Wait(1);

        WebElement home = driver.findElement(By.cssSelector("[id='nav-logo-sprites']"));
        home.click();

        WebElement dropDownBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        dropDownBox.click();
        MyFunc.Wait(1);

        Select choice = new Select(dropDownBox);
        choice.selectByIndex(4);
        MyFunc.Wait(1);

        WebElement searchBox = driver.findElement(By.cssSelector("[id='nav-search-submit-button']"));
        searchBox.click();
        MyFunc.Wait(1);

        WebElement pageControl = driver.findElement(By.xpath("//h1[text()='Bilgisayar']"));

        if (pageControl.getText().contains("Bilgisayar")) {
            WebElement accessory = driver.findElement(By.xpath("//span[text()='Intel']"));
            accessory.click();
            MyFunc.Wait(1);

            WebElement itemClick = driver.findElement(By.xpath("((//div[@data-cy='title-recipe'])[1])//a"));
            itemClick.click();
            MyFunc.Wait(1);

            WebElement normalPriceSelect = driver.findElement(By.xpath("(//div[@data-action='a-accordion'])[2]"));
            normalPriceSelect.click();
            MyFunc.Wait(1);

            WebElement addToBasket = driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
            addToBasket.click();
            MyFunc.Wait(1);

            driver.navigate().back();
            MyFunc.Wait(1);
            driver.navigate().back();
            MyFunc.Wait(1);

            WebElement itemClick2 = driver.findElement(By.xpath("((//div[@data-cy='title-recipe'])[4])//a"));
            itemClick2.click();
            MyFunc.Wait(1);

            WebElement normalPriceSelect2 = driver.findElement(By.xpath("(//div[@data-action='a-accordion'])[2]"));
            normalPriceSelect2.click();
            MyFunc.Wait(1);

            WebElement addToBasket2 = driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
            addToBasket2.click();
            MyFunc.Wait(1);

            WebElement basket = driver.findElement(By.cssSelector("[id='nav-cart']"));
            basket.click();
            MyFunc.Wait(1);

            List<WebElement> itemPrice = driver.findElements(By.cssSelector("[class='sc-badge-price-to-pay']"));
            String priceStr = "";
            double totalD = 0;

            for (WebElement e : itemPrice) {
                String price = e.getText().replaceAll("[^0-9.]", "");
                price = price.replace(",", ".");
                System.out.println("Price = " + price);
                totalD += Double.parseDouble(price);
                priceStr = String.valueOf(totalD);
            }

            WebElement priceControl = driver.findElement(By.cssSelector("[id='sc-subtotal-amount-buybox']"));
            String total = priceControl.getText().replaceAll("[^0-9.]", "");
            total = total.replace(",", ".");
            Assert.assertTrue("Fiyatlar eşleşmedi", total.contains(priceStr));

            WebElement clearItem = driver.findElement(By.xpath("//input[@value='Sil']"));
            clearItem.click();
            MyFunc.Wait(1);

            WebElement clearItem2 = driver.findElement(By.xpath("//input[@value='Sil']"));
            clearItem2.click();
            MyFunc.Wait(1);

            WebElement clearControl = driver.findElement(By.xpath("(//div[@class='a-row sc-cart-header'])//h2"));
            Assert.assertTrue("Ürünler silinemedi", clearControl.getText().contains("Amazon sepetiniz boş."));

            WebElement home2 = driver.findElement(By.cssSelector("[id='nav-logo-sprites']"));
            home2.click();
        }
        BekleKapat();
    }
}
