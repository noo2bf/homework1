
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormTests {
    @Test
    void registrationFormRequired() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Wazowski");
        $("#userNumber").setValue("1234567890");
        $("[value='Male']").click();
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void registrationFormFull() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Wazowski");
        $("#userEmail").setValue("mike@example.in");
        $("#userNumber").setValue("1234567890");
        $("[value='Male']").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day.react-datepicker__day--011").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#subjectsInput").setValue("ph");
        $("#react-select-2-option-0").click();
        $("#currentAddress").setValue("Bullet street 7");
        $("#uploadPicture").uploadFromClasspath("screen.png");
        $("#state").scrollTo().click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void emptyFirstName() {
        open("https://demoqa.com/automation-practice-form");
        $("#lastName").setValue("Wazowski");
        $("#userNumber").setValue("1234567890");
        $("[value='Male']").click();
        $("#submit").scrollTo().click();
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyLastName() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#userNumber").setValue("1234567890");
        $("[value='Male']").click();
        $("#submit").scrollTo().click();
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyUserNumber() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Wazowski");
        $("[value='Male']").click();
        $("#submit").scrollTo().click();
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
