import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
public class TN_SignUp_Parameterization {

    WebDriver driver = null;

    @DataProvider(name = "data-set")
    public static Object[][] DataSet() {
        Object[][] obj = {
                {"asr7780749210@gmail.com", "", "Renu@1234"},
                {"vyshujv@gmail.com", "", "qwe@123K"},
                {"abcdef@gmail.com", "", "aBcyhd@129"}

        };
        return obj;
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        //System.out.println("\n\n \t Iam inside setUp method");
        String url = "https://login.mailchimp.com/";
        String chromeDriverPath = "C:\\software\\chromedriver_113Version\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get(url);
        Thread.sleep(2000);

        String signUpUrl = "https://login.mailchimp.com/signup/";
        driver.get(signUpUrl);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        System.out.println("created new account successfully");
    }

    @Test(dataProvider = "data-set")
    public void search(String email, String username, String password) {
        // WebDriver driver = null;
        driver.findElement(xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(xpath("//input[@id='new_username']")).sendKeys(username);
        driver.findElement(xpath("//input[@id='new_password']")).sendKeys(password);
        String signUpButton = "//*[@id='create-account-enabled']";
        driver.findElement(By.xpath(signUpButton)).click();
    }
}



