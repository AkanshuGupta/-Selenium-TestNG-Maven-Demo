package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ImdbPage extends TestBase {

    public ImdbPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "home_img")
    WebElement logo;

    @FindBy(id = "suggestion-search")
    WebElement search_bar;

    @FindBy(id = "suggestion-search-button")
    WebElement search_button;

    @FindBy(xpath = "//h3[contains(text(),'Titles')]")
    WebElement title;

    @FindBy(xpath="//a[contains(text(),'Release date')]/parent::li/div//a")
    WebElement release_date;

    @FindBy(xpath = "//button[contains(text(),'Country of origin')]/parent::li/div//a")
    WebElement country_name;

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void OpenIMDBUrl(){
        driver.get("https://www.imdb.com/");
    }

    public void enterSearchTextIntoSearchBar(String searchText){
        search_bar.isDisplayed();
        search_bar.sendKeys(searchText);
    }

    public void clickOnSearchIcon(){
        search_button.click();
    }

    public void openMovieDetailsPage(String movieFullName){
        title.isDisplayed();
        String xpathExpression = "//li[contains(@class,'find-title-result')]//a[contains(text(),'"+movieFullName+"')]";
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public String getCountryName(){
        return country_name.getText();
    }

    public String getReleaseDate(){
        return release_date.getText();
    }
}
