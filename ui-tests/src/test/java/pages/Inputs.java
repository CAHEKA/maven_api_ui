package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Inputs {

    private final SelenideElement inputField = $x("//div[@class='example']/input");

    public Inputs() {
        Selenide.open("https://the-internet.herokuapp.com/inputs");
        inputField.should(visible, Duration.ofSeconds(30));
    }

    public InputsAssert check(){
        return InputsAssert.assertThat(this);
    }
    
    @Step("Enter input: {number}")
    public Inputs enterInput(String number) {
        inputField.clear();
        inputField.sendKeys(number);
        return this;
    }
    
    public String getNumber() {
        return inputField.getValue();

    }


}