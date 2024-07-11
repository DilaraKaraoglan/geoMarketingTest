package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private static ConfigReader configReader = new ConfigReader();

    public static WebDriver getDriverOLD() {
        if (driver == null) {
            getDriver();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (configReader.getBrowser()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    Map<String, Object> chromePrefs = new HashMap<>();
                    chromePrefs.put("profile.default_content_setting_values.notifications", 1);
                    chromeOptions.addArguments("--enable-notifications");
                    chromeOptions.setExperimentalOption("prefs", chromePrefs);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    Map<String, Object> edgePrefs = new HashMap<>();
                    edgePrefs.put("profile.default_content_setting_values.notifications", 1);
                    edgeOptions.addArguments("--enable-notifications");
                    edgeOptions.setExperimentalOption("prefs", edgePrefs);
                    driver = new EdgeDriver(edgeOptions);
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            System.out.println("Get driver works");
        }
        return driver;
    }

    static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.addArguments("--enable-notifications");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public static WebDriver StartBrowser(String url) {
        if (driver == null) {
            getDriver();
        }
        driver.get(url);
        waitForPageLoadComplete(driver, 15);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> ((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")).apply(webDriver));
        return driver;
    }

    public static void waitForPageLoadComplete(WebDriver driver, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
