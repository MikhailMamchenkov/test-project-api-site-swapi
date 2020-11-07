package test.project.api.site.swapi.starwars;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

@Epic("Api testing")
@Feature("Get requests")
public class PlanetApiTests {

    private final String URL_FOR_CASE_ONE = "https://swapi.dev/api/people/";
    private final String KEY_COUNT = "count";
    private final int KEY_VALUE_COUNT = 82;

    private final String URL_FOR_CASE_TWO = "https://swapi.dev/api/people/1";
    private final String KEY_HOMEWORLD = "homeworld";
    private final String KEY_NAME = "name";
    private final String KEY_VALUE_TATOOINE = "Tatooine";


    /* Test 1: Send a GET request to https://swapi.dev/api/people/
    and check that the value of the count field is 82;*/

    @DisplayName("Checks the value of the 'count' field")
    @Test
    void getAPi() {
        get(URL_FOR_CASE_ONE).then().body(KEY_COUNT, equalTo(KEY_VALUE_COUNT));
    }


    /*Test 2: Send a GET request to https://swapi.dev/api/people/1 and check if
     that the home planet of the Luke Skywalker character is called Tatooine.*/

    @DisplayName("Verifies that Luke Skywalker's home planet is called Tatooine.")
    @Test
    void getAPi2() {
        String responseString = get(URL_FOR_CASE_TWO).then()
                .extract()
                .path(KEY_HOMEWORLD);
        get(responseString).then().body(KEY_NAME, equalTo(KEY_VALUE_TATOOINE));

    }
}
