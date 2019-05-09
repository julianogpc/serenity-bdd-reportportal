package br.eti.julianograciano.serenity_bdd.steps;

import br.eti.julianograciano.serenity_bdd.pages.GooglePage;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Classe de Steps do Serenity BDD.</p>
 *
 * @author Juliano Graciano Pereira Costa
 * @version $Id: $Id
 * @since 1.0.0
 */
public class GoogleSearchSteps {

    private GooglePage googlePage;

    @Step("Open Google Page")
    public void openPage() {
        googlePage.openPage();
    }

    @Step("Fills the text '{0}' in search field")
    public void fillsSearchField(String text) {
        googlePage.fillsSearchField(text);
    }

    @Step("Click on 'Search' button")
    public void clickOnSearchGoogle() {
        googlePage.clickOnSearchGoogle();
    }

    @Step("Get title")
    public String getTitle() {
        return googlePage.getTitle();
    }

    @Step("Get Search Title List")
    public List<String> getSearchTitleList() {
        return googlePage.getSearchTitleList();
    }
}
