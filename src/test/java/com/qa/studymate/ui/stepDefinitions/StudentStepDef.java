package com.qa.studymate.ui.stepDefinitions;
import com.github.javafaker.Faker;
import com.qa.studymate.ui.pages.LoginPage;
import com.qa.studymate.ui.pages.StudentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utils.Driver.driver;

public class StudentStepDef {
    StudentPage studentPage = new StudentPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    public String addedEmail;

    @Given("user goes to a website and enters valid credentials")
    public void user_goes_to_a_website_and_enters_valid_credentials() {
        loginPage.login("admin@codewise.com","codewise_123");
    }

    @When("user adds online and offline students")
    public void user_adds_online_and_offline_students() {
        studentPage.addStudentOnline("Sam","Aryanov","7777777771","sam@gmail.com");
        studentPage.addStudentOffline("Mike","Luke","7777777772","mike@gmail.com");
    }

    @Then("user deletes offline student")
    public void user_deletes_offline_student() {
        studentPage.deleteStudent("mike@gmail.com");
    }

    @When("user goes to a student page")
    public void user_goes_to_a_student_page() {
        studentPage.openAddStudentForm();
    }
    @When("user adds students by {string},{string},{string},{string}")
    public void user_adds_students_by(String name, String lastName, String phone, String email) {
        Faker faker = new Faker();
        if (name.equalsIgnoreCase("random")) {
            name = faker.name().firstName();
        }

        if (lastName.equalsIgnoreCase("random")) {
            lastName = faker.name().lastName();
        }

        if (phone.equalsIgnoreCase("random_phone")) {
            phone = faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "").substring(0, 10);
        }

        if (email.equalsIgnoreCase("random@gmail.com")) {
            email = name.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
        }
        studentPage.addNewStudents(name,lastName,phone,email);
        addedEmail=email;
    }
    @Then("user verifies that new students were added")
    public void user_verifies_that_new_students_were_added() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(studentPage.table,addedEmail));
        Assert.assertTrue(studentPage.table.getText().contains(addedEmail));
    }
}
