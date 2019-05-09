package br.eti.julianograciano.serenity_bdd.stepdefinitions;

import br.eti.julianograciano.serenity_bdd.steps.GoogleSearchSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * <p>Classe de Step Definitions do Cucumber.</p>
 *
 * @author Juliano Graciano Pereira Costa
 * @version $Id: $Id
 * @since 1.0.0
 */
public class GoogleSearchStepDefinitions {

    @Steps
    GoogleSearchSteps googleSearchSteps;

    @Given("^that I have gone to the Google page$")
    public void thatIHaveGoneToTheGooglePage() {
        googleSearchSteps.openPage();
    }

    @When("^I add \"([^\"]*)\" to the search box$")
    public void iAddToTheSearchBox(String text) {
        googleSearchSteps.fillsSearchField(text);
    }

    @When("^submit the search$")
    public void submitTheSearch() {
        googleSearchSteps.clickOnSearchGoogle();
    }

    @Then("^\"([^\"]*)\" should be mentioned in the results$")
    public void shouldBeMentionedInTheResults(String cats) {
        //assertThat(googleSearchSteps.getSearchTitleList(), contains(cats));

        List<String> list = googleSearchSteps.getSearchTitleList();
        list.replaceAll(String::toUpperCase);
        assertThat(list, hasItem(containsString(cats.toUpperCase())));
    }

}
