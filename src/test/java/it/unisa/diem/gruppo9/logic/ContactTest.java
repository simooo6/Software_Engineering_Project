package it.unisa.diem.gruppo9.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @file ContactTest.java
 * @brief Unit test for the {@link Contact} class.
 *
 * This class contains a series of tests for the {@code Contact} class; to
 * verify the corret behavior of the:
 * {@code Constructor},{@code Getters},{@code Setters} and the {@code toString}
 * methods.
 *
 * Tests ensure the proper handling of valid and invalid input, exception
 * handling and edge cases.
 *
 * @details The test class includes: - Valid and invalid usage of the
 * {@code Contact} constructor with different combinations of: name, surname,
 * phone number array and email array
 *
 * - Verification of correct functionality of getter and setter methods for all
 * the class attributes
 *
 * - Proper handling of null or invalid input for phoneNumber and email arrays
 *
 * - Testing the {@code toString()} method for various input configurations to
 * ensure the correct string rapresentation
 *
 * @see Contact.java
 *
 *
 * @author gruppo 9
 * @version 1.0
 * @date 2024-12-11
 */
public class ContactTest {

    /**
     * Create the instance of {@code Contact} class used for testing
     */
    private Contact contact;

    public ContactTest() {

    }

    /**
     * Initializes resources before all tests.
     */
    @BeforeAll
    public static void setUpClass() {
        System.out.println("\n\nStarting test Contact.java...\n");
    }

    /**
     * Cleans up resources after all tests.
     */
    @AfterAll
    public static void tearDownClass() {
        System.out.println("\n\n\nFinished testing Contact.java.\n\n");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("\n\nSetting up a new Contact instance to test...");
        String[] initialPhoneNumbers = {"1234567890", "-", "-"};
        String[] initialEmails = {"test@example.com", "-", "-"};
        contact = new Contact("Dylan", "Bob", initialPhoneNumbers, initialEmails);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down the Contact instance after test...");
        contact = null;
    }

    /**
     * @test Verify the correct behavior of the {@code Contact} constructor with
     * a valid input.
     *
     * Assert that the {@code Contact} object is created with the correct
     * attributes. Expected Result: Contact with -> Surname:""; Name:"Bob";
     * Phone Numbers ="1234567890","-","-"; Emails="test@example.com","-","-";
     */
    @Test
    public void testConstructorValidName() {
        System.out.println("Constructor - Valid Contact With Name");
        String[] phoneNumbers = {"1234567890", "-", "-"};
        String[] emails = {"test@example.com", "-", "-"};

        contact = new Contact("", "Bob", phoneNumbers, emails);

        assertEquals("Bob", contact.getName());
        assertEquals("", contact.getSurname());
        assertArrayEquals(phoneNumbers, contact.getPhoneNumber());
        assertArrayEquals(emails, contact.getEmail());
    }

    /**
     * @test Verify the correct behavior of the {@code Contact} constructor with
     * a valid input.
     *
     * Assert that the {@code Contact} object is created with the correct
     * attributes. Expected Result: Contact with -> Surname:"Dylan"; Name:"";
     * Phone Numbers ="-","-","-"; Emails="-","-","-";
     */
    @Test
    public void testConstructorValidSurname() {
        System.out.println("Constructor - Valid Contact With Surname");
        String[] phoneNumbers = {"-", "-", "-"};
        String[] emails = {"-", "-", "-"};

        contact = new Contact("Dylan", "", phoneNumbers, emails);

        assertEquals("", contact.getName());
        assertEquals("Dylan", contact.getSurname());
        assertArrayEquals(phoneNumbers, contact.getPhoneNumber());
        assertArrayEquals(emails, contact.getEmail());
    }

    /**
     * @test Verify the correct behavior of the {@code Contact} constructor with
     * a valid input.
     *
     * Assert that the {@code Contact} object is created with the correct
     * attributes. Expected Result: Contact with -> Surname:"Dylan"; Name:"Bob";
     * Phone Numbers="1234567890","-","-"; Emails="test@example.com","-","-";
     */
    @Test
    public void testConstructorValidNameAndSurname() {
        System.out.println("Constructor - Valid Contact With Name And Surname");
        String[] phoneNumbers = {"-", "-", "-"};
        String[] emails = {"test@example.com", "-", "-"};

        contact = new Contact("Dylan", "Bob", phoneNumbers, emails);

        assertEquals("Bob", contact.getName(), "valid name and surname");
        assertEquals("Dylan", contact.getSurname());
        assertArrayEquals(phoneNumbers, contact.getPhoneNumber());
        assertArrayEquals(emails, contact.getEmail());
    }

    /**
     * @test Verify that {@code Contact} constructor throws an exception when
     * both Name and Surname are empty
     */
    @Test
    public void testConstructorInvalidNameAndSurname() {
        System.out.println("Constructor - Invalid Contact Without Name and Surname");
        String[] phoneNumbers = {"-", "-", "-"};
        String[] emails = {"test@example.com", "-", "-"};

        assertThrows(RuntimeException.class, () -> {
            new Contact("", "", phoneNumbers, emails);
        }, "Expected RuntimeException when both name and surname are empty.");
    }

    /**
     * @test Verify that {@code Contact} constructor throws an exception when
     * phone number array exceeds the maximum size allowed.
     */
    @Test
    public void testConstructorInvalidPhoneNumberDim() {
        System.out.println("Constructor - Invalid Phone Number Array Too Large");
        String[] invalidPhoneNumbers = {"1000", "0100", "0010", "0001"};
        String[] emails = {"-", "-", "-"};

        assertThrows(RuntimeException.class, () -> {
            new Contact("Dylan", "Bob", invalidPhoneNumbers, emails);
        }, "Expected RuntimeException when phoneNumber array size exceeds 3.");
    }

    /**
     * @test Verify that {@code Contact} constructor throws an exception when
     * email array exceeds the maximum size allowed.
     */
    @Test
    public void testConstructorInvalidEmailDim() {
        System.out.println("Constructor - Invalid Email Array Too Large");
        String[] phoneNumbers = {"-", "-", "-"};
        String[] invalidEmails = {"first@test.com", "second@test.com", "third@test.com", "fourth@test.com"};

        assertThrows(RuntimeException.class, () -> {
            new Contact("Dylan", "Bob", phoneNumbers, invalidEmails);
        }, "Expected RuntimeException when email array size exceeds 3.");
    }

    /**
     * @test Verify the correct behavior of the {@code Contact} constructor with
     * a valid input.
     *
     * Assert that the {@code Contact} object is created with the correct
     * attributes. Expected Result: Contact with -> Surname:"Dylan"; Name:"Bob";
     * Phone Numbers ="-","-","-"; Emails="-","-","-";
     *
     */
    @Test
    public void testConstructorEmptyPhoneNumberAndEmail() {
        System.out.println("Constructor - Empty Phone Number And Email Arrays");
        String[] phoneNumbers = {"-", "-", "-"};
        String[] emails = {"-", "-", "-"};

        contact = new Contact("Dylan", "Bob", phoneNumbers, emails);

        assertEquals("Bob", contact.getName());
        assertEquals("Dylan", contact.getSurname());
        assertArrayEquals(phoneNumbers, contact.getPhoneNumber());
        assertArrayEquals(emails, contact.getEmail());
    }

    /**
     * @test Verify that the {@code Contact} constructor throws an exception
     * when the phone number array is null. The test ensure that the instance of
     * contact can not be created if the phone number array is {@code null}.
     */
    @Test
    public void testConstructorPhoneNumberNull() {
        System.out.println("Constructor - Null Phone Number Array");
        String[] emails = {"test@example.com", "-", "-"};

        assertThrows(NullPointerException.class, () -> {
            new Contact("Dylan", "Bob", null, emails);
        }, "Expected NullPointerException when phoneNumber array is null.");
    }

    /**
     * @test Verify that the {@code Contact} constructor throws an exception
     * when the email array is null. The test ensure that the instance of
     * contact can not be created if the email array is {@code null}.
     */
    @Test
    public void testConstructorEmailNull() {
        System.out.println("Constructor - Null Email Array");
        String[] phoneNumbers = {"1234567890", "-", "-"};

        assertThrows(NullPointerException.class, () -> {
            new Contact("Dylan", "Bob", phoneNumbers, null);
        }, "Expected NullPointerException when email array is null.");
    }

    /**
     * @test Verify the {@code getName()} method. Expected result: - the correct
     * name is returned, Name="Bob"
     */
    @Test
    public void testGetName() {
        System.out.println("Testing getName...");
        assertEquals("Bob", contact.getName());
    }

    /**
     * @test Verify the {@code getSurname()} method. Expected Result: - the
     * correct surname is returned, Surname="Dylan"
     */
    @Test
    public void testGetSurname() {
        System.out.println("Testing getSurname...");
        assertEquals("Dylan", contact.getSurname());
    }

    /**
     * @test Verify the {@code getPhoneNumber}. Expected result: - the correct
     * phone number is returned, phoneNumber="1234567890","-","-"
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("Testing getPhoneNumber...");
        String[] expectedPhoneNumbers = {"1234567890", "-", "-"};
        assertArrayEquals(expectedPhoneNumbers, contact.getPhoneNumber());
    }

    /**
     * @test Verify the {@code getEmail} Expected Result: - the correct email is
     * returned, email="test@example.com","-","-"
     */
    @Test
    public void testGetEmail() {
        System.out.println("Testing getEmail...");
        String[] expectedEmails = {"test@example.com", "-", "-"};
        assertArrayEquals(expectedEmails, contact.getEmail());
    }

    /**
     * @test Verify the {@code setName} Expected Result: - the name is uptaded
     * correctly, Name="Alice"
     */
    @Test
    public void testSetName() {
        System.out.println("Testing setName...");
        contact.setName("Alice");
        assertEquals("Alice", contact.getName());
    }

    /**
     * @test Verify the {@code setSurname} Expected Result: - the surname is
     * uptaded correctly, surname="inWonderland"
     */
    @Test
    public void testSetSurname() {
        System.out.println("Testing setSurname...");
        contact.setSurname("inWonderland");
        assertEquals("inWonderland", contact.getSurname());
    }

    /**
     * @test Verify the {@code setPhoneNumber} Expected Result: - the phone
     * number is uptaded correctly, phone number="9876543210", "1234567890","-"
     */
    @Test
    public void testSetPhoneNumberValid() {
        System.out.println("Testing setPhoneNumber with valid input...");
        String[] newPhoneNumbers = {"9876543210", "1234567890", "-"};
        contact.setPhoneNumber(newPhoneNumbers);
        assertArrayEquals(newPhoneNumbers, contact.getPhoneNumber());
    }

    /**
     * @test Verify that the {@code setPhoneNumber} method throws an exception
     * if the phone number array exceeds the maximum size allowed.
     */
    @Test
    public void testSetPhoneNumberInvalid() {
        System.out.println("Testing setPhoneNumber with invalid input (too many numbers)...");
        String[] invalidPhoneNumbers = {"1000", "0100", "0010", "0001"};
        assertThrows(RuntimeException.class, () -> {
            contact.setPhoneNumber(invalidPhoneNumbers);
        }, "Expected RuntimeException when phoneNumber array exceeds 3 entries.");
    }

    /**
     * @test Verify the {@code setEmail} Expected Result: - the email is uptaded
     * correctly, email="new@example.com", "another@example.com","-"
     */
    @Test
    public void testSetEmailValid() {
        System.out.println("Testing setEmail with valid input...");
        String[] newEmails = {"new@example.com", "another@example.com", "-"};
        contact.setEmail(newEmails);
        assertArrayEquals(newEmails, contact.getEmail());
    }

    /**
     * @test Verify that the {@code setEmail} method throws an exception if the
     * email array exceeds the maximum size allowed.
     */
    @Test
    public void testSetEmailInvalid() {
        System.out.println("Testing setEmail with invalid input (too many emails)...");
        String[] invalidEmails = {"first@test.com", "second@test.com", "third@test.com", "fourth@test.com"};
        assertThrows(RuntimeException.class, () -> {
            contact.setEmail(invalidEmails);
        }, "Expected RuntimeException when email array exceeds 3 entries.");
    }

    /**
     * @test Verify that the {@code setPhoneNumber} method throws an exception
     * if the phone number array is null.
     */
    @Test
    public void testSetPhoneNumberNullArray() {
        System.out.println("Testing setPhoneNumber with null array...");
        assertThrows(NullPointerException.class, () -> {
            contact.setPhoneNumber(null);
        }, "Expected NullPointerException when phoneNumber array is null.");
    }

    /**
     * @test Verify that the {@code setEmail} method throws an exception if the
     * email array is null.
     */
    @Test
    public void testSetEmailNullArray() {
        System.out.println("Testing setEmail with null array...");
        assertThrows(NullPointerException.class, () -> {
            contact.setEmail(null);
        }, "Expected NullPointerException when email array is null.");
    }

    /**
     * @test Test the {@code toString()} method for the {@code Contact} class
     * when all the fields are populated. The test ensure that the
     * {@code toString()} method correctly return a string rapresentation of
     * the{@code Contact} object.
     *
     * Expected Result: Dylan;Bob;1234567890;-;-;test@example.com;-;-
     *
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString...");
        String expectedString = "Dylan;Bob;1234567890;-;-;test@example.com;-;-\n";
        assertEquals(expectedString, contact.toString());
    }

    /**
     * @test Test the {@code toString()} method for the {@code Contact} class
     * when only the surname and name fields are populated and the phone number
     * and email fields are empty.
     *
     * Expected Result: Dylan;Bob;-;-;-;-;-;-
     */
    @Test
    public void testToStringEmptyPhoneAndEmail() {
        System.out.println("Testing toString with empty phone numbers and emails...");
        contact.setPhoneNumber(new String[]{"-", "-", "-"});
        contact.setEmail(new String[]{"-", "-", "-"});
        String expectedString = "Dylan;Bob;-;-;-;-;-;-\n";
        assertEquals(expectedString, contact.toString());
    }

    /**
     * @test Test the {@code toString()} method for the {@code Contact} class
     * when only the name field is populated and the surname,phone number, email
     * fields are empty
     *
     * Expected Result: "";Alice;;-;-;-;-;-;-
     */
    @Test
    public void testToStringName() {
        System.out.println("Testing toString with only name set...");
        Contact singleNameContact = new Contact("", "Alice", new String[]{"-", "-", "-"}, new String[]{"-", "-", "-"});
        String expectedString = ";Alice;-;-;-;-;-;-\n";
        assertEquals(expectedString, singleNameContact.toString());
    }

    /**
     * @test Test the {@code toString()} method for the {@code Contact} class
     * when only the surname field is populated and the name,phone number, email
     * fields are empty
     *
     * Expected Result: inWonderland; ;-;-;-;-;-;-
     */
    @Test
    public void testToStringSurname() {
        System.out.println("Testing toString with only surname set...");
        Contact singleSurnameContact = new Contact("inWonderland", "", new String[]{"-", "-", "-"}, new String[]{"-", "-", "-"});
        String expectedString = "inWonderland;;-;-;-;-;-;-\n";
        assertEquals(expectedString, singleSurnameContact.toString());
    }

}
