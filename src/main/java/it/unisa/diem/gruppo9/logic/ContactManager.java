package it.unisa.diem.gruppo9.logic;

import it.unisa.diem.gruppo9.data.DataManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @file ContactManager.java
 * @brief This file contains the implementation of 'DataManager'.
 *
 * <p>
 * The {@code ContactManager} class provides a data structure 'contacts' that
 * contains 0...* Contact. This class provides methods to do all the operation
 * on the data structure. It implements the 'DataManager' interface to save and
 * load contact data.
 * </p>
 *
 * @see Contact.java
 * @see DataManager.java
 *
 * @author gruppo9
 * @version 2.0
 * @date 2024-12-07
 */
public class ContactManager implements DataManager {

    /**
     * The {@code ObservableList} of contacts managed by this class
     */
    private ObservableList<Contact> contacts;

    /**
     * Creates a new {@code ContactManager}.
     *
     * @pre An instance of {@code ContactManager} has been declared and not yet
     * initialized
     *
     * @post A new {@code ContactManager} object is created.
     * @post A new {@code ObservableList} instance is created
     */
    public ContactManager() {
        contacts = FXCollections.observableArrayList();
    }

    /**
     * Adds a new contact in the {@code ObservableList}
     *
     * @invariant The {@code Contact} object that the method uses must not be
     * null
     *
     * @pre The {@code Contact} object must be a valid contact. In this sense it
     * must respect all the costraints that are upon the {@code Contact} class
     *
     * @post The size of {@code contacts} is incremented by 1.
     * @post The added contact is included in the list.
     * @post The contact list is sorted in coherence with an instance of
     * {@link NameAndSurnameComparator}.
     *
     * @param c The contact to be added in the data structure
     */
    public void addContacts(Contact c) {
        if (c != null) {
            contacts.add(c);
        }

        this.sortList(new NameAndSurnameComparator());
    }

    /**
     * Delete an existing contact in the {@code ObservableList}
     *
     * @invariant The {@code contacts} list must not be null and must contain
     * valid {@code Contact} objects.
     *
     * @pre {@code c != null} The contact to be deleted must not be null.
     * @pre The contact to be deleted must exist in the list.
     *
     * @post The size of {@code contacts} is decremented by 1.
     * @post The deleted contact is no longer in the list.
     *
     * @param c The contact to be deleted in the data structure
     *
     * @throws NullPointerException if the invariant (!null ObservableList) is
     * not respected
     */
    public void deleteContact(Contact c) {
        if (contacts == null) {
            throw new NullPointerException("Error");
        }
        if (contacts.contains(c)) {
            contacts.remove(c);
        }
        this.sortList(new NameAndSurnameComparator());
    }

    /**
     * Search an existing contact in the {@code ObservableList}
     *
     * @invariant The {@code contacts} list must not be null and must contain
     * valid {@code Contact} objects.
     *
     * @pre {@code s != null} The search string must not be null.
     * @pre The search string must contain only characters.
     *
     * @post The returned list contains all and only the contacts that match
     * {@code s}.
     *
     * @param s The search substring to filter contacts
     *
     * @return A FilteredList of contacts matching the search criteria
     *
     * @throws NullPointerException if the invariant (!null ObservableList) is
     * not respected
     */
    public ObservableList<Contact> searchContact(String s) {

        if (contacts == null) {
            throw new NullPointerException("Error");
        }

        ObservableList<Contact> filtrata = FXCollections.observableArrayList();

        for (Contact c : this.contacts) {
            if (c.getName().startsWith(s) || c.getSurname().startsWith(s)) {
                filtrata.add(c);
            }
        }
        filtrata.sort(new NameAndSurnameComparator());
        return filtrata;
    }

    /**
     * Creates a new contact with the specified details
     *
     * @invariant
     * {@link Contact#Contact(java.lang.String, java.lang.String, java.lang.String[], java.lang.String[])}
     *
     * @pre
     * {@link Contact#Contact(java.lang.String, java.lang.String, java.lang.String[], java.lang.String[])}
     * @post
     * {@link Contact#Contact(java.lang.String, java.lang.String, java.lang.String[], java.lang.String[])}
     *
     * @param name The name of the contact
     * @param surname The surname of the contact
     * @param phoneNumber An array of phone numbers for the contact
     * @param email An array of emails for the contact
     *
     * @return The new contact created
     *
     */
    public Contact createContact(String surname, String name, String[] phoneNumber, String[] email) {
        return new Contact(surname, name, phoneNumber, email);
    }

    /**
     * Sorts the {@code ObservableList} of contacts using the specified
     * {@code Comparator}. Reorders the contacts in the internal
     * {@code ObservableList} according to the order defined by the provided
     * {@code Comparator}. By default, the {@code NameAndSurnameComparator} is
     * used to sort the list by name and surname in lexicographic order.
     *
     *
     * @invariant The {@code contacts} list must not be null and must contain
     * valid {@code Contact} objects.
     *
     * @pre The {@code Comparator} parameter must not be null.
     * @pre The {@code contacts} list must be properly initialized.
     *
     * @post The {@code contacts} list is sorted in accordance with the logic
     * defined in the provided {@code Comparator}.
     * @post The size and content of the {@code contacts} list remain unchanged,
     * apart from their order.
     * @post The fields of the {@code Contact} objects in the list must not be
     * modified during sorting.
     *
     * @param c the {@code Comparator} used to determine the order of the
     * {@code Contact} objects.
     *
     * @throws NullPointerException if the provided {@code Comparator} is null.
     */
    public void sortList(Comparator<Contact> c) {
        contacts.sort(c);
    }

    /**
     * Retrieves the current {@code ObservableList} of contacts.
     *
     * @invariant The {@code contacts} list must not be null and must contain
     * valid {@code Contact} objects.
     *
     * @pre The {@code contacts} list must be properly initialized.
     *
     * @post The returned list contains all and only the {@code Contact} objects
     * currently managed by the {@code ContactManager}.
     *
     * @return the current {@code ObservableList} of contacts managed by the
     * {@code ContactManager}.
     */
    public ObservableList<Contact> getListOfContacts() {
        return this.contacts;
    }

    /**
     * Saves the current data structure to a defined file.
     * <p>
     * This method writes the contacts data managed by {@code ContactManager} to
     * a CSV file named "rubrica.csv". It ensures that all contacts in the
     * {@code contacts} list are serialized into a structured format. Each
     * contact is represented as a row with fields separated by semicolons.
     * </p>
     *
     * @invariant The {@code contacts} list must not be null and must contain
     * only valid {@code Contact} objects.
     * @invariant Each {@code Contact} object in the list must have valid
     * attributes, adhering to the class constraints.
     *
     * @pre {@code contacts != null} The contacts list must be properly
     * initialized.
     *
     * @post All entries in the {@code contacts} list are successfully written
     * to the file.
     * @post The file "rubrica.csv" is created or overwritten with the current
     * contacts data.
     *
     * @throws IOException if an error occurs during file writing.
     */
    @Override
    public void saveContact() throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rubrica.csv")))) {
            pw.println("Surname;Name;Phone1;Phone2;Phone3;Email1;Email2;Email3");
            for (Contact c : contacts) {
                pw.print(c);
            }
        }
    }

    /**
     * Loads the data structure from a defined file.
     * <p>
     * This method reads the contacts data from a CSV file named "rubrica.csv"
     * and populates the {@code contacts} list. Each row in the file represents
     * a contact, with fields separated by semicolons. If the file is empty, the
     * {@code ContactManager} remains unchanged.
     * </p>
     *
     * @invariant The {@code contacts} list must not contain invalid or null
     * {@code Contact} objects after the method execution.
     * @invariant The file "rubrica.csv" must follow the expected format: each
     * row must contain exactly 8 fields, corresponding to surname, name, three
     * phone numbers, and three emails.
     *
     * @post The {@code contacts} list contains all valid {@code Contact}
     * objects read from the file.
     * @post The method does not modify the existing data structure if the file
     * is empty.
     *
     * @return The {@code ContactManager} object with the updated contacts list.
     *
     * @throws FileNotFoundException if the file "rubrica.csv" does not exist.
     * @throws IOException if an error occurs during file reading.
     */
    @Override
    public ContactManager loadContact() throws FileNotFoundException, IOException {
        String filename = "rubrica.csv";
        String nome = filename.split("\\n")[0]; //utilizzo il metodo escape 

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            if (br.readLine() == null) {
                return this;
            }
            String line;
            while ((line = br.readLine()) != null) {
                String fields[] = line.split(";");
                Contact c = this.createContact(fields[0], fields[1],
                        new String[]{fields[2], fields[3], fields[4]},
                        new String[]{fields[5], fields[6], fields[7]});

                this.addContacts(c);
            }
        }

        return this;
    }

}
