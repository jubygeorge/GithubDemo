package com.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	WebDriver driver;
	@Given("User is within login page")
	public void user_is_within_login_page()   {
	   System.out.println("Step 1:User is on Login Page");
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("Step2:Enter username and password");
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.name("password")).sendKeys("admin123");
	    
	}

	@And("User  clicks on login button")
	public void user_clicks_on_login_button() {
		System.out.println("Step 3:User clicks on login button");
		//driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")). click();
	}

	@Then("User should land on home page")
	public void user_should_land_on_home_page() {
		System.out.println("Step 4:User lands on Home Page");
		driver.close();	}


}
