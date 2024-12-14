package it.unisa.diem.gruppo9.logic;

import java.io.IOException;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @file ContactManagerTest.java
 * @brief Unit test for the {@code ContactManager} class
 *
 * This class contains a series of methods to verify the correct behavior of the
 * {@code ContactManager} method.
 *
 * The test covers functionality such as: - Adding valid and invalid contact to
 * the contact list - Deleting existing and non existing contacts - Search
 * contact based on name or surname substring - Creating contact with specific
 * details - Sorting contacts and handling edge cases - Saving and loading
 * contact to and from a file
 *
 * @see Contact.java
 * @see ContactManager.java
 *
 * @author gruppo9
 * @version 2.0
 * @date 2024-12-12
 */
public class ContactManagerTest {

    /**
     * Create the instance of {@code ContactManager} class used for testing
     */
    private ContactManager contactManager;

    public ContactManagerTest() {

    }

    /**
     * Initializes resources before all tests.
     */
    @BeforeAll
    public static void setUpClass() {
        System.out.println("\n\nStarting test ContactManagerTest.java...\n\n");
    }

    /**
     * Cleans up resources after all tests.
     */
    @AfterAll
    public static void tearDownClass() {
        System.out.println("\n\nFinished testing ContactManagerTest.java\n\n");
    }

    /**
     * Sets up resources before each test.
     * Initializes a new ContactManager instance before each test.
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Setting up a new ContactManager instance to test...");
        contactManager = new ContactManager();
    }

    /**
     * Cleans up resources after each test.
     * Sets the ContactManager instance to null to 
     * ensure a succesful start of the next test
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down the ContactManager instance after test...\n");
        contactManager = null;
    }

    /**
     * @test Tests the addContacts method with a valid contact
     *
     * Expected Result: - The valid contact is added to the list.
     */
    @Test
    public void testAddContactsValid() {
        System.out.println("Testing adding valid contact");
        Contact contact = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        contactManager.addContacts(contact);

        ObservableList<Contact> contacts = contactManager.getListOfContacts();
        assertEquals(1, contacts.size());
        assertTrue(contacts.contains(contact));
    }

    /**
     * @test Tests the addContacts method with a non valid contact
     *
     * Expected Result: - The contact does not modify the list.
     */
    @Test
    public void testAddContactsInvalid() {
        System.out.println("Testing adding invalid contact");
        Contact contact = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        contactManager.addContacts(contact);

        ObservableList<Contact> contacts = contactManager.getListOfContacts();
        assertEquals(1, contacts.size());
        assertTrue(contacts.contains(contact));

        contactManager.addContacts(null);
        assertEquals(1, contacts.size());
    }

    /**
     * @test Tests the deleteContact method deleting an existing contact. -
     * Attempting to delete a non-existent contact.
     *
     * Expected Result: - The contact is removed from the list if it exists.
     */
    @Test
    public void testDeleteContactValid() {
        System.out.println("Testing deleting valid contact");
        Contact contact = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        contactManager.addContacts(contact);

        contactManager.deleteContact(contact);
        ObservableList<Contact> contacts = contactManager.getListOfContacts();
        assertEquals(0, contacts.size());
    }

    /**
     * @test Tests the deleteContact method deleting a non-existent contact.
     *
     * Expected Result: - No change occurs if the contact does not exist.
     */
    public void testDeleteContactInvalid() {
        System.out.println("Testing deletin invalid contact");
        Contact contact = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        contactManager.addContacts(contact);

        contactManager.deleteContact(contact);
        ObservableList<Contact> contacts = contactManager.getListOfContacts();
        assertEquals(0, contacts.size());
        contactManager.deleteContact(contact);
        assertEquals(0, contacts.size());
    }

    /**
     * @test Tests the searchContact method for a contact with a matching
     * substring.
     *
     * Expected Result: - Contacts with names or surnames starting with the
     * substring are returned.
     */
    @Test
    public void testSearchContactMatch() {
        System.out.println("Testing search contact with match");
        Contact contact = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        contactManager.addContacts(contact);

        // Search for existing contact
        ObservableList<Contact> result = contactManager.searchContact("Bo");
        assertEquals(1, result.size());
        assertTrue(result.contains(contact));
    }

    /**
     * @test Tests the searchContact method for a contact with no matching
     * substring.
     *
     * Expected Result: - An empty list is returned for non-matching substrings.
     */
    @Test
    public void testSearchContactNoMatch() {
        System.out.println("Testing search contact without match");
        Contact contact = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        contactManager.addContacts(contact);

        // Search for non existing contact
        ObservableList<Contact> result = contactManager.searchContact("X");
        assertEquals(0, result.size());
    }

    /**
     * @test Tests the createContact method with valid contact.
     *
     * Expected Result: - A contact object is returned with the specified
     * details.
     *
     * <p>
     * The
     * {@link ContactManager#createContact(java.lang.String, java.lang.String, java.lang.String[], java.lang.String[])}
     * method is simply a call to the {@code Contact} contstructor. It
     * represents in this sense the integration test between this very class and
     * the {@code Contact} class while invoking all of its getter methods and
     * the constructor.
     * </p>
     */
    @Test
    public void testCreateContact() {
        System.out.println("Testing create contact");
        String[] phoneNumbers = {"12345", "-", "-"};
        String[] emails = {"bob.dylan@example.com", "-", "-"};
        Contact contact = contactManager.createContact("Dylan", "Bob", phoneNumbers, emails);

        assertNotNull(contact);

        //integration testing section 
        assertEquals("Dylan", contact.getSurname());
        assertEquals("Bob", contact.getName());
        assertArrayEquals(phoneNumbers, contact.getPhoneNumber());
        assertArrayEquals(emails, contact.getEmail());
    }

    /**
     * @test Tests the sortList method.
     *
     * Scenarios: - Sorting contacts where one or both have a null surname. -
     * Sorting contacts with identical surnames but different names. - Sorting
     * contacts with identical names and surnames. - General lexicographic
     * sorting by surname, then name.
     *
     * Expected Results: - Contacts are sorted according to the provided compare
     * logic in the following order: contact4, contact1, contact5, contact2,
     * contact3
     */
    @Test
    public void testSortListVersionTwo() {
        // Case 1: General lexicographic sorting by surname and name
        System.out.println("Testing sorting list of contact");
        Contact contact1 = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        Contact contact2 = new Contact("inWonderland", "Alice", new String[]{"67890", "-", "-"}, new String[]{"alice.smith@example.com", "-", "-"});
        contactManager.addContacts(contact1);
        contactManager.addContacts(contact2);

        ObservableList<Contact> contacts = contactManager.getListOfContacts();
        assertEquals(contact1, contacts.get(0));
        assertEquals(contact2, contacts.get(1));

        // Case 2: Sorting with null surname for one contact
        Contact contact3 = new Contact(null, "Zelda", new String[]{"-", "-", "-"}, new String[]{"-", "-", "-"});
        contactManager.addContacts(contact3);

        contacts = contactManager.getListOfContacts();
        assertEquals(contact1, contacts.get(0));
        assertEquals(contact2, contacts.get(1));
        assertEquals(contact3, contacts.get(2));

        // Case 3: Sorting with null surnames for both contacts
        Contact contact4 = new Contact(null, "Atreus", new String[]{"-", "-", "-"}, new String[]{"-", "-", "-"});
        contactManager.addContacts(contact4);

        contacts = contactManager.getListOfContacts();
        assertEquals(contact4, contacts.get(0));
        assertEquals(contact1, contacts.get(1));
        assertEquals(contact2, contacts.get(2));
        assertEquals(contact3, contacts.get(3));

        // Case 4: Identical names and surnames
        Contact contact5 = new Contact("Dylan", "Bob", new String[]{"-", "-", "-"}, new String[]{"-", "-", "-"});
        contactManager.addContacts(contact5);

        contacts = contactManager.getListOfContacts();
        assertEquals(contact5, contacts.get(2));
        assertEquals(contact1, contacts.get(1));
    }

    /**
     * @test Tests the saveContact method by writing contacts on a file.
     *
     * Expected Result: - The file is created and contains the correct data.
     *
     * <p>
     * Furthermore this test method represents the integration test between this
     * very class with the invocation of the
     * {@link ContactManager#addContacts(it.unisa.diem.gruppo9.logic.Contact)}
     * and {@link ContactManager#saveContact()} and the {@code Contact} class
     * while invoking its constructor. To be even more specific in the
     * {@link ContactManager#saveContact()} method there is a call on a
     * {@link PrintWriter#print(it.unisa.diem.gruppo9.logic.Contact)} that uses
     * the {@link Contact#toString()} method.
     * </p>
     */
    @Test
    public void testSaveContact() throws IOException {
        System.out.println("Testing save contact list");
        Contact contact = new Contact("Dylan", "Bob", new String[]{"12345", "-", "-"}, new String[]{"bob.dylan@example.com", "-", "-"});
        contactManager.addContacts(contact);

        assertDoesNotThrow(() -> contactManager.saveContact());
    }

    /**
     * @test Tests the loadContact method by loading contacts from a file.
     *
     * Expected Result: - The contact list is populated with data from the file.
     *
     * <p>
     * Furthermore this test method represents the integration test between this
     * very class with the invocation of {@link ContactManager#loadContact()}
     * and the {@code Contact} class. To be even more specific in the
     * {@link ContactManager#loadContact()} method there is a call on a
     * {@link ContactManager#addContacts(it.unisa.diem.gruppo9.logic.Contact)}that
     * uses a previoulsy created instance of {@code Contact} via its
     * constructor.
     * </p>
     */
    @Test
    public void testLoadContact() throws IOException {
        // Assumes the file "rubrica.csv" exists and contains valid data
        System.out.println("Testing load contact list");
        assertDoesNotThrow(() -> contactManager.loadContact());
    }
}
