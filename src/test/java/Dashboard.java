import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.DashboardPage;
import utilities.ConfigReader;

public class Dashboard {

    ConfigReader configReader;
    static WebDriver driver;

    @Step("Set up configuration for dashboard")
    public void setUpConfig() {
        configReader = new ConfigReader();
    }

    @Step("Click 'Uygulamayı Başlat' button dashboard")
    public void clickStartAppButton() throws InterruptedException {
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Thread.sleep(3000);
        dashboardPage.clickStartAppButton();
        Thread.sleep(2000);
    }
}
