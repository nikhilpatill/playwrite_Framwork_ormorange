package NikhilPractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class day2 {

	static Page page;
	static Base_Utility bs;
	
	
	
	public static void days3()
	{
		

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://playwright.dev/java/docs/api/class-keyboard");

		
	
		
		ScrollToElement(page);
		
		
		
	}
	
	
	
	
	
	
	
	public static void ScrollToElement(Page page) {

		
		for(int i=0;i<10;i++)
		{
			page.keyboard().press("ArrowDown");
		}
	   

	}
	
	
	public static void VisibilityofElement(Locator element) {
		int i = 1000;

		for (int j = 1; j < 10; j++) {

			if (element.isVisible()&& element.isEnabled() ) {

			} else {

				try {
					Thread.sleep(j * i);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}

		}

	}


	public static void days2() {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://qa-practice.netlify.app/checkboxes");

		Locator Check = page.locator("//input[@id='checkbox1']");
		Locator Check1 = page.locator("//input[@id='checkbox2']");
		Locator Check2 = page.locator("//input[@id='checkbox3']");

		// Check.check();
		Check.click();
		Check1.click();
	
		
		Check2.click();
	

		page.close();

	}

	public static void main(String[] args) {

		days2();

	}

}
