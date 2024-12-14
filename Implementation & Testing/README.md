ENGLISH :
About Tests on BricoRubrica

The testing approach for "BricoRubrica" primarily follows the black-box testing methodology. While the focus is on evaluating the system based on its external behavior, edge cases and potential internal errors are also anticipated and rigorously tested to ensure robustness.
Moreover, in the ContactManagerTest class are included some methods ( testCreateContact(), testLoadContact() and testSaveContact() ) that test how the Contact and ContactManager classes cooperate as a kind of integration test. More information about it in the inline documentation of these very methods.

Key aspects of the testing strategy include:
a) Edge Case Testing: Scenarios beyond typical user interactions, including edge cases, have been systematically documented and validated through targeted test methods.

b) Logic and Interface Testing: Testing is not limited to the core logic. A dedicated test class exists for the BaseController class in the package it.unisa.diem.gruppo9.interfaces.controller. Given the BaseController’s pivotal role as a mediator between the computational logic and the GUI, its functionality directly impacts user interactions and event handling. Therefore, targeted tests ensure stability and reliability in this critical component.

c) Inline Documentation: All test cases are accompanied by detailed JavaDoc annotations, including the expected outcomes for each case, making the results easy to understand and verify.

This comprehensive testing approach ensures a robust, well-documented, and user-centered system.

ITALIAN :
In merito ai test di BricoRubrica

L’approccio di test per BricoRubrica segue principalmente la metodologia di black-box testing. Sebbene l’attenzione sia rivolta a valutare il comportamento esterno del sistema, sono stati anche anticipati e rigorosamente testati scenari limite e potenziali errori interni per garantire la robustezza.
Inoltre, nella classe ContactManagerTest sono inclusi metodi ( testCreateContact(), testLoadContact() e testSaveContact()  ) che testano come le classi Contact e ContactManager cooperano, rappresentando così il test di integrazione. Più informazioni in merito a ciò possono essere reperite nella documentazione inline dei suddetti metodi.

Aspetti chiave della strategia di testing includono:
a) Test di Casi Limite: Gli scenari che vanno oltre le interazioni tipiche dell’utente, inclusi i casi limite, sono stati sistematicamente documentati e validati tramite metodi di test mirati.

b) Test di Logica e Interfaccia: I test non si limitano alla logica del sistema. Una classe di test dedicata è stata sviluppata per la classe BaseController nel package it.unisa.diem.gruppo9.interfaces.controller. Dato il ruolo cruciale di BaseController come mediatore tra la logica computazionale e l’interfaccia grafica, la sua funzionalità influenza direttamente le interazioni con l’utente e la gestione degli eventi. Pertanto, sono stati sviluppati test mirati per garantire stabilità e affidabilità in questo componente essenziale.

c) Documentazione Inline: Tutti i casi di test sono accompagnati da dettagliate annotazioni JavaDoc, incluse le aspettative sui risultati di ogni caso, rendendo i risultati facili da comprendere e verificare.

Questo approccio di testing completo garantisce un sistema robusto, ben documentato e orientato all’utente.
