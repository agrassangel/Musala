package packages.company;

import io.cucumber.java.en.*;

public class CompanyStepDefinitions {
    private CompanySteps companySteps;

    public CompanyStepDefinitions() {
        companySteps = new CompanySteps();
    }

    @Then("Web page url match with {string}")
    public void web_page_url_match_with(String string) {
        companySteps.checkPageURL(string);

    }

    @Then("Web page shows the Leadership section")
    public void web_page_shows_the_leadership_section() {
        this.companySteps.checkLeadershipSection();
    }

    @Given("user clicks on {string} icon")
    public void user_clicks_on_icon(String string) {
        companySteps.clicksOnIcon(string);
    }
    @Given("Musala Soft picture should appears")
    public void musala_soft_picture_should_appears() {
        companySteps.checkMusalaPicture();
    }
}
