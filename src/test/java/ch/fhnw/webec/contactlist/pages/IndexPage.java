package ch.fhnw.webec.contactlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
}
