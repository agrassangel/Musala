package packages.main;

import io.cucumber.java.en.*;
//import cucumber.api.java.en.Given;

public class MainStepDefinition {

    private MainSteps mainSteps;

    public MainStepDefinition() {
        mainSteps = new MainSteps();
    }

    @Given("User is on Musala web side")
    public void user_is_on_musala_web_side() {
        mainSteps.validateMainView();

    }

    @Given("User click on {string}")
    public void user_click_on(String string) {
        mainSteps.clickOnContact();

    }

    @When("User clicks on {string} top link")
    public void user_clicks_on_top_link(String string) {
        mainSteps.clicksOnTopLink(string);
    }


}
