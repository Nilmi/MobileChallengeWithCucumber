package com.straitstimes.mobiletest.stepdefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.straitstimes.mobiletest.util.PropertyUtil;
import com.straitstimes.mobiletest.util.ValidationUtil;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;

public class LatestArticleTest {

	private AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private List<WebElement> elementList;
	private String loginEmail;
	private WebDriverWait wait;

	/**
	 * Read values for property file and set desired capabilities
	 * 
	 * @throws IOException
	 */
	@Before
	public void beforeTest() throws IOException {
		System.out.println("Setting desired capabilities...");
		capabilities = new DesiredCapabilities();

		// Read properties from property file
		String platformName = PropertyUtil.getProperty("platform.name");
		String deviceName = PropertyUtil.getProperty("device.name");
		String appActivity = PropertyUtil.getProperty("app.activity");
		String appPackage = PropertyUtil.getProperty("app.package");
		String noReset = PropertyUtil.getProperty("no.reset");

		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("noReset", noReset);
	}

	/**
	 * Launch the Straitstimes application
	 * 
	 * @throws IOException
	 */
	@Given("^user already launched straitstimes application$")
	public void user_already_launched_straitstimes_application() throws IOException {
		System.out.println("Launching Application...");

		// Read properties from property file
		String androidDriverUrl = PropertyUtil.getProperty("driver.android.url");

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver(new URL(androidDriverUrl), capabilities);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	/**
	 * Opens the drawer menu
	 * 
	 * @throws IOException
	 */
	@Then("^user open drawer menu$")
	public void user_open_drawer_menu() throws IOException {
		System.out.println("user open drawer menu");

		// Read element locators from property file
		String drawerMenuAccessibilityId = PropertyUtil.getProperty("menu.drawer.accessibility.id");
		String toolbarLogoId = PropertyUtil.getProperty("toolbar.logo.id");

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(toolbarLogoId)));

		System.out.println("Locate Drawer menu...");
		System.out.println("Drawer menu..." + drawerMenuAccessibilityId);

		// take a web element list using accessibility ID of navigate up and click on
		// first element
		elementList = driver.findElementsByAccessibilityId(drawerMenuAccessibilityId);
		elementList.get(0).click();
	}

	/**
	 * Tap on login button
	 * 
	 * @throws IOException
	 */
	@Then("^tap on LOGIN button$")
	public void tap_on_LOGIN_button() throws IOException {
		// Read the Id from property file
		String loginButtonId = PropertyUtil.getProperty("button.login.id");

		// click on login button
		driver.findElement(By.id(loginButtonId)).click();
	}

	/**
	 * Refer "Example" test data from feature file "Scenario Outline"
	 * 
	 * @param email
	 * @param password
	 * @throws IOException
	 */
	@Then("^enter \"([^\"]*)\" and \"([^\"]*)\" tap on continue button$")
	public void enter_and_tap_on_continue_button(String email, String password) throws IOException {
		// Read element locators from property file
		String usernameFieldId = PropertyUtil.getProperty("field.username.id");
		String passwordFieldId = PropertyUtil.getProperty("field.password.id");
		String continueButtonId = PropertyUtil.getProperty("button.continue.id");

		// enter user name and password and login
		driver.findElement(By.id(usernameFieldId)).sendKeys(email);
		driver.findElement(By.id(passwordFieldId)).sendKeys(password);
		driver.findElement(By.id(continueButtonId)).click();

		// store email in loginEmail variable for later assertions
		loginEmail = email;
	}

	/**
	 * Verify whether user has logged-in successfully
	 * 
	 * @throws Throwable
	 */
	@Then("^verify user has logged in successfully$")
	public void verify_user_has_logged_in_successfully() throws Throwable {
		// Read element locators from property file
		String loggedUsernameId = PropertyUtil.getProperty("username.logged.id");
		String straitstimesLogoId = PropertyUtil.getProperty("logo.straitstimes.id");
		String drawerMenuAccessibilityId = PropertyUtil.getProperty("menu.drawer.accessibility.id");
		String drawerMenuXpath = PropertyUtil.getProperty("menu.drawer.xpath");

		System.out.println("Locate Drawer menu...");
		System.out.println("Drawer menu..." + drawerMenuAccessibilityId);

		// click on drawer menu
		driver.findElement(By.xpath(drawerMenuXpath)).click();

		// verify logged user email address
		WebElement loginName = driver.findElement(By.id(loggedUsernameId));
		String actualLogin = loginName.getText();
		Assert.assertEquals(loginEmail, actualLogin);

		// Navigate again to main activity
		driver.findElement(By.id(straitstimesLogoId)).click();
	}

	/**
	 * Tap on Latest tab and tap on first article from latest tab
	 * 
	 * @throws IOException
	 */
	@Then("^tap on latest tab and tap on first article$")
	public void tap_on_latest_tab_and_tap_on_first_article() throws IOException {
		// Read element locators from property file
		String latestLinkXpath = PropertyUtil.getProperty("latest.link.xpath");
		String firstArticleOfLatestXpath = PropertyUtil.getProperty("first.article.latest.xpath");

		// wait until the latest link appear
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(latestLinkXpath)));

		// click on latest link
		driver.findElement(By.xpath(latestLinkXpath)).click();
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click on first article
		WebElement firstArticleOfLatest = driver.findElement(By.xpath(firstArticleOfLatestXpath));
		firstArticleOfLatest.click();
	}

	/**
	 * Verify whether first article of latest tab loaded with image/video
	 * 
	 * @throws IOException
	 */
	@Then("^verify that article loading sucessfully with image/video$")
	public void verify_that_article_loading_sucessfully_with_image_video() throws IOException {
		// Read element locators from property file
		String firstArticleOfLatestImageId = PropertyUtil.getProperty("first.article.latest.image.id");
		try {
			Boolean imageValidity = ValidationUtil
					.checkImageValidity(driver.findElement(By.id(firstArticleOfLatestImageId)));
			Assert.assertTrue(imageValidity);
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false);
		}

	}

}
