package rest.com.co.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import rest.com.co.interactions.Get;

public class Get_User implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users?page=2")
                        .withRequest(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }

    public static Get_User obtain (){
        return Tasks.instrumented(Get_User.class);
    }
}
