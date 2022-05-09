package packages.careers;

import io.cucumber.java.en.*;
import packages.main.MainSteps;

public class CareersStepDefinition {
    private CareersSteps careersSteps;

    public CareersStepDefinition() {
        this.careersSteps = new CareersSteps();
    }

    @Given("User click on Check our open positions")
    public void user_click_on_check_our_open_positions() {
        this.careersSteps.checkCareersPage();
        this.careersSteps.clickOnOpenPositions();
    }

    @Then("System displays Join US web page with url {string}")
    public void system_displays_join_us_web_page_with_url(String string) {
        this.careersSteps.checkJoinUSPage(string);
    }


    @Given("User is on Musala Join US page")
    public void user_is_on_musala_join_us_page() {
        new MainSteps().clicksOnTopLink("Careers");
        this.careersSteps.checkCareersPage();
        this.careersSteps.clickOnOpenPositions();
        this.careersSteps.checkJoinUSPage(null);
    }

    @When("User select option {string} from Select location dropdown")
    public void user_select_option_from_select_location_dropdown(String string) {
        this.careersSteps.selectLocation(string);
    }

    @When("User select open position {string}")
    public void user_select_open_position(String string) {
        this.careersSteps.selectPosition(string);

    }

    @Then("System will display the 4 main session")
    public void system_will_display_the_main_session() {
        this.careersSteps.checkCareersSections();

    }

    @Then("The apply button show be present")
    public void the_apply_button_show_be_present() {
        this.careersSteps.checApplyButton();
    }

    @Given("User clicks on Apply button")
    public void user_clicks_on_apply_button() {
        this.careersSteps.clicksOnApplyBtn();

    }

    @Given("User fills the required fields with wrong data {string} {string} and {string}")
    public void user_fills_the_required_fields_with_wrong_data_and(String string, String string2, String string3) {
        this.careersSteps.fillApplyRequieredfields(string, string2, string3);
    }


    @Given("Users upload an image")
    public void users_upload_an_image() {
        this.careersSteps.uploadImages();

    }

    @Then("System shows the error message expected")
    public void system_shows_the_error_message_expected() {
        this.careersSteps.checkErrorMessages();
    }

    @Then("System will display the open positions")
    public void system_will_display_the_open_positions() {
       this.careersSteps.printOpenPositions();
    }

}
