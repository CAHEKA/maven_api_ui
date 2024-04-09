package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class InputsAssert extends AbstractAssert<InputsAssert, Inputs> {

    public InputsAssert(Inputs actual) {
        super(actual, InputsAssert.class);
    }

    public static InputsAssert assertThat(Inputs actual) {
        return new InputsAssert(actual);
    }

    public Inputs page() {
        return actual;
    }
    
    @Step("Check valid number: {number}")
    public InputsAssert checkValidNumber(String number) {
        Assertions.assertEquals(number, actual.getNumber(),
                "Expected input value to match " + number + ", but found " + actual.getNumber());
        return this;
    }


}