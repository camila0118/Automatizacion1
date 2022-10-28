package co.com.conduit.stepsdefinitions;

import co.com.conduit.steps.CriticalFlowArticleStep;
import co.com.conduit.steps.RegisterStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class RegisterStepDefinition {

    @Steps
    RegisterStep rs;


    @Given("Kevin go to the webside")
    public void KevinGoToTheWebside() {

        rs.openWebSite();
    }

    @When("enter the sign up credential")
    public void enterTheSignUpCredential(Map<String,String> registerData) {

        rs.callSignUp(registerData);
    }

    @Then("validate that the new username is  {string}")
    public void validateThatTheNewUsernameIs(String username) {

        rs.validationProfile(username);
    }

    //critical flow article

    @Steps
    CriticalFlowArticleStep cfas;


    @When("create a article, update a article, view a article and delete a article")
    public void createAArticleUpdateAArticleViewAArticleAndDeleteAArticle(Map<String,String> data) throws InterruptedException {
        cfas.callFlujoArticulo(data);
    }

    @Then("validation the message {string}")
    public void validationTheMessage(String message) {
        cfas.compareMessage(message);
    }


}
