package test.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;


public class ApiGetTests extends BaseApiTest {


    @Description("API GET Тест на проверку имеющихся проектов")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка имеющихся проектов", description = "API GET проверка имеющихся проектов")
    public void getAllProjects() {
        Response response = projectService.getProjects();

        System.out.println("Статус код = " + response.getStatusCode());
    }

    @Description("API GET проверка проекта по id")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка проекта по id", description = "API GET проверка проекта по id")
    public void getSingleProject() {
        Project project = projectService.getProject(2);

        Assert.assertEquals(project.getName(), "testrailaqa27@mail.ru");
    }

    @Description("API GET проверка несуществующего проекта")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API GET проверка несуществующего проекта", description = "API GET проверка несуществующего проекта")
    public void getInvalidProjectTest() {
        Response response = projectService.getInvalidProject(1000);
        response
                .then()
                .assertThat()
                .statusCode(404)
                .body("type", is("ApiError"))
                .body("code", is("API_DATA_NOT_FOUND"))
                .body("message", is("The entity with id 1000 was not found."));

        System.out.println("Статус код = " + response.getStatusCode());
    }
}
