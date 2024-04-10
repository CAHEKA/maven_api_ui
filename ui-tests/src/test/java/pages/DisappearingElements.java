package pages;

import assertions.DisappearingElementsAssert;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DisappearingElements {

    private final SelenideElement elements = $x("//div[@class='example']/ul");

    public DisappearingElements() {
        Selenide.open("https://the-internet.herokuapp.com/disappearing_elements");
        elements.shouldBe(visible, Duration.ofSeconds(30));
    }

    public DisappearingElementsAssert check(){
        return DisappearingElementsAssert.assertThat(this);
    }
    
    public int getNumberOfElements() {
       return elements.findAll(By.tagName("li")).size();
    }
    
}
