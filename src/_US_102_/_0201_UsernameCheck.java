package _US_102_;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _0201_UsernameCheck extends BaseDriver {

    /* Verify that the user can see his/her name in the profile section
     after successfully logging in to the system with the correct credentials. */
    // CREDENTIALS:
    // name: TestUser
    // surname: Tester
    // email: lalot13449@artgulin.com
    // password: Not4You2Know
    @Test
    public void Test1() {

        /** single-line comments have been added for clarity.*/

        // Open the browser and navigate to the website
        driver.navigate().to("https://www.akakce.com/");

        // Click on the Login button on the main page.
        WebElement loginButton = driver.findElement(By.cssSelector("div[id='H_rl_v8']>a:nth-child(2)"));
        loginButton.click();
        MyFunc.Wait(2);

        // Enter the valid credentials in the placeholders provided.
        // valid e-mail
        WebElement eMail = driver.findElement(By.xpath("//input[@id='life' and @type='email']"));
        eMail.sendKeys("lalot13449@artgulin.com");

        // valid password
        WebElement passWord = driver.findElement(By.xpath("//input[@id='lifp' and @type='password']"));
        passWord.sendKeys("Not4You2Know");

        MyFunc.Wait(2);

        // Enter the login button
        WebElement loginBttn = driver.findElement(By.xpath("//input[@id='lfb' and @type='submit']"));
        loginBttn.click();

        // Check the upper right corner to verify if the Username matches the Username entered during the login.
        WebElement expectedUsername = driver.findElement(By.linkText("TestUser"));
        Assert.assertTrue("The username doesn't match!", expectedUsername.getText().equals("TestUser"));
        System.out.println("Verified Username: " + expectedUsername.getText());

        WaintandClose();
    }
}
