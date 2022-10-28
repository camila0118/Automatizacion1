package rest.com.co.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import rest.com.co.interactions.Post;
import rest.com.co.models.Data;

public class Register_Post implements Task {

    Data data = new Data(); //guardamos el json en variables (pojos) y solo llamamos el nombre

    @Override
    public <T extends Actor> void performAs(T actor) {
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("pistol");
        actor.attemptsTo(
                Post.to("/register") //le pasamos el endpoint
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)                                //le decimos de que manera va a ser.tipo JSON
                                //le decimos de que manera va a ser.tipo JSON
                                .body(data))); //le pasamos el request


    }

    public static Performable whitinfo(){
        return Tasks.instrumented(Register_Post.class);
    }
}

