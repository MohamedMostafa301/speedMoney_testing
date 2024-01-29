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

    public void addSteps(String name,String time,String code,String validation) throws InterruptedException {
         driver.findElement(By.xpath("//a[@href=\"https://speed-money.app/admin/country/add\"]")).click();
        Thread.sleep(3000);
        countryName().sendKeys(name);
        countryTime().sendKeys(time);
        countryCode().sendKeys(code);
        countryValidation().sendKeys(validation);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
    }
    public void editSteps(String name,String time,String code,String validation) throws InterruptedException {
        driver.findElement(By.xpath("//a[@href=\"https://speed-money.app/admin/country/edit/6\"]")).click();
        Thread.sleep(3000);
        countryName().clear();
        countryName().sendKeys(name);
        countryTime().clear();
        countryTime().sendKeys(time);
        countryCode().clear();
        countryCode().sendKeys(code);
        countryValidation().clear();
        countryValidation().sendKeys(validation);
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
    }
}
