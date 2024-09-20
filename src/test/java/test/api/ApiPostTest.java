package test.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiPostTest extends BaseApiTest {

    @Description("API Post Тест на проверку создания проекта")
    @Severity(SeverityLevel.NORMAL)
    @Test(testName = "API Post проверка создания проекта", description = "API Post проверка создания проекта")
    public void addProject(){
        Project expectedProject = new Project();
        expectedProject.setName("Api_project");
        expectedProject.setProjectKey("KEY");
        expectedProject.setDescription("Api_description");

        actualProject = projectService.addProject(expectedProject);
        Assert.assertEquals(actualProject, expectedProject);
    }
}
