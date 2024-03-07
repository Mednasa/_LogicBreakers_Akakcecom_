package _US_107_;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _US_107_N extends BaseDriver {
    @Test
    public void Test01() {

        driver.get("https://www.akakce.com/");
        WebElement loginn = driver.findElement(By.xpath("(//*[text()='Giriş Yap'])[1]"));
        loginn.click();
        MyFunc.Wait(2);

        WebElement txteposta = driver.findElement(By.xpath("(//form[@action='/akakcem/nojs/']/span)[2]/input"));
        txteposta.sendKeys("caputdraconis183@gmail.com" + Keys.TAB + "Lord@183.");
        MyFunc.Wait(2);

        WebElement loginopen = driver.findElement(By.xpath("(//*[@value='Giriş yap'])[1]"));
        loginopen.click();
        MyFunc.Wait(2);

        Actions actionDriver = new Actions(driver);

        WebElement account = driver.findElement(By.cssSelector("[title='Hesabım']"));
        actionDriver.moveToElement(account).build().perform();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Hesabım']"), "Hesabım"));

        WebElement accountcl = driver.findElement(By.xpath("//*[text()='Hesabım']"));
        accountcl.click();
        MyFunc.Wait(2);

        WebElement accountdelete = driver.findElement(By.cssSelector("ul>:nth-of-type(4)>a:nth-child(5)"));
        accountdelete.click();
        MyFunc.Wait(2);

        WebElement passwordtext = driver.findElement(By.cssSelector("[method='post'] span>input:nth-child(2)"));
        passwordtext.sendKeys("Lord@183");
        MyFunc.Wait(2);

        WebElement accountdeleteclick = driver.findElement(By.cssSelector("[method='post'] span>input:nth-child(1)"));
        accountdeleteclick.click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("[class='alertX t2'] p"), "Mevcut şifrenizi doğru girdiğinizden emin olun."));

        WebElement alerttext = driver.findElement(By.cssSelector("[class='alertX t2'] p"));

        Assert.assertFalse("Hesap silme işlemi Başarılı", passwordtext.getText().equals("Lord@183."));
        System.out.println(alerttext.getText());

        WebElement okclick = driver.findElement(By.cssSelector("div[class='buttons'] b"));
        okclick.click();

        WaintandClose();
    }

}
