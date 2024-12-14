package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.interfaces.change.ChangeView;
import it.unisa.diem.gruppo9.logic.Contact;
import it.unisa.diem.gruppo9.logic.ContactManager;
import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @file DisplayContactsController.java
 * @brief The {@code DisplayContactsController} manages the user interface for
 * displayingand managing the list of contacts.
 * <p>
 * The {@code DisplayContactsController} provides the logic for interacting with
 * the contact list via GUI. It is linked to an FXML file called
 * "ContactView.fxml" located in the "it.unisa.diem.gruppo9.interfaces.view"
 * package; the "@FXML" annotation can bind the UI components to the methods of
 * this class.
 * </p>
 *
 * <p>
 * The {@code DisplayContactsController} interacts with the 'ContactManager'
 * giving the user the possibility to: view, add, edit, delete, search for
 * contacts and save changes. The controller also give the user the possibility
 * to handle the navigation between different views in the application via
 * interaction with 'ChangeView'.
 * </p>
 *
 * <p>
 * @extends BaseController The {@code DisplayContactsController} extends the
 * {@code BaseController} class. {@code BaseController} gives the possibility to
 * interact with the same list used by all the other classes the
 * {@code BaseController} uses the {
 * @interface ContactManagerAware}
 * </p>
 *
 *
 * <p>
 * @implements Initializable The {@code Initializable} interface defines the
 * method {@code initialize} that is called automatically after the FXML file is
 * loaded.
 * </p>
 *
 * @see ChangeView.java
 * @see ContactManager.java
 * @see Contact.java to learn about obbligation on mandatory and optionals
 * contact's fields
 * @see BaseController
 * @see Initializable
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */
public class DisplayContactsController extends BaseController {

    /**
     * Handles view transitions whitin the application
     */
    private ChangeView view;

    /**
     * Button to save changes applied and to export it on a file
     */
    @FXML
    private Button saveButton;

    /**
     * Button to navigate to the Add Contact viw
     *
     * @see DisplayAddContactController.java
     */
    @FXML
    private Button addButton;

    /**
     * Button to navigate to the Edit Contact view
     *
     * @see DisplayEditContactView
     */
    @FXML
    private Button editButton;

    /**
     * Button to delete the selected contact
     */
    @FXML
    private Button deleteButton;

    /**
     * Button to perform a search for contacts, based on am input text
     */
    @FXML
    private Button searchButton;

    /**
     * Button to cancel the current search and the reset the contact list view
     */
    @FXML
    private Button cancelSearchButton;

    /**
     * Text fields to insert the search terms to filter contacts
     */
    @FXML
    private TextField searchTextField;

    /**
     * Table view for displaying the list of contacts
     */
    @FXML
    private TableView<Contact> tableView;

    /**
     * Column in the table view for displaying contact names
     */
    @FXML
    private TableColumn<Contact, String> nameColumn;

    /**
     * Column in the table view for displaying contact surnames
     */
    @FXML
    private TableColumn<Contact, String> surnameColumn;

    /**
     * Column in the table view for displaying contact phone numbers
     */
    @FXML
    private TableColumn<Contact, String> phoneNumberColumn;

    /**
     * Column in the table view for displaying contact emails
     */
    @FXML
    private TableColumn<Contact, String> emailColumn;

    /**
     * Initializes the controller class. It is called automatically after the
     * FXML file is loaded.
     *
     * Specifically it initialize the table view with a list of contact retrived
     * from the {@code ContactManager } object; configure the table view column
     * with their respective values, and initialize the binding property of the
     * button: search, cancel, edit and delete.
     *
     * @invariant the ContactManager instance must be not modified
     *
     * @pre The tableView and the buttons must be correctly associated with
     * their respective references in the controller
     * @pre the {@code getContact()} method must return a valid
     * {@code ContactManager} object
     * @pre The contact object retured by {@code getListOfContacts()} must
     * contains consistent values
     *
     * @post The table view must be correctly populated with the contacts
     * @post Contact's data must be correctly displayed
     * @post The button are enabled/disabled dinamically based on the binding
     * conditions
     *
     */
    public void initialize() {
        ContactManager contacts = getContacts();

        tableView.setItems(FXCollections.observableArrayList(contacts.getListOfContacts()));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        phoneNumberColumn.setCellValueFactory(cellData -> {
            String[] phoneNumberArray = cellData.getValue().getPhoneNumber();
            String phoneNumbers = String.join("\n", phoneNumberArray);
            return new SimpleStringProperty(phoneNumbers);
        });

        emailColumn.setCellValueFactory(cellData -> {
            String[] emailArray = cellData.getValue().getEmail();
            String emails = String.join("\n", emailArray);
            return new SimpleStringProperty(emails);
        });

        tableView.refresh();

        searchButton.disableProperty().bind(searchTextField.textProperty().isEmpty());
        cancelSearchButton.disableProperty().bind(searchTextField.textProperty().isEmpty());
        editButton.disableProperty().bind(tableView.getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disableProperty().bind(tableView.getSelectionModel().selectedItemProperty().isNull());
    }

    /**
     * @invariant The view object is always a valid instance of ChangeView.
     *
     * @pre The {@code ChangeView} class must be available in the project and
     * correctly defined.
     * @post The view object has been initialised and contains a valid
     * {@code ChangeView} instance.
     */
    public DisplayContactsController() {
        this.view = new ChangeView();
    }

    /**
     * Handles the action of saving changes on the contact list (for the export
     * of the contact list on file)
     *
     * @param event The Action Event triggered by clicking the save button
     */
    @FXML
    private void saveContactButton(javafx.event.ActionEvent event) throws IOException {
        ContactManager contacts = getContacts();
        contacts.saveContact();
    }

    /**
     * Handles the action of navigating to the "Add Contact" view
     *
     * @param event the Action Event triggere by clicking the button
     */
    @FXML
    private void viewAddContactButton(javafx.event.ActionEvent event) {
        ContactManager contacts = getContacts();
        tableView.setItems(contacts.getListOfContacts());
        view.addContactView(event, contacts);
    }

    /**
     * Handles the action of navigating to the "Edit Contact" view
     *
     * @param event the Action Event triggere by clicking the button
     */
    @FXML
    private void viewEditContactButton(javafx.event.ActionEvent event) {
        ContactManager contacts = getContacts();

        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            view.editContactView(event, contacts, selectedContact);
        }
    }

    /**
     * Handles the action of deleting the selected contact
     *
     * @param event the Action Event triggered by clicking the button
     */
    @FXML
    private void deleteContactButton(javafx.event.ActionEvent event) {
        ContactManager contacts = getContacts();
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            contacts.deleteContact(selectedContact);
            tableView.getItems().remove(selectedContact);
        }

        tableView.getSelectionModel().clearSelection();
    }

    /**
     * Handles the action of searching contacts based on an input text
     *
     * @param event the Action Event triggered by clicking the button
     */
    @FXML
    private void searchContactButton(javafx.event.ActionEvent event) {
        ContactManager contacts = getContacts();

        String searchText = searchTextField.getText();
        System.out.println(searchText);
        if (!searchText.isEmpty()) {
            // Ottieni i contatti filtrati
            ObservableList<Contact> filteredContacts = contacts.searchContact(searchText);

            // Aggiorna la TableView con i risultati
            tableView.setItems(filteredContacts);
        }
        searchTextField.setDisable(true);
    }

    /**
     * Handles the action of removing the current search and resetting the
     * contact list
     *
     * @param event the Action Event triggered by clicking the button
     */
    @FXML
    private void cancelSearchButton(javafx.event.ActionEvent event) {
        searchTextField.setDisable(false);
        searchTextField.setText("");
        this.initialize();
    }

}
