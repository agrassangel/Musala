package packages.careers.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import packages.general.Setup;
import packages.general.pom.PageObject;

import java.io.File;
import java.util.*;

public class JoinUSPage extends PageObject {

    public JoinUSPage() {
        super();
        this.urlpath = "join-us/";
    }

    public List<WebElement> getListPositions(String position) {
        List<WebElement> list = new ArrayList<>();
        if (position != null) {
            list.add(this.getElement(By.xpath("//h2[text()='Automation QA Engineer']/ancestor::a")));
        } else
            list = this.getElements(By.className("card-container"));
        return list;
    }

    public void fillApplyRequieredfields(String username, String email, String mobile) {
        List<String> parameter = new ArrayList<>();
        boolean emailW = email.equals("incorrect");
        String emailValue = this.generateRandomEmailScenario(emailW);
        this.getElement(By.name("your-email")).sendKeys(emailValue);
        if (emailW)
            parameter.add("email");
//        #username
        String user = (username.equals("incorrect")) ? "" : this.faker.name().username();
        this.getElement(By.name("your-name")).sendKeys(user);
        if (username.equals("incorrect"))
            parameter.add("username");
//        #mobile
        boolean mobileW = mobile.equals("incorrect");
        String mobileValue = generateRandomMobileScenario(mobileW);
        this.getElement(By.name("mobile-number")).sendKeys(mobileValue);
        if (mobileW)
            parameter.add("mobile");
        this.clickOnButton(By.id("adConsentChx"));
//        this.clickOnButton(By.id("recaptcha-anchor"));/

        Setup.setKeyValueStore("errorFields", parameter);

    }

    private String generateRandomEmailScenario(Boolean incorrectFormat) {
        if (incorrectFormat) {
            String user = this.faker.name().username();
            String part = (new Random().nextInt(1) == 0) ? this.faker.lorem().characters(1, 15) : this.faker.company().suffix().toLowerCase();
            String domain = this.faker.country().countryCode3().toLowerCase();
            switch (new Random().nextInt(4)) {
                case 0:
                    return user.concat("@").concat(part);
                case 1:
                    return user.concat("@").concat(part).concat(".");
                case 2:
                    return user.concat("@");
                case 3:
                    return part.concat(".").concat(domain);
                case 4:
                    return user.concat(".").concat(domain);
                default:
                    return user;
            }

        }
        return this.faker.internet().emailAddress();

    }

    private String generateRandomMobileScenario(Boolean incorrectFormat) {
        if (incorrectFormat)
            return RandomStringUtils.randomAlphanumeric(0, 10);
        return this.faker.phoneNumber().cellPhone();

    }

    public void uploadImages() {
        File f = new File("documents/Example CV.pdf");
        String path = f.getAbsolutePath();
        this.getElement(By.name("uploadtextfield")).sendKeys(f.getAbsolutePath());
        this.getElement(By.xpath("//input[@type='submit']")).submit();

    }

    public void checkErrors() {
//        List<String> errorFields = Stream.of(Setup.getValueStore("errorFields")).map(Object::toString).collect(Collectors.toList());
        List<Object> errorFields = Arrays.asList(Collections.singletonList(Setup.getValueStore("errorFields")).get(0));
        for (Object l:errorFields
             ) {

        }
        for (Object fieldName : errorFields) {
            String errorMesg = "";
            switch (String.valueOf(fieldName)) {
                case "email":
                    errorMesg = "The e-mail address entered is invalid.";
                case "username":
                    errorMesg = "The field is required.";
                case "mobile":
                    errorMesg = "The telephone number is invalid.";
            }

            Setup.getWait().textAppear(errorMesg);
        }

    }

    public void selectDropDownValue(String country, By dropdown) {
        this.scrollIntoView(dropdown);
        Select location = new Select(this.getElement(dropdown));
        try {
            location.selectByVisibleText(country);
        } catch (Exception e) {

        }


    }
}
