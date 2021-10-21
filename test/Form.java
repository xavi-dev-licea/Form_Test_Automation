import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Selenium/Exercise Files 2/Resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage(driver);
        formPage.submitForm();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.waitForAlertBanner();

        assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText());

        driver.quit();
        System.out.println("The test is done!");
    }
}
