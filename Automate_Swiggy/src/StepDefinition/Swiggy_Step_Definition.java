package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;

public class Swiggy_Step_Definition {

	WebElement element;
	static WebDriver driver;
	
	@Given("^Browser is open$")
	public void browser_is_open() {

		System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Given("^Swiggy WebSite is Open$")
	public void swiggy_website_is_open() {

		driver.get("https://www.swiggy.com");
		driver.manage().window().maximize();
	}

	@When("^User Enters (.+) click Search$")
	public void user_enters_click_search(String locations) throws InterruptedException {

		WebElement element = driver.findElement(By.id("location"));
		element.sendKeys(locations);
		element.clear();
		Thread.sleep(3000);
		driver.findElement(By.className("_2W-T9")).click();
		Thread.sleep(2000);

	}

	@And("^User is navigated to Search page$")
	public void user_is_navigated_to_search_page() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains (text(),'Search')]")).click();
		Thread.sleep(3000);

	}

	@When("^User search (.*) to order$")
	public void user_search_to_order(String items) throws InterruptedException {

		Thread.sleep(3000);
		
		element = driver.findElement(By.className("_2FkHZ"));
		element.click();
		Thread.sleep(2000);
		element.sendKeys(items);
		element.clear();
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/button[1]/div[2]/div[1]/b"));
		element.click();
		Thread.sleep(4000);
	}

	@And("^clicks on Add Item and item is added to cart$")
	public void clicks_on_add_item_and_item_is_added_to_cart() throws InterruptedException {

		WebElement el = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/div/div/div[4]/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div[1]"));

		el.click();

	}

	@Given("^User is on Cart Page$")
	public void user_is_on_cart_page() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/checkout']")).click();

	}

	@Then("^check item added is available in cart or not$")
	public void check_item_added_is_available_in_cart_or_not() throws InterruptedException {

		String ExpectedURL = driver.getCurrentUrl();
		if (ExpectedURL.equalsIgnoreCase("https://www.swiggy.com/checkout")) {
			System.out.println("Item added to the cart successfully");
		} else {
			System.out.println("Item added to the cart is unsuccessful");
		}

	}

}
