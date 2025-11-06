
# Git-Übung: Arbeiten mit IntelliJ und GitHub

## Ziel
Die Studierenden lernen:
- Ein bestehendes Repository klonen
- Branches erstellen und nutzen
- Code erweitern und committen
- Änderungen pushen und Pull Requests erstellen
- GitHub-Authentifizierung mit Personal Access Token (PAT)

---

## GitHub-Authentifizierung mit Token in IntelliJ

1. Öffne IntelliJ.
2. Gehe zu:
   ```
   File → Settings → Version Control → GitHub
   ```
3. Klicke **Add account** → **Log in with token**.
4. Öffne GitHub im Browser und gehe zu:
   auf Profil-Bild klicken -> Settings --> Developer Settings (links ganz unten) --> personal access tokens
   [https://github.com/settings/tokens](https://github.com/settings/tokens)
6. Klicke **Generate new token** und wähle:
   - Name: `IntelliJ-Git`
   - Expiration: z. B. 90 Tage
   - Scopes: `repo`
7. Klicke **Generate token** und kopiere ihn.
8. Füge den Token in IntelliJ ein und bestätige mit **OK**.

---

## Teil 1: Repository klonen
1. Menü:
   ```
   File → New → Project from Version Control → Git
   ```
2. Gib die GitHub-URL ein:
   ```
   https://github.com/<dein-benutzername>/<dein-repo>.git
   z.b. https://github.com/dany-meyer/git-uebung.git
   ```
3. Wähle einen lokalen Ordner und klicke **Clone**.

---

## Teil 2: Neuen Branch erstellen
1. Menü:
   ```
   Git → Branches → New Branch
   ```
2. Name:
   ```
   feature/<dein-name>
   ```
3. Klicke **Create** und **Checkout**.

---

## Teil 3: Code erweitern
Öffne die Datei `App.java` und füge eine neue Methode hinzu: eine eigene Methode mit speziellem Namen wäre sinnvoll

```java
public static void greetStudent(String name, String course) {
    System.out.println("Welcome " + name + " to the course " + course + "!");
}
```

Rufe die Methode in `main` auf:

```java
greetStudent("Alice", "git");
```

---

## Teil 4: Commit & Push
1. Menü:
   ```
   VCS → Commit…
   ```
2. Nachricht:
   ```
   Add greetStudent method
   ```
3. Klicke **Commit and Push**.

---

## Teil 5: Pull Request auf GitHub
1. Gehe zu deinem Repository auf GitHub.
2. Öffne einen Pull Request von deinem Branch zu `main`.
3. Füge eine kurze Beschreibung hinzu und klicke **Create Pull Request**.

---
## Teil 6: Pull Request mergen und Konflikte lösen
Pull Request erstellen (in IntelliJ oder auf GitHub)
Pull Requests müssen nicht zwingend auf GitHub im Browser erstellt werden – IntelliJ kann das direkt übernehmen.

#### Variante A: In IntelliJ
1. Menü:
   ```
   Git → GitHub → Create Pull Request
   ```
2. IntelliJ öffnet ein Fenster:
   - **Base branch:** `main`
   - **Compare branch:** dein Feature-Branch
   - **Title:** z. B. „Add greetStudent method“
   - **Description:** kurze Beschreibung deiner Änderung
3. Optional: **Reviewer** auswählen (falls das Repository das verlangt).
4. Klicke **Create Pull Request** – IntelliJ öffnet den PR auf GitHub automatisch.

#### Variante B: Auf GitHub im Browser
1. Gehe zu deinem Repository.
2. GitHub erkennt automatisch deinen neuen Branch und schlägt einen Pull Request vor.
3. Klicke **Compare & pull request**, beschreibe die Änderung und bestätige mit **Create pull request**.

---

### Pull Request mergen
1. Nach der Codeprüfung (Review) kann der Pull Request gemergt werden:
   - Auf GitHub: **Merge pull request** → **Confirm merge**
   - Oder direkt in IntelliJ:
     - Öffne das **Git Tool Window**
     - Wähle **Git → GitHub → View Pull Requests**
     - Dort kannst du den PR öffnen, prüfen und über das Menü **Merge Pull Request** abschließen
2. Nach dem Merge:
   - Der Code deines Branches ist jetzt Teil von `main`.
   - Lokale Bereinigung:
     ```
     git checkout main
     git pull --ff-only
     git branch -d feature/<dein-name>
     git push origin --delete feature/<dein-name>
     ```

---

### Konflikte erkennen und lösen
Wenn GitHub oder IntelliJ meldet:
> **This branch has conflicts that must be resolved**

Dann wurde `main` verändert und dein Branch ist nicht mehr kompatibel.

#### Konfliktlösung in IntelliJ:
1. Aktualisiere zuerst den `main`-Branch:
   ```
   Git → Fetch
   ```
2. Starte ein Rebase deines Branches auf `main`:
   ```
   Git → Rebase… → Onto: origin/main → Start
   ```
3. IntelliJ zeigt die Konfliktdateien an:
   - Öffne die betroffene Datei.
   - Wähle **Accept Yours**, **Accept Theirs** oder führe manuell zusammen.
   - Danach: **Mark as Resolved**.
4. Setze das Rebase fort:
   ```
   Git → Rebase → Continue
   ```
5. Wenn der Rebase abgeschlossen ist:
   ```
   git push --force-with-lease
   ```
   (in IntelliJ über **Git → Push**, dann im Dropdown  **Force Push** auswählen)

---
Nach dem Merge zum main-Zweig zurückkehren und mit Pull den Merge holen. Der Hauptast ist jetzt aktualisiert.

---

## Empfohlene `.gitignore` für IntelliJ-Projekte
```gitignore
# IntelliJ IDEA
.idea/workspace.xml
.idea/tasks.xml
.idea/shelf/
out/
target/
.DS_Store
*.log
```

---
