package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.interfaces.change.ChangeView;
import it.unisa.diem.gruppo9.logic.ContactManager;
import it.unisa.diem.gruppo9.logic.ContactManagerAware;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * @file DisplayAddContactController.java
 * @brief The {@code DisplayAddContactController} manages the user interface for
 * adding a new contact.
 * <p>
 * The {@code DisplayAddContactController} provides the logic required to enable
 * the user to add a new contact via GUI. It is linked to an FXML file called
 * "AddView.fxml" located in the "it.unisa.diem.gruppo9.interfaces.view"
 * package; the "@FXML" annotation can bind the UI components to the methods of
 * this class.
 * </p>
 * <p>
 * The {@code DisplayAddContactController} includes the functionality to add a
 * new contact using the {@code ContactManager} class and also to navigate back
 * to the contact manager view using the {@code ChangeView}
 * </p>
 *
 * <p>
 * The {@code DisplayAddContactController} extends the {@code BaseController}
 * class. {@code BaseController} gives the possibility to interact with the same
 * list used by all the other classes the {@code BaseController} uses the {
 * @interface ContactManagerAware}
 * </p>
 *
 * @see ContactManagerAware
 * @see BaseController
 * @see ChangeView.java
 * @see ContactManager.java
 * @see Contact.java to learn about obbligation on mandatory and optionals
 * contact's fields
 *
 * @author gruppo9
 * @version 2.1
 * @date 2024-12-07
 */
public class DisplayAddContactController extends BaseController {

    /**
     * Handles view transitions whitin the application
     */
    private ChangeView view = new ChangeView();

    /**
     * Text field to enter the contact's name
     */
    @FXML
    private TextField nameField;

    /**
     * Text field to enter the contact's surname
     */
    @FXML
    private TextField surnameField;

    /**
     * Text field to enter the contact's first phone number,
     */
    @FXML
    private TextField phoneNumber1;

    /**
     * Text field to enter the contact's second phone number
     */
    @FXML
    private TextField phoneNumber2;

    /**
     * Text field to enter the contact's third phone number
     */
    @FXML
    private TextField phoneNumber3;

    /**
     * Text field to enter the contact's first email
     */
    @FXML
    private TextField email1;

    /**
     * Text field to enter the contact's second email
     */
    @FXML
    private TextField email2;

    /**
     * Text field to enter the contact's third email
     */
    @FXML
    private TextField email3;

    /**
     * Button to confirm the intention of adding a new contact
     */
    @FXML
    private Button addButton;

    /**
     * Button to cancel the current operation and return to the previous view
     *
     * @see ChangeView.java
     */
    @FXML
    private Button cancelButton;

    /**
     * Handles the back end binding of the addButton. The addButton will be
     * deatcivated till almost one between name and surname is not empty.
     * 
     * @invariant {@code addButton}, {@code nameField},{@code surnameField} must
     * remain valid and not null for the duration of the binding
     * @invariant The condition for the binding always evaluates to a valid
     * boolen value (true or false), wich dirrectly affects the
     * {@code disableProperty}
     * 
     * @pre {@code addButton}, {@code nameField},{@code surnameField} must be
     * properly initialized and cannot be null
     * @pre {@code namefield.textProperty()} and
     * {@code surnameField.textProperty()} must be properly observable to allow
     * the binding to work
     * @post The {@code addButton} will be disabled whenever both name and
     * surname field are empty
     * @post The {@code addButton} will be enabled as soon as at least one
     * between name and surname field is not empty
     * @post Texfields {@code phoneNumber1},{@code phoneNumber2},{@code phoneNumber3} must only contain numbers or are empty.  
     */
    public void initialize() {
        addButton.disableProperty().bind(nameField.textProperty().isEmpty().and(surnameField.textProperty().isEmpty()));
        phoneNumber1.setTextFormatter(new TextFormatter<>(change -> 
        (change.getControlNewText().matches("\\d*")) ? change : null
        ));
        phoneNumber2.setTextFormatter(new TextFormatter<>(change -> 
        (change.getControlNewText().matches("\\d*")) ? change : null
        ));
        phoneNumber3.setTextFormatter(new TextFormatter<>(change -> 
        (change.getControlNewText().matches("\\d*")) ? change : null
        ));
    }

    /**
     * Handles the action of adding a new contact when the "addButton" is
     * clicked
     *
     * @param event the Action Event triggered by the button click.
     */
    @FXML
    private void addContactButton(javafx.event.ActionEvent event) {
        ContactManager contacts = getContacts();
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

        contacts.addContacts(contacts.createContact(surnameField.getText(), nameField.getText(), phoneNumber, email));

        this.view.contactView(event, contacts);
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
