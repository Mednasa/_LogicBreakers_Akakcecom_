package _US_105_;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class _0501_OrderListCheck extends BaseDriver {

    /* Check if the user is able to log in successfully and redirect to the "Order List" page
     Also confirm that an appropriate message is displayed if the order list is empty. */

    // CREDENTIALS:
    // Name: TestUser
    // Surname: Tester
    // E-mail: lalot13449@artgulin.com
    // Password: Not4You2Know
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
        WebElement eMail = driver.findElement(By.xpath("//input[@id='life']"));
        eMail.sendKeys("lalot13449@artgulin.com");

        // valid password
        WebElement passWord = driver.findElement(By.xpath("//input[@id='lifp']"));
        passWord.sendKeys("Not4You2Know");
        MyFunc.Wait(2);

        // Enter the "Login" button
        WebElement loginBttn = driver.findElement(By.xpath("//input[@id='lfb']"));
        loginBttn.click();

        // Hover over the "Account" section located in the upper right corner.
        WebElement account = driver.findElement(By.xpath("//a[@id='H_a_v8']"));
        account.click();

        // Navigate to the profile page by clicking on the "My Account" link from the "Account" section.
        WebElement myAccount = driver.findElement(By.xpath("(//*[@rel='nofollow'])[3]"));
        myAccount.click();

        MyFunc.Wait(2);

        // Click on the "My Orders" link to be directed to the order list.
        WebElement orders = driver.findElement(By.cssSelector("ul#AL>:nth-of-type(1)>:nth-child(2)"));
        orders.click();

        // If the order list is empty,  an appropriate message (such as "You do not have a registered order.") should be displayed.
        WebElement msg = driver.findElement(By.xpath("//div[@class='cwbb_v8']/div"));
        Assert.assertTrue("Message not found!", msg.getText().equals("Kayıtlı siparişiniz bulunmuyor."));

        System.out.println("Result: " + msg.getText());

        WaintandClose();
    }
}
