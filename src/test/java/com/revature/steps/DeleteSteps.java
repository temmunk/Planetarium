package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DeleteSteps {

    @Given("the user is logged in to delete")
    public void the_user_is_logged_in_to_delete() {
        TestRunner.loginPage.setUpLoggedInUser();
    }

    @When("the user deletes planet or moon")
    public void the_user_deletes_planet_or_moon() {
        TestRunner.homePage.deleteCelestial("Luna");
    }

    @Then("the table refreshes and the user should see their planets and moons.")
    public void theTableRefreshesAndTheUserShouldSeeTheirPlanetsAndMoons() {
        List<WebElement> rows = TestRunner.driver.findElements(By.tagName("tr"));
        boolean found = false;

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().equals("Earth")) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        Assert.assertFalse(found);
    }


    @When("the user deletes planet or moon {string}")
    public void the_user_deletes_planet_or_moon_with_invalid_data(String name) {
        TestRunner.homePage.enterNameToDelete(name);
    }

    @Then("user should get a browser alert saying {string}")
    public void user_should_get_a_browser_alert_saying(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }


}
