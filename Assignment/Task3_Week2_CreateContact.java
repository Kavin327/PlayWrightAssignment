package Assignment;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Task3_Week2_CreateContact {
	
	@Test
	public void createcontact() throws InterruptedException
	{
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screensize.height;
		int width = screensize.width;
		System.out.println("Height = " + height + "Width = " + width);
		page.setViewportSize(width, height);
		page.navigate("http://leaftaps.com/opentaps/control/login");
		page.type("#username", "demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.click(".decorativeSubmit");
		page.click("text=CRM/SFA");
		page.click("//a[text()='Contacts']");
		page.click("//a[text()='Create Contact']");
		Thread.sleep(5000);
		page.type("#firstNameField", "TestFirstName");
		page.type("#lastNameField", "TestLastName");
		page.type("#createContactForm_firstNameLocal", "TF");	
		page.type("#createContactForm_lastNameLocal", "TL");
		page.type("#createContactForm_departmentName", "Dep");
		page.type("#createContactForm_description", "Desc");
		page.type("#createContactForm_primaryEmail", "test@gmail.com");
		page.locator("#createContactForm_generalStateProvinceGeoId").selectOption("California");
		page.click(".smallSubmit");
		Thread.sleep(5555);
		page.click("//a[text()='Edit']");
		page.fill("#updateContactForm_description", "Updated Description Value");
		page.type("#updateContactForm_importantNote", "ImportantNotes");
		page.click(".smallSubmit");
		Thread.sleep(4444);
		String title = page.title();
		System.out.println("Resulting Page Title = " + title);
		Thread.sleep(9999);
		
		
		
		
		
	}
	
	
	

}
