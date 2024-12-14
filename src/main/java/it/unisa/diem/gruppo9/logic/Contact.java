package it.unisa.diem.gruppo9.logic;

/**
 * @file Contact.java
 * @brief Represents a single contact in the address book.
 *
 * <p>
 * The {@code Contact} class defines a set of parameters that characterize a
 * contact. Each contact is represented as an instance of this class and can
 * have mutable attributes, which can be modified using the provided setter
 * methods.
 * </p>
 * <p>
 * A {@code Contact} consists of the following attributes:
 * <ul>
 * <li>{@code name}: the first name of the contact;</li>
 * <li>{@code surname}: the last name of the contact;</li>
 * <li>{@code phoneNumber}: an array of up to three phone numbers;</li>
 * <li>{@code email}: an array of up to three email addresses.</li>
 * </ul>
 * </p>
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-06
 */
public class Contact {

    /**
     * The first name of the contact.
     */
    private String name;

    /**
     * The last name of the contact.
     */
    private String surname;

    /**
     * An array of phone numbers associated with the contact, with a maximum of
     * three entries.
     */
    private String[] phoneNumber;

    /**
     * An array of email addresses associated with the contact, with a maximum
     * of three entries.
     */
    private String[] email;

    /**
     * Creates a new {@code Contact} with the specified attributes.
     * <p>
     * If any of the input parameters are empty, the corresponding attributes
     * will be initialized as empty strings or empty arrays. At least one of
     * {@code name} or {@code surname} should be non-empty. If the input arrays
     * for {@code phoneNumber} or {@code email} are non-empty, their size will
     * be set to the number of elements provided, with a maximum of three.
     * </p>
     *
     *
     *
     * @invariant PhoneNumber must not have more than three entries and it must
     * not be null
     * @invariant Email must not have more than three entrie and it must not be
     * null
     * @invariant At least one between name and surname must not be empty
     *
     * @pre An instance of {@code Contact} has been declared and not yet
     * initialized
     * @pre The number and type of parameters needed to invoke this constructor
     * is coherent with its declaration
     * @pre All entries in the phoneNumber and email {@code Array} must not be
     * empty so that blank entries will still be recognizible with a "-"
     * character.
     *
     * @post Every parameter is not modified or casted to another type
     * @post A new contact object is created with the specified attributes
     * @post If one between name and surname is empty it is initialized as empty
     * String
     *
     * @param name the first name of the contact.
     * @param surname the last name of the contact.
     * @param phoneNumber an array of phone numbers, up to three.
     * @param email an array of email addresses, up to three.
     *
     * @throws RuntimeException if one of the parameters doesn't respect the
     * invariants
     * @throws NullPointerException if one of the arrays doesn't respect the
     * invariants
     */
    public Contact(String surname, String name,  String[] phoneNumber, String[] email) {
        if (name.isEmpty() && surname.isEmpty()) {
            throw new RuntimeException("A contact must have at least a name or a surname.");
        } else {

            this.name = name;
            this.surname = surname;

            if (phoneNumber.length <= 3) {
                this.phoneNumber = phoneNumber;
            } else if (phoneNumber == null) {
                throw new NullPointerException("Phone number array cannot be null.");
            } else {
                throw new RuntimeException("A contact must have less than four phone numbers");
            }
            if (email.length <= 3) {
                this.email = email;
            } else if (email == null) {
                throw new NullPointerException("Email array cannot be null.");
            } else {
                throw new RuntimeException("A contact must have less than four emails");
            }
        }
    }

    /**
     * Returns the first name of the contact.
     *
     * @pre The {@code Contact} must be properly initialized
     * @post Return the value of the name attribute without editing it
     * @post If the name is empty returns null
     *
     * @return the first name of the contact, or {@code null} if it is empty.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the last name of the contact.
     *
     * @pre The {@code Contact} must be properly initialized
     * @post Return the value of the surname attribute without editing it
     * @post If the surname is empty returns null
     *
     * @return the last name of the contact, or {@code null} if it is empty.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Returns the array of phone numbers associated with the contact.
     *
     * @pre The {@code Contact} must be properly initialized
     * @post Returns the array of phone numbers without editing it
     * @post If no phone numbers are set it return null
     *
     * @return an array of phone numbers, or the blank characters "-"
     */
    public String[] getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns the array of email addresses associated with the contact.
     *
     * @pre The {@code Contact} must be properly initialized
     * @post Return the array of email without editin it
     * @post If no emails are set it return null
     *
     * @return an array of email addresses, or the blank characters "-"
     */
    public String[] getEmail() {
        return this.email;
    }

    /**
     * Sets the first name of the contact.
     *
     * @pre name must be not null
     * @post the name attribute is updated to the specific value
     * @post if name is an empty {@code String}, the name attribute became an
     * empty{@code String}
     *
     * @param name the new name of the contact.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the last name of the contact.
     *
     * @pre surname must be not null
     * @post the surname attribute is updated to the specific value
     * @post if surname is an empty {@code String}, the surname attribute became
     * an empty {@code String}
     *
     * @param surname the new surname of the contact.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Sets the array of phone numbers associated with the contact.
     * <p>
     * Replaces the current array of phone numbers with the specified array, or
     * initializes it if it is currently empty.
     * </p>
     *
     * @invariant {@code phoneNumber} must not have more than three entries and
     * it must not be null
     * @post the {@code phoneNumber} is updated to the specified array
     *
     * @param phoneNumber the new array of phone numbers, up to three entries.
     * @throws RuntimeException if the {@code phoneNumber} {@code Array} exceeds
     * the maximum size allowed
     * @throws NullPointerException if the {@code Array} is null
     */
    public void setPhoneNumber(String[] phoneNumber) {
        if (phoneNumber == null) {
            throw new NullPointerException("Phone number array cannot be null.");
        }
        if (phoneNumber.length <= 3) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new RuntimeException("A contact must have less than four phone numbers");
        }
    }

    /**
     * Sets the array of email addresses associated with the contact.
     * <p>
     * Replaces the current array of email addresses with the specified array,
     * or initializes it if it is currently empty.
     * </p>
     *
     * @invariant {@code email} must not have more than three entries and it
     * must not be null
     * @post the {@code email} is updated to the specified array
     *
     * @param email the new array of email addresses, up to three entries.
     * @throws RuntimeException if the {@code email} {@code Array} exceeds the
     * maximum size allowed
     * @throws NullPointerException if the {@code Array} is null
     */
    public void setEmail(String[] email) {
        if (email == null) {
            throw new NullPointerException("Email array cannot be null.");
        }
        if (email.length <= 3) {
            this.email = email;
        } else {
            throw new RuntimeException("A contact must have less than four emails.");
        }
    }
    /**
     * Returns a string representation of the {@code Contact} object in a
     * specific format.
     * <p>
     * The string representation of a {@code Contact} object includes the
     * following attributes, separated by semicolons:
     * <ul>
     * <li>{@code surname}: the last name of the contact;</li>
     * <li>{@code name}: the first name of the contact;</li>
     * <li>{@code phoneNumber}: a semicolon-separated list of all phone numbers
     * associated with the contact;</li>
     * <li>{@code email}: a semicolon-separated list of all email addresses
     * associated with the contact.</li>
     * </ul>
     * A newline character is appended at the end of the string.
     * </p>
     * <p>
     * If the {@code phoneNumber} or {@code email} arrays contain multiple
     * elements, they will be concatenated into a single string using semicolons
     * as the delimiter. If either array is empty, the corresponding part of the
     * string will be left blank.
     * </p>
     *
     * @invariant The {@code surname}, {@code name}, {@code phoneNumber}, and
     * {@code email} fields must not be null. The arrays {@code phoneNumber} and
     * {@code email} must contain at most three elements.
     *
     * @pre The {@code Contact} object must be properly initialized with valid
     * attributes. - {@code surname} and {@code name} must not be null. -
     * {@code phoneNumber} and {@code email} must not be null and must contain
     * valid entries.
     *
     * @post The returned string will contain: - The {@code surname} followed by
     * a semicolon. - The {@code name} followed by a semicolon. - The
     * concatenated {@code phoneNumber} entries, separated by semicolons. - The
     * concatenated {@code email} entries, separated by semicolons. - A newline
     * character at the end of the string.
     *
     * @return a string representation of the {@code Contact} object, formatted
     * as:
     * {@code "surname;name;phoneNumber1;phoneNumber2;...;email1;email2;...\n"}
     * where {@code phoneNumber1}, {@code phoneNumber2}, etc., and
     * {@code email1}, {@code email2}, etc., are the entries in the respective
     * arrays.
     */
    @Override
    public String toString() {
        String phoneNumbers = String.join(";", phoneNumber);
        String emails = String.join(";", email);
        return this.surname + ";" + this.name + ";" + phoneNumbers + ";" + emails + "\n";
    }

}
