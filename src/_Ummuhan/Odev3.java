package _Ummuhan;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Odev3 extends BaseDriver {
       //amazona gidin
       //sepete 3 ürün ekleyin
       //her ürün eklendikten sonra ürün sepete eklendi yazısını doğrulayın
       //sepette 3 ürün olduğunu doğrulayın
       //3 ürünün fiyat toplamının, sitede gösterilen fiyat ile aynı olduğunu doğrulayın
       //ürünleri tek tek sepetten kaldırın. her ürünü kaldırdığınızda "ürün sepetten kaldırıldı" yazısının göründüğünü doğrulayın
       //tüm ürünleri kaldırınca "sepetiniz şu an boş" yazısının göründüğünü doğrulayın
       //home button ile anasayfaya gidin
       //driver ı kapatın
       // sadece CSSSelector ya da XPath

        @Test
        public void Test()
        {
            driver.get("https://www.amazon.com.tr/");
            MyFunc.Wait(2);

            String secondProduct="termos";
            String thirdProduct="Suç ve Ceza";

            WebElement homePage=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
            homePage.click();
            MyFunc.Wait(2);

            WebElement logoClick=driver.findElement(By.xpath("//div[@id='nav-logo']/a"));
            logoClick.click();
            MyFunc.Wait(2);

            WebElement bestSeller=driver.findElement(By.linkText("Çok Satanlar"));
            bestSeller.click();
            MyFunc.Wait(2);

            WebElement pet=driver.findElement(By.xpath("//a[text()='Evcil Hayvan Ürünleri']"));
            pet.click();
            MyFunc.Wait(2);

            WebElement catFood=driver.findElement(By.xpath("(//a[@class='a-link-normal']//span)[1]"));
            catFood.click();
            MyFunc.Wait(2);

            WebElement basket=driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
            basket.click();
            MyFunc.Wait(2);

            WebElement allCategories=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
            Select categories=new Select(allCategories);
            categories.selectByValue("search-alias=kitchen");

            WebElement searchBox=driver.findElement(By.xpath("//input[@type='text']"));
            searchBox.sendKeys(secondProduct);
            MyFunc.Wait(2);

            WebElement searchClick=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
            searchClick.click();
            MyFunc.Wait(2);

            WebElement stanley=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[6]"));
            stanley.click();
            MyFunc.Wait(2);

            WebElement basketStanley=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
            basketStanley.click();
            MyFunc.Wait(2);

            WebElement textControl=driver.findElement(By.xpath("(//div[@id='sw-atc-details-single-container']//div)[3]//h1"));
            Assert.assertTrue("ürün sepete eklenemedi", textControl.getText().contains("Eklendi"));
            MyFunc.Wait(2);

            WebElement searchBoxThree=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            searchBoxThree.sendKeys(thirdProduct);
            MyFunc.Wait(2);

            WebElement searchClickBox=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
            searchClickBox.click();
            MyFunc.Wait(2);

            WebElement sucVeceza=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
            sucVeceza.click();
            MyFunc.Wait(2);

            WebElement bookBasket=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
            bookBasket.click();
            MyFunc.Wait(2);

            WebElement bookControl=driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
            Assert.assertTrue("ürün sepete eklenemedi", bookControl.getText().contains("Eklendi"));
            MyFunc.Wait(2);

            WebElement totalBasket=driver.findElement(By.xpath("(//div[@id='nav-cart-text-container']/span)[1]"));
            totalBasket.click();
            MyFunc.Wait(2);

            List<WebElement> priceTotal=driver.findElements(By.xpath("//div[@class='a-section a-spacing-mini']"));

            double totalDouble=0;
            String totalStr="";

            for (WebElement total: priceTotal )
            {
                String elements=total.getText().replaceAll("[^0-9,]","");
                elements=elements.replace(",",".").trim();
                System.out.println(elements);
                totalDouble+=Double.parseDouble(elements);
                totalStr=String.valueOf(totalDouble);
            }

            WebElement itemTotal=driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']"));
            String item=itemTotal.getText().replaceAll("[^0-9,]","");
            item=item.replace(",",".").trim();
            System.out.println(item);
            Assert.assertTrue("toplam ürün tutarı eşleşmedi", item.contains(totalStr));
            MyFunc.Wait(2);
            BekleKapat();
        }
}
