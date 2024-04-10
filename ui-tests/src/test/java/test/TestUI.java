package test;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.*;


public class TestUI extends BaseTest {

    @Test
    public void testCheckbox() {
        new Checkboxes()
                .clickCheckbox("checkbox 1")
                .check()
                .isSelected("checkbox 1", true)
                .page()
                .clickCheckbox("checkbox 2")
                .check()
                .isSelected("checkbox 2", false);
    }

    @Test
    public void testDropdown() {
        new Dropdown()
                .selectDropdownByNum(1)
                .check()
                .isSelected("Option 1")
                .page()
                .selectDropdownByNum(2)
                .check()
                .isSelected("Option 2");
    }

    @Tag("regression")
    @RepeatedTest(value = 10, name = "Disappearing elements: {currentRepetition} out of {totalRepetitions}")
    public void testDisappearingElements() {
        new DisappearingElements()
                .check()
                .checkNumberOfElements(5);
    }

    @Tag("smoke")
    @ParameterizedTest(name = "Line number {0} has the value: {1}")
    @CsvSource({
            "'-99', '-99'",
            "'-1', '-1'",
            "'0', '0'",
            "'1', '1'",
            "'9e+18', '9e+18'",
            "'abc', ''",
            "'!@#', ''",
            "' 123', '123'",
            "'456 ', '456'",
            "'1q', '1'"
    })
    public void testInputs(String input, String expect) {
        new Inputs()
                .enterInput(input)
                .check()
                .checkValidNumber(expect);
    }

}
