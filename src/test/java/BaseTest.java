import com.google.common.primitives.Bytes;
import io.qameta.allure.Attachment;
import org.example.User;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver;

    String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get(BASE_URL);
    }

   // @After
    public void tearDown(){
        driver.quit();
    }
    User standardUser = new User("standard_user", "secret_sauce");

    @Rule
    public TestWatcher screenShotOnFailure = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            driver.quit();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenShot();
            driver.quit();
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            driver.quit();
        }
        @Attachment
        public byte[] makeScreenShot(){
            return driver.getScreenshotAs(OutputType.BYTES);
        }
    };
//
}