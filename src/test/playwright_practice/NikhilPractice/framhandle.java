package NikhilPractice;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class framhandle {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Page page = browserType.launch(new LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://qa-practice.netlify.app/iframe");
		
	

		FrameLocator s2 = page.frameLocator("iframe");

		String name = s2.locator("//p[text()='Lorem ipsum dolor sit amet.']").textContent();

		System.out.println(name);

		playwright.close();

	}

}
