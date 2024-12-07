package it.unisa.diem.gruppo9.interfaces.controller;

import it.unisa.diem.gruppo9.logic.ContactManager;
import it.unisa.diem.gruppo9.logic.ContactManagerAware;

/**
 * @file BaseController.java
 * @brief Provides a base implementation for setting a {@link ContactManager} instance in controllers.
 * 
 * <p>
 * The {@code BaseController} class implements the {@link ContactManagerAware} interface, 
 * allowing controllers that extend this class to have a {@link ContactManager} instance 
 * injected dynamically. This simplifies the management of contact data by ensuring 
 * that all extending controllers have access to an instance of {@code ContactManager}.
 * Furthermore {@code BaseController} represents for a {@code ChangeView} instance the public contract
 * with {@code DisplayEditContactController}, {@code DisplayContactsController} and {@code DisplayAddContactController}.
 * </p>
 * 
 * <h2>Responsibilities</h2>
 * <ul>
 *   <li>Implements the {@link #setContacts(it.unisa.diem.gruppo9.logic.ContactManager)} method from the 
 *       {@link ContactManagerAware} interface to enable dependency injection of 
 *       a {@link ContactManager} instance.</li>
 *   <li>Provides a protected {@code ContactManager} field accessible to subclasses 
 *       such as:
 *       <ul>
 *           <li>{@code DisplayEditContactController}</li>
 *           <li>{@code DisplayContactsController}</li>
 *           <li>{@code DisplayAddContactController}</li>
 *       </ul>
 *   </li>
 * </ul>
 * 
 * <h2>Usage</h2>
 * <p>
 * The {@code BaseController} class is not abstract and can be extended by other 
 * controllers in the {@code it.unisa.diem.gruppo9.interfaces.controller} package. Subclasses 
 * automatically inherit the implementation of the {@link #setContacts(it.unisa.diem.gruppo9.logic.ContactManager)} 
 * method and can access the protected {@code contacts} field to work with contact data.
 * </p>
 * 
 * @see ContactManager.java
 * @see ContactManagerAware.java
 * @see DisplayEditContactController.java
 * @see DisplayContactsController.java
 * @see DisplayAddContactController.java
 * @see ChangeView.java
 * 
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */

public class BaseController implements ContactManagerAware{
    
    /**
     * The {@link ContactManager} instance used to manage contact data.
     * <p>
     * This protected field is accessible to subclasses and is set via the 
     * {@link #setContacts(it.unisa.diem.gruppo9.logic.ContactManager)} method.
     * </p>
     */
    protected ContactManager contacts;
    
    
    /**
     * Sets the {@link ContactManager} instance for the controller.
     * <p>
     * This method is part of the {@link ContactManagerAware} interface implementation 
     * and allows subclasses to receive and manage a {@code ContactManager} instance dynamically.
     * The injected {@code ContactManager} is stored in the {@code contacts} field, making it 
     * accessible to subclasses.
     * In this sense the method represents the public contract between the interfaces.change section 
     * and the interfaces.controller section of the system.
     * An instance of {@code ChangeView} is so allowed to use a {@code ContactManager} object and this very method to set it
     * when an instance of {@code DisplayEditContactController}, {@code DisplayContactsController} or 
     * {@code DisplayAddContactController} needs it.
     * </p>
     * 
     * @invariant {@link ContactManagerAware#setContacts(it.unisa.diem.gruppo9.logic.ContactManager)}
     * 
     * @pre The {@code contacts} parameter must not be {@code null}.
     * @pre The {@code contacts} parameter must be a valid instance of {@link ContactManager} 
     * that has been properly initialized.
     * @post The {@code contacts} field of this instance is set to the provided {@code contacts} parameter.
     * @post The {@code contacts} field is accessible by subclasses of {@code BaseController}.
     * 
     * @param contacts the {@link ContactManager} instance to be associated with the controller.
     */
    @Override
    public void setContacts(ContactManager contacts) {
    }
}