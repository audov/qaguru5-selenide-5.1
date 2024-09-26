import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.holdBrowserOpen = true;
        baseUrl = "https://github.com";
    }

    @Test
    void pageLoadSuccessTest() {
        open(baseUrl);
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $("a[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}

