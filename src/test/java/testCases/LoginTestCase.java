package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import PageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTestCase extends BaseClass{
	
	@BeforeMethod
	public void Login( )
	{
		logger.info("***Starting Login Test Case****");
		LoginPage login_obj=new LoginPage(driver);
		try {
		login_obj.Add_UserName("mary.gonsalves@6dtech.co.in");
		login_obj.Add_Password("Admin@123");
		login_obj.click_login();
		}
		catch(Exception e)
		{
	        Assert.fail("Login test failed: " + e.toString(), e);
		}
		finally {
			logger.info("Finished Test execution");
		}
		
	}

}
