package packages.contact;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactStepDefinition {

    private ContactSteps contactSteps;

    public ContactStepDefinition() {
        contactSteps = new ContactSteps();
    }


    @Given("user is on Contact Us form")
    public void user_is_on_contact_us_form() {
        contactSteps.checkForm();

    }

    @When("^User fill the required fields with invalid email \"([^\"]*)\"$")
    public void user_fill_the_required_fields(String string) {
        contactSteps.fillRequiredFields(string);

    }


    @When("user clicks on Send button")
    public void user_clicks_on_send_button() {
        contactSteps.clickOnSendButton();

    }

    @Then("The validation email error message should appears")
    public void the_validation_email_error_message_should_appears() {
        contactSteps.validateEmailErrorMessage();

    }
}
