package rest.com.co.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class LoginCoduit2 implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users/login")
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .body(""))

        );
    }
    //public static Performable login(){
     //   return Tasks.instrumented(LoginCoduit2.class);
  //  }
}
