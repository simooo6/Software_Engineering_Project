package it.unisa.diem.gruppo9.logic;

/**
 * @file ContactAware.java
 * @brief Interface that defines a contract between the contact management logic
 * and the interface logic for editing a contact.
 *
 * <p>
 * The {@code ContactAware} interface establishes a public contract between the
 * logic responsible for managing individual contacts (represented by the
 * {@code Contact} class) and the GUI logic for modifying a selected contact. It
 * ensures that GUI controllers, such as those extending {@code BaseController},
 * can interact with the contact management system in a consistent and decoupled
 * manner.
 * </p>
 *
 * <p>
 * This interface does not create or modify {@code Contact} objects. Instead, it
 * defines methods to set and retrieve a {@code Contact} instance that is
 * selected within the graphical user interface (GUI). The interaction is
 * mediated through {@code BaseController}, which implements this interface,
 * allowing subclasses like {@code EditContactController} to indirectly utilize
 * a {@code Contact} instance.
 * </p>
 *
 * <p>
 * By enforcing this separation of concerns, the {@code ContactAware} interface
 * promotes modularity and reduces dependencies between the GUI layer and the
 * contact management logic.
 * </p>
 *
 * @see Contact.java
 * @see BaseController.java
 * @see DisplayEditContactController.java
 *
 * @author gruppo9
 * @version 1.0
 * @since 2024-12-07
 */
/**
 * @interface ContactAware Interface for handling selcted {@code Contact}
 * instances
 */
public interface ContactAware {

    /**
     * Sets the selected {@code Contact} instance for use in the implementing
     * class.
     *
     * <p>
     * This method allows the implementing class to associate a {@code Contact}
     * instance that has been selected within the graphical user interface. The
     * selected {@code Contact} can then be used for further operations, such as
     * displaying or editing its details.
     * </p>
     *
     * @invariant The object that is an instance of {@code Contact} must never
     * be casted to another object.
     * @invariant The object that is an instance of {@code Contact} must never
     * be modified in this method. It means that the {@code name},
     * {@code surname}, {@code phoneNubers} and {@code emails} that represents
     * the contect of a contact must remain the same.
     *
     * @param contact the {@code Contact} instance selected in the interface.
     */
    public void setSelectedContact(Contact contact);

    /**
     * Retrieves the {@code Contact} instance that has been selected in the
     * graphical user interface.
     *
     * <p>
     * This method provides access to the currently selected {@code Contact},
     * allowing the implementing class, and precisely its subclasses, to
     * interact with the contact's data without directly managing its creation
     * or selection logic.
     * </p>
     *
     * @invariant The object that is an instance of {@code Contact} must never
     * be cast to another object.
     * @invariant The object that is an instance of {@code Contact} must never
     * be modified in this method. It means that the {@code name},
     * {@code surname}, {@code phoneNubers} and {@code emails} that represents
     * the contect of a contact must remain the same.
     *
     * * @pre The {@code Contact} instance must have been initialized and set
     * using the {@code setSelectedContact(Contact contact)} method.
     *
     * @return the {@code Contact} instance currently selected in the interface.
     */
    public Contact getSelectedContact();
}