package Examples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class FirstExample {
    //Declare AndroidDriver
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //set desired capabilities
       DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability("deviceId","bb5c82eb");
       caps.setCapability("platformName","android");
       caps.setCapability("automationName", "UiAutomator2");
       caps.setCapability( "appPackage","com.coloros.calculator");
       caps.setCapability("appActivity","com.android.calculator2.Calculator");
       caps.setCapability("noReset", true);

       //Set Appium server URL
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        //Initialize AndroidDriver
        driver = new AndroidDriver<>(remoteUrl, caps);

    }
    @Test
    public void additionTest() {
        //find the button 5
        MobileElement digit5 = driver.findElementById("digit_5");
        //Click 5
        digit5.click();

        //find and click+
        driver.findElementByAndroidUIAutomator("Decription(\"plus\")").click();
        digit5.click();
        driver.findElementByAccessibilityId("equals").click();


        String resultText = driver.findElementById("result").getText();
        System.out.println(resultText);

        assertEquals(resultText, "10");

    }
    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }

    }




