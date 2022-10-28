import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import models.conduit.Data_Conduit;
import models.conduit.User_conduit;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static models.conduit.ConduitBuilder.cUser;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class Resreq_conduit_test {

    public String token;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://api.realworld.io";  //guardamos la url para no estar llamandola en cada metodo
        RestAssured.basePath = "/api";                     //y la basepath tambien se guarda
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());    // hacemos el .log().all()
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build(); //Configurado y compilado esto es para no repetir en contentType(ContentType.JSON)
    }



    //JSON ANINADOS
    //**************************************************************************************************
    @Test
    public void loginconduit() throws JsonProcessingException {

        Data_Conduit data_conduit = new Data_Conduit();   //JSON MAYOR, es decir tenemos el user
        User_conduit user_conduit = new User_conduit();   //JSON HIJO: tenemos las credenciales
        user_conduit.setEmail("maob13@yopmail.com");
        user_conduit.setPassword("1234");
        data_conduit.setUser(user_conduit); //JSON aninado, json dentro de otro json
        ObjectMapper objectMapper2 = new ObjectMapper();  //visualizame esto ern json
        System.out.println(objectMapper2.writeValueAsString(data_conduit));
        RestAssured
                .given()
                .body(data_conduit)
                .post("/users/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("user.token", notNullValue());

    }

    //*******************************************************************************************************************

    @Test
    public void loginconduit1() {
        token = RestAssured
                .given()
                .body("{\n" +
                        "  \"user\": {\n" +
                        "    \"email\": \"jarv078@gmail.com\",\n" +
                        "    \"password\": \"123qwe\"\n" +
                        "  }\n" +
                        "} ")
                .post("/users/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response().jsonPath().getString("user.token");
        System.out.println(token);
    }


    @Test
    public void getArticleuser1() {

        RestAssured
                .given()
                .when()
                .header("Autorizacion", "Bearer" + token)
                .get("/articles?limit=10&offset=0")
                .then()
                .extract()
                .asString();
    }


    @Test
    public void getAricleuser() {
        Response response = RestAssured
                .given()
                .get("/articles?limit=10&offset=0");
        Headers headers = response.getHeaders();
        int statusCode = response.statusCode();
        String body = response.getBody().asString();
        String contentType = response.contentType();
        assertThat(statusCode, Matchers.equalTo(HttpStatus.SC_OK));

        System.out.println("********************************BODY******************* :" + body);
        System.out.println("*************************************************** ");
        System.out.println("********************************CONTENT_TYPE******************* :" + contentType);
        System.out.println("*************************************************** ");
        System.out.println("********************************HEADERS******************* :" + headers.toString());
        System.out.println("*************************************************** ");


        System.out.println("*************************************************** ");
        System.out.println("*************************************************** ");
        System.out.println(headers.get("Connection"));  //=keep-alive
        System.out.println(headers.get("Access-Control-Allow-Origin"));  //=*
        System.out.println("*************************************************** ");
        System.out.println("*************************************************** ");

        //  assertThat(headers.get("Connection"), Matchers.equalTo("keep-alive"));
    }
}

