package ch.fhnw.webec.contactlist;

import ch.fhnw.webec.contactlist.pages.IndexPage;
import ch.qos.logback.core.joran.event.InPlayListener;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexIT {

    @LocalServerPort
    private int port;

    private final WebDriver driver = new HtmlUnitDriver();

    @Test
    void initialPageShouldNotShowPersonDetails() {
        // when
        final IndexPage page = IndexPage.to(driver, port);

        // then
        assertThat(page.getContactDetails()).isEmpty();
        assertThat(page.getNoContactMessage()).isNotEmpty();
    }

    @Test
    void clickingContactShouldShowContactDetails() {
        // given
        final IndexPage page = IndexPage.to(driver, port);

        // when
        page.getContactLinks().get(5).click();

        // then
        assertThat(page.getContactDetails()).isNotEmpty();
        assertThat(page.getNoContactMessage()).isEmpty();
    }

    @Test
    void clickingContactShouldShowCorrectContactDetails() {
        // given
        final IndexPage page = IndexPage.to(driver, port);

        // when
        page.getContactLinks().get(3).click();

        // then
        assertThat(page.getSelectedFirstName()).hasValue("Bax");
        assertThat(page.getSelectedLastame()).hasValue("McGrath");
        assertThat(page.getSelectedEmails()).hasValueSatisfying(emails -> {
            assertThat(emails).contains("dpocock0@google.es");
            assertThat(emails).contains("hdafforne1@slashdot.org");
        });
        assertThat(page.getSelectedPhones()).isEmpty();
        assertThat(page.getSelectedJobTitle()).hasValue("Associate Professor");
        assertThat(page.getSelectedCompany()).hasValue("Skiba");
    }

    @Test
    void clickingTwoContactsShouldShowCorrectContactDetails() {
        // given
        final IndexPage page = IndexPage.to(driver, port);
        page.getContactLinks().get(3).click();

        // when
        page.getContactLinks().get(11).click();

        // then
        assertThat(page.getSelectedFirstName()).hasValue("Marian");
        assertThat(page.getSelectedLastame()).hasValue("Blacket");
        assertThat(page.getSelectedEmails()).hasValueSatisfying(emails -> {
            assertThat(emails).contains("bgosker0@hugedomains.com");
        });
        assertThat(page.getSelectedPhones()).hasValueSatisfying(phones -> {
            assertThat(phones).contains("902-492-6396");
            assertThat(phones).contains("941-543-5141");
        });
        assertThat(page.getSelectedJobTitle()).hasValue("Editor");
        assertThat(page.getSelectedCompany()).hasValue("Quamba");
    }
}
