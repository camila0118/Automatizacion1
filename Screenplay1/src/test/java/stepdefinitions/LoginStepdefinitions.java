package stepdefinitions;

import com.co.screen.exceptions.MessageException;
import com.co.screen.models.Credentials;
import com.co.screen.questions.Vlidations;
import com.co.screen.tasks.LoginTasks;
import com.co.screen.utils.Constants;
import com.co.screen.utils.Url;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.vavr.control.Validation;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import javax.xml.ws.handler.MessageContext;
import java.net.URI;
import java.util.List;

public class LoginStepdefinitions {

    @Managed(driver = "chrome", options = "--start-maximized")
    WebDriver hisBrowser;


    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("cami");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }


    @Given("^he user in the page$")
    public void heUserInThePage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(Url.URL));

    }

    @When("^he user entre in the page$")
    public void heUserEntreInThePage(List<Credentials>credentialsList) {
        Credentials credentials;
        credentials = credentialsList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTasks.enter(credentials));
    }

    @Then("^he user could see the products$")
    public void heUserCouldSeeTheProducts() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Vlidations.compare(), Matchers.equalTo(Constants.EXCEPTION_PRODUCT))
                .orComplainWith(MessageException.class, Constants.MESSAGE_EXCEPTION_PRODUCT));


    }


}
