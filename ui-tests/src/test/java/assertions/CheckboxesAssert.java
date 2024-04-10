package assertions;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.junit.Assert;
import pages.Checkboxes;


public class CheckboxesAssert extends AbstractAssert<CheckboxesAssert, Checkboxes> {

    public CheckboxesAssert(Checkboxes actual) {
        super(actual, CheckboxesAssert.class);
    }

    public static CheckboxesAssert assertThat(Checkboxes actual) {
        return new CheckboxesAssert(actual);
    }

    public Checkboxes page() {
        return actual;
    }

    @Step("checkboxes is selected")
    public CheckboxesAssert isSelected(String text, Boolean state) {
        actual.getCheckbox(text).isSelected();
        Assert.assertEquals(state, actual.getCheckbox(text).isSelected());
        return this;
    }
}
