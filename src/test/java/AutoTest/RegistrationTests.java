import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");



        $("#firstName").setValue("petr");
        $("#lastName").setValue("petrov");
        $("#userEmail").setValue("petr@petrov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");



        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--001").click();



        $("#subjectsInput").setValue("Economics")
                .pressEnter();
        $("#subjectsInput").setValue("Social Studies")
                .pressEnter();
        $("#subjectsInput").setValue("Hindi")
                .pressEnter();
        $("#subjectsInput").setValue("Biology")
                .pressEnter();



        $("#hobbiesWrapper").$(byText("Sports"))
                .click();
        $("#hobbiesWrapper").$(byText("Reading"))
                .click();
        $("#hobbiesWrapper").$(byText("Music"))
                .click();



        $("#uploadPicture").uploadFromClasspath("unnamed.png");



        $("#currentAddress-wrapper").$("#currentAddress")
                .setValue("Super street");



        $("#stateCity-wrapper").$("#state")
                .click();
        $("#stateCity-wrapper").$("#state").$(byText("Rajasthan"))
                .click();



        $("#stateCity-wrapper").$("#city")
                .click();
        $("#stateCity-wrapper").$("#city").$(byText("Jaipur"))
                .click();



        $("#submit")
                .click();



        $(".modal-open").shouldBe(visible);
        $(".table-responsive").$(byText("Label")).parent()
                .shouldHave(text("Values"));
        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(text("petr petrov"));
        $(".table-responsive").$(byText("Student Email")).parent()
                .shouldHave(text("petr@petrov.com"));
        $(".table-responsive").$(byText("Gender")).parent()
                .shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent()
                .shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text("01 July,2000"));
        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(text("Economics, Social Studies, Hindi, Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent()
                .shouldHave(text("unnamed.png"));
        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(text("Super street"));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(text("Rajasthan Jaipur"));
    }
}
