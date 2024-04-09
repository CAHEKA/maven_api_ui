package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElementsAssert extends AbstractAssert<DisappearingElementsAssert, DisappearingElements> {

    public DisappearingElementsAssert(DisappearingElements actual) {
        super(actual, DisappearingElementsAssert.class);
    }

    public static DisappearingElementsAssert assertThat(DisappearingElements actual) {
        return new DisappearingElementsAssert(actual);
    }

    public DisappearingElements page() {
        return actual;
    }

    @Step("Check number of elements: {numberElements}")
    public void checkNumberOfElements(int numberElements) {
        Assertions.assertEquals(numberElements, actual.getNumberOfElements());
    }
    
}
