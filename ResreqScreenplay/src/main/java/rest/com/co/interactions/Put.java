package rest.com.co.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Put extends RestInteraction {

    private final String resource;

    public Put(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a PUT on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().put(as(actor).resolve(resource)).then().log().all();
    }

    public static net.serenitybdd.screenplay.rest.interactions.Put to(String resource) {
        return instrumented(net.serenitybdd.screenplay.rest.interactions.Put.class, resource);
    }

}
