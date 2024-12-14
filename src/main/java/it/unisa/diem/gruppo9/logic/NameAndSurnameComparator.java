package it.unisa.diem.gruppo9.logic;

import java.util.Comparator;

/**
 * @file NameAndSurnameComparator.java
 * @brief A comparator for sorting {@code Contact} objects by name and surname.
 *
 * <p>
 * The {@code NameAndSurnameComparator} class defines a custom ordering for
 * instances of the {@code Contact} class based on their names and surnames. It
 * implements the {@link java.util.Comparator} interface, providing the
 * necessary logic to compare two {@code Contact} objects in a lexicographic
 * order.
 * </p>
 * <p>
 * This comparator is primarily used by the {@code ContactManager} class to sort
 * an {@link javafx.collections.ObservableList} of {@code Contact} objects. The
 * comparison considers both the name and surname attributes, ensuring
 * consistent and predictable ordering for contact lists.
 *
 * </p>
 * An instance of this class is needed every time an operation which modifies
 * the content of the user's observed list of contacts is performed.
 * <p>
 *
 * </p> @see Comparator
 *
 * @author gruppo9
 * @version 1.0
 * @date 2024-12-07
 */
public class NameAndSurnameComparator implements Comparator<Contact> {

    /**
     * Compares two {@code Contact} objects by their name and surname.
     * <p>
     * This method compares the {@code name} attributes of the two contacts
     * first. If the names are identical, it proceeds to compare their
     * {@code surname} attributes. The comparison follows the natural
     * lexicographic ordering of {@link String}.
     * </p>
     *
     * @pre A {@code NameAndSurnameComparator} instance must be declared with
     * the associated default constructor
     * @pre {@code name != null || surname != null}
     * @pre Both {@code o1} and {@code o2} must not be null (the contacts must
     * be valid).
     *
     * @post The method does not modify the state of the {@code o1} or
     * {@code o2} objects.
     * @post If both contacts have a non-empty {@code surname}, the comparison
     * is first made on the {@code surname}, and then on the {@code name} if the
     * surnames are identical.
     * @post If the {@code surname} is empty for one contact, let be it the
     * first, the comparison is made between the {@code name} of the first and
     * the {@code surname} of the second and viceversa.
     * @post If the {@code surname} is empty for both contacts, the comparison
     * is made based on the {@code name}.
     * @post If both the {@code surname} and {@code name} are identical the last
     * added contact is the last visualized while keeping the sorted list valid,
     * so that two identical contacts are still sorted in comparison to the
     * others.
     * @post The {@code Contact} instances must not be modified in their content
     *
     * @param o1 the first {@code Contact} object to be compared.
     * @param o2 the second {@code Contact} object to be compared.
     *
     * @return a negative integer, zero, or a positive integer as the first
     * contact is less than, equal to, or greater than the second contact,
     * respectively.
     */
    @Override
    public int compare(Contact o1, Contact o2) {

        if (o1.getSurname() == null && o2.getSurname() != null) {
            return o1.getName().compareToIgnoreCase(o2.getSurname());
        }
        if (o2.getSurname() == null && o1.getSurname() != null) {
            return o1.getSurname().compareToIgnoreCase(o2.getName());
        }
        if (o1.getSurname() == null && o2.getSurname() == null || (o1.getSurname().equals(o2.getSurname()))) {
            if (!o1.getName().equals(o2.getName())) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            } else {
                return 0;
            }
        }

        return o1.getSurname().compareToIgnoreCase(o2.getSurname());
    }
}
