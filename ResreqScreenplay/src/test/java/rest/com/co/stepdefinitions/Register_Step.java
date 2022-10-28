package rest.com.co.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import rest.com.co.exceptions.Message_exception;
import rest.com.co.questions.Compare_list_get;
import rest.com.co.questions.Modify_Put;
import rest.com.co.questions.Response_Code;
import rest.com.co.tasks.Get_User;
import rest.com.co.tasks.Register_Post;
import rest.com.co.tasks.User_put;
import rest.com.co.utils.Constants;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Register_Step {

    public static final String restApiUrl = "https://reqres.in/api";  //esta es la url pero con el api, ya que aqui con patron no se separara.
    Actor camila = Actor.named("Cami the trainer");  //definimos el actor que va a realizar el proceso, esta definido de manera global.

    //metodos comunes de screen play
    @Given("Camila is client that can managment his bank products")
    //lo primero que se hace es llamar la api para poder cnsumir la  url y obtener respuesta
    public void camilaIsClientThatCanManagmentHisBankProducts() {
        camila.whoCan(CallAnApi.at(restApiUrl)); //ingresamos a la url para poder admonistrar todeos los verbos.
        //whocan es para hacer alguna conexion en servicios
        //callanapi me llama la api.
        // y ya le estamos diciendo que lo que hagamos en esa automatizacion esta pegada a esa api.
    }

    @When("We send the information required for the register")
    public void weSendTheInformationRequiredForTheRegister() {
        camila.attemptsTo(Register_Post.whitinfo()); //esto quiere decir *camila intenta registrar el metodo post con la info

    }

    @Then("he should see a virtual account for can login into page")
    public void heShouldSeeAVirtualAccountForCanLoginIntoPage() {
        camila.should(seeThat(Constants.MESSAGE_STATUS, Response_Code.was()
                , equalTo(Constants.RESPONSE_STATU_OK))); //le decimos que la ultima respuesta que se obtiene con el statuscode sea 200
    }


    //*******************************************************************************************************************************


    @When("he send the information for put")
    public void heSendTheInformationForPut() {
        camila.attemptsTo(User_put.select());

    }

    @Then("he should see put")
    public void heShouldSeePut() {
        camila.should(seeThat(Constants.MESSAGE_NAME, Modify_Put.enter(),
                equalTo(Constants.RESPONSE_NAME)).orComplainWith(Message_exception.class
                , Constants.MESSAGE_ERROR));

        //orientados al fallo con message_esception.class
    }

    //****************************************************************************************************************************

    @When("he capture the list")
    public void heCaptureTheList() {
        camila.attemptsTo(Get_User.obtain());
    }

    @Then("he should the data list")
    public void heShouldTheDataList() {
        camila.should(GivenWhenThen.seeThat(Compare_list_get.one()));
    }


    //******************************************************************************************************************************************

    @When("we see articles for the delete")
    public void weSeeArticlesForTheDelete() {

    }

    @Then("see that the articles are deleted")
    public void seeThatTheArticlesAreDeleted() {

    }

}
