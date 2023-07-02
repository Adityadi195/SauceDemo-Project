package step_definitions.YourInformationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.YourInformationPage;
import step_definitions.Hooks;

import static org.junit.Assert.assertEquals;

public class DataBuyerSteps {
    public WebDriver webDriver;

    public DataBuyerSteps(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @And("User click button continue")
    public void userClickButtonContinue() throws InterruptedException {
        YourInformationPage informationPage = new YourInformationPage(webDriver);
        informationPage.continueBtn.click();
        Thread.sleep(2000);
    }

    @And("User input {string} as firstName and input {string} as lastName and postalCode {string}")
    public void userInputAsFirstNameAndInputAsLastNameAndPostalCode(String firstName, String lastName, String postcode) throws InterruptedException {
        YourInformationPage informationPage = new YourInformationPage(webDriver);
        informationPage.inputDataBuyer(firstName, lastName, postcode);
        Thread.sleep(2000);
    }

    @Then("User able to see  confirmation message as {string}")
    public void theUserAbleToSeeConfirmationMessageAs(String expectedMessage) throws InterruptedException {
        YourInformationPage informationMessage = new YourInformationPage(webDriver);
        assertEquals(expectedMessage,informationMessage.confirmationMessage.getText());
        Thread.sleep(2000);
    }

    @Then("User see {string} error popUp on your information page")
    public void userSeeErrorPopUpOnYourInformationPage(String errorPopUp ) throws InterruptedException {
        YourInformationPage infoPage = new YourInformationPage(webDriver);
        Assert.assertEquals(errorPopUp, infoPage.errortext());
        Thread.sleep(2000);
    }

    @And("User click continue to your overview page")
    public void userClickContinueToYourOverviewPage() throws InterruptedException {
        YourInformationPage infoPage = new YourInformationPage(webDriver);
        infoPage.continueBtn.click();
        Thread.sleep(2000);
    }

    @And("User enters details firstName {string} lastName {string} and postalCode {string}")
    public void theUserEntersDetailsFirstnameLastnameAndPostalcode(String firstName, String lastName, String postcode) throws InterruptedException {
        YourInformationPage informationPage = new YourInformationPage(webDriver);
        informationPage.inputDataBuyer(firstName, lastName, postcode);
        Thread.sleep(2000);
    }

    @Then("User already on checkout page")
    public void userAlreadyOnCheckoutPage() throws InterruptedException {
        YourInformationPage pageInfo = new YourInformationPage(webDriver);
        Assert.assertTrue(pageInfo.verifyDshboardInfo());
        Thread.sleep(2000);
    }
}
