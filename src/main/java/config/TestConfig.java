package config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

import static constans.Constans.RunVeriable.path;
import static constans.Constans.RunVeriable.server;

public class TestConfig {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}
