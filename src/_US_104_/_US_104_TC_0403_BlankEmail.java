package _US_104_;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _US_104_TC_0403_BlankEmail extends BaseDriver {
    @Test
    public void test4() {
        driver.get("https://www.akakce.com/");

        WebElement log_inPageBtn = driver.findElement(By.cssSelector("div > a[href=\"/akakcem/giris/\"]"));
        log_inPageBtn.click();

        //Fill with the password only

        WebElement passwordPlc = driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"lifp\"]"));
        passwordPlc.sendKeys("123456789Bl");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type=\"submit\" and @value=\"Giriş yap\"]"));
        loginBtn.click();

        WebElement nullEmailAlert = driver.findElement(By.xpath("//div[@class=\"alertX t2\"]//p"));

        wait.until(ExpectedConditions.visibilityOf(nullEmailAlert));

        Assert.assertTrue("Blank Mail Alert Not Found!",
                nullEmailAlert.getText().contains("Lütfen e-posta adresinizi yazın."));

        WaintandClose();
    }
}
