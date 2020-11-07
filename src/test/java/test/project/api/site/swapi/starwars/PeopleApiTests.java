package test.project.api.site.swapi.starwars;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


@Epic("Api testing")
@Feature("Put requests")
public class PeopleApiTests {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final String REQUEST_URL = "https://jsonplaceholder.typicode.com/posts/7";
    private final String KEY_ID = "id";
    private final String KEY_ID_VALUE = "3";

    private final String KEY_TITLE = "title";
    private final String KEY_TITLE_VALUE = "foo";

    private final String KEY_BODY = "body";
    private final String KEY_BODY_VALUE = "bar";

    private final String KEY_USER_ID = "userId";
    private final String KEY_USER_ID_VALUE = "1";

    private final int EXPECTED_KEY_ID_VALUE = 7;

    private Map<String, String> map = new HashMap<String, String>();

        /*
Test 1: Send a PUT request to https://jsonplaceholder.typicode.com/posts/7
with request body: {
    "id": 3,
    "title": "foo",
    "body": "bar",
    "userId": 1

check that the response body matches:
{
    "id": 7
}
  }*/

    @BeforeEach
    void putdata() {
        map.put(KEY_ID, KEY_ID_VALUE);
        map.put(KEY_TITLE, KEY_TITLE_VALUE);
        map.put(KEY_BODY, KEY_BODY_VALUE);
        map.put(KEY_USER_ID, KEY_USER_ID_VALUE);
        RestAssured.baseURI = BASE_URL;
    }

    @DisplayName("Checks that the response body matches: 'id': 7")
    @Test
    void testPUT() {
        given()
                .body(map)
                .when()
                .put(REQUEST_URL)
                .then()
                .body(KEY_ID, equalTo(EXPECTED_KEY_ID_VALUE));
    }

}
