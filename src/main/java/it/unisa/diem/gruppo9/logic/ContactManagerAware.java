package it.unisa.diem.gruppo9.logic;

/**
 * @file ContactManagerAware.java
 * @brief Represents an interface to define a contract for classes that require
 * a {@code ContactManager} instance.
 *
 * <p>
 * Classes implementing the {@code ContactManagerAware} interface, such as
 * {@code BaseController} in the "it.unisa.diem.gruppo9.interfaces.controller"
 * package, are expected to provide a concrete implementation of the
 * {@code setContacts(ContactManager contacts)} and {@code getContacts()}
 * methods or to extend a class that implements this very interface. This
 * methods are intended to associate a {@code ContactManager} instance with the
 * implementing class, enabling interaction with the contact management logic.
 * </p>
 *
 * <p>
 * The primary purpose of this interface is to establish a standardized way for
 * classes in the application to access and utilize the functionality of the
 * {@code ContactManager} class or to gain access to the associated
 * {@code ContactManager}. This ensures that classes implementing this interface
 * can access the {@code ContactManager} instance after it has been set. This
 * two-way interaction enhances flexibility and modularity within the
 * application architecture.
 * </p>
 * <p>
 *
 * The relationship between this interface and the {@code ContactManager} class
 * is a "use" relationship, meaning the interface depends on
 * {@code ContactManager} for its functionality.
 * </p>
 *
 *
 * @see ContactManager.java
 * @see BaseController.java
 *
 * @author gruppo9
 * @version 1.1
 * @date 2024-12-12
 */
/**
 * @interface ContactManagerAware Interface for handling {@code ContactManager}
 * instances
 */
public interface ContactManagerAware {

    /**
     * Associates a {@code ContactManager} instance with the implementing class.
     * <p>
     * This method is primarily used in controllers that manage FXML views to
     * facilitate operations on the contact list. By setting a
     * {@code ContactManager} instance, implementing classes can utilize its
     * methods to interact with and manage the contact data.
     * </p>
     * <p>
     * Implementations of this interface are expected to override the method in
     * order to properly initialize and configure the {@code ContactManager}
     * instance they want to use. In this sense, this very method represents the
     * public contract between the logic and the interfaces.controller section
     * of this system.
     * </p>
     *
     * @invariant The object that is an instance of {@code ContactManager} must
     * never be cast to another object.
     * @invariant The object that is an instance of {@code ContactManager} must
     * never be modified in this method. It means that the
     * {@code ObservableList<Contact>} that represents the list of contacts must
     * remain coherent with its content.
     *
     * @param contacts the {@code ContactManager} instance to be associated with
     * the implementing class.
     */
    public void setContacts(ContactManager contacts);

    /**
     * Retrieves the {@code ContactManager} instance associated with the
     * implementing class.
     * <p>
     * This method provides access to the {@code ContactManager} instance that
     * has been previously set using
     * {@code setContacts(ContactManager contacts)}. The implementing class or
     * its subclasses can use the returned instance to perform operations such
     * as retrieving, adding, or deleting contacts in a consistent manner.
     * </p>
     *
     * <p>
     * This method is essential for ensuring bidirectional interaction between
     * the implementing class and the contact management logic. It adheres to
     * the principle of encapsulation by allowing controlled access to the
     * {@code ContactManager} instance without exposing internal details of the
     * implementing class.
     * </p>
     *
     * @invariant The {@code ContactManager} instance returned must remain
     * consistent with the instance that was set using
     * {@code setContacts(ContactManager contacts)}.
     * @invariant The returned {@code ContactManager} must not be modified or
     * cast to an incompatible type.
     *
     * @pre The {@code ContactManager} instance must have been initialized and
     * set using the {@code setContacts(ContactManager contacts)} method.
     *
     * @return the {@code ContactManager} instance associated with the
     * implementing class.
     */
    public ContactManager getContacts();
}