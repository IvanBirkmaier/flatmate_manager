# WG-Verwaltungs-App

### **Technologie-Stack:**
- **Java Version:** 16
- **Frameworks und Bibliotheken:**
  - Spring Boot 2.4.5
  - Spring Dependency Management 1.0.11.RELEASE
  - Spring Boot Starter Thymeleaf
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Security
  - Okta Spring Boot Starter 2.0.1
  - Thymeleaf Extras Spring Security 5
  - Spring Boot DevTools
  - Oracle JDBC (ojdbc8)
  - Spring Boot Starter Test (JUnit Platform)

## **Beschreibung:**
Die WG-Verwaltungs-App ist ein Unterstützungstool für Wohnungsgemeinschaften, das die Organisation von Einkäufen und generellen Aufgaben erleichtert.

### **Funktionsübersicht:**
- **Login und Registrierung:** Beim Aufrufen der Website wird der Nutzer automatisch zur Login-Seite weitergeleitet, wo man sich entweder einloggen oder bei Erstbenutzung registrieren kann.
- **Startseite:** Nach dem Login wird die Startseite angezeigt, welche als Single-Page-Applikation die gesamte Anwendung darstellt.
- **Einkaufsliste:** Auf der linken Seite können Artikel durch Eingabe in das Textfeld und Klick auf den "Hinzufügen"-Button zur Liste hinzugefügt werden. Gekaufte Artikel können durch Anklicken der Checkbox abgehakt und ans Ende der Liste verschoben werden. Bereits gekaufte Artikel können bei Bedarf durch erneutes Anklicken der Checkbox reaktiviert werden. Mit dem Button "Einkaufsliste leeren" lassen sich alle Artikel von der Liste löschen.
- **To-Do-Liste:** Auf der rechten Seite können Aufgaben durch Eingabe ins Textfeld und Klick auf den "Hinzufügen"-Button erstellt werden. Erledigte Aufgaben können über den "X"-Button entfernt werden. Ist die To-Do-Liste leer, erscheint die Nachricht "alles erledigt :)".
- **Logout:** In der oberen rechten Ecke befindet sich der "Logout"-Button zum Abmelden von der Website.

### **Deprecated URL (Stand Juli 2024):**
[WG-Verwaltungs-App auf Heroku](https://wg-verwaltung.herokuapp.com/)

> Pascal Hamar s0573990, Ivan Birkmaier s0574204


