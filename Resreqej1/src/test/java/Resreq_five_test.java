import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Resreq_five_test {

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
    public void getAllUsertest() {
        Response response = RestAssured
                .given()
                .get("users?page=2");
        Headers headers = response.getHeaders();
        int statusCode = response.statusCode();
        String body = response.getBody().asString();
        String contentType = response.contentType();
        assertThat(statusCode, equalTo(HttpStatus.SC_OK));
        //se guardo y parametrizo todos los campos para poder realizar aserciones.


        System.out.println("********************************BODY******************* :" + body);   //le digo que me traiga el body
        System.out.println("*************************************************** ");
        System.out.println("********************************CONTENT_TYPE******************* :" + contentType);    //le digo que me traiga el ContentType
        System.out.println("*************************************************** ");
        System.out.println("********************************HEADERS******************* :" + headers.toString());  //que me traiga el hearders pero como lo trae uy general lo pasamos a string con .toString
        System.out.println("*************************************************** ");


        System.out.println("*************************************************** ");
        System.out.println("*************************************************** ");
        System.out.println(headers.get("Cache-Control"));  //=14400           // le decimos que de headers me traiga el cache
        System.out.println(headers.get("Transfer-Encoding"));     //=chunked  // le decimos que de headers me traiga encoding
        System.out.println("*************************************************** ");
        System.out.println("*************************************************** ");


        assertThat(headers.get("Transfer-Encoding"), equalTo("chunked")); //esto sale error porque el headers.get me traetoda la propiedad, entonces toca desestructurar para obtener el chunked

    }

}
