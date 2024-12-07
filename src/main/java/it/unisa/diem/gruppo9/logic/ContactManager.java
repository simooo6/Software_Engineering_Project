package it.unisa.diem.gruppo9.logic;

import it.unisa.diem.gruppo9.data.DataManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 * @file ContactManager.java
 * @brief This file contains the implementation of 'DataManager'.
 *
 * <p>
 * The {@code ContactManager} class provides a data structure 'contacts' that contains 0...* Contact.
 * This class provides methods to do all the operation on the data structure.
 * It implements the 'DataManager' interface to save and load contact data.
 * </p>
 *
 * @see Contact.java
 * @see DataManager.java
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */

public class ContactManager implements DataManager {

    /**
     * The {@code ObservableList} of contacts managed by this class
     */
    private ObservableList<Contact> contacts;

    /**
     * Adds a new contact in the {@code ObservableList}
     *
     * @param c The contact to be added in the data structure
     *
     * @invariant The name or surname of the contact must not be null.
     * @invariant The phoneNumber of the contact must not contain characters.
     *
     * @pre {@code c != null} The contact to be added must not be null.
     * @post The size of {@code contacts} is incremented by 1.
     * @post The added contact is included in the list.
     */
    public void addContacts(Contact c) {
    }

    /**
     * Delete an existing contact in the {@code ObservableList}
     *
     * @param c The contact to be deleted in the data structure
     *
     * @invariant {@code contacts != null}The ObservableList must not be null.
     *
     * @pre {@code c != null} The contact to be deleted must not be null.
     * @pre The contact to be deleted must exist in the list.
     * @post The size of {@code contacts} is decremented by 1.
     * @post The deleted contact is no longer in the list.
     */

    public void deleteContact(Contact c) {
    }

    /**
     * Edit an existing contact in the {@code ObservableList}
     *
     * @param c The contact to be edited in the data structure
     * @return  The edited contact
     *
     * @invariant {@code contacts != null}The ObservableList must not be null.
     *
     * @pre {@code c != null} The contact to be edited must not be null.
     * @pre The contact to be edited must exist in the list.
     * @post The specified contact's attributes are updated in the list.
     * @post The list size remains unchanged.
     */
    public Contact editContact(Contact c) {
    }

    /**
     * Search an existing contact in the {@code ObservableList}
     *
     * @param s The search substring to filter contacts
     * @return A FilteredList of contacts matching the search criteria
     *
     * @invariant {@code contacts != null}The ObservableList must not be null.
     *
     * @pre {@code s != null} The search string must not be null.
     * @pre The search string must contain only characters.
     * @post The returned list contains all and only the contacts that match {@code s}.
     */
    public FilteredList<Contact> searchContact(String s) {
    }

    /**
     * Creates a new contact with the specified details
     *
     * @param name The name of the contact
     * @param surname The surname of the contact
     * @param phoneNumber An array of phone numbers for the contact 
     * @param email An array of emails for the contact
     * @return The new contact created
     *
     * @pre {@code name != null || surname != null}.
     * @post The name and surname must not contain numbers.
     * @post The phoneNumber must not contain characters.
     * @post A new contact object is created with the given details.
     */
    public Contact createContact(String name, String surname, String[] phoneNumber, String[] email) {
    }


    /**
     * Save the current data structure in defined file.
     * This method represents the public contract between {@code DisplayContactsController} and {@code ContactManager}
     *
     * @pre {@code contacts != null} The contacts list must not be null.
     * @post The contacts data is successfully saved to the file.
     */
    @Override
    public void saveContact() {
    }

    /**
     * Load the current data structure from defined file.
     * This method represents the public contract between {@code PrimaryDisplayController} and {@code ContactManager}
     *
     *
     * @return The {@code ContactManager} object with loaded contacts
     *
     * @post The returned {@code ContactManager} contains the contacts data from the file.
     */
    @Override
    public ContactManager loadContact() {
    }

}