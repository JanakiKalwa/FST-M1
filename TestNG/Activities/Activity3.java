package LiveProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test

    public void testCase1() {
        //This test case will pass
        String copyright = driver.findElement(By.cssSelector("a#admin_options")).getText();
        System.out.println("copyright text: " + copyright);

    }


    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}