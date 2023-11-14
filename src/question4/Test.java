package question4;
/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Test {

    static String baseUrl = "https://www.saucedemo.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {

        // Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser");
        }

        //Open the URL into browser
        driver.get(baseUrl);

        //Maximise the browser
        driver.manage().window().maximize();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get Current Url
        System.out.println("The current Url " + driver.getCurrentUrl());

        //Get the page source
        System.out.println(driver.getPageSource());

        //Find username field element ant type the email
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        usernamefield.sendKeys("standard_user");

        //Find password field element ant type the email
        WebElement passwordfield = driver.findElement(By.id("password"));
        passwordfield.sendKeys("secret_sauce");

        //current url
        System.out.println(" Get Current Url " + driver.getCurrentUrl());

        //Navigate to homepage
        driver.navigate().back();

        //Refresh the page
        driver.navigate().refresh();

        //close the browser
        driver.quit();
    }
}
