package Assignment;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Task1_Week2_EditLead {
	
	private String FirstNameText;
	private String CompanyNameText;

	@Test
	public void editlead() throws InterruptedException
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		/*
		 * new page.navigate("http://leaftaps.com/crmsfa/control/logout"); page.
		 * type("//div[text()='Opentaps CRMSFA Login']/following::input[@name='USERNAME']"
		 * , "demosalesmanager"); page.
		 * locator("//div[text()='Opentaps CRMSFA Login']/following::input[@name='PASSWORD']"
		 * ).type("crmsfa"); page.click(".loginButton"); Thread.sleep(1000);
		 * page.click("text=CRM/SFA");
		 */
		
		//new Login page
		page.navigate("http://leaftaps.com/opentaps/control/main");
		page.type("#username", "demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.click(".decorativeSubmit");
		page.click("text=CRM/SFA");
	
		page.click("a:has-text('Leads')");
		
		// Code for Create Lead
		/*
		 * page.click("//a[text()='Create Lead']");
		 * page.fill("#createLeadForm_companyName", "Testleaf"); Locator cName =
		 * page.locator("#createLeadForm_companyName");
		 * 
		 * cName.clear(); cName.type("Testleaf");
		 * 
		 * cName.fill(""); cName.type("TestCompany");
		 * 
		 * // Enter the First Name page.type("[id=createLeadForm_firstName]","TestKA");
		 * // Enter the last name page.type("#createLeadForm_lastName","K"); //Click
		 * Create Lead button
		 * page.locator("#createLeadForm_dataSourceId").selectOption("LEAD_DIRECTMAIL");
		 * Thread.sleep(5000);
		 * page.locator("#createLeadForm_industryEnumId").selectOption(
		 * "IND_MANUFACTURING"); // Thread.sleep(2000); page.click(".smallSubmit");
		 */
		
		
		// Code for Edit Lead
		  page.click("//a[text()='Find Leads']");
		  page.type("#ext-gen248", "TestKA");
		  page.click("//button[text()='Find Leads']");
		  Thread.sleep(1000);
		  page.click("//a[text()='TestKA']");
		  page.click("//a[text()='Edit']");
		  page.fill("#updateLeadForm_companyName", "NewTestCompany");
		  page.fill("[id=updateLeadForm_firstName]", "NewTestKA");
		  page.click(".smallSubmit");
		  Thread.sleep(10000);
		  CompanyNameText = page.locator("#viewLead_companyName_sp").innerText();
		  System.out.println("Updated Company Name = " + CompanyNameText);
		  FirstNameText = page.locator("#viewLead_firstName_sp").innerText();
		  System.out.println("Updated First Name = " + FirstNameText);
		  
		
		
		
		
		
		
	}

}
