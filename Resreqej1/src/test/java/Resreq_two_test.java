import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.awt.geom.QuadCurve2D;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Resreq_two_test {

    @Test
    public void logintwotest() {
        RestAssured
                .given()                                   //le decimos que dado a *haga tal cosa*
                .log().all()                               //muestre en consola lo que el JSON
                .contentType(ContentType.JSON)             //que nos lea en formato JSON
                .body(" {\n" +
                        "                                \"email\": \"eve.holt@reqres.in\",\n" +
                        "                \"password\": \"cityslicka\"\n" +
                        "}")                               //Le damos la peticion, request
                .post("https://reqres.in/api/login")  //el endpoint o url
                .then()                                    //validamos
                .log().all()                               //mostramos en consola el response o respuesta
                .statusCode(200)                           //empezamos asercion, aqui le decimos que nos valide si el estado esta en 200
                .body("token", notNullValue());       //y que el token no sea nulo

    }


    @Test
    public void getSingleUsertest() {

        RestAssured
                .given()                        //le decimos que dado a *haga tal cosa*
                .log().all()                    //muestre en consola lo que el JSON
                .contentType(ContentType.JSON)  //que nos lea en formato JSON
                .get("https://reqres.in/api/users/2") //endpoit
                .then()                         //validamos
                .log().all()                    //mostramos en consola el response o respuesta
                .statusCode(200)                //empezamos asercion, aqui le decimos que nos valide si el estado esta en 200
                .body("data.email", equalTo("janet.weaver@reqres.in"));  //aqui ingresamos al JSON y le decimos que de los datos *data* me traiga el que tenga *email* @yopmail
    }

}
