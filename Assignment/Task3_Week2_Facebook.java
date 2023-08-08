package Assignment;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Task3_Week2_Facebook {
	/*
	 * int hei =1080; int wid = 1920;
	 */	
	
	@Test
	public void testvalue() throws InterruptedException
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		//Maximize the Browser
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screensize.getHeight();
		int width = (int) screensize .getWidth();
		System.out.println("Height = " + height + "Width = " + width);
		page.setViewportSize(width, height);
		page.navigate("https://www.facebook.com/");
		page.click("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']");
		Thread.sleep(2000);
		page.type("//input[@name='firstname']","Test");
		page.type("//input[@name='lastname']","T");
		page.type("#password_step_input","Test@123");
		page.locator("#day").selectOption("27");
		page.locator("#month").selectOption("Jun");
		page.locator("#year").selectOption("1994");
		page.click("//span[@class='_5k_2 _5dba']/input[@value='1']");
		
		Thread.sleep(5000);
		
		
		
	}

}
