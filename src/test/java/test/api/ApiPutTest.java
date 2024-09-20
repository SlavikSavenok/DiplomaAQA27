package test.api;

import baseEntities.BaseApiTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiPutTest extends BaseApiTest {

    @Test
    public void updateProject() {
        Project updateProject = new Project();
        updateProject.setName("update name");
        updateProject.setProjectKey("UPD");
        updateProject.setDescription("update description");

        Project actualProject = projectService.updateProject(updateProject, 31);
        Assert.assertEquals(actualProject, updateProject);
    }
}
