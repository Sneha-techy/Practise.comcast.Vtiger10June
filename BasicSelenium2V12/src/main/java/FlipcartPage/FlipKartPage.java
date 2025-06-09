package FlipcartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipKartPage {
	@FindBy(xpath="//input[contains (@ title,'Search for Products, Brands and More')]")
	private  WebElement searchTF;
	
	@FindBy(xpath="//div[text()='in Mobiles']")
	private  WebElement inMoblie;
	
	@FindBy(xpath="(//select[contains(@class,'Gn+jFg')])[1]")
	private  WebElement mobPrcDD;

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getInMoblie() {
		return inMoblie;
	}

	public WebElement getMobPrcDD() {
		return mobPrcDD;
	}
	
	
	
	
}

