package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddLocationZone extends BasePage {

    public AddLocationZone(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="add_data")
    WebElement addLocationZoneBtn;

    @FindBy(xpath="//span[@id='select2-networkType-container']/parent::span")
    WebElement networkTypeDropdown;

    @FindBy(id="select2-serviceProviderID-container")
    WebElement serviceProviderDropdown;

    @FindBy(id="areaCode")
    WebElement areaCodeTxt;

    @FindBy(id="select2-zoneTypeId-container")
    WebElement zoneTypeDropdown;

    @FindBy(id="rateCenter")
    WebElement rateCenterTxt;

    @FindBy(id="select2-timeZone-container")
    WebElement timeZoneDropdown;

    @FindBy(id="originZoneName")
    WebElement originZoneTxt;

    @FindBy(id="applyImmediatelyLocationZone")
    WebElement applyImmediatelyCheckbox;

    @FindBy(xpath="(//a[normalize-space()='Submit'])[1]")
    WebElement submitBtn;

    // ================= SMALL REUSABLE METHODS =================

    public void clickAddLocationZone()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	waitForLoaderToDisappear();
    	wait.until(ExpectedConditions.elementToBeClickable(addLocationZoneBtn));
        addLocationZoneBtn.click();
    }

    public void selectNetworkType(String value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // 1. Click dropdown
        WebElement dropdown = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//span[@id='select2-networkType-container']")));
        dropdown.click();

        // 2. Wait for search box
        WebElement searchBox = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        searchBox.sendKeys(value);

        // 3. Wait for option and click
        WebElement option = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[contains(text(),'" + value + "')]")));
        option.click();
    }
    public void selectServiceProvider(String serviceProvider)
    {
        serviceProviderDropdown.click();
        driver.switchTo().activeElement().sendKeys(serviceProvider);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public void enterAreaCode(String areaCode)
    {
        waitForLoaderToDisappear();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(areaCodeTxt));
        wait.until(ExpectedConditions.elementToBeClickable(areaCodeTxt));

        areaCodeTxt.click();
        areaCodeTxt.sendKeys(Keys.CONTROL + "a");
        areaCodeTxt.sendKeys(Keys.DELETE);
        areaCodeTxt.sendKeys(areaCode);
    }

    public void selectZoneType(String zoneType)
    {
        zoneTypeDropdown.click();
        driver.switchTo().activeElement().sendKeys(zoneType);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public void enterRateCenter(String rateCenter)
    {
        rateCenterTxt.clear();
        rateCenterTxt.sendKeys(rateCenter);
    }

    public void selectTimeZone(String timeZone)
    {
        timeZoneDropdown.click();
        driver.switchTo().activeElement().sendKeys(timeZone);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public void enterOriginZone(String originZone)
    {
        originZoneTxt.clear();
        originZoneTxt.sendKeys(originZone);
    }

    public void setApplyImmediately(boolean value)
    {
        if(applyImmediatelyCheckbox.isSelected() != value)
        {
            applyImmediatelyCheckbox.click();
        }
    }

    public void clickSubmit()
    {
        submitBtn.click();
    }

    // ================= MAIN BUSINESS METHOD =================

    public void addLocationZone(String networkType,
                                String serviceProvider,
                                String areaCode,
                                String zoneType,
                                String rateCenter,
                                String timeZone,
                                String originZone,
                                boolean applyImmediately)
    {
        clickAddLocationZone();
        selectNetworkType(networkType);
        selectServiceProvider(serviceProvider);
        enterAreaCode(areaCode);
        selectZoneType(zoneType);
        enterRateCenter(rateCenter);
        selectTimeZone(timeZone);
        enterOriginZone(originZone);
        setApplyImmediately(applyImmediately);
        clickSubmit();
    }
}