package com.revature.pom;

import com.revature.TestRunner;
import com.revature.steps.HomepageSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;


    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(xpath = "//*[@id=\"inputContainer\"]/button")
    private WebElement submitButton;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;



    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }

    public void deleteCelestial(String celestialName){
        deleteInput.sendKeys(celestialName);
        deleteButton.click();

    }

//    public Boolean checkDeleted(){
//        List<WebElement> deletedElements = driver.findElements(By.xpath("//table/tbody/tr[text()='Earth'"));
//        if (deletedElements.isEmpty()){
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void enterNameToDelete(String celestialBody){
        deleteInput.sendKeys(celestialBody);
        deleteButton.click();
    }


    public void selectMoonInput(){
        WebElement dropdownElement = TestRunner.driver.findElement(By.xpath("//*[@id=\"locationSelect\"]"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("moon");
    }

    public void selectPlanetInput(){
        WebElement dropdownElement = TestRunner.driver.findElement(By.xpath("//*[@id=\"locationSelect\"]"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("planet");
    }

    public void enterPlanetName(String planetName){
        planetNameInput.sendKeys(planetName);
        submitButton.click();
    }

    public void enterMoonName(String moonName, String id){
        moonNameInput.sendKeys(moonName);
        orbitedPlanetInput.sendKeys(id);
        submitButton.click();
    }

}
