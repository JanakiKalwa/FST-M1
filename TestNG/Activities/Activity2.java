package LiveProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class Activity2 {
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
        String url = driver.findElement(By.cssSelector("div.companylogo img")).getAttribute("src");
              System.out.println("URL is: " + url);

    }


    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}