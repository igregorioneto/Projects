package br.com.erudio.integrations.swagger;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import br.com.erudio.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest {

    @Test
    public void shouldDisplaySwaggerUiPage() {
        String content =
                given()
                        .basePath("/swagger-ui/index.html")
                        .port(TestConfig.SERVER_PORT)
                        .when()
                            .get()
                        .then()
                            .statusCode(200)
                        .extract()
                            .body()
                                .asString();
        assertTrue(content.contains("Swagger UI"));
    }

}
