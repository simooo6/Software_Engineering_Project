package it.unisa.diem.gruppo9.interfaces.change;

import it.unisa.diem.gruppo9.interfaces.controller.DisplayAddContactController;
import it.unisa.diem.gruppo9.interfaces.controller.DisplayContactsController;
import it.unisa.diem.gruppo9.interfaces.controller.DisplayEditContactController;
import it.unisa.diem.gruppo9.logic.Contact;
import javafx.event.ActionEvent;
import it.unisa.diem.gruppo9.logic.ContactManager;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * @file ChangeView.java
 * @brief Manages scene transitions in the application.
 *
 * <p>
 * The {@code ChangeView} class is responsible for switching between different
 * FXML scenes based on user interactions, such as button clicks in the GUI. It
 * provides methods to manage transitions between specific views, enabling
 * seamless navigation within the application.
 * </p>
 *
 * <h2>Responsibilities</h2>
 * <ul>
 * <li>Handles scene changes triggered by button events in the application's
 * GUI.</li>
 * <li>Works closely with controllers to manage navigation between views.</li>
 * <li>Ensures consistent transitions between the following FXML files:
 * <ul>
 * <li>{@code ContactView.fxml}</li>
 * <li>{@code AddView.fxml}</li>
 * <li>{@code EditView.fxml}</li>
 * </ul>
 * </li>
 * </ul>
 *
 * <h2>Usage</h2>
 * <p>
 * The {@code ChangeView} class is utilized by the following controllers in the
 * {@code it.unisa.diem.gruppo9.interfaces.controller} package:
 * <ul>
 * <li>{@code PrimaryDisplayController}</li>
 * <li>{@code DisplayContactsController}</li>
 * <li>{@code DisplayAddContactController}</li>
 * <li>{@code DisplayEditContactController}</li>
 * </ul>
 * Each controller calls the appropriate method in {@code ChangeView} to handle
 * the transition to the desired scene.
 * </p>
 *
 * <h2>Scene Transitions</h2>
 * <p>
 * Each method in this class is responsible for transitioning to a specific
 * view:
 * <ul>
 * <li>{@code contactView}: Called by all controllers listed above to navigate
 * to {@code ContactView.fxml}.</li>
 * <li>{@code addContactView}: Called by all controllers listed above to
 * navigate to {@code AddView.fxml}.</li>
 * <li>{@code editContactView}: Exclusively called by
 * {@code DisplayContactsController} to navigate to {@code EditView.fxml}.</li>
 * </ul>
 * </p>
 *
 * @see DisplayContactsController.java
 * @see DisplayAddContactController.java
 * @see DisplayEditContactController.java
 * @see PrimaryDisplayController.java
 * @see ContactManager.java
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */
public class ChangeView {

    /**
     * Constructs a new instance of {@code ChangeView}.
     * <p>
     * This constructor initializes the object but does not perform any specific
     * setup. The methods provided in this class are used dynamically during
     * runtime by the controllers.
     * </p>
     * @pre -
     * @post a valid instance of {@code ChangeView} has been created
     * @inv the {@code ChangeView} object is ready to be used with the defined public methods.
     */
    public ChangeView() {
    }

    /**
     * Transitions to the {@code ContactView.fxml} scene.
     * <p>
     * This method switches the current scene to the {@code ContactView.fxml}
     * file. It is called by the following controllers when user interactions
     * (e.g., button clicks) require navigation to the contact list:
     * <ul>
     * <li>{@code PrimaryDisplayController}</li>
     * <li>{@code DisplayContactsController}</li>
     * <li>{@code DisplayAddContactController}</li>
     * <li>{@code DisplayEditContactController}</li>
     * </ul>
     * </p>
     *
     * @param event the action event that triggered the scene change.
     * @param contacts the {@link ContactManager} instance used to manage
     * contact data.
     *
     * @invariant The ContactManager instance must be unchanged during the
     * transition
     *
     * @pre {@code event != null} The action event must not be null.
     * @pre {@code contacts != null} The contact manager instance must not be
     * null.
     * @pre the file {@code ContactsView.fxml} must exisist and be accesibile
     * @pre the {@code ContactManger} must contain valid {@code Contact}
     * 
     * @post the current scene is replaced with {@code ContactView.fxml}.
     * @post an instance of {@code DisplayContactsController} has been initialised
     * @post the method setContact as called on the controller and the contacts object was passed correctly
     * @post the initialize() method of the controller was invoked correctly.
     */
    public void contactView(ActionEvent event, ContactManager contacts) {
        try {
            // Carica la nuova vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/diem/gruppo9/interfaces/view/ContactsView.fxml"));
            Parent newView = loader.load();

            // Recupera la scena corrente dal nodo che ha generato l'evento
            Scene currentScene = ((javafx.scene.Node) event.getSource()).getScene();

            // Imposta il nuovo root
            currentScene.setRoot(newView);

            // Passa i dati al nuovo controller
            DisplayContactsController controller = loader.getController();
            controller.setContacts(contacts);
            controller.initialize();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     * Transitions to the {@code AddView.fxml} scene.
     * <p>
     * This method switches the current scene to the {@code AddView.fxml} file.
     * It is called by the following controllers when user interactions require
     * navigation to the "Add Contact" view:
     * <ul>
     * <li>{@code PrimaryDisplayController}</li>
     * <li>{@code DisplayContactsController}</li>
     * <li>{@code DisplayAddContactController}</li>
     * <li>{@code DisplayEditContactController}</li>
     * </ul>
     * </p>
     *
     * @param event the action event that triggered the scene change.
     * @param contacts the {@link ContactManager} instance used to manage
     * contact data.
     *
     * @invariant The ContactManager instance must be unchanged during the
     * transition
     *
     * @pre {@code event != null} The action event triggering the scene change
     * must not be null.
     * @pre {@code contacts != null} The ContactManager must not be null.
     * @pre the file {@code ContactsView.fxml} must exisist and be accesibile
     * @pre the {@code ContactManger} must contain valid {@code Contact}
     * 
     * @post The current scene is replaced with {@code AddView.fxml}.
     * @post an instance of {@code DisplayAddContactController} has been initialised
     * @post the method setContact as called on the controller and the contacts object was passed correctly
     */
    public void addContactView(ActionEvent event, ContactManager contacts) {
        try {
            // Carica la nuova vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/diem/gruppo9/interfaces/view/AddView.fxml"));
            Parent newView = loader.load();

            // Recupera la scena corrente dal nodo che ha generato l'evento
            Scene currentScene = ((javafx.scene.Node) event.getSource()).getScene();

            // Imposta il nuovo root
            currentScene.setRoot(newView);

            // Passa i dati al nuovo controller
            DisplayAddContactController controller = loader.getController();
            controller.setContacts(contacts);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     * Transitions to the {@code EditView.fxml} scene.
     * <p>
     * This method switches the current scene to the {@code EditView.fxml} file.
     * It is called exclusively by {@code DisplayContactsController} when user
     * interactions require navigation to the "Edit Contact" view.
     * </p>
     *
     * @param event the action event that triggered the scene change.
     * @param contacts the {@link ContactManager} instance used to manage
     * contact data.
     * @param c the {@link Contact} that is selected in the {@code DisplayContactsView}
     *
     * @invariant the {@code ContactManager} instance must be unchanged during the
     * transition
     * @invariant the
     * @invariant the {@code Contact} is not changed during the transition.
     *
     * @pre {@code event != null} The action event must not be null.
     * @pre {@code contacts != null} The contact manager instance must not be
     * null
     * @pre {code c != null} the selected contact must not be null
     * @pre the file {@code ContactsView.fxml} must exisist and be accesibile
     * @pre the {@code ContactManger} must contain valid {@code Contact}
     * @pre the {code Contact} c must be a valid object 
     * 
     * @post The current scene is replaced with {@code EditView.fxml}.
     * @post an instance of {@code DisplayEditContactController} has been initialised
     * @post the method setContact as called on the controller and the contacts object was passed correctly
     * @post the method setSelectedContact as called on the controller and the contact object was passed correctly
     * @post the setFiled() method of the controller was invoked correctly.
     * 
     */
    public void editContactView(ActionEvent event, ContactManager contacts,Contact c) {
        try {
            // Carica la nuova vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/diem/gruppo9/interfaces/view/EditView.fxml"));
            Parent newView = loader.load();

            // Recupera la scena corrente dal nodo che ha generato l'evento
            Scene currentScene = ((javafx.scene.Node) event.getSource()).getScene();

            // Imposta il nuovo root
            currentScene.setRoot(newView);

            // Passa i dati al nuovo controller
            DisplayEditContactController controller = loader.getController();
            controller.setContacts(contacts);
            controller.setSelectedContact(c);
            controller.setField();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
