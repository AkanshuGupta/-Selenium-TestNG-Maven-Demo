package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ImdbPage;
import com.crm.qa.pages.WikiPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MovieInformationTest extends TestBase {
    WikiPage wikiPage;
    ImdbPage imdbPage;
    String movieName = "Pushpa: The Rise";
    String movieFullName = "Pushpa: The Rise - Part 1";
    public  MovieInformationTest(){super();}
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initializaton("wikiUrl");
        wikiPage = new WikiPage();
        imdbPage = new ImdbPage();
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser(){
        tearDownMain();
    }

    @Test
    public void TC001_MovieInformationValidation() {
        boolean isWikiLogoDisplayed = wikiPage.isLogoDisplayed();
        Assert.assertTrue(isWikiLogoDisplayed);
        wikiPage.enterSearchTextIntoSearchBar(movieName);
        wikiPage.clickSearchIcon();
        String releaseDateOnWiki = wikiPage.getReleaseDate();
        String countryNameOnWiki= wikiPage.getCountryName();
        imdbPage.OpenIMDBUrl();
        boolean isImdbLogoDisplayed = imdbPage.isLogoDisplayed();
        Assert.assertTrue(isImdbLogoDisplayed);
        imdbPage.enterSearchTextIntoSearchBar(movieName);
        imdbPage.clickOnSearchIcon();
        imdbPage.openMovieDetailsPage(movieFullName);
        String releaseDateOnImdb = imdbPage.getReleaseDate();

        //remove Country Name (United State) and , from date
        releaseDateOnImdb = releaseDateOnImdb.replace(" (United States)","");
        releaseDateOnImdb = releaseDateOnImdb.replace(",","");

        //change date format same as wiki page
        String[] strArray = releaseDateOnImdb.split(" ");
        String dateOfIMDBPage = strArray[1]+" "+""+strArray[0]+" "+""+strArray[2];

        String countryNameOnOnImdb= imdbPage.getCountryName();

        Assert.assertEquals(countryNameOnWiki,countryNameOnOnImdb);
        Assert.assertEquals(releaseDateOnWiki,dateOfIMDBPage);

    }
}
