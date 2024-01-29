import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
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
    }

    @Test
    public void ValidLogin(){
        loginPage.LoginSteps("admin@gmail.com","123456789");
        Assert.assertEquals(driver.getCurrentUrl(),"https://speed-money.app/admin/home");
        loginPage.logOutSteps();
    }

    @Test
    public void inValidUserNameLogin(){
        loginPage.LoginSteps("user@gmail.com","123456789");
        String actualValue= driver.findElement(By.cssSelector("span[class=\"text-light fw-bold\"]")).getText();
        System.out.println(actualValue);
        String expectedValue="The selected user email is invalid.";
        Assert.assertTrue(actualValue.contains(expectedValue));
          }

    @Test
    public void inValidPassLogin(){
        loginPage.LoginSteps("admin@gmail.com","1236789");
        String actualValue= driver.findElement(By.cssSelector("span[class=\"text-light fw-bold\"]")).getText();
        System.out.println(actualValue);
        String expectedValue="Password Incorrect";
        Assert.assertTrue(actualValue.contains(expectedValue));
           }

    @Test
    public void inValidLogin(){
        loginPage.LoginSteps("ain@gmail.com","1236789");
        String actualValue= driver.findElement(By.cssSelector("span[class=\"text-light fw-bold\"]")).getText();
        System.out.println(actualValue);
        String expectedValue="The selected user email is invalid.";
        Assert.assertTrue(actualValue.contains(expectedValue));

    }

    @Test
    public void emptyLogin(){
        loginPage.LoginSteps("","");
        String actualValue1= driver.findElement(By.xpath("//span[@class=\"text-light fw-bold\" and contains(.,\"email\")]")).getText();
        String actualValue2= driver.findElement(By.xpath("//span[@class=\"text-light fw-bold\" and contains(.,\"password\")]")).getText();
        System.out.println(actualValue1);
        System.out.println(actualValue2);
        String expectedValue1="The user email field is required.";
        Assert.assertTrue(actualValue1.contains(expectedValue1));
        String expectedValue2="The user password field is required.";
        //text-light fw-bold
        Assert.assertTrue(actualValue2.contains(expectedValue2));
           }

    @AfterTest
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
