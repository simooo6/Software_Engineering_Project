package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.logic.Contact;
import it.unisa.diem.gruppo9.logic.ContactManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @file BaseControllerTest.java
 * @brief Unit test for {@code BaseController} class.
 *
 * This class test the functionality of setting and retriving a ContactManager
 * and a selected Contact. Each test ensure that the {@code Basecontroller}
 * behaves as expected.
 *
 * The test covers functionality such as: - Set the ContactManager instance -
 * Set a selected contact - Get a selected contact - Get the ContactManager
 * instance
 *
 * @see BaseController.java
 * @see ContactManager.java
 * @see Contact.java
 *
 * @author gruppo9
 * @version 2.0
 * @date 2024-12-12
 */
public class BaseControllerTest {

    /**
     * Create the instance of BaseController used for testing
     */
    private BaseController baseController;

    private ContactManager contactManager;

    private Contact contact;

    public BaseControllerTest() {
    }

    /**
     * Initializes resources before all tests.
     */
    @BeforeAll
    public static void setUpClass() {
        System.out.println("\n\nStarting test BaseControllerTest.java...\n\n");
    }

    /**
     * Cleans up resources after all tests.
     */
    @AfterAll
    public static void tearDownClass() {
        System.out.println("\n\nFinished testing BaseControllerTest.java\n\n");
    }

    /**
     * Sets up resources before each test.
     * Initialize a new BaseController, a new
     * ContactManager and a new Contact including empty arrays for phoneNumber
     * and email
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Setting up a new BaseController instance to test");
        baseController = new BaseController();
        contactManager = new ContactManager();
        String[] initialPhoneNumbers = {"-", "-", "-"};
        String[] initialEmails = {"-", "-", "-"};
        contact = new Contact("Dylan", "Bob", initialPhoneNumbers, initialEmails);
    }

    /**
     * Cleans up the resources after eache test.
     * Sets all data to null to ensure
     * a succesful start of the sequent test
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down the BaseController instance after testing\n");
        baseController = null;
        contactManager = null;
        contact = null;
    }

    /**
     * @test Test the {@code setContacts} method with a valid
     * {@code ContactManager} instance into the {@code BaseController}.
     * Expected Result:
     * -The {@code contacts} field is not null. -The {@code contacts}
     * field contains the injected {@code ContactManager} instance.
     */
    @Test
    public void testSetContacts() {
        System.out.println("Testing class for set contacts method");
        baseController.setContacts(contactManager);
        assertNotNull(baseController.contacts, "The contacts field should not be null after begin setted");
        assertEquals(baseController.contacts, contactManager, "The contact fields should refere to the contact manager instance");
    }

    /**
     * @test Test the {@code setSelectedContact} method with a valid
     * {@code Contact} instance into the {@code BaseController}.
     * Expected Result:
     * -The {@code selectedContact} field is not null. 
     * -The {@code selectedContact} field contains the injected {@code Contact}
     * instance.
     */
    @Test
    public void testSetSelectedContact() {
        System.out.println("Testing class for set contact");
        baseController.setSelectedContact(contact);
        assertNotNull(baseController.selectedContact, "The selected contact should not be null after begin setted");
        assertEquals(baseController.selectedContact, contact, "The selected contact should be the same as the one set");
    }

    /**
     * @test Test the {@code getSelectedContact} method with a {@code Contact}
     * instance that was previously set. 
     * Expected Result:
     * -The retrieved instance matches the previously injected {@code Contact} instance.
     */
    @Test
    public void testGetSelectedContact() {
        System.out.println("Testing class for getSelectedContact");
        baseController.setSelectedContact(contact);
        Contact expectedContact = baseController.getSelectedContact();
        assertEquals(expectedContact, contact, "The two instance should be the same");
    }

    /**
     * @test Test the {@code getContacts} method with a {@code ContactManager}
     * instance that was previously set. 
     * Expected Result: 
     * -The retrieved instance matches the previously injected {@code ContactManager} instance.
     */
    @Test
    public void testGetContacts() {
        System.out.println("Testing class for getSelectedContacts");
        baseController.setContacts(contactManager);
        ContactManager expectedContactManager = baseController.getContacts();
        assertEquals(expectedContactManager, contactManager, "The two instance of contact manager should be the same");
    }
}
