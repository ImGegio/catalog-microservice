# CATALOG-MICROSERVICE

Questo microservizio rappresenta il core dell'applicativo e per il suo funzionamento necessita dello start di altri 2 microservices:

- BOOK-MICROSERVICE (crud per i libri)
- AUTHOR-MICROSERVICE (crud per autori)

E' stata configurata la sicurezza con Spring di modo da rendere protette tutte le risorse a eccezione di "/author".
Di conseguenza al tentativo di accesso a "/book", l'utente verra' reindirizzato alla form di login.
Il sistema gestisce una table sql relativa agli utenti, sulla quale si dovra' inserire una tupla per matchare la login.

N.B. e' stato configurato un encoder BCRYPT per le password, quindi questa deve essere memorizzata in forma criptata su db. Di seguito fornita la pwd utilizzata in sviluppo per test:

- Lorenzo123 -> $2a$12$Xwd9yj0imjpWgIrh9I7IeubDhKNyPBJjuAOMIND1ZBLdkMa0D5LKi

E' stata prevista una classe di gestione delle eccezioni a scopo dimostrativo di come si possano gestire le varie casistiche in un sistema centralizzato. 
Lo stesso approccio puo' essere utilizzato nei vari microservizi o meglio reso disponibile a tutti di modo da loggare informazioni al client (cosa che attualmente viene gestita solo in alcuni contesti).
Un esempio puo' essere il caso in cui due diversi endpoint che ritornano dei modelli dati sulla base di un "/param", possono loggare entambi "ENTITY_NOT_FOUND".

Databse utilizzato: MYSQL

Di seguito la collezione Postman utilizzata per il testing:

- https://app.getpostman.com/join-team?invite_code=6a0a354704f1a2f21754c74bd0e8dc6e&target_code=986975202c8821921cac5a3b7daefe72

N.B. tutte le tabelle sono gestite da Hibernate, quindi generate/aggiornate a runtime.
Inserire, una volta generate, almeno 1 autore e di conseguenza i libri da referenziare a quest'ultimo/i.

