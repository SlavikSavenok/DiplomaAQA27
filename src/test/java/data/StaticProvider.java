package data;

import org.testng.annotations.DataProvider;


public class StaticProvider {

    @DataProvider(name = "boundaryValues")
    public static Object[][] boundaryValue() {
        return new Object[][]{
                {new String(new char[39]).replace('\0', '1'), true},
                {new String(new char[40]).replace('\0', '1'), true},
                {new String(new char[41]).replace('\0', '1'), false},
        };
    }
}
