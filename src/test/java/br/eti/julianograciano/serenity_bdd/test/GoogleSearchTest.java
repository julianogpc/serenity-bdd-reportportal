package br.eti.julianograciano.serenity_bdd.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * <p>Classe de Teste.</p>
 *
 * @author Juliano Graciano Pereira Costa
 * @version $Id: $Id
 * @since 1.0.0
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/google_search.feature", glue = {"classpath:br.eti.julianograciano.serenity_bdd.stepdefinitions", "classpath:br.eti.julianograciano.serenity_bdd.hooks"})
public class GoogleSearchTest {

}
