package com.ariat.Tests.Categories.Countries.MenCategory.Sorting;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Categories.MenCategories.MenCategoryPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;


/**
 * Pagination and sorting for Men Category
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenCategoryPaginationSortingUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private MenCategoryPage menCategoryPage;
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
			
    @BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test
	public void navigateMenCategory() {
		logger.info("Starting sort and navigate pagination test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		menCategoryPage = homePageUK.returnMenCategoryPage();
		menCategoryPage.clickSortUp();
		menCategoryPage.sortProductWomenCategoryRecommended();
		menCategoryPage.clickSortUp();
		menCategoryPage.sortProductWomenCategoryBestSellers();
		menCategoryPage.clickSortUp();
		menCategoryPage.sortProductWomenCategoryPriceHighToLow();
		menCategoryPage.show72ItemsUp();
		menCategoryPage.show108ItemLinkUp();
		menCategoryPage.show36ItemsUp();
		menCategoryPage.nextPaginationUp();
		menCategoryPage.prevPaginationButtonUp();
		logger.info("Finishing  sort and navigate pagination test.");
	}
	
	@AfterTest
	public void clearBrowserSession() {
		KillChrome kill = new KillChrome();
		kill.killChrome();
    }

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		menCategoryPage.quit();
		
	}
}
