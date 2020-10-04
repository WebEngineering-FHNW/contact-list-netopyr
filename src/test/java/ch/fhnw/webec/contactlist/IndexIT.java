package ch.fhnw.webec.contactlist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexIT {

    @LocalServerPort
    private int port;

    private final WebDriver driver = new HtmlUnitDriver();

}
