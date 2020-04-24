package IMDB.imdb;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageElements.Elements;

public class QuestionsAnswers extends Elements
{
  @BeforeSuite
  public void loaddrive() throws Exception
  {
	  launchPortal();
  }
  
  @Test (priority=1, description="TopRatedShows", enabled=true)
  public void DrivetoTopRatedShows() throws Exception 
  {	  
	  implicit_wait();	
	  Thread.sleep(3000);
	  dr.findElement(Menu).click();
	  dr.findElement(TopRatedShow).click();
  }
  
  @Test (priority=2, description="Game_of_Thrones_search", enabled=true)
  public void GameofThronessearch() throws Exception 
  {
	  implicit_wait();
	 
	  String Search_word=loadFile().getProperty("SEARCH_KEYWORD");
	  	  
	  Actions act = new Actions(dr);
	  act.moveToElement(dr.findElement(SearchElement)).click().sendKeys(Search_word).sendKeys(Keys.ENTER).build().perform();
	  dr.findElement(Select_Episode).click();
  }
  
  @Test (priority=3, description="Assertions", enabled=true)
  public void assertions() throws Exception 
  {
	  implicit_wait();
	  String Original_Title = loadFile().getProperty("EPIOSDE_TITLE");
	  String Original_Rating = loadFile().getProperty("RATING");
	  String Original_Reviews= loadFile().getProperty("REVIEW");
	  
	  String TRR = dr.findElement(Title_Rate_Review).getText();
	  
	  if(TRR.contains(Original_Title))
	  {
		  System.out.println("Title matched successfully");
	  }
	  else
	  {
		  System.out.println("Title did not matched successfully");
	  }
	  
	  try 
	  {
		Assert.assertEquals(TRR.trim().contains(Original_Rating), true);
		Assert.assertEquals(TRR.trim().contains(Original_Reviews), true);
		System.out.println("All Assert Success");
	  } 
	  catch (Exception e) 
	  {
		System.out.println("Rating or Review did not matched, please find the error: "+e.toString());
	  } 
  }

  @Test (priority=4, description="Create New Account and Login", enabled=true)
  public void Create_login_account() throws Exception 
  {
	  implicit_wait();
	  
	  HSSFWorkbook Login_WB = Exceel();
	  HSSFSheet Login_Sheet = Login_WB.getSheet("Details");
	  
	  for (int i=1; i<=1; i++)
	  {
		  String Name= Login_Sheet.getRow(i).getCell(0).getStringCellValue();
		  String emailid= Login_Sheet.getRow(i).getCell(1).getStringCellValue();
		  String password= Login_Sheet.getRow(i).getCell(2).getStringCellValue();
		  String rpassword= Login_Sheet.getRow(i).getCell(3).getStringCellValue();
		  
		  dr.findElement(Signin).click();
		  dr.findElement(Createnewbutton).click();
		  dr.findElement(CustName).sendKeys(Name);
		  dr.findElement(emailID).sendKeys(emailid);
		  dr.findElement(pwd).sendKeys(password);
		  dr.findElement(repwd).sendKeys(rpassword);
		  dr.findElement(login).click();
		  
		  By logged_in_user_check = By.xpath("//*[text()='"+Name+"']");
		  
		  String user_check = dr.findElement(logged_in_user_check).getText();
		  
		  if (user_check.equals(Name))
		  {
			  System.out.println("Created user logged in successfully");
		  }
		  else
		  {
			  System.out.println("Created user logged did not logged-in - Failed");
		  }  
	  }	  
  }
}