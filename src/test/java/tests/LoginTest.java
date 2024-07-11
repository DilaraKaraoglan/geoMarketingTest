package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class LoginTest {
    @Test
    public void excludeSwitches() {
        EdgeOptions options = new EdgeOptions();

        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));

        EdgeDriver driver = new EdgeDriver(options);
    }
}
