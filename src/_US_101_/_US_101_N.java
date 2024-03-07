package _US_101_;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class _US_101_N extends BaseDriver {
    @Test
    public void Test(){

        driver.get("https://www.akakce.com/");
        WebElement openAnAccount= driver.findElement(By.xpath("//div[@id=\"H_rl_v8\"]/a[1]"));
        openAnAccount.click();

        WebElement name= driver.findElement(By.xpath("//input[@id=\"rnufn\"]"));
        name.sendKeys("John");

        WebElement surname= driver.findElement(By.xpath("//input[@id=\"rnufs\"]"));
        surname.sendKeys("Lion");

        WebElement email= driver.findElement(By.xpath("//input[@id=\"rnufe1\"]"));
        email.sendKeys("wipano6954@sfpixel.com");

        WebElement emailAgain=driver.findElement(By.xpath("//input[@id=\"rnufe2\"]"));
        emailAgain.sendKeys("wipano6954@sfpixel.com");

        WebElement password=driver.findElement(By.xpath("//input[@id=\"rnufp1\"]"));
        password.sendKeys("Logic.123456");

        WebElement passwordRepeat=driver.findElement(By.xpath("//input[@id=\"rnufp2\"]"));
        passwordRepeat.sendKeys("Logic.12345");

        WebElement Gender=driver.findElement(By.xpath("//input[@id=\"rngm\"]"));
        Gender.click();

        WebElement city=driver.findElement(By.xpath("//select[@id=\"locpr\"]"));
        Select secim=new Select(city);
        secim.selectByIndex(2);

        WebElement district=driver.findElement(By.xpath("//select[@id=\"locds\"]"));
        Select secim2=new Select(district);
        secim2.selectByIndex(14);

        WebElement day=driver.findElement(By.xpath("//select[@id=\"bd\"]"));
        Select secim3=new Select(day);
        secim3.selectByIndex(13);

        WebElement month=driver.findElement(By.xpath("//select[@id=\"bm\"]"));
        Select secim4=new Select(month);
        secim4.selectByIndex(10);

        WebElement years=driver.findElement(By.xpath("//select[@id=\"by\"]"));
        Select secim5=new Select(years);
        secim5.selectByVisibleText("2000");

        WebElement terms=driver.findElement(By.xpath("//input[@id=\"rnufpca\"]"));
        terms.click();

        WebElement campaigns=driver.findElement(By.xpath("//input[@id=\"rnufnee\"]"));
        campaigns.click();

        WebElement oAnAccountBtn=driver.findElement(By.xpath("//input[@id=\"rfb\"]"));
        oAnAccountBtn.click();

        WebElement verification=driver.findElement(By.xpath("//div[@class='alertX t2']//p"));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='alertX t2']//p"),"Şifreler aynı olmalı."));
        Assert.assertTrue("Başarılı Giriş",verification.getText().contains("Şifreler aynı olmalı."));
        WaintandClose();
    }
}
