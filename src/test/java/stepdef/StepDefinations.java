package stepdef;

import base.ProjectBaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LandingPage;

import java.text.ParseException;

public class StepDefinations extends ProjectBaseClass
{
    LandingPage landingPage;
    @Given("I am on the homePage of Expedia")
    public void ExpediaHomePage()
    {
        Initialize();
        landingPage= new LandingPage();
    }

    @Then("I search {string}")
    public void iSearch(String text) throws Exception
    {
        landingPage.searchText(text);
    }


    @And("I select {string} and {string}")
    public void iSelectAnd(String date1, String date2) throws ParseException {
        landingPage.EnterTravelDates(date1, date2);
    }

    @And("I select {string} as number of travellers")
    public void iSelectAsNumberOfTravellers(String travellersNumber) throws Exception {
        landingPage.EnterTavellers(travellersNumber);
    }

    @And("I click on Search button")
    public void iClickOnSearchButton()
    {
        landingPage.ClickSearchButton();
    }

    @Then("I validate the url contains the {string}")
    public void iValidateTheUrlContainsThe(String arg0) {
    }

    @Then("I validate  the text is selected under Neighbourhood")
    public void iValidateTheTextIsSelectedUnderNeighbourhood()
    {

    }

    @Then("I validate the {string} of the page")
    public void iValidateTheTitleOfThePage(String expectedTitle)  throws Exception{
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}
