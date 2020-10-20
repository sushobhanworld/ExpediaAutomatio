package pages;

import base.ProjectBaseClass;
import org.testng.Assert;

public class SearchResultPage extends ProjectBaseClass
{
    public void PageTitle()
    {
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle, "Kolkata (and vicinity), West Bengal, India Hotel Search Results");
    }

    public void VerifySearchedText()
    {

    }
}
