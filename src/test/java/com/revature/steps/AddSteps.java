package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddSteps {
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        TestRunner.loginPage.setUpLoggedInUser();
    }



    @When("the user inputs valid planet name")
    public void the_user_inputs_valid_planet_name() {
        TestRunner.homePage.selectPlanetInput();
        TestRunner.homePage.enterPlanetName("Earth-1");
    }

    @Then("the table refreshes and the user should see their added planet")
    public void theTableRefreshesAndTheUserShouldSeeTheirAddedPlanet() {

        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Earth-1']")));

        List<WebElement> rows = TestRunner.driver.findElements(By.tagName("tr"));
        boolean found = false;

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals("Earth-1")) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        Assert.assertTrue(found);
    }

    @When("the user inputs valid moon name and planet id")
    public void theUserInputsValidMoonNameAndPlanetId() {
        TestRunner.homePage.selectMoonInput();
        TestRunner.homePage.enterMoonName("Moon-1", "1");
    }

    @Then("the table refreshes and the user should see their added moon")
    public void theTableRefreshesAndTheUserShouldSeeTheirAddedMoon() {

        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Moon-1']")));

        List<WebElement> rows = TestRunner.driver.findElements(By.tagName("tr"));
        boolean found = false;

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals("Moon-1")) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        Assert.assertTrue(found);

    }

    @When("the user inputs invalid moon name {string} or planetid {string}")
    public void theUserInputsInvalidMoonNameOrPlanetid(String moonName, String planetId) {
        TestRunner.homePage.selectMoonInput();
        TestRunner.homePage.enterMoonName(moonName,planetId);
    }

    @Then("the user should receive an alert {string}")
    public void theUserShouldReceiveAnAlert(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }

    @When("the user inputs invalid planet name {string}")
    public void theUserInputsInvalidPlanetName(String planetName) {
        TestRunner.homePage.selectPlanetInput();
        TestRunner.homePage.enterPlanetName(planetName);
    }

    @Then("user should receive an alert {string}")
    public void UserShouldReceiveAnAlert(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }
}
