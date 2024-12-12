package it.unisa.diem.gruppo9.logic;

import java.util.Comparator;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gruppo9
 */
public class ContactManagerTest {
    
    public ContactManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addContacts method, of class ContactManager.
     */
    @Test
    public void testAddContacts() {
        System.out.println("addContacts");
        Contact c = null;
        ContactManager instance = new ContactManager();
        instance.addContacts(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteContact method, of class ContactManager.
     */
    @Test
    public void testDeleteContact() {
        System.out.println("deleteContact");
        Contact c = null;
        ContactManager instance = new ContactManager();
        instance.deleteContact(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchContact method, of class ContactManager.
     */
    @Test
    public void testSearchContact() {
        System.out.println("searchContact");
        String s = "";
        ContactManager instance = new ContactManager();
        ObservableList<Contact> expResult = null;
        ObservableList<Contact> result = instance.searchContact(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createContact method, of class ContactManager.
     */
    @Test
    public void testCreateContact() {
        System.out.println("createContact");
        String surname = "";
        String name = "";
        String[] phoneNumber = null;
        String[] email = null;
        ContactManager instance = new ContactManager();
        Contact expResult = null;
        Contact result = instance.createContact(surname, name, phoneNumber, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortList method, of class ContactManager.
     */
    @Test
    public void testSortList() {
        System.out.println("sortList");
        Comparator<Contact> c = null;
        ContactManager instance = new ContactManager();
        instance.sortList(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfContacts method, of class ContactManager.
     */
    @Test
    public void testGetListOfContacts() {
        System.out.println("getListOfContacts");
        ContactManager instance = new ContactManager();
        ObservableList<Contact> expResult = null;
        ObservableList<Contact> result = instance.getListOfContacts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveContact method, of class ContactManager.
     */
    @Test
    public void testSaveContact() throws Exception {
        System.out.println("saveContact");
        ContactManager instance = new ContactManager();
        instance.saveContact();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadContact method, of class ContactManager.
     */
    @Test
    public void testLoadContact() throws Exception {
        System.out.println("loadContact");
        ContactManager instance = new ContactManager();
        ContactManager expResult = null;
        ContactManager result = instance.loadContact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
