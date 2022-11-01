package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class WDriver {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static final long WAIT_TIMEOUT = 5;
    private static final long PAGE_TIMEOUT = 15;
    private WDriver() {
    }
    public static void getWebDriverInstance() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_TIMEOUT, TimeUnit.SECONDS);
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }
}
