import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Resreq_four_test {

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
    public void deleteUser(){
        RestAssured
                .given()                    //dado que
                .delete("users/2")     //eviamos endpoint o url
                .then()                     //validamos
                .statusCode(HttpStatus.SC_NO_CONTENT); //que su estado sea 204
        //no colocamos ni la url completa, ni el contentType, ni el log.all porque ya lo tenemos estatico
    }

    @Test
    public void patchUsertest (){
       String name =  RestAssured             //capturamostodo en una variable para poder hacer la asercion
                .given()                      //dado que
                .when()                       //cuando
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")                  //le pasamos los parametros o request
                .patch("users/2")        //el endpoint de lo no va a responder
                .then()                       //validamos
                .statusCode(HttpStatus.SC_OK) //que su estado sea 200
                .extract()                    //entramos al JSON a rebuscar propiedades, para extraer
                .jsonPath().getString("job"); // esta es la manera de como yo voy a accerder esto
        assertThat(name, equalTo("morpheus")); //realizamos la asercion (assertthat libreria de hamcrest y equalsTo cpmparacion.)
    }
}
