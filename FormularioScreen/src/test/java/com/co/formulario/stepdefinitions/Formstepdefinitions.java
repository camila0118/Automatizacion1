package com.co.formulario.stepdefinitions;

import com.co.formulario.models.DataForm;
import com.co.formulario.tasks.FormTasks;
import com.co.formulario.utils.Url;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Formstepdefinitions {

    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("user");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^he user open the page$")
    public void heUserOpenThePage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(Url.URL));
    }

    @When("^he user enter data$")
    public void heUserEnterData(List<DataForm>dataFormList) {
        DataForm dataForm;
        dataForm = dataFormList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(FormTasks.enter(dataForm));

    }

    @Then("^the user verifies entered data$")
    public void theUserVerifiesEnteredData() {

    }


}
