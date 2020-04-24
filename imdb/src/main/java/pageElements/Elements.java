package pageElements;

import org.openqa.selenium.By;

import supporting.WaitMethods;

public class Elements extends WaitMethods
{
	protected By Menu = By.id("imdbHeader-navDrawerOpen--desktop");
	protected By TopRatedShow = By.linkText("Top Rated Shows");
	protected By SearchElement = By.xpath("//*[@id=\"suggestion-search\"]");
	protected By Select_Episode = By.linkText("Game of Thrones: The Last Watch");
	protected By Title_Rate_Review = By.className("heroic-overview"); 
	
	protected By Signin = By.xpath("//*[text()='Sign In']");
	protected By Createnewbutton = By.xpath("//*[text()='Create a New Account']");
	protected  By CustName = By.id("ap_customer_name");
	protected By emailID = By.name("email");
	protected By pwd=By.id("ap_password");
	protected By repwd= By.id("ap_password_check");
	protected By login= By.cssSelector(".a-button-input");
	 
}
