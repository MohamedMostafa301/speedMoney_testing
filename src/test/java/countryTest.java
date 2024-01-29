import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class countryTest {
    WebDriver driver =null;
    LoginPage loginPage;
    Country country;
    @BeforeTest
    public void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "src\\main\\resources\\chromedriver.exe";
        System.setProperty("chrome",chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        loginPage =new LoginPage(driver);
        country =new Country(driver);
    }

    @Test
    public void addCountry() throws InterruptedException {
        loginPage.LoginSteps("admin@gmail.com","123456789");
        driver.findElement(By.xpath("//a[@href=\"https://speed-money.app/admin/country/list\"]//span[@class=\"menu-title\"]")).click();
        country.addSteps("ind","1122p","+21","9");
        if(driver.findElement(By.xpath("//div[@class=\"alert alert-dismissible bg-danger d-flex flex-column align-items-center flex-sm-row py-0 px-4 mb-5\"]")).isDisplayed()){
            String expectedResult="The country name has already been taken.";
            String actual = driver.findElement(By.xpath("//div[@class=\"alert alert-dismissible bg-danger d-flex flex-column align-items-center flex-sm-row py-0 px-4 mb-5\"]")).getText();
            Assert.assertTrue(actual.contains(expectedResult));
            loginPage.logOutSteps();
        }else {
            boolean isAdded =driver.findElement(By.xpath("//tr[@style=\"white-space: nowrap;\" and contains(.,ind) and contains(.,\"+21\")]")).isDisplayed();
            Assert.assertTrue(isAdded);
            loginPage.logOutSteps();
        }

    }
    @Test
    public void editCountry() throws InterruptedException {
        loginPage.LoginSteps("admin@gmail.com","123456789");
        driver.findElement(By.xpath("//a[@href=\"https://speed-money.app/admin/country/list\"]//span[@class=\"menu-title\"]")).click();
        country.editSteps("india","1122p","+75","9");
        boolean isAdded =driver.findElement(By.xpath("//tr[@style=\"white-space: nowrap;\" and contains(.,india) and contains(.,\"+75\")]")).isDisplayed();
        Assert.assertTrue(isAdded);
        loginPage.logOutSteps();
    }
    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
