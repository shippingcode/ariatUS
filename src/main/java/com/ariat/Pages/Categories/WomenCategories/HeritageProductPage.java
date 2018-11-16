package com.ariat.Pages.Categories.WomenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.BasePage;
import com.ariat.Pages.MyAccountWishListPage;
import com.ariat.Pages.MyBagPage;
import com.ariat.Pages.MyWishListPage;
import com.ariat.Utils.WebDriverUtils;

public class HeritageProductPage extends BasePage{

	private By addToBasket = By.xpath("//button[text()='Add to basket']");

	private By productBonusDialog = By.id("bonus-product-dialog");
	private By wishList = By.xpath("//button[text()='Add to WishList']");
	private By myWishListText = By.xpath("//*contains[text(), 'Wish list']");

	private By myAccountText = By.xpath("//*contains[text()='My account']");
	private By myWishlistText = By.xpath("//*contains[text()='Wishlist']");
	
	private By selectSize = By.id("va-size");
	private By selectCalf = By.id("va-calf");
	private By selectHeight = By.id("va-height");
	private By increaseQty = By.xpath("//span[text()='+']");
	private By decreaseQty = By.xpath("//span[text()='-']");
	private By writeReview = By.xpath("//*[@id=\"BVRRSummaryContainer\"]/div/div/div/div/div/div/div");
	private By reviewDialog = By.id("bv-mbox-lightbox-list");
	private By starReviewExcellent = By.xpath("//span[text()='Excellent']");
	private By starReviewGood = By.xpath("//span[text()='Good']");
	private By starReviewAverage = By.xpath("//span[text()='Average']");
	private By starReviewFair = By.xpath("//span[text()='Fair']");
	private By starReviewPoor = By.xpath("//span[text()='Poor']");

	private By titleReview = By.id("bv-text-field-title");
	private By textReview = By.id("bv-textarea-field-reviewtext");
	private By addPhotoReview = By.xpath("//span[text()='Add Photo']");
	private By addVideoReview = By.xpath("//button[text()=' Add Video ']");
	private By addPhotoModal = By.id("bv-mbox-lightbox-list");
	private By choosePhotoReview = By.id("bv-text-field-photourl_1");
	private By videoModalReview = By.id("bv-mbox-lightbox-list");
	private By insertVideoURLReview = By.id("bv-text-field-videourl_1");
	private By addVideoButton = By.xpath("//button[text()='Add Video']");
	private By recommendProductYes = By.id("bv-radio-isrecommended-true-label");
	private By recommendProductNo = By.id("bv-radio-isrecommended-false-label");
	private By nicknameReview = By.id("bv-text-field-usernickname");
	private By userLocation = By.id("bv-text-field-userlocation");
	private By emailReview = By.id("bv-email-field-hostedauthentication_authenticationemail");
	private By postReviewButton = By.xpath("//span[text()='Post Review']");

	public HeritageProductPage(WebDriver driver) {
		super(driver);
	}

	public void selectAttributeSize(String size) {
		WebDriverUtils.selectVisibleText(driver, selectSize, size);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectAttributeCalf(String calf) {
		WebDriverUtils.selectVisibleText(driver, selectCalf, calf);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectAttributeHeight(String height) {
		WebDriverUtils.selectVisibleText(driver, selectHeight, height);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void setQtyIncrease(int n) {
		for (int i = 0; i <= n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, increaseQty);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		}
	}

	public void setQtyDecrease(int n) {
		for (int i = 0; i <= n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, decreaseQty);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		}
	}

	public void writeReviewClick() {
		WebDriverUtils.clickOnElementWithWait(driver, writeReview);
	}

	public void writeReviewStar(String star) {
		if (WebDriverUtils.findElement(driver, reviewDialog) != null) {
			switch (star) {
			case "Excellent":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewExcellent);
				break;

			case "Good":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewGood);
				break;

			case "Average":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewAverage);
				break;

			case "Fair":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewFair);
				break;

			case "Poor":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewPoor);
				break;

			default:
				throw new RuntimeException("No star supported");
			}
		}
	}

	public void writeReviewContent(String titleReviewText, String reviewText) {
		WebDriverUtils.enterTextBox(driver, titleReview, titleReviewText);
		WebDriverUtils.enterTextBox(driver, textReview, reviewText);
	}

	public void addPhoto() {
		WebDriverUtils.clickOnElementWithWait(driver, addPhotoReview);
		if (WebDriverUtils.findElement(driver, addPhotoModal) != null) {
			WebDriverUtils.clickOnElementWithWait(driver, choosePhotoReview);
			// Upload the file
		}
	}

	public void addVideo(String videoURL) {
		WebDriverUtils.clickOnElementWithWait(driver, addVideoReview);
		if (WebDriverUtils.findElement(driver, videoModalReview) != null) {
			WebDriverUtils.enterTextBox(driver, insertVideoURLReview, videoURL);
			WebDriverUtils.clickOnElementWithWait(driver, addVideoButton);
		}
	}

	public void recommendProductYes() {
		WebDriverUtils.clickOnElementWithWait(driver, recommendProductYes);
	}

	public void recommendProductNo() {
		WebDriverUtils.clickOnElementWithWait(driver, recommendProductNo);
	}

	public void userInfoReview(String nickname, String userLocationReview, String email) {
		WebDriverUtils.enterTextBox(driver, nicknameReview, nickname);
		WebDriverUtils.enterTextBox(driver, userLocation, userLocationReview);
		WebDriverUtils.enterTextBox(driver, emailReview, email);
	}

	public void postReview() {
		WebDriverUtils.clickOnElementWithWait(driver, postReviewButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}
	
	public void addToCart() {
		WebDriverUtils.clickOnElementWithWait(driver, addToBasket);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}

	public MyBagPage returnMyBagPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, addToBasket);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(productBonusDialog));
		return new MyBagPage(driver);
	}

	public MyAccountWishListPage returnMyAccountWishListPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, wishList);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishlistText));
		return new MyAccountWishListPage(driver);
	}

	public MyWishListPage returnMyWishListPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, wishList);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishListText));
		return new MyWishListPage(driver);
	}
}
