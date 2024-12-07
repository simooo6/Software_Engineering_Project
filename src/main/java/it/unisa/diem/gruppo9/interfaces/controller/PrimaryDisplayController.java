package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.interfaces.change.ChangeView;
import javafx.event.ActionEvent;
import it.unisa.diem.gruppo9.logic.ContactManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @file PrimaryDisplayController.java
 * @brief Controller for the primary display of the application.
 * 
 <p>
 * The {@code PrimaryDisplayController} class manages the main interface of the application
 * during its initial session. It is linked to the FXML file {@code PrimaryView.fxml}, 
 * which is located in the {@code it.unisa.diem.gruppo9.interfaces.view} package. This controller 
 * handles user interactions with the initial GUI scene and provides methods for navigating 
 * to other scenes.
 * </p>
 * 
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Manages the main application window displayed upon program startup.</li>
 *   <li>Handles user interaction via buttons to navigate to:
 *       <ul>
 *           <li>{@code ContactView.fxml} to visualize the contact list.</li>
 *           <li>{@code AddView.fxml} for adding new contacts.</li>
 *       </ul>
 *   </li>
 *   <li>Uses an instance of {@link ChangeView} to manage scene transitions.</li>
 * </ul>
 * 
 * <h2>Class Dependencies</h2>
 * <p>
 * This class works closely with:
 * <ul>
 *   <li>{@link ChangeView}: Handles FXML file transitions.</li>
 *   <li>{@link ContactManager}: Loads and manages the application's contact data.</li>
 *   <li>Controllers such as {@code DisplayContactsController} and {@code DisplayAddContactController} 
 *       for managing specific views.</li>
 * </ul>
 * </p>
 * 
 * <h2>Associated FXML Files</h2>
 * <ul>
 *   <li>{@code PrimaryView.fxml}: Initial GUI scene.</li>
 *   <li>{@code ContactView.fxml}: Contact list view managed by {@code DisplayContactsController}.</li>
 *   <li>{@code AddView.fxml}: Contact addition view managed by {@code DisplayAddContactController}.</li>
 * </ul>
 * 
 * @see ChangeView.java
 * @see DisplayContactsController.java
 * @see DisplayAddContactController.java
 * @see ContactManager.java
 * @see BaseController.java ????
 * 
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */

public class PrimaryDisplayController {

    /** 
     * The {@code ContactManager} instance used to manage the application's contact list. 
     * This object is initialized at runtime and allows the loading and handling of contact data.
     * This object may be setted to a specific {@code ContactManager} instace 
     * via {@link BaseController#setContacts(it.unisa.diem.gruppo9.logic.ContactManager)} ????
     */
    private ContactManager contacts = new ContactManager();
    
    /** 
     * The {@code ChangeView} instance used to handle scene transitions between different FXML files. 
     * This object encapsulates logic for navigating between {@code PrimaryView.fxml}, 
     * {@code ContactView.fxml}, and {@code AddView.fxml}.
     */
    private ChangeView view = new ChangeView();
    
    /** 
     * The label displaying the title of the primary view. 
     * This is automatically initialized via FXML.
     */
    @FXML
    private Label Title;
    
    /** 
     * The button that triggers navigation to the contact list view {@code ContactView.fxml}.
     */
    @FXML
    private Button myContacts;
    
    /** 
     * The button that triggers navigation to the contact addition view {@code AddView.fxml}.
     */
    @FXML
    private Button addContact;
    
    /**
     * Handles the event triggered when the "My Contacts" button is pressed.
     * <p>
     * This method performs the following actions:
     * <ul>
     *   <li>Loads the contact list using the {@link ContactManager#loadContact()} method.</li>
     *   <li>Switches the scene to {@code ContactView.fxml} using the 
     *   {@link ChangeView#contactView(javafx.event.ActionEvent, it.unisa.diem.gruppo9.logic.ContactManager) } method.</li>
     * </ul>
     * 
     * @param event the action event triggered by the button press.
     * 
     * @see ContactManager#loadContact()
     * @see ChangeView#contactView(javafx.event.ActionEvent, it.unisa.diem.gruppo9.logic.ContactManager) 
     */
    @FXML
    private void viewContactManagerButton(ActionEvent event) {
    }

    /**
     * Handles the event triggered when the "Add Contact" button is pressed.
     * <p>
     * This method performs the following actions:
     * <ul>
     *   <li>Loads the contact list using the {@link ContactManager#loadContact()} method.</li>
     *   <li>Switches the scene to {@code AddView.fxml} using the 
     *   {@link ChangeView#addContactView(javafx.event.ActionEvent, it.unisa.diem.gruppo9.logic.ContactManager)} method.</li>
     * </ul>
     * 
     * @param event the action event triggered by the button press.
     * 
     * @see ContactManager#loadContact() 
     * @see ChangeView#addContactView(javafx.event.ActionEvent, it.unisa.diem.gruppo9.logic.ContactManager)
     */
    @FXML
    private void viewAddContactButton(ActionEvent event) {
    }
    
}