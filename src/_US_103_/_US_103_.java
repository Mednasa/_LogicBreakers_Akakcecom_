package _US_103_;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _US_103_ extends BaseDriver {
    @Test
    public void Test01(){
        driver.get("https://www.akakce.com/");
        WebElement login = driver.findElement(By.xpath("(//*[text()='Giriş Yap'])[1]"));
        login.click();


        WebElement eposta = driver.findElement(By.id("life"));
        eposta.sendKeys("mahmut12@gmail.com");


        WebElement password = driver.findElement(By.id("lifp"));
        password.sendKeys("Mahmut34.");


        WebElement loginBtn = driver.findElement(By.id("lfb"));
        loginBtn.click();


        WebElement loginCorrect = driver.findElement(By.xpath("//*[text()='Mahmut']"));
        Assert.assertTrue(loginCorrect.getText().contains("Mahmut"));


        WebElement myAccount = driver.findElement(By.cssSelector("[title='Hesabım']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccount).perform();


        WebElement logut = driver.findElement(By.xpath("//*[text()='Çık']"));
        logut.click();

        wait.until(ExpectedConditions.elementToBeClickable(logut));

        WebElement logoutCorrect = driver.findElement(By.xpath("(//*[text()='Hesap Aç'])[1]"));
        Assert.assertTrue(logoutCorrect.isDisplayed());

        WaintandClose();
    }
}
