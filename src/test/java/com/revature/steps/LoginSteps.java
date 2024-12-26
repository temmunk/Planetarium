package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginSteps {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        try {
            Alert alert = TestRunner.wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Unexpected alert during login: " + alert.getText());
            alert.accept();
        }
        catch (TimeoutException e) {
            TestRunner.loginPage.openLoginPage();
        }

    }

    @When("the user provides valid login username")
    public void the_user_provides_valid_login_username() {
        TestRunner.loginPage.enterUsername("Batman");
    }

    @When("the user provides a valid login password")
    public void the_user_provides_a_valid_login_password() {
        TestRunner.loginPage.enterPassword("Iamthenight1939");
    }

    @When("the user submits the login credentials")
    public void the_user_submits_the_login_credentials() {
        TestRunner.loginPage.clickLoginButton();
    }

    @Then("user should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() {

            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            Assert.assertEquals(
                    String.format(
                            "Expected 'Welcome to the Home Page Batman, but got %s",
                            TestRunner.homePage.getHomePageGreeting()
                    ),
                    "Welcome to the Home Page Batman",
                    TestRunner.homePage.getHomePageGreeting());
            Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());


    }

    @When("the user provides login username {string}")
    public void the_user_provides_login_username(String username) {
        TestRunner.loginPage.enterUsername(username);
    }

    @When("the user provides login password {string}")
    public void the_user_provides_login_password(String password) {
        TestRunner.loginPage.enterPassword(password);
    }

    @Then("the user should get a browser alert {string}")
    public void the_user_should_get_a_browser_alert(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }

    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }


}
