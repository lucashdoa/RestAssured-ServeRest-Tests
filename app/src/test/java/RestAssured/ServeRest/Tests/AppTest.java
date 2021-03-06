/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package RestAssured.ServeRest.Tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


class AppTest {

    public static final String BASE_URL = "https://serverest.dev";

    // CT-1: Should return status code 200, message and token when email and password are correct
    @Test void loginSuccessful() {
        String requestBody = "{\n" +
                "  \"email\": \"fulano@qa.com\",\n" +
                "  \"password\": \"teste\" \n}";
        Response response = given()
                .body(requestBody)
                .and()
                .header("Content-type", "application/json")
                .when()
                .post(BASE_URL + "/login")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        response.then().body("$", hasKey("authorization"));
        Assertions.assertEquals("Login realizado com sucesso", response.jsonPath().getString("message"));

    }

    // CT-2: Should return status code 401 and message when email is incorrect
    @Test void incorrectEmailLogin() {
        String requestBody = "{\n" +
                "  \"email\": \"incorreto@qa.com\",\n" +
                "  \"password\": \"teste\" \n}";
        Response response = given()
                .body(requestBody)
                .and()
                .header("Content-type", "application/json")
                .when()
                .post(BASE_URL + "/login")
                .then()
                .extract().response();

        Assertions.assertEquals(401, response.statusCode());
        Assertions.assertEquals("Email e/ou senha inválidos", response.jsonPath().getString("message"));

    }

    // CT-3: Should return status code 401 and message when password is incorrect
    @Test void incorrectPasswordLogin() {
        String requestBody = "{\n" +
                "  \"email\": \"fulano@qa.com\",\n" +
                "  \"password\": \"wrong password\" \n}";
        Response response = given()
                .body(requestBody)
                .and()
                .header("Content-type", "application/json")
                .when()
                .post(BASE_URL + "/login")
                .then()
                .extract().response();

        Assertions.assertEquals(401, response.statusCode());
        Assertions.assertEquals("Email e/ou senha inválidos", response.jsonPath().getString("message"));

    }
}
