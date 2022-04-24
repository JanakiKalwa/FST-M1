package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    @Parameters({"username", "password"})
    public void TestCase(String username, String password) {
        //Find username and password fields
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));

        //Enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        //Click Log in
        driver.findElement(By.id("bigbutton")).click();

        //Click Sales
        driver.findElement(By.cssSelector("#grouptab_0")).click();

        //Click Leads
        driver.findElement(By.cssSelector("div#toolbar ul.nav:first-child li.topnav ul.dropdown-menu li a#moduleTab_9_Leads")).click();

        //Get Rows
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.list-view-rounded-corners > table > tbody tr:first-child td:last-child span")));

        //Get last element of first row
        driver.findElement(By.cssSelector("div.list-view-rounded-corners > table > tbody tr:first-child td:last-child span")).click();

        //Get phone span
        WebElement span_phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-5 > span")));

        System.out.println("Phone number is: " + span_phone.getText());
    }

    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}
