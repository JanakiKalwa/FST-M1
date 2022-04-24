package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    @Parameters({"username", "password"})
    public void loginTestCase(String username, String password) {
        //Find username and password fields
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));

        //Enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        //Click Log in
        driver.findElement(By.id("bigbutton")).click();

        //Assert Message
        String loginMessage = driver.findElement(By.id("tab0")).getText();
        Assert.assertEquals(loginMessage, "SUITECRM DASHBOARD");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}