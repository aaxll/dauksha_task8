import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    // URLs
    String loginPageURL = "http://open-eshop.stqa.ru/oc-panel/auth/login/";
    String adminPanelURL = "http://open-eshop.stqa.ru/oc-panel";
    String couponsPageURL = "http://open-eshop.stqa.ru/oc-panel/coupon";

    // Admin credentials
    String adminEmail = "demo@open-eshop.com";
    String adminPassword = "demo";

    // Coupon data
    String couponNameField = "coupon32324";
    String couponDateField = "2021-01-03";
    String couponCountField = "3";

    protected static WebDriver driver;
    protected static LoginPage loginPage;
    protected static AdminPage adminPage;


    @BeforeEach
    public void setUp() {
        System.out.println("Starting a browser");
        System.setProperty("webdriver.chrome.driver", "C:/testing/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);

    }

    @AfterEach
    public void tearDown() {
        System.out.println("Stopping the browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
