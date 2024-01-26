import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement userName(){
        return driver.findElement(By.cssSelector("input[name=\"UserEmail\"]"));
    }

    public WebElement password(){
        return driver.findElement(By.cssSelector("input[name=\"UserPassword\"]"));
    }

    public void LoginSteps(String username,String password){
        driver.navigate().to("https://speed-money.app/admin/login");
        userName().sendKeys(username);
        password().sendKeys(password);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }
}
