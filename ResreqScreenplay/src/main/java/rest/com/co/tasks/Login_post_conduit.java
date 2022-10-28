package rest.com.co.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import rest.com.co.interactions.Post;
import rest.com.co.models.credentials_conduit.Data_Conduit;
import rest.com.co.models.credentials_conduit.User_conduit;


public class Login_post_conduit implements Task {

    User_conduit user_conduit = new User_conduit();
    Data_Conduit data_conduit = new Data_Conduit();

    @Override
    public <T extends Actor> void performAs(T actor) {
        user_conduit.setEmail("maob13@yopmail.com");
        user_conduit.setPassword("1234");
        data_conduit.setUser(user_conduit);
        actor.attemptsTo(
                Post.to("/users/login") //le pasamos el endpoint
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                //le decimos de que manera va a ser.tipo JSON
                                .body(data_conduit))); //le pasamos el request
    }

    public static Performable login() {
        return Tasks.instrumented(Login_post_conduit.class);
    }
}
