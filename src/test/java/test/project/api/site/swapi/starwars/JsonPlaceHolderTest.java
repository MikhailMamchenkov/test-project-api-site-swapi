package test.project.api.site.swapi.starwars;

import config.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constans.Constans.Actions.JSON_PLACE_HOLDER_PUT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Epic("Api testing")
@Feature("Put requests")
public class JsonPlaceHolderTest extends TestConfig {

/*Test 1: Send a PUT request to https://jsonplaceholder.typicode.com/posts/7
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

    @DisplayName("Checks that the response body matches: 'id': 7")
    @Test
    public void putCheckValueBodyFromResponse() {
        String putBodyJson = "{\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "  }\n";
        given().body(putBodyJson).log().uri()
                .when().put(JSON_PLACE_HOLDER_PUT)
                .then()
                .body("id", equalTo(7))
                .log().body().statusCode(200);
    }
}
