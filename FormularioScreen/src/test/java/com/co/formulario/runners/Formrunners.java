package com.co.formulario.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/form.feature",
        glue = "com.co.formulario.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class Formrunners {

}
