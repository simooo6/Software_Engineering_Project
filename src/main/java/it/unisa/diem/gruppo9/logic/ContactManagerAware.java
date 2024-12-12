package it.unisa.diem.gruppo9.logic;

/**
 * @file ContactManagerAware.java
 * @brief Represents an interface to define a contract for classes that require a {@code ContactManager} instance.
 * 
 * <p>
 * Classes implementing the {@code ContactManagerAware} interface, such as {@code BaseController} in the 
 * "it.unisa.diem.gruppo9.interfaces.controller" package, are expected to provide a concrete implementation 
 * of the {@code setContacts(ContactManager contacts)} method or to extend a class that implements 
 * {@code setContacts(ContactManager contacts)}. This method is intended to associate 
 * a {@code ContactManager} instance with the implementing class, enabling interaction with 
 * the contact management logic.
 * </p>
 * <p>
 * The primary purpose of this interface is to establish a standardized way for classes in the 
 * application to access and utilize the functionality of the {@code ContactManager} class. 
 * The relationship between this interface and the {@code ContactManager} class is a "use" relationship, 
 * meaning the interface depends on {@code ContactManager} for its functionality.
 * </p>
 * 
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */

/**
 * @interface ContactManagerAware Interface for handling {@code ContactManager} instances
 */
public interface ContactManagerAware {
    
    /**
     * Associates a {@code ContactManager} instance with the implementing class.
     * <p>
     * This method is primarily used in controllers that manage FXML views to facilitate operations 
     * on the contact list. By setting a {@code ContactManager} instance, implementing classes can 
     * utilize its methods to interact with and manage the contact data.
     * </p>
     * <p>
     * Implementations of this interface are expected to override the method in order to properly initialize 
     * and configure the {@code ContactManager} instance they want to use.
     * In this sense, this very method represents the public contract 
     * between the logic and the interfaces.controller section of this system.
     * </p>
     * 
     * @invariant The object that is an instance of {@code ContactManager} 
     * must never be casted to another object.
     * @invariant The object that is an instance of {@code ContactManager}
     * must never be modified in this method. It means that the {@code ObservableList<Contact>}
     * that represents the list of contacts must remain coherent with its content.
     * 
     * @param contacts the {@code ContactManager} instance to be associated with the implementing class.
     */
    public void setContacts(ContactManager contacts);
}




