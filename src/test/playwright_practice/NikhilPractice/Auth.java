package NikhilPractice;

import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import baseutility.startup;

public class Auth {

	public static Page page;
	public static Playwright playwright;

	public static startup s;
	
	public String application_TextMessage() {
		try {

			Locator txt = s.page.locator("//input[@id='firstname']|//input[@id='lasttname']|//input[@id='Phno']|//input[@id='Addl1']|//input[@id='Addl2']|//input[@id='state']|//input[@id='postalcode']|//input[@id='male']|//input[@id='female']|//input[@id='trans']|//input[@id='email']");

			for (Locator ele : txt.all()) {

				s.page.keyboard().press("ArrowDown");
				
				if (ele.isVisible() && ele.isEnabled()) {
                     String name = ele.getAttribute("id");
                     
					if(ele.getAttribute("id").equalsIgnoreCase("firstname"))
					{
						ele.fill("nikhil");
					}
					else if(ele.getAttribute("id").equalsIgnoreCase("lasttname"))
					{
						ele.fill("patil");
					}else if(ele.getAttribute("id").equalsIgnoreCase("Phno"))
					{
						ele.fill("7798260576");
					}
					else if(ele.getAttribute("id").equalsIgnoreCase("email"))
					{
						ele.fill("nik@gmail.com");
					}else if(ele.getAttribute("id").equalsIgnoreCase("state"))
					{
						ele.fill("maharastra");
					}else if(ele.getAttribute("id").equalsIgnoreCase("Addl1"))
					{
						ele.fill("maharastra");
					}else if(ele.getAttribute("id").equalsIgnoreCase("Addl2"))
					{
						ele.fill("maharastra");
					}
					else if(ele.getAttribute("id").equalsIgnoreCase("male"))
					{
						ele.click();
					}else if(ele.getAttribute("id").equalsIgnoreCase("female"))
					{
						ele.click();
					}else if(ele.getAttribute("id").equalsIgnoreCase("trans"))
					{
						ele.click();
					}
					
					
					
				}

			}

		} catch (Exception e) {

		}
		return null;
	}
	
	
	
	

	@Test
	public void verify_Loginpage_placeholders() {

		s = new startup();
		s.startBrowser("chrome","https://letcode.in/forms");
		String title = s.page.title();
		System.out.println(title);
		
		for(int i=0;i<1;i++)
		{
			s.page.keyboard().press("PageDown");
		}
		
		application_TextMessage();
		
		// enter the input 
		
		
		
		
	}

}
