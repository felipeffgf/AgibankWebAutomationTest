package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import pageObjects.homePageLogic;
import pageObjects.searchResultsPageLogic;
import utils.utilsWeb;
import static org.junit.jupiter.api.Assertions.*;

public class SearchSteps {

    WebDriver driver = utilsWeb.getDriver();
    homePageLogic homePage = new homePageLogic(driver);
    searchResultsPageLogic resultsPage = new searchResultsPageLogic(driver);

    @Dado("que o usuário está na homepage")
    public void usuario_esta_na_homepage() throws InterruptedException {
        homePage.open();
    }

    @Quando("o usuário busca por {string}")
    public void usuario_busca_por(String termo) {
        homePage.search(termo);
    }

    @Então("os resultados da busca devem ser exibidos")
    public void resultados_devem_ser_exibidos() {
        assertTrue(resultsPage.getResultsCount() > 0);
    }

    @Então("nenhum resultado deve ser exibido")
    public void nenhum_resultado() {
        assertEquals(0, resultsPage.getResultsCount());
    }
}
