import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestClass {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(By.className("App_appContainer__3jRx1"));
        form.$("[data-test-id=name] input").setValue("Василий");
        form.$("[data-test-id=phone] input").setValue("+79279879076");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button__text")).click();
        $(By.xpath("//div[@id='root']/div[@class='App_appContainer__3jRx1']//p[@class='paragraph paragraph_theme_alfa-on-white']")).shouldBe(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void wrongPhone() {
        open("http://localhost:9999");
        SelenideElement form = $(By.className("App_appContainer__3jRx1"));
        form.$("[data-test-id=name] input").setValue("Василий");
        form.$("[data-test-id=phone] input").setValue("+7927");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button__text")).click();
        $(By.xpath("//div[@id='root']//form[@action='/']/div[2]/span//span[@class='input__sub']")).shouldBe(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}


