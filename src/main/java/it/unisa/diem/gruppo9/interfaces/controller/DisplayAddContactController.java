package it.unisa.diem.gruppo9.interfaces.controller;
import it.unisa.diem.gruppo9.interfaces.change.ChangeView;
import it.unisa.diem.gruppo9.logic.ContactManager;
import it.unisa.diem.gruppo9.logic.ContactManagerAware;
import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @file DisplayAddContactController.java
 * @brief The {@code DisplayAddContactController} manages the user interface for adding a new contact.
 * <p>
 * The {@code DisplayAddContactController} provides the logic required to enable the user to add a new contact via GUI.
 * It is linked to an FXML file called "AddView.fxml" located in the "it.unisa.diem.gruppo9.interfaces.view" package; the "@FXML" annotation can bind the UI components
 * to the methods of this class.
 * </p>
 * <p>
 * The {@code DisplayAddContactController} includes the functionality to add a new contact using the {@code ContactManager} class
 * and also to navigate back to the contact manager view using the {@code ChangeView}
 * </p>
 * 
 * <p>
 * The {@code DisplayAddContactController} extends the {@code BaseController} class. 
 * {@code BaseController} gives the possibility to interact with the same list used by all the
 * other classes  the {@code BaseController} uses the {@interface ContactManagerAware}
 * </p>
 * 
 * @see ContactManagerAware
 * @see BaseController
 * @see ChangeView.java
 * @see ContactManager.java
 * @see Contact.java to learn about obbligation on mandatory and optionals contact's fields
 * 
 * @author gruppo9 
 * @version 1.0
 * @date 2024-12-07
 */
public class DisplayAddContactController extends BaseController{

    /**Handles view transitions whitin the application*/
    private ChangeView view = new ChangeView();

    /**Manages the application's contact data*/
    private ContactManager contacts;
    
    
    /**Text field to enter the contact's name*/
    @FXML
    private TextField nameField;
    
    /**Text field to enter the contact's surname*/
    @FXML
    private TextField surnnameField;
    
    /**Text field to enter the contact's first phone number,*/
    @FXML
    private TextField phoneNumber1;
    
    /**Text field to enter the contact's second phone number*/
    @FXML
    private TextField phoneNumber2;
    
    /**Text field to enter the contact's third phone number*/
    @FXML
    private TextField phoneNumber3;
    
    /**Text field to enter the contact's first email*/
    @FXML
    private TextField email1;
    
    /**Text field to enter the contact's second email*/
    @FXML
    private TextField email2;
    
    /**Text field to enter the contact's third email*/
    @FXML
    private TextField email3;
    
    /**Button to confirm the intention of adding a new contact*/
    @FXML
    private Button addButton;
    
    /**Button to cancel the current operation and return to the previous view
     * @see ChangeView.java
     */
    @FXML
    private Button cancelButton;  

    /**FXML methods:*/
    
    /**Handles the action of adding a new contact when the "addButton" is clicked
     * @param event the Action Event triggered by the button click.
     */
    @FXML
    private void addContactButton(javafx.event.ActionEvent event) {
    }

    /**Handles the action of navigating back to the contact view
     * @see ChangeView.java
     * @param event the Action Event triggered by the button click.
     */
    @FXML
    private void viewContactManagerButton(javafx.event.ActionEvent event) {
    }


}