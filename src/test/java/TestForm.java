import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void afterAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Snezhana");
        $("#lastName").setValue("Ganzha");
        $("#userEmail").setValue("gan@na.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("8596857456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("2024-02-27.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").pressEnter();

        //проверяем, корректно ли заполнились данные
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive tr:nth-child(1) > td:nth-child(2)").shouldHave(text("Snezhana Ganzha"));
        $(".table-responsive tr:nth-child(2) > td:nth-child(2)").shouldHave(text("gan@na.com"));
        $(".table-responsive tr:nth-child(3) > td:nth-child(2)").shouldHave(text("Female"));
        $(".table-responsive tr:nth-child(4) > td:nth-child(2)").shouldHave(text("8596857456"));
        $(".table-responsive tr:nth-child(5) > td:nth-child(2)").shouldHave(text("19 November,1989"));
        $(".table-responsive tr:nth-child(6) > td:nth-child(2)").shouldHave(text("English"));
        $(".table-responsive tr:nth-child(7) > td:nth-child(2)").shouldHave(text("Sports"));
        $(".table-responsive tr:nth-child(8) > td:nth-child(2)").shouldHave(text("2024-02-27.jpg"));
        $(".table-responsive tr:nth-child(9) > td:nth-child(2)").shouldHave(text("Moscow"));
        $(".table-responsive tr:nth-child(10) > td:nth-child(2)").shouldHave(text("Rajasthan Jaipur"));
        //$("#closeLargeModal").pressEnter();
    }
}