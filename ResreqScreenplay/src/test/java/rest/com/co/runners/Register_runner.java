package rest.com.co.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/register_user.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "rest.com.co.stepdefinitions",
        dryRun = false)
       // tags = "@get")

public class Register_runner {


}
