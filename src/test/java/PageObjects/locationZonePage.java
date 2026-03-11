package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class locationZonePage extends BasePage {

    public locationZonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "menu_1087")
    WebElement Rating_Zone_Ele;

    @FindBy(id = "menu_1113")
    WebElement location_Zone_Ele;

    // Loader locator (VERY IMPORTANT)
    @FindBy(css = ".loader1.loader--style3")
    WebElement loader;

    // Common wait method
    public void waitForLoaderToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }

    public void click_Rating_Zone() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        waitForLoaderToDisappear();

        wait.until(ExpectedConditions.elementToBeClickable(Rating_Zone_Ele));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", Rating_Zone_Ele);

        Rating_Zone_Ele.click();
    }

    public void click_Location_Zone() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        waitForLoaderToDisappear();

        wait.until(ExpectedConditions.elementToBeClickable(location_Zone_Ele));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", location_Zone_Ele);

        location_Zone_Ele.click();
    }
}