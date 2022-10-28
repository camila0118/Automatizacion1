import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Data;
import org.junit.Test;

import static models.UserRequestBuilder.aUser;

public class Resreq_one_test {


    @Test
    public void PostLogintest() throws JsonProcessingException {
//        Data data = new Data();
//        data.setEmail("eve.holt@reqres.in");
//        data.setPassword("cityslicka");

        ObjectMapper objectMapper = new ObjectMapper();
        Data user = aUser()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();
        System.out.println(objectMapper.writeValueAsString(user));
        RestAssured
                .given()                        //le decimos que dado a *haga tal cosa*
                .log().all()                    //muestre en consola lo que el JSON
                .contentType(ContentType.JSON)  //que nos lea en formato JSON
                .body(user)                     //Le damos la peticion, request
                .post("https://reqres.in/api/login") //el endpoint o url
                .then()                           //validamos
                .log().all()                      //mostramos en consola el response o respuesta
                .extract()                        //le decimos que nos extraiga los datos
                .asString();                      //y que nos lo convierta en String

    }

    @Test
    public void PostLoginconduit() {
        RestAssured
                .given()                        //le decimos que dado a *haga tal cosa*
                .log().all()                    //muestre en consola lo que el JSON
                .contentType(ContentType.JSON)  //que nos lea en formato JSON
                .body(" {\\n\" +\n" +
                        "                        \"  \\\"email\\\": \\\"jarv078@gmail.com\\\",\\n\" +\n" +
                        "                        \"  \\\"password\\\": \\\"123qwe\\\"\\n\" +\n" +
                        "                        \"}")                     //Le damos la peticion, request
                .post("https://api.realworld.io/api/users/login") //el endpoint o url
                .then()                           //validamos
                .log().all()                      //mostramos en consola el response o respuesta
                .extract()                        //le decimos que nos extraiga los datos
                .asString();                       //y que nos lo convierta en String

    }
}

