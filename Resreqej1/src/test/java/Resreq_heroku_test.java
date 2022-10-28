import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

public class Resreq_heroku_test {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io";  //guardamos la url para no estar llamandola en cada metodo
        RestAssured.basePath = "/#";                     //y la basepath tambien se guarda
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());    // hacemos el .log().all()
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build(); //Configurado y compilado esto es para no repetir en contentType(ContentType.JSON)
    }


    @Test
    public void postheroku(){
        RestAssured
                .given()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2022-10-20T21:08:38.770Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .post("/store/placeOrder")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .asString();
    }


}



