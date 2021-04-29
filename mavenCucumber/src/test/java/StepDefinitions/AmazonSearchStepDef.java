package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSearchStepDef {
	WebDriver driver;
	
	@Given("^I want to search on Amazon$")
	public void i_want_to_search_on_Amazon() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}

	@When("^I search for \"([^\"]*)\" and price (\\d+)$")
	public void i_search_for_and_price(String searchtext, int price){
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchtext);
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@Then("^Shoes should get displayed$")
	public void shoes_should_get_displayed() throws InterruptedException{
		driver.findElement(By.linkText("Under $25")).click();
		Thread.sleep(2000);
		List<WebElement> prod_List = driver.findElements(By.xpath("sg-col-inner"));
		System.out.println(prod_List.size());
	}

}
