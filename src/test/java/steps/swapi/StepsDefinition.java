package steps.swapi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static constans.Constans.Actions.SWAPI_GET_PEOPLE;
import static constans.Constans.Path.SWAPI_PATH;
import static constans.Constans.Servers.SWAPI_URL;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class StepsDefinition {

    private String path;
    private Response response;


    @Given("endpoint")
    public void endpoint() {
        RestAssured.baseURI = SWAPI_URL;
        path = SWAPI_PATH;
    }

    @When("I sent a request")
    public void sentRequest() {
        response = given().log().uri()
                .when().baseUri(SWAPI_URL).get(SWAPI_PATH + SWAPI_GET_PEOPLE);
    }

    @And("I get a response")
    public void getResponce() {
        response.then().log().body().extract();
    }


    @Then("response status code should be {int}")
    public void checkResponseStatusCode(int code) {
        Assertions.assertEquals(code, response.getStatusCode());
    }

    @And("Checks the value of the 'count' field")
    public void verifyResponse() {
        int count = response.jsonPath().get("count");
        Assertions.assertEquals(82, count);
    }


    private String keyHomeWorld;
    private String keyName;


    @When("I get value from key homeworld from first request")
    public void getValueFromFirstRequest() {
        keyHomeWorld = given().log().uri()
                .when().baseUri(SWAPI_URL).get(SWAPI_PATH + SWAPI_GET_PEOPLE + "1")
                .then()
                .extract()
                .path("homeworld");
    }

    @And("I get value from key name from second request")
    public void checkKeyNameFromResponse() {
        keyName = get(keyHomeWorld).then().extract().path("name");
    }

    @Then("Assert what value equals Tatooine")
    public void checkNameKeyFromResponse() {
        Assertions.assertEquals(keyName, "Tatooine");
    }
}

/*    @Then("Assert what value equals Tatooine")
    public void checkResponseStatusCode() {
        get(keyHomeWorld).then().body("name ", equalTo("Tatooine"));
    }
        @And("response status code should be {int}")
        public void checkResponseStatusCode(int code) {
            Assertions.assertEquals(code, response.getStatusCode());
        }
}
    */