
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Class with negative tests")
public class FormTests extends test.TestBase {

    @ParameterizedTest
    @DisplayName("ValueSource тесты")
    @Tag("Smoke")
    @ValueSource(strings = {
            "Mike", "Nancy", "Penny"
    })
    void registrationFormValueSource(String searchQuery) {
        open("/automation-practice-form");
        $("#firstName").setValue(searchQuery);
        $("#lastName").setValue("Wazowski");
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText("Male")).click();
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(searchQuery));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
    }

    @ParameterizedTest
    @DisplayName("ValueCSV тесты")
    @Tag("Smoke")
    @CsvSource(value = {
            "Mike, Wazowski, Male",
            "Nancy, Pelony, Female",
            "Penny, Gilmore, Other",
    })
    void registrationFormValueCsv(String firstName, String lastName, String gender) {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText(gender)).click();
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
    }

    @ParameterizedTest
    @DisplayName("ValueCSV тесты")
    @Tag("Smoke")
    @CsvFileSource(resources = "/test.csv")
    void registrationFormValueCsvFile(String firstName, String lastName, String gender) {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue("1234567890");
        $("#genterWrapper").$(byText(gender)).click();
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
    }
}
