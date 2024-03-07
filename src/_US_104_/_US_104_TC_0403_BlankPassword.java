package _US_104_;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _US_104_TC_0403_BlankPassword extends BaseDriver {
    @Test
    public void test3() {
        driver.get("https://www.akakce.com/");

        WebElement log_inPageBtn = driver.findElement(By.cssSelector("div > a[href=\"/akakcem/giris/\"]"));
        log_inPageBtn.click();

        // Fill with email only
        WebElement emailPlc = driver.findElement(By.xpath("//input[@type=\"email\" and @id=\"life\"]"));
        emailPlc.sendKeys("licidew642@aersm.com");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type=\"submit\" and @value=\"Giriş yap\"]"));
        loginBtn.click();

        // Check for alert text
        WebElement nullPasswordAlert = driver.findElement(By.xpath("//div[@class=\"alertX t2\"]"));
        wait.until(ExpectedConditions.visibilityOf(nullPasswordAlert));
        Assert.assertTrue("Blank Password Alert Not Found!",
                nullPasswordAlert.getText().contains("Lütfen şifrenizi yazın."));


        WaintandClose();
    }
}
