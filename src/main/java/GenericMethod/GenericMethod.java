package GenericMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;

public class GenericMethod {

	Page page;
	PlaywrightFactory bs = new PlaywrightFactory();

	public boolean checkVisiblityflag(Locator elements) {
		for (Locator element : elements.all()) {
			if (element.isVisible())
				return true;
		}
		return false;
	}

	// this is use for CheckError Message Application

	public String checkErrorMessage(Page page) {
		Locator msgele = page.locator(
				".//div[@role='dialog']//p | .//div[contains(@style,'color: red')] | .//span[text()='Required'] |.//span[text()='Should be at least 5 characters'] | .//span[text()='Passwords do not match']| .//span[text()='Invalid'] ");
		if (msgele != null && !msgele.textContent().isEmpty()
				&& (msgele.textContent().contains("Review") || msgele.textContent().contains("Duplicate")
						|| msgele.textContent().contains("error") || msgele.textContent().contains("mandatory")
						|| msgele.textContent().contains("Required")
						|| msgele.textContent().contains("Should be at least 5 characters")
						|| msgele.textContent().contains("Passwords do not match")
						|| msgele.textContent().contains("Invalid"))) {
			return msgele.textContent();
		}

		return null;
	}

	// end

	public String application_TextMessage(Page page, String textName) {
		try {

			Locator txt = page.locator("//h6[text()='" + textName.trim() + "'] ");

			for (Locator ele : txt.all()) {

				page.keyboard().press("ArrowDown");
				;
				if (ele.isVisible() && ele.isEnabled()) {

					page.keyboard().press("ArrowDown");
					page.keyboard().press("ArrowDown");
					return ele.textContent();

				}

			}

		} catch (Exception e) {

		}
		return null;
	}

	public String organization_Engineering_pericularfiled_sow(Page page, String textName) {
		try {
			Locator txt = page.locator("//div[text()='" + textName.trim() + "'] ");
			page.keyboard().press("ArrowDown");
			page.keyboard().press("ArrowDown");

			for (Locator ele : txt.all()) {

				page.keyboard().press("ArrowDown");

				if (ele.isVisible() && ele.isEnabled()) {

					page.keyboard().press("ArrowDown");
					return ele.textContent();

				}

			}

		} catch (Exception e) {

		}

		return null;

	}

	public void organization_Engineering_extende1(Page page) {
		try {
			Locator txt = page.locator(
					"//button[@class='oxd-icon-button' and @type='button' and @role='none']/i[@class='oxd-icon bi-chevron-down']");

			for (Locator ele : txt.all()) {

				if (ele.isVisible() && ele.isEnabled()) {
					try {

						bs.clickByJS();
						break;

					} catch (Exception e) {
						ele.click();
					}

				}

			}

		} catch (Exception e) {

			System.out.println("message not found");
		}

	}

	public void moveToUppersideOfScreen(Page page) {
		try {

			page.keyboard().press("ArrowUp");

		} catch (Exception e) {
		}
	}

	public void waitUntilLoadComplete(Page page) {
		try {

			Locator txt = page.locator("//div[@class=\"oxd-loading-spinner-container\"]/div");

			txt.page().wait(5000);

			Locator eles = page.locator("//div[@class=\"oxd-loading-spinner-container\"]/div");

			for (Locator ele : eles.all()) {

				if (ele.isEnabled() && ele.isVisible()) {

					System.out.println("loadder is present ");
				}

			}

		} catch (Exception e) {
			// log.error("No Loader are present");
		}

	}

	public static void takeScreenshot(Page page, String filePath) {
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath)));

		// call method like //takeScreenshot(page, "pageScreenshot.png");
	}

	public static void takeElementScreenshot(Page page, String filePath, String selector) {
		ElementHandle element = page.querySelector(selector);
		if (element != null) {
			element.screenshot(new ElementHandle.ScreenshotOptions().setPath(Paths.get(filePath)));
		} else {
			System.out.println("Element not found for selector: " + selector);
		}

		// call method like that //takeElementScreenshot(page, "elementScreenshot.png",
		// "#exampleElement");

	}

	public Locator CheckVisibleElements(Locator elements) {

		for (Locator ele : elements.all()) {
			if (ele.isVisible()) {
				return ele;
			}

		}
		return null;

	}

	public void VisibilityofElement(Locator element) {
		int i = 1000;

		for (int j = 1; j < 10; j++) {

			if (element.isVisible()) {

			} else {

				try {
					Thread.sleep(j * i);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}

		}

	}

	public boolean isAlertprasent(Page page) {
		boolean Alertvalue = false;

		try {

			page.onceDialog(alet -> {

				alet.defaultValue();
			});

		} catch (Exception e) {
			Alertvalue = true;
			return Alertvalue;

		}

		return Alertvalue;

	}

	// Success message
	public String successMessage() {
		String Expecxedmessage = "";

		try {

			Locator tostMgs = page.locator(
					"//div[@class='oxd-toast-content oxd-toast-content--success']/p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']");

			Expecxedmessage = tostMgs.textContent();

		} catch (Exception e) {

			System.out.println("message is not present ");

		}

		return Expecxedmessage;

	}

	// end

	// this is implemented for Textboxfiled = lebel , data
	public void inputField(Page page, String label, String data) {

		Locator tostMgs = page.locator("//label[text()='" + label.trim() + "'][1]/following::input[1]");

		for (Locator ele : tostMgs.all()) {

			try {

				ele.page().keyboard().press("Delete");

				;
				ele.fill(data);

			} catch (Exception e) {

			}

		}

	}

	// end

	public void TextAreasInput(Page page, String placeholdername, String data) {
		;

		Locator tostMgs = page.locator("textarea");

		for (Locator singele : tostMgs.all()) {
			String name = singele.getAttribute("placeholder");

			if (name.equalsIgnoreCase(placeholdername)) {
				singele.fill(data);
			} else {
				System.out.println("no data available ");
			}

		}

	}

	public void ButtonClick(Page page, String Btnname) {

		Locator elements = page.locator("//button[text()=' " + Btnname.trim() + " ']");

		for (Locator ele : elements.all()) {
			{
				if (ele.isVisible()) {
					try {
						ele.click();

					} catch (Exception e) {

					}

				}

			}
		}

	}

	public void WorkingMinutFromAction(Page page, String uniqueTxt, String AM) {
		try {

			Locator elements = page.locator(
					"//label[text()='" + uniqueTxt + "']/following::div[@class=\"oxd-time-wrapper\"][1]/div/input");

			for (Locator ele : elements.all()) {
				if (ele.isVisible() && ele.isEnabled()) {
					try {
						ele.click();
						break;
					} catch (Exception e) {

					}
				}

			}

			Locator ele = page.locator("//div[@class='oxd-time-hour-input']//input");

			;
			if (ele.isVisible() && ele.isEnabled()) {

				ele.page().keyboard().press("DELETE");
				ele.page().keyboard().press("Backspace");
				ele.page().keyboard().press("Backspace");
				ele.page().keyboard().press("DELETE");
				ele.fill("9");

			}

			Locator el = page.locator("//input[@value='" + AM + "']");

			String type = el.getAttribute("value");

			if (type.equalsIgnoreCase(AM)) {

				el.click();
			}

			page.locator("html").click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void WorkingHoursFromAction(Page page, String uniqueTxt, String AM) {
		try {

			Locator elements = page.locator(
					"//label[text()='" + uniqueTxt + "']/following::div[@class=\"oxd-time-wrapper\"][1]/div/input");

			for (Locator ele : elements.all()) {
				if (ele.isVisible() && ele.isEnabled()) {
					try {
						ele.click();
						break;
					} catch (Exception e) {

					}
				}

			}

			Locator ele = page.locator("//div[@class='oxd-time-hour-input']//input");

			;
			if (ele.isVisible() && ele.isEnabled()) {
				ele.page().keyboard().press("DELETE");
				ele.page().keyboard().press("Backspace");
				ele.page().keyboard().press("Backspace");
				ele.page().keyboard().press("DELETE");
				ele.fill("9");
			}

			Locator el = page.locator("//input[@value='AM']");

			String type = el.getAttribute("value");

			if (type.equalsIgnoreCase(AM)) {

				el.click();
			}
			page.locator("html").click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Unique txt according to Delete Row
	public void deleteActionIntable(Page page, String uniqueTxt) {
		try {
			Locator elements = page
					.locator("//div[text()='" + uniqueTxt + "']/following::div/button/i[@class='oxd-icon bi-trash']");

			for (Locator ele : elements.all()) {
				if (ele.isVisible() && ele.isEnabled()) {
					try {
						ele.click();
						break;
					} catch (Exception e) {
						bs.clickByJS();
					}
				}

			}

			Locator ele = page.locator("//button[@type='button' and text()=' Yes, Delete ']");
			ele.page().wait(5000);
			ele.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// end

	// Unique txt according to Edit Row
	public void EditActionIntable(Page page, String uniqueTxt) {
		try {

			Locator eles = page.locator(
					"//div[text()='" + uniqueTxt + "']/following::div/button[2]/i[@class='oxd-icon bi-pencil-fill']");

			for (Locator ele : eles.all()) {
				if (ele.isVisible() && ele.isEnabled()) {
					try {
						ele.click();
						break;
					} catch (Exception e) {
						bs.clickByJS();
					}
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
