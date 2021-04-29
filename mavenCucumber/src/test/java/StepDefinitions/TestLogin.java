package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLogin {
	
	WebDriver driver;
	
	@Given("User enter the url")
	public void user_enter_the_url(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}

	@Given("check the page title")
	public void checkthe_page_title() {
		
		String PageTitle=driver.getTitle();
		if(PageTitle.equals("My Store"))
			System.out.println("Page Title is correct");
		else
			System.out.println("Page Title is wrong");
		
	}

	@When("user clicks on the sign in button")
	public void user_clicks_on_the_sign_in_button() throws InterruptedException {
	    driver.findElement(By.linkText("Sign in")).click();
	    Thread.sleep(2000);
	    String LoginPageTitle=driver.getTitle();
	    Assert.assertEquals(LoginPageTitle,"Login - My Store");
	}

	@Then("user enters email address")
	public void user_enters_email_address() {
		WebElement txtemailid =  driver.findElement(By.id("email_create"));
		txtemailid.clear();
		txtemailid.sendKeys("test818824@gmail.com");
		
	}

	@And("user clicks on create an account button")
	public void user_clicks_on_create_account_button() {
		driver.findElement(By.id("SubmitCreate")).click();
	}

	@Then("user is on registration page")
	public void user_on_registration_page() throws InterruptedException
	{
		
		Thread.sleep(5000);
		WebElement chkele= driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3"));
		System.out.println(chkele.getText());
		if(chkele.getText().equalsIgnoreCase("Your personal information"))
		{
			System.out.println("We r on Registration Page");
		}
	}

}
