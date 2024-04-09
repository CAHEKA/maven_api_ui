package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownAssert extends AbstractAssert<DropdownAssert, Dropdown> {

    public DropdownAssert(Dropdown actual) {
        super(actual, DropdownAssert.class);
    }

    public static DropdownAssert assertThat(Dropdown actual) {
        return new DropdownAssert(actual);
    }

    public Dropdown page() {
        return actual;
    }

    @Step("Dropdown check text")
    public DropdownAssert isSelected(String text) {
        Assert.assertEquals(text, actual.getText());
        return this;
    }

}
