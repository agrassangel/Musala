package packages.contact;

//import org.junit.Assert;

import org.openqa.selenium.By;
import packages.contact.pages.ContactForm;
import packages.general.Setup;

public class ContactSteps {
    private ContactForm contactForm;

    String nameField = "your-name";
    String emailField = "your-email";
    String numberField = "mobile-number";
    String subjectField = "your-subject";
    String messageField = "your-message";

    public ContactSteps() {
        contactForm = new ContactForm();
    }

    public void checkForm() {
        contactForm.checkForm();
    }

    public void fillRequiredFields(String wrongEmail) {
        contactForm.fillRequiredFields(wrongEmail);
    }

    public void clickOnSendButton() {
        contactForm.clickOnButton(By.xpath("//input[@type='submit']"));
    }

    public void validateEmailErrorMessage() {
        Setup.getWait().textAppear("The e-mail address entered is invalid.");
    }
}
