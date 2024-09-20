package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import servises.ProjectService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected Project actualProject;
    protected ProjectService projectService;

    @BeforeTest
    public void setupApiClient() {
        RestAssured.baseURI = ReadProperties.getUri();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("X-Api-Key", "tny_7lWbJQPRdq4bqUkZzGRi8LT7xTtSHkiBOmuKCDTggqZqSXYy");

        projectService = new ProjectService();
    }
}
