package rest.com.co.setpdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static rest.com.co.utils.Constans.url;

public class LoginStepdefinitions {
    Actor cami = Actor.named("camila is the actor");

    @Given("camila is a swaglabs user and wants to log in")
    public void camilaIsASwaglabsUserAndWantsToLogIn() {
        cami.whoCan(CallAnApi.at(url));
    }

    @When("We send the information required for the login")
    public void weSendTheInformationRequiredForTheLogin() {


    }
    @Then("he user obtain a token")
    public void heUserObtainAToken() {

    }
}
