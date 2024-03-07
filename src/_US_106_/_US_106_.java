package _US_106_;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _US_106_ extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("https://www.akakce.com/");

        WebElement login=driver.findElement(By.xpath("(//*[text()='Giriş Yap'])[1]"));
        login.click();
        MyFunc.Wait(2);

        WebElement email=driver.findElement(By.xpath("(//form[@action='/akakcem/nojs/']/span)[2]/input"));
        email.sendKeys("beyzanur.er@outlook.com"+ Keys.TAB+"Beyza123.");
        MyFunc.Wait(2);

        WebElement loginClick=driver.findElement(By.xpath("(//*[@value='Giriş yap'])[1]"));
        loginClick.click();
        MyFunc.Wait(2);


        Actions actionDriver=new Actions(driver);
        WebElement myAccount=driver.findElement(By.cssSelector("[title='Hesabım']"));
        actionDriver.moveToElement(myAccount).build().perform();


        WebElement myAccountClick=driver.findElement(By.xpath("//a[text()='Hesabım']"));
        myAccountClick.click();

        WebElement myMessage=driver.findElement(By.xpath("//a[text()='Mesajlarım']"));
        myMessage.click();

        WebElement messageText=driver.findElement(By.xpath("//p[text()='Listelenecek mesaj bulunamadı.']"));
        Assert.assertTrue("Mesaj kutunuzda görüntülenecek mesaj var",messageText.getText().equals("Listelenecek mesaj bulunamadı."));

        WaintandClose();
    }
}
