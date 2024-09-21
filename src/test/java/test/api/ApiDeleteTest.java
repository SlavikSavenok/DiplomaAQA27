package test.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiDeleteTest extends BaseApiTest {

    @Description("API DELETE тест на проверку удаления проекта")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API DELETE удаление проекта", description = "API DELETE удаление проекта")
    public void deleteProject() {
        Response deleteProject = projectService.deleteProject(52);
        deleteProject
                .then()
                .assertThat()
                .statusCode(200)
                .log().status();

        System.out.println("Статус код = " + deleteProject.getStatusCode());
    }
}
