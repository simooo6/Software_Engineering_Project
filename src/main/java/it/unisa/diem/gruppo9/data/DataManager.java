package it.unisa.diem.gruppo9.data;

import it.unisa.diem.gruppo9.logic.ContactManager;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @file DataManager.java
 * @brief The {@code DataManager} manage contact data storage and their
 * retrival.
 *
 * <p>
 * Provides methods to save a contact and load contact information using the
 * logic defined in the {@link it.unisa.diem.gruppo9.logic.ContactManager}
 * class.
 * </p>
 *
 * <p>
 * @invariant Data consistency: data saved via {@code saveContact()} must always
 * be retrivable in an equivalent and consistent format via
 * {@code loadContact()}
 * @invariant Storage integrity: the storage system must always remain in a
 * consisted and readable state
 * @invariant Data format compilance: any contacts saved or loaded must respect
 * the format defined by the program's logic
 * </p>
 *
 * @see ContactManager
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */
/**
 * @interface DataManager Interface for handling contact data operations
 */
public interface DataManager {

    /**
     * This method helps saving the contacts data, it is responsible for
     * persisting contact data to a storage system. The implementation details
     * are left to the implementing class.
     *
     */
    public void saveContact() throws IOException;

    /**
     * This method retrives contact informations from a file and return the
     * information as an instance of ContactManager
     * ({@link it.unisa.diem.gruppo9.logic.ContactManager})
     *
     * @return An instance of ContactManager containing the loaded contact data
     *
     */
    public ContactManager loadContact() throws IOException, FileNotFoundException;
}
