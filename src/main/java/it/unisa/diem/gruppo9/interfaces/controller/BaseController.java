package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.logic.Contact;
import it.unisa.diem.gruppo9.logic.ContactManager;
import it.unisa.diem.gruppo9.logic.ContactManagerAware;
import it.unisa.diem.gruppo9.logic.ContactAware;

/**
 * @file BaseController.java
 * @brief Base class for controllers that manage contact-related functionality and interact with the GUI.
 *
 * <p>
 * The {@code BaseController} class provides a foundational implementation for controllers
 * in the {@code it.unisa.diem.gruppo9.interfaces.controller} package. It implements the
 * {@code ContactManagerAware} and {@code ContactAware} interfaces, allowing interaction with both
 * the contact management logic and the selected contact within the GUI.
 * </p>
 *
 * <h2>Role and Responsibilities</h2>
 * <p>
 * As part of its responsibilities, the {@code BaseController} class:
 * <ul>
 *   <li>Implements the {@link ContactManagerAware} interface to manage a shared instance of
 *       {@link ContactManager}, ensuring access to the contact list for all subclasses.</li>
 *   <li>Implements the {@link ContactAware} interface to handle the currently selected
 *       {@link Contact} instance in the GUI, facilitating operations such as editing and displaying contact details.</li>
 *   <li>Acts as a bridge between the core contact management logic and GUI controllers
 *       such as {@code DisplayEditContactController}, {@code DisplayContactsController},
 *       and {@code DisplayAddContactController}, ensuring consistent access to contacts.</li>
 * </ul>
 * </p>
 *
 * <h2>Interactions with the System</h2>
 * <ul>
 *   <li><b>Through {@link ContactManagerAware}:</b>
 *       The {@code BaseController} interacts with the {@code ContactManager} to provide
 *       subclasses access to contact-related operations, such as retrieving the contact list
 *       and performing CRUD operations. This is achieved by dynamically injecting a
 *       {@code ContactManager} instance via the {@link BaseController#setContacts(it.unisa.diem.gruppo9.logic.ContactManager)} method.</li>
 *   <li><b>Through {@code ContactAware}:</b>
 *       The {@code BaseController} provides mechanisms to set and retrieve the currently
 *       selected {@code Contact} instance in the GUI. This enables the GUI to display or edit
 *       the details of the selected contact.</li>
 * </ul>
 *
 * <h2>Usage</h2>
 * <p>
 * Subclasses of {@code BaseController}, such as {@code DisplayEditContactController},
 * {@code DisplayContactsController}, and {@code DisplayAddContactController}, inherit
 * the implementations of the methods from both interfaces and gain access to the shared
 * {@code contacts} and {@code selectedContact} fields. These subclasses can utilize
 * these functionalities to implement their specific behavior while maintaining a consistent
 * interface with the rest of the system.
 * </p>
 *
 * @see Contact.java
 * @see ContactManager.java
 * @see ContactManagerAware.java
 * @see ContactAware.java
 * @see DisplayEditContactController.java
 * @see DisplayContactsController.java
 * @see DisplayAddContactController.java
 * @see ChangeView.java
 *
 * @author gruppo9
 * @version 1.1
 * @since 2024-12-12
 */
public class BaseController implements ContactManagerAware, ContactAware {

    /**
     * The {@code ContactManager} instance used to manage contact data.
     * <p>
     * This protected field is set via the {@link BaseController#setContacts(it.unisa.diem.gruppo9.logic.ContactManager)} method and
     * provides access to the contact management functionality for subclasses.
     * </p>
     */
    ContactManager contacts = new ContactManager();

    /**
     * The currently selected {@link Contact} instance in the GUI.
     * <p>
     * This field is managed via the {@link BaseController#setSelectedContact(it.unisa.diem.gruppo9.logic.Contact)} and
     * {@link BaseController#getSelectedContact()} methods, as defined by the {@code ContactAware} interface.
     * </p>
     */
    Contact selectedContact;

    /**
     * Sets the {@code ContactManager} instance for the controller.
     * <p>
     * This method implements the {@link ContactManagerAware#setContacts(it.unisa.diem.gruppo9.logic.ContactManager)}
     * interface. It allows dynamic injection of a {@code ContactManager} instance, which is
     * stored in the {@code contacts} field. This instance can then be utilized by subclasses
     * to perform contact management operations, ensuring a consistent interaction with
     * the {@code ContactManager}.
     * </p>
     *
     * <p>
     * This method also represents the public contract between the interface logic and
     * the controller layer, facilitating communication between an instance of
     * {@code ChangeView} and the system controllers like {@code DisplayEditContactController},
     * {@code DisplayContactsController}, and {@code DisplayAddContactController}.
     * </p>
     *
     * @invariant {@link ContactManagerAware#setContacts(it.unisa.diem.gruppo9.logic.ContactManager)}
     *
     * @pre The {@code contacts} parameter must not be {@code null}.
     * @pre The {@code contacts} parameter must be a valid instance of {@code ContactManager}.
     * @post The {@code contacts} field is set to the provided parameter and is accessible by subclasses.
     *
     * @param contacts the {@code ContactManager} instance to be associated with the controller.
     */
    @Override
    public void setContacts(ContactManager contacts) {
        this.contacts = contacts;
    }

    /**
     * Returns the {@code ContactManager} instance associated with the controller.
     * <p>
     * This method implements the {@link ContactManagerAware#getContacts()} interface and
     * provides access to the {@code ContactManager} instance that has been previously
     * set using {@code setContacts(ContactManager)}.
     * </p>
     *
     * @invariant {@link ContactManagerAware#getContacts()}
     *
     * @pre {@link ContactAware#getContacts()}
     * @post the "client" class has a non-null instance of {@code ContactManager}
     *
     * @return the {@code ContactManager} instance currently set for this controller.
     */
    @Override
    public ContactManager getContacts() {
        return this.contacts;
    }

    /**
     * Sets the currently selected {@link Contact} instance in the GUI.
     * <p>
     * This method implements the {@link ContactAware#setSelectedContact(Contact)} interface
     * and allows the GUI to specify the contact that is currently selected for operations such as
     * editing or displaying its details. The contact is stored in the {@code selectedContact} field.
     * </p>
     *
     * @invariant {@link ContactAware#setSelectedContact(it.unisa.diem.gruppo9.logic.Contac)}
     *
     * @pre The {@code contact} parameter must not be {@code null}.
     * @post The {@code selectedContact} field is set to the provided {@code contact}.
     *
     * @param contact the {@link Contact} instance selected in the GUI.
     */
    @Override
    public void setSelectedContact(Contact contact) {
        this.selectedContact = contact;
    }

    /**
     * Retrieves the currently selected {@link Contact} instance in the GUI.
     * <p>
     * This method implements the {@link ContactAware#getSelectedContact()} interface and
     * provides access to the {@code Contact} instance currently selected in the GUI.
     * </p>
     *
     * @invariant {@link ContactAware#getSelectedContact()}
     *
     * @pre {@link ContactAware#getSelectedContact()}
     * @post the "client" class has a non-null instance of {@code Contact}
     *
     * @return the {@code Contact} instance currently selected.
     */
    @Override
    public Contact getSelectedContact() {
        return this.selectedContact;
    }
}