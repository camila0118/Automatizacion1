import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class Resres_tree_test {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/";  //guardamos la url para no estar llamandola en cada metodo
        RestAssured.basePath = "/api";               //y la basepath tambien se guarda
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());    // hacemos el .log().all()
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();                            //Configurado y compilado esto es para no repetir en contentType(ContentType.JSON)
         }


        @Test
        public void getSingleUsertest () {

            RestAssured
                    .given()                        //le decimos que dado a *haga tal cosa*
                    .contentType(ContentType.JSON)  //que nos lea en formato JSON
                    .get("/users/2")           //endpoit
                    .then()                         //validamos
                    .statusCode(200)                //empezamos asercion, aqui le decimos que nos valide si el estado esta en 200
                    .body("data.email", equalTo("janet.weaver@reqres.in"));  //aqui ingresamos al JSON y le decimos que de los datos *data* me traiga el que tenga *email* @yopmail
        }


    }

