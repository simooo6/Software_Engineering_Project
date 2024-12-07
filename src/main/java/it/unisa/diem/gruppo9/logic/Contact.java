package it.unisa.diem.gruppo9.logic;

/**
 * @file Contact.java
 * @brief Represents a single contact in the address book.
 * 
 * <p>
 * The {@code Contact} class defines a set of parameters that characterize a contact.
 * Each contact is represented as an instance of this class and can have mutable attributes,
 * which can be modified using the provided setter methods.
 * </p>
 * <p>
 * A {@code Contact} consists of the following attributes:
 * <ul>
 *     <li>{@code name}: the first name of the contact;</li>
 *     <li>{@code surname}: the last name of the contact;</li>
 *     <li>{@code phoneNumber}: an array of up to three phone numbers;</li>
 *     <li>{@code email}: an array of up to three email addresses.</li>
 * </ul>
 * </p>
 * 
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-06
 */

public class Contact {

    /** The first name of the contact. */
    private String name;
    
    /** The last name of the contact. */
    private String surname;
    
    /** An array of phone numbers associated with the contact, with a maximum of three entries. */
    private String[] phoneNumber;

    /** An array of email addresses associated with the contact, with a maximum of three entries. */
    private String[] email;

    /**
     * Creates a new {@code Contact} with the specified attributes.
     * <p>
     * If any of the input parameters are empty, the corresponding attributes will be initialized
     * as empty strings or empty arrays. At least one of {@code name} or {@code surname} should be non-empty.
     * If the input arrays for {@code phoneNumber} or {@code email} are non-empty, their size
     * will be set to the number of elements provided, with a maximum of three.
     * </p>
     * 
     * 
     * 
     * @pre PhoneNumber must not have more than three entries
     * @pre Email must not have more than three entrie
     * @pre At least one between name and surnam must not be empty
     * @post A new contact object is created with the specified attributes
     * @post If one between name and surname is empty it is initialized as empty String
     * @post If no phone numbers are inserted the attribute phoneNumber is initialized as an empty {@code Array}
     * @post If no emails are inserted the attribute email is initialized as an empty {@code Array}
     * 
     * 
     * 
     * 
     * @param name       the first name of the contact.
     * @param surname    the last name of the contact.
     * @param phoneNumber an array of phone numbers, up to three.
     * @param email      an array of email addresses, up to three.
     * 
     * 
     */
    public Contact(String name, String surname, String[] phoneNumber, String[] email) {
    }

    /**
     * Returns the first name of the contact.
     * 
     * @pre None(it can be called anytime)
     * @post Return the value of the name attribute
     * @post If the name is empty returns null
     * 
     * @return the first name of the contact, or {@code null} if it is empty.
     */
    public String getName() {
    }

    /**
     * Returns the last name of the contact.
     * 
     * @pre None(it can be called anytime)
     * @post Return the value of the surname attribute
     * @post If the surname is empty returns null
     * 
     * @return the last name of the contact, or {@code null} if it is empty.
     */
    public String getSurname() {
    }

    /**
     * Returns the array of phone numbers associated with the contact.
     * 
     * @pre None(it can be called anytime)
     * @post Returns the array of phone numbers
     * @post If no phone numbers are set it return null
     * 
     * 
     * @return an array of phone numbers, or {@code null} if no numbers are set.
     */
    public String[] getPhoneNumber() {
    }

    /**
     * Returns the array of email addresses associated with the contact.
     * 
     * @pre None(it can be called anytime)
     * @post Return the array pf email
     * @post If no emails are set it return null
     * 
     * @return an array of email addresses, or {@code null} if no addresses are set.
     */
    public String[] getEmail() {
    }

    /**
     * Sets the first name of the contact.
     * 
     * @pre name must be not null
     * @post the name attribute is updated to the specific value 
     * @post if name is an empty {@code String}, the name attribute became an empty{@code String}
     * 
     * @param name the new first name of the contact.
     */
    public void setName(String name) {
    }

    /**
     * Sets the last name of the contact.
     * 
     * @pre surname must be not null
     * @post the surname attribute is updated to the specific value 
     * @post if surname is an empty {@code String}, the surname attribute became an empty {@code String}
     *  
     * @param surname the new last name of the contact.
     */
    public void setSurname(String surname) {
    }

    /**
     * Sets the array of phone numbers associated with the contact.
     * <p>
     * Replaces the current array of phone numbers with the specified array, or initializes it
     * if it is currently empty.
     * </p>
     * 
     * @pre phone number must not have more than three entries
     * @pre phone number must not be null
     * @post the phone number is updated to the specified array
     * 
     * @param phoneNumber the new array of phone numbers, up to three entries.
     */
    public void setPhoneNumber(String[] phoneNumber) {
    }

    /**
     * Sets the array of email addresses associated with the contact.
     * <p>
     * Replaces the current array of email addresses with the specified array, or initializes it
     * if it is currently empty.
     * </p>
     *
     * @pre email must not have more than three entries
     * @pre email must not be null
     * @post the email is updated to the specified array
     * 
     * @param email the new array of email addresses, up to three entries.
     */
    public void setEmail(String[] email) {
    }

}