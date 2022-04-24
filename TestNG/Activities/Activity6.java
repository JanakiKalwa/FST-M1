package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test(priority = 0)
    @Parameters({"username", "password"})
    public void TestLogin(String username, String password) {
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

    @Test(priority = 1)
    public void TestExist(){

        WebElement activity_tab = driver.findElement(By.cssSelector("nav a#grouptab_3"));

        Assert.assertEquals(activity_tab.getText(), "ACTIVITIES");
    }

    @Test(priority = 2)
    public void TestClickable(){
        String testClickable = "";
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav a#grouptab_3")));
            testClickable = "Clickable";
        } catch (TimeoutException e) {
            testClickable = "Not Clickable";
        }

        Assert.assertEquals(testClickable, "Clickable");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}
