package rest.com.co.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;

public class Response_Code implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode(); //le decimos que me obtenga el status de la ultima respuesta
    }



    public static Question<Integer> was(){
        return new Response_Code(); //le decimos que me retorne la  ultima respuesta
    }
}
