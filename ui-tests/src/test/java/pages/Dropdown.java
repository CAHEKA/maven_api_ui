package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {

    private final SelenideElement dropdown = $x("//select[@id='dropdown']");

    public Dropdown() {
        Selenide.open("https://the-internet.herokuapp.com/dropdown");
        dropdown.should(visible, Duration.ofSeconds(30));
    }

    public DropdownAssert check(){
        return DropdownAssert.assertThat(this);
    }

    public Dropdown selectDropdownByNum(Integer num) {
        dropdown.selectOptionByValue(String.valueOf(num));
        return this;
    }
    public String getText(){
        return dropdown.getSelectedOption().getText();
    }

}
