package test.project.api.site.swapi.starwars;

import config.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constans.Constans.Actions.SWAPI_GET_PEOPLE;
import static constans.Constans.Path.SWAPI_PATH;
import static constans.Constans.Servers.SWAPI_URL;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@Epic("Api testing")
@Feature("Get requests")
public class SwapiTest extends TestConfig {


   /*
   Test 1: Send a GET request to https://swapi.dev/api/people/
    and check that the value of the count field is 82;
    */

    @DisplayName("Checks the value of the 'count' field")
    @Test
    public void getSomeFiledInResponseWithIndexAssertion() {
        given().log().uri()
                .when().baseUri(SWAPI_URL).get(SWAPI_PATH + SWAPI_GET_PEOPLE)
                .then()
                .body("count", equalTo(82))
                .log().body().statusCode(200);
    }


    /*
    Test 2: Send a GET request to https://swapi.dev/api/people/1 and check if
     that the home planet of the Luke Skywalker character is called Tatooine.
     */

    @DisplayName("Verifies that Luke Skywalker's home planet is called Tatooine.")
    @Test
    void getCheckValueBodyFromResponse() {
        String responseString = given().log().uri()
                .when().baseUri(SWAPI_URL).get(SWAPI_PATH + SWAPI_GET_PEOPLE + "1")
                .then()
                .extract()
                .path("homeworld");
        get(responseString).then().body("name", equalTo("Tatooine"))
         .log().body().statusCode(200);

    }
}
