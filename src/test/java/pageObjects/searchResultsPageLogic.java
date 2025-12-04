package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class searchResultsPageLogic {

    private WebDriver driver;

    private By results = By.cssSelector("article");

    public searchResultsPageLogic(WebDriver driver) {
        this.driver = driver;
    }

    public int getResultsCount() {
        List<WebElement> items = driver.findElements(results);
        return items.size();
    }
}
