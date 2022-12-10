package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage extends TestBase {

    public WikiPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "p-logo")
    WebElement logo;

    @FindBy(id="searchInput")
    WebElement search_bar;

    @FindBy(id="searchButton")
    WebElement search_button;

    @FindBy(xpath="//div[contains(text(),'Release date')]/parent::th/following-sibling::td//li")
    WebElement release_date;

    @FindBy(xpath = "//th[contains(text(),'Country')]/following-sibling::td")
    WebElement country_name;

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void enterSearchTextIntoSearchBar(String searchText){
        search_bar.isDisplayed();
        search_bar.sendKeys(searchText);
    }

    public void clickSearchIcon(){
        search_button.isDisplayed();
        search_button.click();
    }

    public String getCountryName(){
        return country_name.getText();
    }

    public String getReleaseDate(){
        return release_date.getText();
    }

}
