package _US_104_;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _US_104_TC_0402_ extends BaseDriver {
    @Test
    public void test2() {
        //Credentials:
        // licidew642@aersm.com
        // 123456789Bl
        // Username : Artam
        driver.get("https://www.akakce.com/");
        String mainpageID = driver.getWindowHandle();

        WebElement log_inPageBtn = driver.findElement(By.cssSelector("div > a[href=\"/akakcem/giris/\"]"));
        log_inPageBtn.click();

        // LOGIN WITH WRONG EMAIL
        WebElement emailPlc = driver.findElement(By.xpath("//input[@type=\"email\" and @id=\"life\"]"));
        emailPlc.sendKeys("wrong_mail@mail.com");

        WebElement passwordPlc = driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"lifp\"]"));
        passwordPlc.sendKeys("123456789Bl");


        WebElement loginBtn = driver.findElement(By.id("lfb"));
        loginBtn.click();

        // Get the alert when the email is incorrect
        WebElement emailAlert = driver.findElement(By.xpath("//div[@class=\"alertX t2\"]"));
        wait.until(ExpectedConditions.visibilityOf(emailAlert));

        Assert.assertTrue("Wrong Email Alert", emailAlert.getText().contains("Böyle bir kullanıcı yok."));


        //LOGIN WITH WRONG PASSWORD
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.akakce.com/");

        WebElement log_inPageBtn2 = driver.findElement(By.cssSelector("div > a[href=\"/akakcem/giris/\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(log_inPageBtn2));
        log_inPageBtn2.click();

        WebElement emailPlc2 = driver.findElement(By.xpath("//input[@type=\"email\" and @id=\"life\"]"));
        emailPlc2.sendKeys("licidew642@aersm.com");

        WebElement passwordPlc2 = driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"lifp\"]"));
        passwordPlc2.sendKeys("wrongPassword123");

        WebElement loginBtn2 = driver.findElement(By.id("lfb"));
        loginBtn2.click();

        WebElement passwordAlert = driver.findElement(By.xpath("//div[@class=\"alertX t2\"]"));
        wait.until(ExpectedConditions.visibilityOf(passwordAlert));

        Assert.assertTrue("Wrong Email Alert", passwordAlert.getText().contains("Şifre doğru değil. Lütfen kontrol edip yeniden deneyin."));


        WaintandClose();
    }

}
