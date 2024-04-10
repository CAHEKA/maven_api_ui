package assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.junit.Assert;
import pages.Dropdown;

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
