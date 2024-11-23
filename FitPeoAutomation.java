import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FitPeoAutomation {

    public static void main(String[] args) {
        // Set the GeckoDriver path
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\eclipse-workspace\\Selenium_JavaFramework\\drivers\\geckodriver\\geckodriver.exe");

        // Initialize Firefox WebDriver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Navigate to the FitPeo Homepage
            driver.get("https://www.fitpeo.com");
            System.out.println("Navigated to FitPeo Homepage");

            // Step 2: Navigate to the Revenue Calculator Page
            WebElement revenueCalculatorLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
            revenueCalculatorLink.click();
            System.out.println("Navigated to Revenue Calculator Page");

            // Step 3: Scroll down to the Slider section
            WebElement sliderSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slider-section-id"))); // Replace with actual ID
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sliderSection);
            System.out.println("Scrolled to Slider section");

            // Step 4: Adjust the Slider to 820
            WebElement slider = driver.findElement(By.id("slider-id")); // Replace with actual slider ID
            Actions action = new Actions(driver);
            action.clickAndHold(slider).moveByOffset(50, 0).release().perform(); // Adjust offset as needed
            WebElement sliderValue = driver.findElement(By.id("slider-value-id")); // Replace with actual value ID
            if (sliderValue.getAttribute("value").equals("820")) {
                System.out.println("Slider value set to 820");
            } else {
                throw new Exception("Slider value mismatch!");
            }

            // Step 5: Update Text Field to 560
            WebElement textField = driver.findElement(By.id("text-field-id")); // Replace with actual field ID
            textField.clear();
            textField.sendKeys("560");
            WebElement updatedSliderValue = driver.findElement(By.id("slider-value-id")); // Replace with actual value ID
            if (updatedSliderValue.getAttribute("value").equals("560")) {
                System.out.println("Text field updated and slider synchronized to 560");
            } else {
                throw new Exception("Text field and slider not synchronized!");
            }

            // Step 6: Select CPT Codes
            String[] cptCodes = {"99091", "99453", "99454", "99474"}; // CPT code IDs
            for (String code : cptCodes) {
                WebElement checkbox = driver.findElement(By.id("cpt-" + code + "-id")); // Replace with actual ID
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
            System.out.println("Selected CPT Codes");

            // Step 7: Validate Total Recurring Reimbursement
            WebElement reimbursement = driver.findElement(By.id("reimbursement-id")); // Replace with actual reimbursement ID
            if (reimbursement.getText().equals("$110700")) {
                System.out.println("Total Recurring Reimbursement validated successfully");
            } else {
                throw new Exception("Reimbursement value mismatch!");
            }

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
            System.out.println("Test completed and browser closed.");
        }
    }
}
