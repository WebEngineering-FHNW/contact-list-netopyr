package ch.fhnw.webec.contactlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndexPage {

    private static final String URL = "http://localhost:%d";

    public static IndexPage to(WebDriver driver, int port) {
        driver.get(String.format(URL, port));
        return PageFactory.initElements(driver, IndexPage.class);
    }

    private final WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "contact-details")
    private List<WebElement> contactDetails;

    @FindBy(id = "no-contact-message")
    private List<WebElement> noContactMessage;

    public List<WebElement> getContactDetails() {
        return contactDetails;
    }

    public List<WebElement> getNoContactMessage() {
        return noContactMessage;
    }
}
