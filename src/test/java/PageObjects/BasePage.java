package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForLoaderToDisappear() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // Wait until loader appears (optional but safer)
	    try {
	        wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.cssSelector(".loader1.loader--style3")));
	    } catch (Exception ignored) {}

	    // Now wait until it disappears
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader1.loader--style3")));
	}
	
    public void safeClick(WebElement element) {

        waitForLoaderToDisappear();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        waitForLoaderToDisappear();

        js.executeScript("arguments[0].click();", element);

        waitForLoaderToDisappear();
    }
	
}
