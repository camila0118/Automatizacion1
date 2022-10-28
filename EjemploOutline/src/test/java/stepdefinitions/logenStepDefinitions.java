package stepdefinitions;

import com.co.outline.models.Data;
import com.co.outline.steps.LoginStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class logenStepDefinitions {


    @Steps
    LoginStep loginStep;

    @Given("^He user is on the page$")
    public void heUserIsOnThePage() {
        loginStep.openPage();

    }

    @When("^the user enter the credentials$")
    public void theUserEnterTheCredentials(List<Data>dataList) {
        loginStep.DataLogin(dataList.get(0).getUser());
        loginStep.Datalogin1(dataList.get(0).getPassword());
        loginStep.click();
    }

    @Then("^he could see the products$")
    public void heCouldSeeTheProducts() {

    }

}
