package rest.com.co.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Compare_list_get implements Question <String>{
    @Override
    public String answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().path("data.id");
        System.out.println(response);
        return response;
    }

    public static Compare_list_get one (){
        return new Compare_list_get();
    }
}
