package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="username")
    WebElement user_ele;

    @FindBy(id="password")
    WebElement password_ele;

    @FindBy(id="kc-login")
    WebElement Sign_in_ele;

    public void Add_UserName(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(user_ele));
        user_ele.clear();
        user_ele.sendKeys(username);
    }

    public void Add_Password(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(password_ele));
        password_ele.clear();
        password_ele.sendKeys(password);
    }

    public void click_login() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    	    wait.until(ExpectedConditions.elementToBeClickable(Sign_in_ele));

    	    ((JavascriptExecutor) driver)
    	            .executeScript("arguments[0].scrollIntoView(true);", Sign_in_ele);

    	    wait.until(ExpectedConditions.elementToBeClickable(Sign_in_ele)).click();
    }

}

