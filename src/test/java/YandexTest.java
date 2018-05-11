import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import pages.SearchPage;
import utils.Stash;

/**
 * Created by plotnikvk.
 */

public class YandexTest {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Stash.put("driver", driver);
        driver.get("https://www.yandex.ru");
    }

    @After
    public void shutDown(){
        driver.quit();
    }

    @Test
    public void test(){
        new SearchPage().
                searchFinalPage();

    }
}
