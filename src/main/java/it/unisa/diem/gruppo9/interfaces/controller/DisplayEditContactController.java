package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.interfaces.change.ChangeView;
import it.unisa.diem.gruppo9.logic.Contact;
import it.unisa.diem.gruppo9.logic.ContactManager;
import it.unisa.diem.gruppo9.logic.ContactManagerAware;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @file DisplayEditContactController.java
 * @brief The {@code DisplayEditContactController} the user interface for
 * editing an existing contact
 * <p>
 * The {@code DisplayEditContactController} provides the logic required to
 * enable the user to modify the datails of an existing contact via GUI
 * </p>
 *
 * <p>
 * This controller is designed to interact with an FXML user interface; it is
 * linked to an FXML file called "EditView.fxml" that is located in the
 * "it.unisa.diem.gruppo9.interfaces.view" package. The "@FXML" annotation can
 * bind the UI components to the methods of this class
 * </p>
 *
 * <p>
 * This controller extends {@code BaseController}
 * </p>
 *
 * <p>
 * The editing functionality involves uptading contact information such as:
 * name, surname,phoneNumber and email adresses; The controller also give the
 * user the opportunity to navigate back to the contac manager view using the
 * {@code ChangeView}.
 * </p>
 *
 * @note Input validation and error handling for editing contacts details will
 * be impelemented in future to ensure data integrity
 *
 * @see ChangeView.java
 * @see ContactManager.java
 * @see Contact.java
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */
public class DisplayEditContactController extends BaseController implements ContactManagerAware {

    /**
     * Manages the application's contact data
     */
    private ContactManager contacts;

    /**
     * Handles view transitions whitin the application
     */
    private ChangeView view;

    /**
     * Text field to modify the contact's name
     */
    @FXML
    private TextField nameField;

    /**
     * Text field to modify the contact's surname
     */
    @FXML
    private TextField surnameField;

    /**
     * Text field to modify or eventually add the contact's first phone number
     */
    @FXML
    private TextField phoneNumber1;

    /**
     * Text field to modify or eventually add the contact's second phone number
     */
    @FXML
    private TextField phoneNumber2;

    /**
     * Text field to modify or eventually add the contact's third phone number
     */
    @FXML
    private TextField phoneNumber3;

    /**
     * Text field to modify or eventually add the contact's first email
     */
    @FXML
    private TextField email1;

    /**
     * Text field to modify or eventually add the contact's second email
     */
    @FXML
    private TextField email2;

    /**
     * Text field to modify or eventually add the contact's third email
     */
    @FXML
    private TextField email3;

    /**
     * Button to confirm the intention of the user to modify the contact
     */
    @FXML
    private Button editButton;

    /**
     * Button to cancel the current operation and return to the previous view
     *
     * @see ChangeView.java
     */
    @FXML
    private Button cancelButton;

    public DisplayEditContactController(){
        view = new ChangeView();
    }

    public void initialize() {
        editButton.disableProperty().bind(nameField.textProperty().isEmpty().and(surnameField.textProperty().isEmpty()));
    }

    public void setField() {
        Contact c = getSelectedContact();
        surnameField.setText(c.getSurname());
        nameField.setText(c.getName());
        phoneNumber1.setText(c.getPhoneNumber()[0]);
        phoneNumber2.setText(c.getPhoneNumber()[1]);
        phoneNumber3.setText(c.getPhoneNumber()[2]);
        email1.setText(c.getEmail()[0]);
        email2.setText(c.getEmail()[1]);
        email3.setText(c.getEmail()[2]);
    }

    /**
     * Handles the action of editing the contact details when the "editButton"
     * is clicked
     *
     * @param event the Action Event triggered by the button click.
     */
    @FXML
    private void editContactButton(javafx.event.ActionEvent event) {
        ContactManager contacts = getContacts();
        Contact c = getSelectedContact();
        contacts.deleteContact(c);

        String[] phoneNumber = {
                phoneNumber1.getText().isEmpty() ? "-" : phoneNumber1.getText(),
                phoneNumber2.getText().isEmpty() ? "-" : phoneNumber2.getText(),
                phoneNumber3.getText().isEmpty() ? "-" : phoneNumber3.getText()
        };

        String[] email = {
                email1.getText().isEmpty() ? "-" : email1.getText(),
                email2.getText().isEmpty() ? "-" : email2.getText(),
                email3.getText().isEmpty() ? "-" : email3.getText()
        };

        // Aggiungi il contatto alla lista
        contacts.addContacts(contacts.createContact(surnameField.getText(),nameField.getText(), phoneNumber, email));

        // Passa alla vista dei contatti
        view.contactView(event, contacts);
    }

    /**
     * Handles the action of navigating back to the contact view
     *
     * @see ChangeView.java
     * @param event the Action Event triggered by the button click.
     */
    @FXML
    private void viewContactManagerButton(javafx.event.ActionEvent event) {
        ContactManager contacts = getContacts();
        this.view.contactView(event, contacts);
    }
}
