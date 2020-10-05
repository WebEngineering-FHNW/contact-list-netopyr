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
}
