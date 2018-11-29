package com.ariat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Utils.WebDriverUtils;

/**
 * Links page Order details page with My orders
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class OrderDetailsPage extends BasePage {

	private By returnToMyOrdersLink = By.xpath("//a[text()='Return to My Orders']");
	private By myOrdersText = By.xpath("//*contains[text(),'My orders']");


	protected OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public MyOrdersPage returnMyOrdersPage() {
		WebDriverUtils.clickOnElementWithWait(driver, returnToMyOrdersLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myOrdersText));
		return new MyOrdersPage(driver);
	}

}
