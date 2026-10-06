
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormTests extends test.TestBase {
    @Test
    void registrationFormRequired() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Wazowski");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Mike Wazowski"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
    }

    @Test
    void registrationFormFull () {
        open("/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Wazowski");
        $("#userEmail").setValue("mike@example.in");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Mike Wazowski"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("mike@example.in"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 August,1995"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Physics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("screen.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Bullet street 7"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }

    @Test
    void emptyFirstName() {
        open("/automation-practice-form");
        $("#lastName").setValue("Wazowski");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").scrollTo().click();
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyLastName() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").scrollTo().click();
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyUserNumber() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Wazowski");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").scrollTo().click();
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
