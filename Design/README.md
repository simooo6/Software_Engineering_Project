ENGLISH:
About Design Changes

The architectural design reference for understanding the high-level structure of the BricoRubrica system is detailed in “Design_Document__Ver_2_0.pdf”. In the "Class Diagrams__Ver_2_0.png" file its portrayed a detailed version of the class diagrams.
Moreover, all the update to the Detailed Design structure, due to the reviews on the architecture and to the coding phase, can be found in the "html" directory or in the doxyfile associated.

The updated system architecture retains the core principles established in the initial version, with refinements informed by insights from the coding and testing phases. Key changes include:

a) Process View Adjustments:
To strengthen communication principles between the logic and interface layers, a new interface, ContactAware, has been introduced. This interface defines a public contract between the Contact class and the controllers DisplayEditContactController and DisplayContactsController. Modeled similarly to ContactManagerAware, it provides setter and getter methods for Contact objects and is implemented by BaseController.

b) Enhancements to ContactManager:
Two new public methods have been added:
	b.1) A sorting method to reorder the contact list.
	b.2) A getter method to retrieve the current instance’s observable contact list.

c) Logical View Revisions:
All sequence diagrams underwent a thorough revision due to initial misinterpretations of object communication and interaction flows. These updates ensure greater accuracy and alignment with the system’s actual behavior.

This refined design addresses identified gaps, reinforces modular communication, and ensures a robust and maintainable system architecture.


ITALIAN:
In merito ai cambiamenti di Design

Il riferimento per la progettazione architetturale, utile a comprendere la struttura e il design ad alto livello del sistema BricoRubrica, è descritto in “Design_Document__Ver_2_0.pdf”. Nel file "Class Diagrams__Ver_2_0.png" è rappresentata una versione più chiara dei diagrammi delle classi.
Inoltre, tutte le revisioni sul design di dettaglio, dipendenti dagli aggiornamenti architetturali e dalle considerazioni in fase di coding, possono essere viste nella cartella "html" o nel doxyfile associato.

L’architettura aggiornata del sistema mantiene i principi fondamentali definiti nella versione iniziale, con miglioramenti basati su osservazioni derivate dalle fasi di coding e testing. I cambiamenti principali includono:

a) Modifiche alla Process View:
Per rafforzare i principi di comunicazione tra il livello logico e quello dell’interfaccia, è stata introdotta una nuova interfaccia, ContactAware. Questa interfaccia definisce un contratto pubblico tra la classe Contact e i controller DisplayEditContactController e DisplayContactsController. Ispirata a ContactManagerAware, fornisce metodi setter e getter per gli oggetti Contact ed è implementata da BaseController.

b) Miglioramenti a ContactManager:
Sono stati aggiunti due nuovi metodi pubblici:
	b.1) Un metodo di ordinamento per riorganizzare la lista dei contatti.
	b.2) Un metodo getter per ottenere l’elenco osservabile dei contatti dell’istanza 		     corrente.

c) Revisioni alla Logical View:
Tutti i diagrammi di sequenza sono stati sottoposti a una revisione approfondita a causa di mal interpretazioni iniziali delle comunicazioni e interazioni tra gli oggetti. Questi aggiornamenti garantiscono maggiore accuratezza e allineamento con il comportamento effettivo del sistema.

Questo design perfezionato affronta i problemi individuati, rafforza la comunicazione modulare e assicura un’architettura del sistema robusta e manutenibile.