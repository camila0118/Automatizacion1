package rest.com.co.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import rest.com.co.interactions.Put;

public class User_put implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Put.to("/user/2")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON) //debe ser de tipo JSON
                                .body("{\n" +
                                        "    \"name\": \"morpheus\",\n" +
                                        "    \"job\": \"zion resident\"\n" +
                                        "}"))//le pasamos el request
        );
    } //aqui le estoy diciendo que estoy haciendo el metodo put y que cuando ya lo realize

    public static User_put select(){
        return Tasks.instrumented(User_put.class); //me lo retorne al stepdefinitions
    }
}
