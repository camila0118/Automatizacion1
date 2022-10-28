package rest.com.co.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import rest.com.co.models.credentials_conduit.User_conduit;
import rest.com.co.questions.Response_Code;
import rest.com.co.tasks.Conduit_Outline;
import rest.com.co.tasks.Login_post_conduit;
import rest.com.co.utils.Constants;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Login_step_conduit {

    Actor camila = Actor.named("Cami the trainer");  //definimos el actor que va a realizar el proceso, esta definido de manera global.

    @Given("Camila is client that can managment his  products and articles")
    public void camilaIsClientThatCanManagmentHisProductsAndArticles() {
        camila.whoCan(CallAnApi.at(Constants.restApiUrl));
    }

    @When("We send the information required for the login")
    public void weSendTheInformationRequiredForTheLogin() {
        camila.attemptsTo(Login_post_conduit.login());
    }

    @Then("he should see the articles and products into page")
    public void heShouldSeeTheArticlesAndProductsIntoPage() {
        camila.should(seeThat(Constants.MESSAGE_STATUS, Response_Code.was()
                ,equalTo(Constants.RESPONSE_STATU_OK)));
    }

    //**************************************************************************************************************

    @When("the enter credentiales {string} and {string}")
    public void theEnterCredentialesAnd(String email, String password) {
        User_conduit user_conduit = new User_conduit();
        user_conduit.setEmail(email);
        user_conduit.setPassword(password);
        camila.attemptsTo(Conduit_Outline.whitInfo(user_conduit));

    }

    @Then("he should see the articles and products into pages")
    public void heShouldSeeTheArticlesAndProductsIntoPages() {
        camila.should(seeThat(Constants.MESSAGE_STATUS, Response_Code.was()
                ,equalTo(Constants.RESPONSE_STATU_OK)));
    }



}

