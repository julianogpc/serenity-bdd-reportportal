package br.eti.julianograciano.serenity_bdd.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * <p>Classe de Step Definitions do Cucumber.</p>
 *
 * @author Juliano Graciano Pereira Costa
 * @version $Id: $Id
 * @since 1.0.0
 */
public class GooglePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(css = "#tsf > div:nth-child(2) > div > div > center > input[name='btnK']")
    private WebElement searchButton;

    @FindAll({
            @FindBy(css = "a > h3")
    })
    private List<WebElement> searchListTitleElements;

    public GooglePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public void openPage() {
        open();
        driver.navigate().refresh();
    }

    public void fillsSearchField(String text) {
        wait.until(driver -> searchField.isDisplayed());
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.TAB);
    }

    public void clickOnSearchGoogle() {
        searchButton = wait.until(elementToBeClickable(searchButton));
        searchButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<String> getSearchTitleList() {
        ArrayList<String> searchListTitle = new ArrayList<>();

        searchListTitleElements = wait.until(visibilityOfAllElements(searchListTitleElements));

        searchListTitleElements.stream().forEach(e -> {
            searchListTitle.add(e.getText());
        });

        return searchListTitle;
    }
}
