package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.locationZonePage;
import testBase.BaseClass;

public class ClickLocationZone extends BaseClass{
	
@Test
public void click_Location_Zone() {
	
	logger.info("***Starting Location Zone Test Case****");
	locationZonePage location_zone=new locationZonePage(driver);
	try
	{
	location_zone.click_Rating_Zone();
	location_zone.click_Location_Zone();
	}
	catch(Exception e)
	{
		Assert.fail("Clicking on Location Zone Failed"+ e.toString(), e);
	}
	finally {
		logger.info("Finished Test execution");
	}
	}
}
