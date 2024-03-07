package _US_104_;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _US_104_TC_0401_ extends BaseDriver {

    @Test
    public void test1() {
        driver.get("https://www.akakce.com/");

        WebElement log_inPageBtn = driver.findElement(By.cssSelector("div > a[href=\"/akakcem/giris/\"]"));

        log_inPageBtn.click();

        //Credentials:
        // licidew642@aersm.com
        // 123456789Bl
        // Username : Artam

        WebElement emailPlc = driver.findElement(By.xpath("//input[@type=\"email\" and @id=\"life\"]"));
        emailPlc.sendKeys("licidew642@aersm.com");

        WebElement passwordPlc = driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"lifp\"]"));
        passwordPlc.sendKeys("123456789Bl");


        WebElement loginBtn = driver.findElement(By.xpath("//input[@type=\"submit\" and @value=\"Giriş yap\"]"));
        loginBtn.click();


        WebElement accountBtn = driver.findElement(By.xpath("//div[@id=\"HM_v8\"]//i//a[@rel=\"nofollow\"]"));

        WebElement d = driver.findElement(By.xpath("//*[@rel='nofollow'])[3]"));
        new Actions(driver).moveToElement(d).build().perform();
        MyFunc.Wait(2);

        // Check if username displayed and it is right username
        Assert.assertTrue("Hello Not found", accountBtn.getText().contains("Artam"));


        WaintandClose();
    }


}
