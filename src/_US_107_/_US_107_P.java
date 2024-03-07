package _US_107_;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Test;
import org.junit.Assert;

public class _US_107_P extends BaseDriver {
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

        WebElement hesabim = driver.findElement(By.cssSelector("[title='Hesabım']"));
        actionDriver.moveToElement(hesabim).build().perform();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Hesabım']"), "Hesabım"));

        WebElement hesabimclick = driver.findElement(By.xpath("//*[text()='Hesabım']"));
        hesabimclick.click();
        MyFunc.Wait(2);

        WebElement hesapsilme = driver.findElement(By.cssSelector("ul>:nth-of-type(4)>a:nth-child(5)"));
        hesapsilme.click();
        MyFunc.Wait(2);

        WebElement sifretext = driver.findElement(By.cssSelector("[method='post'] span>input:nth-child(2)"));
        sifretext.sendKeys("Lord@183.");
        MyFunc.Wait(2);

        WebElement accountdeleteclick = driver.findElement(By.cssSelector("[method='post'] span>input:nth-child(1)"));
        accountdeleteclick.click();

        MyFunc.Wait(2);

        WebElement sad = driver.findElement(By.cssSelector("[class='sad']+p>i"));

        Assert.assertTrue("Hatalı mesaj", sad.getText().contains("görmek isteriz"));

        System.out.println(sad.getText());

        WaintandClose();
    }
}
