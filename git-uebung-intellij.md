
# Git-Übung: Arbeiten mit IntelliJ und GitHub im Branch

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
   [https://github.com/settings/tokens](https://github.com/settings/tokens)
5. Klicke **Generate new token** und wähle:
   - Name: `IntelliJ-Git`
   - Expiration: z. B. 90 Tage
   - Scopes: `repo`
6. Klicke **Generate token** und kopiere ihn.
7. Füge den Token in IntelliJ ein und bestätige mit **OK**.

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
Öffne die Datei `App.java` und füge eine neue Methode hinzu: ein eigener Methodenname wäre sinnvoll

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
