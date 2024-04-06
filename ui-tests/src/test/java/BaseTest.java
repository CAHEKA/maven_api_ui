import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    private static final UIProps config = ConfigFactory.create(UIProps.class);

    @BeforeAll
    static public void setBaseConfig() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );

        Configuration.browser = "chrome";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        Configuration.browserCapabilities = chromeOptions;
        Configuration.fastSetValue = true;

        //Selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion(config.chromeVersion());
        System.out.println("chromeVersion: " + config.chromeVersion());
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = config.selenoidUrl();
        System.out.println("selenoidUrl: " + config.selenoidUrl());
    }
}
