# AufgabenVerwaltung
## 1. `Task` (Interface)
Definiert das Grundgerüst einer Aufgabe.

- **Methoden:**
  - `int getId()` – liefert die eindeutige ID der Aufgabe.
  - `String getDescription()` – liefert die Beschreibung.
  - `String getPriority()` – liefert die Priorität als Text (`LOW`, `MEDIUM`, `HIGH`).
  - `String getStatus()` – liefert den aktuellen Status als Text (`OPEN`, `IN_PROGRESS`, `DONE`).
  - `void setDescription(String description)` – setzt eine neue Beschreibung.
  - `void setPriority(String priority)` – setzt eine neue Priorität.
  - `void setStatus(String status)` – setzt einen neuen Status.

---

## 2. `SimpleTask` (Implementierung von `Task`)
Realisierung des Task-Interfaces mit automatischer ID-Vergabe.

- **Felder:**
  - `private static int counter` – Zähler für IDs (statisch, hochzählernd).
  - `private final int id` – eindeutige ID (aus `counter`).
  - `private String description` – Beschreibungstext.
  - `private String priority` – Priorität.
  - `private String status` – Status.

- **Konstruktor:**
  - `SimpleTask(String description, String priority)`
    - Inkrementiert `counter` und setzt `id`.
    - Initialisiert `description` und `priority`.
    - Setzt `status` standardmäßig auf `"OPEN"`.

- **Methoden (Implementierung):**
  - Alle Getter/Setter aus `Task`.
  - `toString()` – Ausgabeformat: `[ID] Beschreibung (Priority: X, Status: Y)`.

---

## 3. `TaskManager`
Verwaltet eine Liste von `Task`-Objekten und stellt CRUD-Operationen sowie Statistiken bereit.

- **Felder:**
  - `private final List<Task> tasks` – Liste aller Aufgaben.

- **Methoden:**
  1. **`addTask(Task task)`**
     - Fügt die Aufgabe zu `tasks` hinzu.
     - Gibt eine Bestätigung auf der Konsole aus.

  2. **`removeTask(int id)`**
     - Durchläuft `tasks` und entfernt die Aufgabe mit passender `id`.
     - Ausgabe, ob erfolgreich entfernt oder nicht gefunden.

  3. **`updateTaskStatus(int id, String newStatus)`**
     - Sucht Aufgabe nach `id` und setzt `status` auf `newStatus`.
     - Ausgabe des neuen Status oder Hinweis, falls nicht gefunden.

  4. **`listTasks()`**
     - Listet alle Aufgaben mit `toString()`-Format.

  5. **`listTasksByStatus(String status)`**
     - Listet nur Aufgaben mit passendem `status`.

  6. **`listTasksByPriority(String priority)`**
     - Listet nur Aufgaben mit passender `priority`.

  7. **`printStatistics()`**
     - **Zählt** (ohne Streams) über Schleife:
       - Gesamtzahl `total`
       - Anzahl nach Status: `open`, `inProgress`, `done`
       - Anzahl nach Priorität: `low`, `medium`, `high`
     - Gibt alle Zähler in übersichtlicher Statistik auf der Konsole aus.

---

## 4. `Main`
Konsolen-Oberfläche für den Benutzer mit Menüauswahl.

- **Variablen:**
  - `Scanner scanner` – zur Eingabe von Benutzerbefehlen.
  - `TaskManager manager` – zentrale Verwaltungsklasse.
  - `boolean running` – Steuerung der Hauptschleife.

- **Ablauf:**
  1. Anzeige eines Menüs mit Optionen 1–8:
     - 1: Aufgabe hinzufügen (Eingabe von Beschreibung und Priorität).
     - 2: Aufgabe entfernen (Eingabe der ID).
     - 3: Status ändern (ID + neuer Status).
     - 4: Alle Aufgaben auflisten.
     - 5: Aufgaben nach Status auflisten.
     - 6: Aufgaben nach Priorität auflisten.
     - 7: Statistik anzeigen.
     - 8: Programm beenden.
  2. Auswahl auswerten und entsprechende `TaskManager`-Methode aufrufen.
  3. Schleife wiederholen bis `running` auf `false` gesetzt wird.
  4. Scanner schließen und Abschlussmeldung ausgeben.
