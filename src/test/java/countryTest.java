import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class countryTest {
    WebDriver driver =null;
    LoginPage loginPage;
    @BeforeTest
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "src\\main\\resources\\chromedriver.exe";
        System.setProperty("chrome",chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        loginPage =new LoginPage(driver);
        loginPage.LoginSteps("admin@gmail.com","123456789");
    }
}
