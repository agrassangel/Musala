package packages.contact.pages;

import org.openqa.selenium.By;
import packages.general.Setup;
import packages.general.WaitingObject;
import packages.general.pom.PageObject;

import javax.swing.*;

public class ContactForm extends PageObject {
    String nameField = "your-name";
    String emailField = "your-email";
    String numberField = "mobile-number";
    String subjectField = "your-subject";
    String messageField = "your-message";

    public ContactForm() {
        super();
    }

    public void checkForm() {
        WaitingObject waitingObject = Setup.getWait();
        waitingObject.waitUntilElementAppear(By.xpath("//form/h2"));
        waitingObject.waitUntilElementAppear(By.name(nameField));
        waitingObject.waitUntilElementAppear(By.name(emailField));
        waitingObject.waitUntilElementAppear(By.name(numberField));
        waitingObject.waitUntilElementAppear(By.name(subjectField));
        waitingObject.waitUntilElementAppear(By.name(messageField));
    }

    public void fillRequiredFields(String wrongEmail) {
        this.getElement(By.name(nameField)).sendKeys(this.faker.name().fullName());
        this.getElement(By.name(numberField)).sendKeys(this.faker.phoneNumber().cellPhone());
        this.getElement(By.name(emailField)).sendKeys(wrongEmail);
        this.getElement(By.name(subjectField)).sendKeys(this.faker.lorem().sentence(20));
        this.getElement(By.name(messageField)).sendKeys(this.faker.lorem().sentence(250));
        Setup.getActions().moveToElement(this.getElement(By.id("recaptcha-anchor"))).click().build().perform();
    }
}
