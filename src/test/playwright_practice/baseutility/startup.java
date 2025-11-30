package baseutility;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class startup {


    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;

    // ******************** BROWSER STARTUP ********************
    public Page startBrowser(String browserName, String url) {

        playwright = Playwright.create();

        if (browserName.equalsIgnoreCase("ch") || browserName.equalsIgnoreCase("chrome")) {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

        } else if (browserName.equalsIgnoreCase("ff") || browserName.equalsIgnoreCase("firefox")) {
            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );

        } else if (browserName.equalsIgnoreCase("ed") || browserName.equalsIgnoreCase("edge")) {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("msedge")
                            .setHeadless(false)
            );

        } else {
            System.out.println("Invalid browser name");
        }

        context = browser.newContext();
        page = context.newPage();
        page.navigate(url);

        return page;
    }
}
