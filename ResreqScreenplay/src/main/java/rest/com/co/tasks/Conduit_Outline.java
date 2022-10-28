package rest.com.co.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import rest.com.co.interactions.Post;
import rest.com.co.models.credentials_conduit.Data_Conduit;
import rest.com.co.models.credentials_conduit.User_conduit;

public class Conduit_Outline implements Task {

    User_conduit user_conduit;

    public Conduit_Outline(User_conduit user_conduit) {
        this.user_conduit = user_conduit;
    }

    Data_Conduit data_conduit = new Data_Conduit();
    @Override
    public <T extends Actor> void performAs(T cami) {
       data_conduit.setUser(user_conduit);
        cami.attemptsTo(
                Post.to("/users/login")
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .body(data_conduit))
        );
    }

    public static Performable whitInfo (User_conduit user_conduit){
        return Tasks.instrumented(Conduit_Outline.class, user_conduit);
    }
}
