package it.unisa.diem.gruppo9.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** @mainpage 
  * <p> 
  * Application "BricoRubrica" developed by:
  * <ul>
  *     <li> {@author Michele Cetraro - 0612707419} </li>
  *     <li> {@author Mario Pellegrino Ambrosone - 0612707417} </li>
  *     <li> {@author Simone Grimaldi - 0612707338} </li>
  *     <li> {@author Gaetano Carbone - 0612707663} </li>
  * </ul>
  * </p>
  * 
  * <p>
  * The "BricoRubrica" is an AddressBook-like software that provides multiple data structures in order
  * to memorize and operate on a list of contacts via GUI, as well as an explictly-user-activated mechanism 
  * that enables to overwrite a file with all the information contained in the address book. 
  * Each {@code Contact} is identified by a set of informations and
  * each {@code Contact} is contained in a {@code ContactManager} object.
  * </p>
 */
 /**
 * @file BricoRubrica.java
 * @brief The main entry point for the BricoRubrica application.
 * 
 * <p>
 * {@code BricoRubrica} extends the {@link javafx.application.Application} class to provide the 
 * JavaFX application lifecycle. It initializes and displays the primary stage of the application 
 * by loading the FXML file for the main user interface.
 * </p>
 * <p>
 * This class is responsible for launching the application, setting up the primary stage, 
 * and displaying the initial view. The {@link #main(String[])} method serves as the entry point 
 * for the JVM, while the {@link #start(Stage)} method initializes the JavaFX stage.
 * </p>
 * 
 * @author gruppo9
 * @version 1.0
 * @since 2024-12-07
 */

public class BricoRubrica extends Application {

    /**
     * Initializes and displays the primary stage of the application.
     * <p>
     * The {@code start} method is invoked by the JavaFX runtime to set up the main 
     * {@link javafx.stage.Stage} of the application. It loads the FXML file representing the 
     * primary user interface, creates a {@link javafx.scene.Scene}, and sets it on the stage.
     * </p>
     * 
     * @param stage the primary stage for this application, provided by the JavaFX runtime.
     * @throws Exception if an error occurs during FXML loading or stage setup.
     */
    @Override
    public void start(Stage stage) throws Exception {
    }

    /**
     * The main method serving as the entry point for the application.
     * <p>
     * This method calls the {@link #launch(String[])} method to start the JavaFX runtime 
     * and subsequently invoke the {@link #start(Stage)} method.
     * </p>
     * 
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}