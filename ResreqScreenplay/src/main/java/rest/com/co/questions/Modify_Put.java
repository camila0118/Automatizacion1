package rest.com.co.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Modify_Put implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        //con response le decimos, capturame el registro de la clave name
        String response = SerenityRest.lastResponse().jsonPath().getString("name");//lo capturado se guarda en la variable response
        //jsonpath, es traeme una respuesta del json(clave-valor)
        // capuramos respuesta
        System.out.println(response);
        return response; //y retorname response
    }

    public static Modify_Put enter() {
        return new Modify_Put();
    }

}


//capturamos datos para comprarar
