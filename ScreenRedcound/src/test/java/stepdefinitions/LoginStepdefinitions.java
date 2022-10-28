package stepdefinitions;


import com.co.screen2.tasks.Logintasks;
import com.co.screen2.utils.Url;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class LoginStepdefinitions {

    @Managed
    WebDriver hisBrowser;
    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("cami");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }


    @Given("^open the page$")
    public void openThePage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(Url.URL));
    }

    @When("^enter in the credentials$")
    public void enterInTheCredentials() {
        OnStage.theActorInTheSpotlight().attemptsTo(Logintasks.enter());
    }

    @Then("^send a email$")
    public void sendAEmail() {

    }

}
