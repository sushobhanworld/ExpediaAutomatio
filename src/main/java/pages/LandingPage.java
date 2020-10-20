package pages;

import base.ProjectBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.DateSelection;

import java.text.ParseException;
import java.util.List;

public class LandingPage extends ProjectBaseClass
{
    @FindBy(how = How.XPATH, using = "//*[@id='location-field-destination-menu']/div[1]/button")
    public WebElement SearchTextBox;

    @FindBy(how = How.XPATH, using = "//*[@data-stid='location-field-destination-result-item']")
    public List<WebElement> locationList;

    @FindBy(how = How.ID, using = "d1-btn")
    public WebElement CheckInDate;

    //*[@aria-label='Nov 18, 2020']

    @FindBy(how = How.XPATH, using = "//button[@data-stid='apply-date-picker']/span")
    public WebElement doneDateBtn;

    @FindBy(how = How.XPATH, using = "//a[@data-testid='travelers-field'] | //button[@data-testid= 'travelers-field-trigger']")
    public WebElement travellers;

    @FindBy(how = How.XPATH, using = "//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")
    public List<WebElement> Sign;

    @FindBy(how = How.XPATH, using = "//*[@class='uitk-button uitk-button-large uitk-button-fullWidth uitk-button-has-text uitk-button-primary uitk-button-floating']")
    public WebElement doneTravellersBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='submit-button']")
    public WebElement searchBtn;

    public LandingPage()
    {
        super();
        PageFactory.initElements(driver, this);
    }

    public void searchText(String place) throws Exception
    {
        SearchTextBox.sendKeys(place);
        Thread.sleep(2000);
        locationList.get(0).click();
    }

    public void EnterTravelDates(String inDate, String outDate) throws ParseException {
        CheckInDate.click();
        driver.findElement(By.xpath("//*[@aria-label='"+DateSelection.GetStartDate(inDate)+"']")).click();
        driver.findElement(By.xpath("//*[@aria-label='"+DateSelection.GetReturnDate(outDate)+"']")).click();
        doneDateBtn.click();
    }
    public void EnterTavellers(String travellersNumber) throws Exception
    {
        travellers.click();
        int number= Integer.valueOf(travellersNumber);
        int i=2;
        while(i<=number)
        {
            Sign.get(1).click();
            Thread.sleep(1000);
            i++;
        }
        doneTravellersBtn.click();
    }

    public void ClickSearchButton()
    {
        searchBtn.click();
    }
}
