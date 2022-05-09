package packages.company;

import org.openqa.selenium.By;
import packages.company.pages.CompanyPage;
import packages.company.pages.FacebookPage;
import packages.general.Setup;
import packages.general.pom.PageSteps;

public class CompanySteps extends PageSteps {
    private CompanyPage companyPage;
    private FacebookPage facebookPage;

    public CompanySteps() {
        this.companyPage = new CompanyPage();
        this.facebookPage = new FacebookPage();

    }

    @Override
    public void clicksOnIcon(String icon) {
        By element = By.xpath("//a[contains(@href,'facebook')]");
        this.companyPage.scrollIntoView(element);
        this.companyPage.clickOnButton(element);
    }

    public void checkPageURL(String url) {
        if (url.toLowerCase().contains("facebook")) {
            this.checkURL(url, this.facebookPage);
        } else
            this.checkURL(url, this.companyPage);
    }

    public void checkLeadershipSection() {
        By element = By.xpath("//h2[text()='Leadership']");
        this.companyPage.scrollIntoView(element);
        Setup.getWait().visibilityOfElement(element, "Leadership section could not been found.");
    }

    public void checkMusalaPicture() {
        this.facebookPage.checkMusalaPicture();
    }
}
