package co.com.conduit.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "./src/test/resources/features/criticalflowarticle.feature",
        glue = "co/com/conduit/stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CriticalFlowArticleRunner {
}