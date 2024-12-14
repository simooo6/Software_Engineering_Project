package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.interfaces.change.ChangeView;
import javafx.event.ActionEvent;
import it.unisa.diem.gruppo9.logic.ContactManager;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @file PrimaryDisplayController.java
 * @brief Controller for the primary display of the application.
 *
 * <p>
 * The {@code PrimaryDisplayController} class manages the main interface of the
 * application during its initial session. It is linked to the FXML file
 * {@code PrimaryView.fxml}, which is located in the
 * {@code it.unisa.diem.gruppo9.interfaces.view} package. This controller
 * handles user interactions with the initial GUI scene and provides methods for
 * navigating to other scenes.
 * </p>
 *
 * <h2>Responsibilities</h2>
 * <ul>
 * <li>Manages the main application window displayed upon program startup.</li>
 * <li>Handles user interaction via buttons to navigate to:
 * <ul>
 * <li>{@code ContactView.fxml} to visualize the contact list.</li>
 * <li>{@code AddView.fxml} for adding new contacts.</li>
 * </ul>
 * </li>
 * <li>Uses an instance of {@link ChangeView} to manage scene transitions.</li>
 * </ul>
 *
 * <h2>Class Dependencies</h2>
 * <p>
 * This class works closely with:
 * <ul>
 * <li>{@link ChangeView}: Handles FXML file transitions.</li>
 * <li>{@link ContactManager}: Loads and manages the application's contact
 * data.</li>
 * <li>Controllers such as {@code DisplayContactsController} and
 * {@code DisplayAddContactController} for managing specific views.</li>
 * </ul>
 * </p>
 *
 * <h2>Associated FXML Files</h2>
 * <ul>
 * <li>{@code PrimaryView.fxml}: Initial GUI scene.</li>
 * <li>{@code ContactView.fxml}: Contact list view managed by
 * {@code DisplayContactsController}.</li>
 * <li>{@code AddView.fxml}: Contact addition view managed by
 * {@code DisplayAddContactController}.</li>
 * </ul>
 *
 * @see ChangeView
 * @see DisplayContactsController
 * @see DisplayAddContactController
 * @see ContactManager
 *
 * @author gruppo9
 * @version 2.0
 * @date 2024-12-06
 */
public class PrimaryDisplayController extends BaseController {

    /**
     * The {@code ChangeView} instance used to handle scene transitions between
     * different FXML files. This object encapsulates logic for navigating
     * between {@code PrimaryView.fxml}, {@code ContactView.fxml}, and
     * {@code AddView.fxml}.
     */
    private ChangeView view;
    /**
     * The label displaying the title of the primary view. This is automatically
     * initialized via FXML.
     */
    @FXML
    private Label Title;

    /**
     * The button that triggers navigation to the contact list view
     * {@code ContactView.fxml}.
     */
    @FXML
    private Button myContacts;

    /**
     * The button that triggers navigation to the contact addition view
     * {@code AddView.fxml}.
     */
    @FXML
    private Button addContact;

    /**
     * Constructs an instance of the {@code PrimaryDisplayController}.
     * <p>
     * This constructor initializes the {@code ChangeView} instance used for
     * managing view transitions.
     * </p>
     *
     * @invariant The view object is declared as a {@code ChangeView}.
     *
     * @pre The {@code ChangeView} class must be available in the project and
     * correctly defined.
     * @post A new instance of {@code PrimaryDisplayController} is created with
     * a valid {@code ChangeView} object.
     */
    public PrimaryDisplayController() {
        this.view = new ChangeView();
    }

    /**
     * Handles the event triggered when the "My Contacts" button is pressed.
     * <p>
     * This method performs the following actions:
     * <ul>
     * <li>Loads the contact list using the {@link ContactManager#loadContact()}
     * method.</li>
     * <li>Switches the scene to {@code ContactView.fxml} using the
     * {@link ChangeView#contactView(ActionEvent, ContactManager)} method.</li>
     * </ul>
     *
     * @param event the action event triggered by the button press.
     *
     * @see ContactManager#loadContact()
     * @see ChangeView#contactView(ActionEvent, ContactManager)
     */
    @FXML
    private void viewContactManagerButton(ActionEvent event) throws IOException {
        ContactManager contacts = getContacts();
        contacts.loadContact();
        view.contactView(event, contacts);
    }

    /**
     * Handles the event triggered when the "Add Contact" button is pressed.
     * <p>
     * This method performs the following actions:
     * <ul>
     * <li>Loads the contact list using the {@link ContactManager#loadContact()}
     * method.</li>
     * <li>Switches the scene to {@code AddView.fxml} using the
     * {@link ChangeView#addContactView(ActionEvent, ContactManager)}
     * method.</li>
     * </ul>
     *
     * @param event the action event triggered by the button press.
     * @see ContactManager#loadContact()
     * @see ChangeView#addContactView(ActionEvent, ContactManager)
     */
    @FXML
    private void viewAddContactButton(ActionEvent event) throws IOException {
        ContactManager contacts = getContacts();
        contacts.loadContact();
        view.addContactView(event, contacts);
    }

}
