package elements;

import groovy.xml.StreamingDOMBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDown {
    private UIElement actionElement;
    private UIElement parentElementList;
    private List<UIElement> elementList;

    public DropDown(WebDriver driver, By by, By byTestCase ) {
        this.actionElement = new UIElement(driver, by);
        actionElement.click();
        this.parentElementList = new UIElement(driver, byTestCase);
        ////ul[@data-testid='list-list-box']
        elementList = new ArrayList<>();
        for (WebElement element : parentElementList.findUIElements(By.tagName("li"))) {
            UIElement uiElement = new UIElement(driver, element);
            elementList.add(uiElement);
        }

    }
    public void selectByIndex(int index) {
        if (index >= 0 && index < elementList.size()) {
                elementList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Индекс больше размера коллекции");
        }
    }

    public void selectByText(String text) {
        for (UIElement uiElement : elementList) {
            if (uiElement.getText().equals(text)) {
                uiElement.click();
                return;
            }
        }
        throw new IllegalArgumentException("Элемента с таким текстом не существует");
    }
}
