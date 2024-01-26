import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Country {
    WebDriver driver;
   public Country(WebDriver driver){
        this.driver =driver;
    }

    public WebElement countryName(){
        return driver.findElement(By.cssSelector("input[name=\"CountryName\"]"));
    }
    public WebElement countryTime(){
        return driver.findElement(By.cssSelector("input[name=\"CountryUTC\"]"));
    }
    public WebElement countryCode(){
        return driver.findElement(By.cssSelector("input[name=\"CountryCode\"]"));
    }
    public WebElement countryValidation(){
        return driver.findElement(By.cssSelector("input[name=\"CountryValidation\"]"));
    }

    public void addSteps(){

    }
}
