package NikhilPractice;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ListWebelemts {
	
	
	
	static Page page;
	static Base_Utility bs;

	public static void days2() {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://playwright.dev/java/docs/next/api/class-keyboard");
		
		Locator s = page.locator("//li[@class=\"theme-doc-sidebar-item-link theme-doc-sidebar-item-link-level-3 menu__list-item\"]/a");
		
		for(Locator s1 : s.all())
			
		{

			String name = s1.textContent();
			System.out.println(name);
			
		}
			
		
		
		
	}
	

	public static void main(String[] args) {
		
		ListWebelemts s =new ListWebelemts();
		s.days2();

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));

		Page page = context.newPage();

		page.navigate("https://qa-practice.netlify.app/dropdowns");

		Locator dropdownclick = page.locator("//Select[@id='dropdown-menu']");
		dropdownclick.click();

		Locator droptxt = page.locator("//Select[@id='dropdown-menu']/option");
		System.out.println(droptxt.count());

		for (Locator ele : droptxt.all()) {

			System.out.println(ele.getAttribute("value"));

		}
		
	
		context.close();
		browser.close();
		playwright.close();

	}

}
