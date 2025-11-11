# Git-Übung: Arbeiten mit IntelliJ und GitHub (Fork-Workflow)

## Ziel
Die Studierenden lernen:
- Ein Repository forken (eigene Kopie erstellen)
- Ein bestehendes Repository klonen
- Branches erstellen und nutzen
- Code erweitern und committen
- Änderungen pushen und Pull Requests erstellen
- GitHub-Authentifizierung mit Personal Access Token (PAT)
- **Den professionellen Fork-Workflow für Open-Source-Projekte**

---

## Wichtig: Warum Fork?

In der echten Praxis können Sie nicht direkt in fremde Repositories pushen. Stattdessen:
1. **Forken** Sie das Repository (erstellen eine eigene Kopie)
2. **Klonen** Sie Ihren Fork (nicht das Original!)
3. **Pushen** Sie in Ihren Fork
4. **Erstellen** Sie einen Pull Request zum Original

Dies ist der Standard-Workflow bei GitHub für Open-Source-Projekte und Team-Arbeit!

---

## GitHub-Authentifizierung mit Token in IntelliJ

1. Öffne IntelliJ.
2. Gehe zu:
   ```
   File → Settings → Version Control → GitHub
   ```
3. Klicke **Add account** → **Log in with token**.
4. Öffne GitHub im Browser und gehe zu:
   - Auf Profil-Bild klicken → Settings → Developer Settings (links ganz unten) → Personal access tokens → Tokens (classic)
   - Oder direkt: [https://github.com/settings/tokens](https://github.com/settings/tokens)
   
5. Klicke **Generate new token (classic)** und wähle:
   - Name: `IntelliJ-Git`
   - Expiration: z. B. 90 Tage
   - Scopes: `repo` (alle Häkchen unter repo)
6. Klicke **Generate token** und kopiere ihn sofort (er wird nur einmal angezeigt!).
7. Füge den Token in IntelliJ ein und bestätige mit **Add Account**.

---

## Teil 1: Repository forken

**WICHTIG: Dieser Schritt ist neu und essentiell!**

1. Öffne das Original-Repository im Browser:
   ```
   https://github.com/dany-meyer/git-uebung
   ```

2. Klicke oben rechts auf **Fork**.

3. GitHub erstellt eine Kopie unter deinem Account:
   ```
   https://github.com/<dein-benutzername>/git-uebung
   ```

4. **Diese Fork-URL wirst du im nächsten Schritt zum Klonen verwenden!**

---

## Teil 2: Repository klonen (aus DEINEM Fork!)

1. In IntelliJ, Menü:
   ```
   File → New → Project from Version Control → Git
   ```

2. **Wichtig:** Gib die URL **DEINES FORKS** ein (nicht das Original!):
   ```
   https://github.com/<dein-benutzername>/git-uebung.git
   ```
   **Nicht:** `https://github.com/dany-meyer/git-uebung.git`

3. Wähle einen lokalen Ordner und klicke **Clone**.

4. IntelliJ fragt nach dem GitHub-Account – wähle deinen Account aus.

---

## Teil 3: Neuen Branch erstellen

1. Menü:
   ```
   Git → Branches → New Branch
   ```

2. Name (mit deinem Namen!):
   ```
   feature/<dein-name>
   ```
   Beispiel: `feature/max-mueller`

3. Klicke **Create** und der Branch wird automatisch ausgecheckt.

---

## Teil 4: Code erweitern

Öffne die Datei `App.java` und füge eine neue Methode hinzu:

```java
public static void greetStudent(String name, String course) {
    System.out.println("Welcome " + name + " to the course " + course + "!");
}
```

**Tipp:** Benenne die Methode individuell, z. B. `greetStudentMaxMueller`, um Konflikte zu vermeiden!

Rufe die Methode in `main` auf:

```java
public static void main(String[] args) {
    System.out.println("Hello World!");
    greetStudent("Max", "Software Engineering");
}
```

Teste das Programm (Run), um sicherzustellen, dass es funktioniert.

---

## Teil 5: Commit & Push (in DEINEN Fork!)

1. Menü:
   ```
   Git → Commit…
   ```
   oder Shortcut: `Ctrl+K` (Windows/Linux) / `Cmd+K` (Mac)

2. Wähle die geänderten Dateien aus (Häkchen setzen).

3. Commit-Nachricht eingeben:
   ```
   Add greetStudent method
   ```

4. Klicke **Commit and Push**.

5. IntelliJ zeigt den Push-Dialog:
   - **Remote:** `origin` (das ist dein Fork!)
   - **Branch:** `feature/<dein-name>`
   - Klicke **Push**

6. **Erfolg!** Der Code ist jetzt in deinem Fork auf GitHub.

---

## Teil 6: Pull Request erstellen (von deinem Fork zum Original)

### Variante A: Auf GitHub im Browser (empfohlen für Anfänger)

1. Gehe zu **deinem Fork** auf GitHub:
   ```
   https://github.com/<dein-benutzername>/git-uebung
   ```

2. GitHub erkennt automatisch deinen neuen Branch und zeigt eine Nachricht:
   ```
   <dein-branch> had recent pushes
   [Compare & pull request]
   ```

3. Klicke **Compare & pull request**.

4. Überprüfe die Einstellungen:
   - **base repository:** `dany-meyer/git-uebung` (das Original)
   - **base:** `main`
   - **head repository:** `<dein-benutzername>/git-uebung` (dein Fork)
   - **compare:** `feature/<dein-name>`

5. Füge eine aussagekräftige Beschreibung hinzu:
   ```
   ## Änderungen
   - Neue Methode greetStudent hinzugefügt
   - Aufruf in main-Methode integriert
   - Getestet und funktioniert
   ```

6. Klicke **Create pull request**.

### Variante B: In IntelliJ

1. Menü:
   ```
   Git → GitHub → Create Pull Request
   ```

2. IntelliJ öffnet ein Fenster:
   - **Base fork:** `dany-meyer/git-uebung`
   - **Base branch:** `main`
   - **Head fork:** `<dein-benutzername>/git-uebung`
   - **Head branch:** `feature/<dein-name>`
   - **Title:** z. B. "Add greetStudent method"
   - **Description:** kurze Beschreibung deiner Änderung

3. Klicke **Create Pull Request**.

---

## Teil 7: Nach dem Merge – Aufräumen

Wenn dein Pull Request vom Dozenten gemergt wurde:

1. **In IntelliJ:**
   ```
   Git → Branches → main → Checkout
   ```

2. **Aktualisiere deinen lokalen main-Branch:**
   ```
   Git → Pull
   ```
   Wähle als Remote: `origin` (dein Fork)

3. **Optional: Upstream einrichten (für spätere Updates)**
   
   Öffne das Terminal in IntelliJ (`Alt+F12` / `Option+F12`) und führe aus:
   ```bash
   git remote add upstream https://github.com/dany-meyer/git-uebung.git
   ```
   
   Damit kannst du später Updates vom Original holen:
   ```bash
   git fetch upstream
   git merge upstream/main
   ```

4. **Lösche den alten Feature-Branch (lokal):**
   ```
   Git → Branches → feature/<dein-name> → Delete
   ```

5. **Lösche den Branch auch auf GitHub (optional):**
   ```bash
   git push origin --delete feature/<dein-name>
   ```
   Oder über die GitHub-Weboberfläche nach dem Merge.

---

## Teil 8: Konflikte erkennen und lösen

Wenn GitHub meldet:
> **This branch has conflicts that must be resolved**

Dann wurde `main` im Original verändert und dein Branch ist nicht mehr kompatibel.

### Konfliktlösung in IntelliJ:

1. **Upstream aktualisieren (falls noch nicht eingerichtet):**
   ```bash
   git remote add upstream https://github.com/dany-meyer/git-uebung.git
   ```

2. **Hole die neuesten Änderungen:**
   ```
   Git → Fetch
   ```

3. **Checkout deines Feature-Branches:**
   ```
   Git → Branches → feature/<dein-name> → Checkout
   ```

4. **Starte ein Rebase auf den aktuellen main:**
   ```
   Git → Rebase… → Onto: upstream/main → Start Rebasing
   ```

5. **IntelliJ zeigt Konflikte an:**
   - Öffne die betroffenen Dateien
   - IntelliJ zeigt einen 3-Wege-Merge-Editor:
     - Links: Deine Änderungen
     - Mitte: Ergebnis
     - Rechts: Änderungen aus main
   - Wähle **Accept Yours**, **Accept Theirs** oder kombiniere manuell
   - Klicke **Apply** wenn fertig

6. **Markiere Konflikte als gelöst:**
   ```
   Git → Rebase → Continue
   ```

7. **Force-Push zu deinem Fork:**
   ```
   Git → Push → Force Push
   ```
   **Achtung:** Force Push nur in deinen eigenen Fork, nie in fremde Repositories!

---

## Zusammenfassung: Der Fork-Workflow

```
1. Fork erstellen auf GitHub
   ↓
2. Fork klonen (nicht das Original!)
   ↓
3. Branch erstellen
   ↓
4. Code ändern und committen
   ↓
5. Push in DEINEN Fork
   ↓
6. Pull Request vom Fork zum Original
   ↓
7. Review & Merge (durch Dozent/Maintainer)
   ↓
8. Lokales Aufräumen
```

---

## Häufige Fehler und Lösungen

### Fehler: "Permission denied" beim Push

**Ursache:** Du versuchst, direkt ins Original zu pushen.

**Lösung:** 
- Prüfe die Remote-URL: `git remote -v`
- Sollte auf deinen Fork zeigen: `https://github.com/<dein-name>/git-uebung.git`
- Falls nicht, Fork klonen und neu starten

### Fehler: "Already up to date" beim Pull Request

**Ursache:** Dein Branch hat keine Änderungen gegenüber main.

**Lösung:**
- Stelle sicher, dass du Änderungen committed hast
- Prüfe mit `git log` ob dein Commit vorhanden ist
- Pushe erneut: `git push origin feature/<dein-name>`

### Fehler: IntelliJ fragt nach Passwort statt Token

**Ursache:** GitHub-Account nicht korrekt in IntelliJ konfiguriert.

**Lösung:**
- Settings → Version Control → GitHub
- Lösche den Account und füge ihn neu mit Token hinzu
- Stelle sicher, dass der Token nicht abgelaufen ist

---

## Empfohlene `.gitignore` für IntelliJ-Projekte

```gitignore
# IntelliJ IDEA
.idea/workspace.xml
.idea/tasks.xml
.idea/shelf/
.idea/usage.statistics.xml
out/
target/

# OS
.DS_Store
Thumbs.db

# Logs
*.log

# Package Files
*.jar
*.war
*.ear
```

---

## Checkliste für die Übung

- [ ] Repository auf GitHub geforkt
- [ ] Eigenen Fork geklont (nicht das Original!)
- [ ] GitHub-Token in IntelliJ eingerichtet
- [ ] Feature-Branch erstellt mit eigenem Namen
- [ ] Code-Änderungen vorgenommen
- [ ] Änderungen getestet (Programm ausgeführt)
- [ ] Changes committed mit aussagekräftiger Message
- [ ] In eigenen Fork gepusht
- [ ] Pull Request vom Fork zum Original erstellt
- [ ] Beschreibung im Pull Request hinzugefügt

---

## Ausblick: Arbeiten im Team-Repository (für spätere Projekte)

In euren eigenen Gruppenprojekten werdet ihr **anders** arbeiten als in dieser Übung!

### Unterschied: Fork-Workflow vs. Team-Workflow

| Aspekt | Fork-Workflow (diese Übung) | Team-Workflow (eure Projekte) |
|--------|----------------------------|-------------------------------|
| **Zugriff** | Kein direkter Schreibzugriff | Alle sind Collaborators |
| **Repository** | Eigener Fork erforderlich | Direkter Zugriff aufs Team-Repo |
| **Klonen** | Fork klonen | Original-Repository klonen |
| **Pushen** | In eigenen Fork pushen | Direkt ins Team-Repository pushen |
| **Workflow** | Fork → PR → Merge | Branch → PR → Merge |

### Team-Workflow für eure Gruppenprojekte

Wenn ihr in euren Projekten arbeitet, seid ihr als **Collaborators** (Mitarbeiter) im Repository eingetragen. Dann funktioniert der Workflow so:

#### 1. Team-Repository direkt klonen (KEIN Fork!)

```
File → New → Project from Version Control
URL: https://github.com/<team-name>/<projekt-name>.git
```

Das ist das Original-Repository eures Teams!

#### 2. Branch erstellen (wie gehabt)

```
Git → Branches → New Branch
Name: feature/<feature-name>
```

**Wichtig:** Arbeitet immer in Feature-Branches, nie direkt in `main`!

#### 3. Code ändern, committen (wie gehabt)

```
Git → Commit… → Commit and Push
```

#### 4. Push direkt ins Team-Repository

```
git push origin feature/<feature-name>
```

**Das funktioniert jetzt**, weil ihr Collaborators seid!

#### 5. Pull Request im Team-Repository erstellen

```
Git → GitHub → Create Pull Request
```

Einstellungen:
- **Base repository:** `<team-name>/<projekt-name>` (euer Team-Repo)
- **Base branch:** `main`
- **Head repository:** `<team-name>/<projekt-name>` (dasselbe Repo!)
- **Compare branch:** `feature/<feature-name>`

#### 6. Code Review durch Teammitglieder

- Mindestens ein Teammitglied sollte den Code reviewen
- Kommentare und Verbesserungsvorschläge diskutieren
- Bei Bedarf weitere Commits pushen

#### 7. Merge durch Teammitglied

- Nach erfolgreichem Review kann jedes Teammitglied den PR mergen
- Auf GitHub: **Merge pull request** → **Confirm merge**
- Branch nach dem Merge löschen (GitHub bietet das an)

#### 8. Lokales Update nach Merge

```bash
# Zurück zu main wechseln
git checkout main

# Neueste Änderungen holen
git pull origin main

# Alten Feature-Branch löschen
git branch -d feature/<feature-name>
```

### Wichtige Team-Regeln

1. **Nie direkt in `main` pushen!**
   - Immer über Feature-Branches arbeiten
   - Immer Pull Requests nutzen

2. **Pull vor Push!**
   - Vor dem Pushen immer `git pull` machen
   - Vermeidet Konflikte

3. **Kleine, häufige Commits**
   - Besser 5 kleine Commits als 1 großer
   - Macht Code Review einfacher

4. **Aussagekräftige Branch-Namen**
   - Gut: `feature/login-page`, `bugfix/navbar-responsive`
   - Schlecht: `test`, `version2`, `fixes`

5. **Code Review ernst nehmen**
   - Mindestens ein Teammitglied sollte reviewen
   - Konstruktives Feedback geben
   - Nicht nur "sieht gut aus" schreiben

6. **Regelmäßig pullen**
   - Täglich den `main`-Branch aktualisieren
   - Verhindert große Merge-Konflikte

### Branch-Protection Rules (optional für fortgeschrittene Teams)

Euer Team kann in den Repository-Settings folgendes einstellen:

```
Settings → Branches → Add rule
```

Empfohlene Rules:
- ✅ **Require pull request reviews before merging** (mindestens 1 Review)
- ✅ **Require status checks to pass** (wenn ihr Tests habt)
- ✅ **Include administrators** (gilt auch für Projekt-Owner)

So wird sichergestellt, dass niemand versehentlich direkt in `main` pusht.

### Typischer Arbeitstag im Team

```bash
# Morgens: Aktuellen Stand holen
git checkout main
git pull origin main

# Neuen Feature-Branch erstellen
git checkout -b feature/mein-feature

# ... Code schreiben, testen ...

# Committen
git add .
git commit -m "Implement feature XY"

# Pushen ins Team-Repository
git push origin feature/mein-feature

# Pull Request auf GitHub erstellen
# → Code Review durch Teammitglied abwarten
# → Nach Merge: Branch aufräumen

git checkout main
git pull origin main
git branch -d feature/mein-feature
```

### Zusammenfassung der beiden Workflows

**Fork-Workflow (diese Übung):**
```
Fremdes Repo → Fork → Clone Fork → Branch → Commit → Push Fork → PR → Original
```

**Team-Workflow (eure Projekte):**
```
Team-Repo → Clone → Branch → Commit → Push Team-Repo → PR → Merge
```

Der Hauptunterschied: Im Team habt ihr **direkten Schreibzugriff**, deshalb braucht ihr keinen Fork!

---

**Viel Erfolg bei der Übung!** 🚀

Bei Fragen: Schau erst in "Häufige Fehler", dann frag deine Kommilitonen oder den Dozenten.