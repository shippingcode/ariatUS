package com.ariat.Tests.Checkout.NegativeCreateOrder;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageNO;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessCompletePage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;

/**
 * Checkout -> Negative Create new order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeCheckoutCreateOrderNOTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageNO homePageNO;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private CheckoutProcessCompletePage checkoutProcessCompletePage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;

	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITY = "24534543";
	public static final String COUNTRY = "United Kingdom";
	public static final String ZIP_CODE = GenerateRandomDataUtils.generateRandomString(5);
	public static final String MOBILE = GenerateRandomDataUtils.generateRandomString(7);
	public static final String EMAIL = GenerateRandomDataUtils.generateRandomNumber(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);
	public static final String EMAILEXISTENT = "aila.bogasieru@ariat.com";
	public static final String PASSWORDEXISTENT = "Parola12345!";
	private ListOfCreditCards typeCard;
	private static final String YEAR = "2023";
	private static final String MONTH = "January";
	public static final String CARD_NAME1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String FIRST_NAME1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME1 = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS1 = GenerateRandomDataUtils.generateRandomString(5);

	public static final String ZIP_CODE1 = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String MOBILE1 = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ERROR_ORDER_NOT_PLACED ="We're sorry that your order could not be placed. This probably happened due to a high order volume or temporary connection errors. Please wait a few minutes and resubmit your order. We won't process your payment until you successfully place your order. If you have further questions, please contact us.";

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority=0)
	public void checkoutNegativeCreateOrderInvalidShippingAddress() {
		logger.info("Starting checkout -> create negative order invalid shipping address...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		womenCategoryPage = homePageNO.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME);
		checkoutProcessPage.enterLName(LAST_NAME);
		checkoutProcessPage.enterAddress(ADDRESS);
		checkoutProcessPage.enterAddress1(ADDRESS1);
		checkoutProcessPage.enterCity(CITY);
		checkoutProcessPage.enterZipCode(ZIP_CODE);
		checkoutProcessPage.selectCountry();
		checkoutProcessPage.enterMobile(MOBILE);
		checkoutProcessPage.enterEmail(EMAIL);
		checkoutProcessPage.enterConfirmEmail(EMAIL);
		checkoutProcessPage.continueCheckout();
		logger.info("Finishing checkout -> create negative order invalid shipping address.");
	}

	@Test(priority = 1)
	public void checkoutNegativeCreateOrderInvalidPaymentsDetails() {
		logger.info("Starting checkout -> create negative order invalid payment details...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		womenCategoryPage = homePageNO.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME1);
		checkoutProcessPage.enterLName(LAST_NAME1);
		checkoutProcessPage.enterAddress(ADDRESS1);
		checkoutProcessPage.enterCity(CITY);
		checkoutProcessPage.enterZipCode(ZIP_CODE1);
		checkoutProcessPage.selectCountry();
		checkoutProcessPage.enterMobile(MOBILE1);
		checkoutProcessPage.enterEmail(EMAILEXISTENT);
		checkoutProcessPage.enterConfirmEmail(EMAILEXISTENT);
		checkoutProcessPage.continueCheckout();
		checkoutProcessPage.continueCheckout();
		checkoutProcessPage.enterCardNameNotlogged(CARD_NAME);
		checkoutProcessPage.enterCardNo(typeCard.INVALID_CARD.getNumber());
		checkoutProcessPage.selectTypeCard(typeCard.MASTER_CARD.getName());
		checkoutProcessPage.selectExpirationMonth(MONTH);
		checkoutProcessPage.selectExpirationYear(YEAR);
		checkoutProcessPage.enterSecurityCode(typeCard.INVALID_CARD.getCvs());
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		checkoutProcessCompletePage.assertErrMsgOrderNotPlaced(ERROR_ORDER_NOT_PLACED);
		logger.info("Finishing checkout -> create negative order invalid payment details.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageNO.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		myBagPage.quit();
		checkoutProcessPage.quit();
		checkoutPage.quit();
		checkoutProcessCompletePage.quit();
		glovesProductPage.quit();
		myAccountPage.quit();
	}
}
