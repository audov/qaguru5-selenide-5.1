
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MoveTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.holdBrowserOpen = true;
        baseUrl = "https://the-internet.herokuapp.com";
    }
        @BeforeEach
        void beforeEach () {
            open("/drag_and_drop");
        }
        @Test
        void dragAndDropActionTest () {
            Selenide.actions().clickAndHold($("#column-a"))
                    .moveToElement($("#column-b"))
                    .release()
                    .perform();
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        }

        @Test
        void dragAndDropMethodTest () {
            $("#column-a").dragAndDropTo("#column-b");
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        }
    }

