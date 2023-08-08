package Assignment;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Task2_Week2_DeleteLead {

	private String LeadID;
	private String StatusMessage;

	@Test
	public void deletelead() throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		/*
		 * old login page page.navigate("http://leaftaps.com/crmsfa/control/logout");
		 * page.
		 * type("//div[text()='Opentaps CRMSFA Login']/following::input[@name='USERNAME']"
		 * , "demosalesmanager"); page.
		 * locator("//div[text()='Opentaps CRMSFA Login']/following::input[@name='PASSWORD']"
		 * ).type("crmsfa"); page.click(".loginButton"); Thread.sleep(1000);
		 * page.click("text=CRM/SFA");
		 */

		// new Login page
		page.navigate("http://leaftaps.com/opentaps/control/main");
		page.type("#username", "demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.click(".decorativeSubmit");
		page.click("text=CRM/SFA");

		page.click("a:has-text('Leads')");
		page.click("//a[text()='Create Lead']");
		
		  //Create Lead with Phonenumber page.click("//a[text()='Create Lead']");
		  page.fill("#createLeadForm_companyName", "Testleaf"); 
		  Locator cName = page.locator("#createLeadForm_companyName");
		  cName.clear(); cName.type("Testleaf");
		  cName.fill(""); cName.type("TestDeleteCompany");
		  
		  // Enter the First Name
		  page.type("[id=createLeadForm_firstName]","TestKANew"); // Enter the last
		  page.type("#createLeadForm_lastName","K"); //Click Create Lead button
		  page.locator("#createLeadForm_dataSourceId").selectOption("LEAD_DIRECTMAIL");
		  Thread.sleep(5000);
		  page.locator("#createLeadForm_industryEnumId").selectOption(
		  "IND_MANUFACTURING"); page.fill("#createLeadForm_primaryPhoneCountryCode",
		  "91"); page.type("#createLeadForm_primaryPhoneNumber", "1234599999");
		  page.click(".smallSubmit");
		 

		// Code for DeleteLead

		page.click("//a[text()='Find Leads']");
		page.click("//span[text()='Phone']");
		Thread.sleep(5000);
		page.fill("//input[@name='phoneCountryCode']", "91");
		page.type("//input[@name='phoneNumber']", "1234599999");
		page.click("//button[text()='Find Leads']");
		Thread.sleep(1000);
		LeadID = page.locator("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").innerText();
		System.out.println("Leadid = " + LeadID);
		page.click("//a[text()='" + LeadID + "']");
		Thread.sleep(5000);
		page.click("//a[text()='Delete']");
		page.click("//a[text()='Find Leads']");
		page.fill("//input[@name='id']", LeadID);
		page.click("//button[text()='Find Leads']");
		Thread.sleep(5000);
		StatusMessage = page.locator("//div[@class='x-paging-info']").innerText();
		System.out.println("StatusMessage = " + StatusMessage);

		// div[text()='No records to display']

	}

}
