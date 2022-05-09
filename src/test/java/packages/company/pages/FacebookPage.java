package packages.company.pages;

import org.openqa.selenium.By;
import packages.general.pom.PageObject;

public class FacebookPage extends PageObject {

    public FacebookPage() {
        super();
    }

    public void checkMusalaPicture() {
        /*
        I couldn't find the way to validate whether the image content belong to Musala or not.
        We will need to use third party tools to process the image, and get the appropriate output.
         */
        this.checkElementVisibility(By.xpath("//a[contains(@aria-label,'Musala Soft')]"));

    }
}
