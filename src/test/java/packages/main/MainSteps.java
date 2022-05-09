package packages.main;

//import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import packages.general.Setup;
import packages.general.pom.PageSteps;
import packages.main.pages.MainPage;

public class MainSteps {

    private MainPage mainPage;

    public MainSteps() {
        mainPage = new MainPage();
    }

    public void validateMainView() {
        WebElement company = mainPage.getElement(By.xpath("//*[@id=\"menu-main-nav-1\"]/*/a[text()='Company']"));
        WebElement careers = mainPage.getElement(By.xpath("//*[@id=\"menu-main-nav-1\"]/*/a[text()='Careers']"));
        WebElement joinUS = mainPage.getElement(By.cssSelector("#navbar > button.join-us"));
        WebElement news = mainPage.getElement(By.xpath("//a[contains(@href,'/news')]"));
//        Assert.assertTrue("Musala web page has not been identified.", company.isDisplayed() && careers.isDisplayed() && joinUS.isDisplayed() && news.isDisplayed());
//        Assert.assertEquals("Main url is not valid for Musala initial page", mainPage.getDriver().getCurrentUrl(), Setup.getValueStore("defaultUrl").toString());
    }

    public void clickOnContact() {
        By contactButton = By.cssSelector(".contact-label");
        mainPage.scrollIntoView(contactButton);
        Setup.getActions().moveToElement(mainPage.getElement(contactButton)).click().build().perform();

    }

    public void clicksOnTopLink(String string) {
        mainPage.clickOnButton(By.xpath("//*[@id=\"menu-main-nav-1\"]/*/a[contains(@href,'" + string.toLowerCase() + "')]"));

    }
}
