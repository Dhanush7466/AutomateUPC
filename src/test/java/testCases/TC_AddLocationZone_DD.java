package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AddLocationZone;
import PageObjects.locationZonePage;
import Utilities.ExcelUtils;
import testBase.BaseClass;

public class TC_AddLocationZone_DD extends BaseClass {

    @Test(dataProvider = "LocationZoneData")
    public void verify_Add_Location_Zone(String networkType,
                                         String serviceProvider,
                                         String areaCode,
                                         String zoneType,
                                         String rateCenter,
                                         String timeZone,
                                         String originZone,
                                         String applyImmediately) {

        logger.info("***** Starting Location Zone Test *****");

        try {

            // Navigation
            locationZonePage location_zone = new locationZonePage(driver);
            location_zone.click_Rating_Zone();
            location_zone.click_Location_Zone();

            logger.info("Navigation Successful");

            // Add Location Zone
            AddLocationZone addZone = new AddLocationZone(driver);

            boolean apply = Boolean.parseBoolean(applyImmediately);

            addZone.addLocationZone(
                    networkType,
                    serviceProvider,
                    areaCode,
                    zoneType,
                    rateCenter,
                    timeZone,
                    originZone,
                    apply
            );

            logger.info("Location Zone Added Successfully");

            Assert.assertTrue(true);

        } catch (Exception e) {

            logger.error("Test Failed: " + e.getMessage());
            Assert.fail("Test Failed due to exception: " + e.getMessage());
        }

        logger.info("***** Test Finished *****");
    }

    @DataProvider(name = "LocationZoneData")
    public Object[][] getData() throws Exception {

        String path = System.getProperty("user.dir")
                + "/testData/LocationZoneData.xlsx";

        // Using Sheet1
        return ExcelUtils.getExcelData(path, "Sheet1");
    }
}