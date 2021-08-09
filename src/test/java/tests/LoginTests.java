package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.CreateDriver;

public class LoginTests extends TestBase {

    @Test (groups = {"smoke"})
    public void appHealthCheck(){

        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getProperty("url")));

    }

    @Test(groups = {"smoke"})
    public void loginpositive(){

        LoginPage loginPage = new LoginPage();

        loginPage.useremailField.sendKeys(ConfigReader.getProperty("username1"));
        loginPage.passwordField.sendKeys(ConfigReader.getProperty("password1"));
        loginPage.loginButton.click();


        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));

    }

}
