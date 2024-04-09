package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Checkboxes {

    private final SelenideElement checkboxes = $x("//form[@id='checkboxes']");
    
    public Checkboxes() {
        Selenide.open("https://the-internet.herokuapp.com/checkboxes");
        checkboxes.should(visible, Duration.ofSeconds(30));
    }
    
    public CheckboxesAssert check(){
        return CheckboxesAssert.assertThat(this);
    }

    public SelenideElement getCheckbox(String text){
        String xpath = String.format(".//input[contains(following-sibling::text(), '%s')]", text);
        return  checkboxes.find(By.xpath(xpath));
    }
    
    public Checkboxes clickCheckbox(String text){
        getCheckbox(text).click();
        return this;
    }

}
