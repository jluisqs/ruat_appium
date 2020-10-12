import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*{
        "deviceName": "ZY22486P32",
        "platformVersion": "8",
        "appPackage": "bo.gob.ruat.ruatmovil",
        "appActivity": ".MainActivity",
        "platformName": "Android"
        }*/

public class BasicMobile {
    private AppiumDriver driver;

    @Before
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "ZY22486P32");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("appPackage", "bo.gob.ruat.ruatmovil");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("platformName", "Android");

        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void myFirstTest(){

        this.driver.findElement(By.className("android.widget.Button")).click();
        this.driver.findElement(By.xpath("(//android.view.View[@content-desc=\"Consulta Deuda\"])[1]/android.view.View/android.view.View")).click();        //this.driver.findElement(By.className("android.widget.EditText")).sendKeys("4027GAB");
        this.driver.findElement(By.className("android.widget.EditText")).sendKeys("4027GAB");
        this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.Button")).click();

        String actualResult=this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[23]/android.view.View/android.view.View")).getText();
        String expectedResult="DATOS DEUDAS";

        Assert.assertEquals("procesado",expectedResult,actualResult);
    }

    @After
    public void after(){
        //this.driver.quit();
    }
}
