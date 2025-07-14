package com.qa.studymate.ui.pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentPage extends BasePage{

    public StudentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(text(),'Students')]")
    private WebElement studentsSection;

    @FindBy(xpath = "//button[.='Add student']")
    private WebElement addStudentButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(id = "mui-component-select-groupId")
    private WebElement groupField;

    @FindBy(xpath = "//li[contains(text(),'Batch 9')]")
    private WebElement batch9;

    @FindBy(id = "mui-component-select-studyFormat")
    private WebElement studyFormatField;

    @FindBy(xpath = "//li[.='ONLINE']")
    private WebElement onlineFormat;

    @FindBy(xpath = "//li[.='OFFLINE']")
    private WebElement offlineFormat;

    @FindBy(xpath = "//button[.='Add']")
    private WebElement addStudentButtonF;

    @FindBy(xpath = "//tbody/tr[1]/td[7]/div/button")
    private WebElement editButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[3]")
    private WebElement deleteDivision;

    @FindBy(xpath = "//button[.='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//tbody")
    public WebElement table;

    public void addStudentOnline(String name, String lastName, String phone, String email) {
        click(studentsSection);
        click(addStudentButton);
        type(nameInput, name);
        type(lastNameInput, lastName);
        click(phoneNumberInput);
        type(phoneNumberInput, phone);
        type(emailInput, email);
        click(groupField);
        click(batch9);
        click(studyFormatField);
        click(onlineFormat);
        click(addStudentButtonF);
        waitUntilTextPresent(table, email);
        Assert.assertTrue(table.getText().contains(email));
    }

    public void addStudentOffline(String name, String lastName, String phone, String email) {
        click(studentsSection);
        click(addStudentButton);
        type(nameInput, name);
        type(lastNameInput, lastName);
        click(phoneNumberInput);
        type(phoneNumberInput, phone);
        type(emailInput, email);
        click(groupField);
        click(batch9);
        click(studyFormatField);
        click(offlineFormat);
        click(addStudentButtonF);
        waitUntilTextPresent(table, email);
        Assert.assertTrue(table.getText().contains(email));
    }

    public void deleteStudent(String email) {
        click(editButton);
        click(deleteDivision);
        click(deleteButton);
        waitUntilTextNotPresent(table, email);
        Assert.assertFalse(table.getText().contains(email));
    }

    public void addNewStudents(String name, String lastName, String phone, String email) {
        type(nameInput, name);
        type(lastNameInput, lastName);
        click(phoneNumberInput);
        type(phoneNumberInput, phone);
        type(emailInput, email);
        click(groupField);
        click(batch9);
        click(studyFormatField);
        click(offlineFormat);
        click(addStudentButtonF);
    }

    public void openAddStudentForm() {
        click(studentsSection);
        click(addStudentButton);
    }
}
