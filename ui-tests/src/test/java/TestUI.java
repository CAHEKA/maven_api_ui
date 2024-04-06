import org.junit.jupiter.api.Test;
import pages.*;


public class TestUI extends BaseTest {

    @Test
    public void testCheckbox() {
        new Checkboxes()
                .selectCheckbox("checkbox 1")
                .selectCheckbox("checkbox 2");
    }

    @Test
    public void testDropdown() {
        new Dropdown()
                .selectDropdownByNum(1)
                .selectDropdownByNum(2);
    }

    @Test
    public void testDisappearingElements() {
        new DisappearingElements()
                .waitForNumberOfElementsAfterAttempts(5, 10);
    }

    @Test
    public void testInputs() {
        new Inputs().enterRandomNumber();
    }
    
}
