package packages.careers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import packages.careers.pages.CareersPage;
import packages.careers.pages.JoinUSPage;
import packages.general.Setup;
import packages.general.WaitingObject;
import packages.general.pom.PageSteps;

import java.util.ArrayList;
import java.util.List;

public class CareersSteps extends PageSteps {
    private final CareersPage careersPage;
    private final JoinUSPage joinUSPage;

    public CareersSteps() {
        this.careersPage = new CareersPage();
        this.joinUSPage = new JoinUSPage();
    }

    public void clickOnOpenPositions() {
        By by = By.xpath("//section/descendant::button[contains(@class,'contact-label')]");
        this.careersPage.clickOnButton(by);
    }

    @Override
    public void clicksOnIcon(String icon) {

    }

    public void checkJoinUSPage(String url) {
        this.checkURL(url, this.joinUSPage);
    }

    public void checkCareersPage() {
        this.checkURL(null, this.careersPage);
    }

    public void selectLocation(String country) {
        By locations = By.id("get_location");
        Setup.setKeyValueStore("dropdownCity", country);
        this.joinUSPage.selectDropDownValue(country, locations);
    }

    public void selectPosition(String position) {
        List<WebElement> list = this.joinUSPage.getListPositions(position);
        this.joinUSPage.clickOnButton(list.get(0));
//        Setup.getActions().moveToElement(list.get(0)).click().build().perform();
    }

    public void checkCareersSections() {
        WaitingObject waitobj = Setup.getWait();
        List<String> textList = new ArrayList();
        textList.add("General description");
        textList.add("Requirements");
        textList.add("Responsibilities");
        textList.add("What we offer");

        for (String section : textList) {
            By sect = By.xpath("//h2[text()='" + section + "']");
            this.joinUSPage.scrollIntoView(sect);
            waitobj.visibilityOfElement(sect, "Section ".concat(section).concat(" does not appears in the careers description."));

        }
    }

    public void checApplyButton() {
        Setup.getWait().visibilityOfElement(By.xpath("//input[@value='Apply']"), "Apply button is not visible.");
    }

    public void clicksOnApplyBtn() {

        this.joinUSPage.clickOnButton(By.xpath("//input[@value='Apply']"));
    }

    public void fillApplyRequieredfields(String username, String email, String mobile) {
        this.joinUSPage.fillApplyRequieredfields(username, email, mobile);

    }


    public void uploadImages() {
        this.joinUSPage.uploadImages();
    }

    public void checkErrorMessages() {
        this.joinUSPage.checkErrors();
    }

    public void printOpenPositions() {
        List<WebElement> list = this.joinUSPage.getListPositions(null);
        String city = String.valueOf(Setup.getValueStore("dropdownCity"));
        System.out.println("City: " + city);
        for (WebElement ele:list) {
            String reference=ele.findElement(By.tagName("a")).getAttribute("href");
            WebElement elementH2=ele.findElement(By.tagName("h2"));
            System.out.println("Position: " + elementH2.getText());
            System.out.println("More info: " + reference);

        }

    }
}
