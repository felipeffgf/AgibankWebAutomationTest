package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePageLogic {

    private WebDriver driver;
    private String url = "https://blog.agibank.com.br/";

    private By searchIcon = By.xpath("//a[contains(@class,'astra-search-icon') and @role='button']\n");
    private By searchInput = By.xpath("//*[@id=\"search-field\"]");

    public homePageLogic(WebDriver driver) {
        this.driver = driver;
    }

    public void open() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
    }

    public void search(String termo) {
        driver.findElement(searchIcon).click();
        driver.findElement(searchInput).sendKeys(termo + "\n");
    }
}
