package it.unisa.diem.gruppo9.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @file NameAndSurnameComparatorTest.java
 * @brief Unit test for the {@code NameAndSurnameComparator} class
 *
 * This class contains a series of test to validate the logical comparison
 * implemented in the {@code NameAndSurnameComparator} class. Tests covers all
 * the major scenarios, including: - Comparison of contacts with different name
 * and surname - Comparison of contact with the same surname but with different
 * name - Handling null values for the surname field - Cases where contacts have
 * the same name and the same surname
 *
 * @see Contact.java
 * @see NameAndSurnameComparator.java
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-12
 */
public class NameAndSurnameComparatorTest {

    /**
     * Create the instance of {@code NameAndSurnameComparator} class used for
     * testing
     */
    private NameAndSurnameComparator comparator;

    private Contact contact1;

    private Contact contact2;

    private String[] emptyPhoneNumbers;

    private String[] emptyEmails;

    public NameAndSurnameComparatorTest() {

    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("\n\nStarting test NameAndSurnameComparator.java...\n\n");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("\n\nFinished testing NameAndSurnameComparator.java.\n\n");
    }

    /**
     * Sets up resources befor each test Initialize a new
     * NameAndSurnameComparator, including empty arrays for phone number and
     * email
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Setting up a new NameAndSurnameComparator instance to test...");
        comparator = new NameAndSurnameComparator();
        emptyPhoneNumbers = new String[]{"-", "-", "-"};
        emptyEmails = new String[]{"-", "-", "-"};
    }

    /**
     * Cleans up the resources after each test Sets all data to null to ensure a
     * fresh test of the sequent test
     */
    @AfterEach
    public void teardDown() {
        System.out.println("Tearing down the NameAndSurnameComparator instance after test...\n");
        comparator = null;
        emptyPhoneNumbers = null;
        emptyEmails = null;
    }

    /**
     * @test Compares two contacts with different surname and different name
     *
     * Verify that the comparator correctly orders contacts based on surnames
     *
     * Expected Result: - contact1 comes before contact2
     */
    @Test
    public void testCompareDifferentSurnameDifferentName() {
        System.out.println("Testing with different surname and name");
        contact1 = new Contact("Dylan", "Bob", emptyPhoneNumbers, emptyEmails);
        contact2 = new Contact("inWonderland", "Alice", emptyPhoneNumbers, emptyEmails);

        int result = comparator.compare(contact1, contact2);

        assertTrue(result < 0, "Contact1 should come before Contact2 because 'Dylan' before 'inWonderland'.");
    }

    /**
     * @test Compare two contacts with the same surname but different name
     *
     * Verify that the comprator correctly order contacts based on names
     *
     * Expected Result: - contact1 comes after contact2
     */
    @Test
    public void testCompareSameSurnameDifferentName() {
        System.out.println("Testing with same surname and different name");
        contact1 = new Contact("Dylan", "Bob", emptyPhoneNumbers, emptyEmails);
        contact2 = new Contact("Dylan", "Alice", emptyPhoneNumbers, emptyEmails);

        int result = comparator.compare(contact1, contact2);

        assertTrue(result > 0, "Contact1 should come after Contact2 because 'Bob' after 'Alice'.");
    }

    /**
     * @test Compares two contact with null surname Verify that the comparator
     * correctly handles null surnames and orders the contacts based on name
     *
     * Expected Result: - contact1 comes after contact2
     */
    @Test
    public void testCompareBothSurnamesNull() {
        System.out.println("Testing with both surname null");
        contact1 = new Contact(null, "Bob", emptyPhoneNumbers, emptyEmails);
        contact2 = new Contact(null, "Alice", emptyPhoneNumbers, emptyEmails);

        int result = comparator.compare(contact1, contact2);

        assertTrue(result > 0, "Contact1 should come after Contact2 because 'Bob' after 'Alice'.");
    }

    /**
     * @test Compares two contact where one surname is null Verify that the
     * comparator is able to compare a contact's surname with the name of
     * another contact that as null surname
     *
     * Expected Result: - contact1 comes after contact2
     */
    @Test
    public void testCompareOneSurnameNull() {
        System.out.println("Testing with only one surname null");
        contact1 = new Contact("Dylan", "Bob", emptyPhoneNumbers, emptyEmails);
        contact2 = new Contact(null, "Alice", emptyPhoneNumbers, emptyEmails);

        int result = comparator.compare(contact1, contact2);

        assertTrue(result > 0, "Contact1 should come after Contact2 because 'Dylan' after 'Alice'.");
    }

    /**
     * @test Compares two contact where one surname is null in a reversed order
     * Verify that the comparator is able to compare a contact's surname with
     * the name of another contact that as null surname
     *
     * Expected Result: - contact1 comes before contact2
     */
    @Test
    public void testCompareOneSurnameNull_Reverse() {
        System.out.println("Testing with only one surname null in reversed order");
        contact1 = new Contact(null, "Bob", emptyPhoneNumbers, emptyEmails);
        contact2 = new Contact("inWonderland", "Alice", emptyPhoneNumbers, emptyEmails);

        int result = comparator.compare(contact1, contact2);

        assertTrue(result < 0, "Contact1 should come before Contact2 because 'Bob' before 'inWonderland'.");
    }

    /**
     * @test Compares two contact with identical Surname and Name Verify that
     * the comparator consider equal two contact with the same name and the same
     * surname
     *
     * Expected Result: - The result of the comparison is 0 indicating equality
     */
    @Test
    public void testCompareSameNameAndSurname() {
        System.out.println("Testing with same surname and name");
        contact1 = new Contact("Dylan", "Bob", emptyPhoneNumbers, emptyEmails);
        contact2 = new Contact("Dylan", "Bob", emptyPhoneNumbers, emptyEmails);

        int result = comparator.compare(contact1, contact2);

        assertEquals(0, result, "Contacts with identical names and surnames should be considered equal.");
    }

}