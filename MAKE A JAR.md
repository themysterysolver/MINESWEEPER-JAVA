# HOW TO MAKE A JAR?

## WHAT'S A JAR?
- A "JAR" file, which stands for *"Java Archive"*, is a **compressed file format** used in Java programming 
*to bundle together multiple Java class files, along with associated metadata and resources like images or text*, into a single package for easier distribution and deployment of applications or libraries;
- essentially acting as a container for all the necessary components of a Java program.
```bash [] 
javac -d out GameBoardGUI.java GameLogic.java Minesweeper.java MineSweeperGUI.java
jar cfm Minesweeper.jar MANIFEST.MF -C out .
java -jar Minesweeper.jar
```

### STEP-1:Save everything  in `.out`
```
javac -d out GameBoardGUI.java GameLogic.java Minesweeper.java MineSweeperGUI.java
```
- Compiles the Java source files and places the compiled `.class` files into the `out` directory.

## What is MANIFEST.MF??

- A manifest file (MANIFEST.MF) is a `metadata file` used in JAR files.
- It contains information about the JAR file, such as the 
  - entry point (main class), 
  - version details, and 
  - package configurations.

- When creating a runnable JAR, the `MANIFEST.MF` file is 
crucial because it tells the `Java Virtual Machine (JVM)` *which class contains the `main()`* method.

### STEPT-2:Create a MANIFEST.MF!

>Manifest-Version: 1.0

- This specifies the manifest file format version.
- Java currently uses version 1.0, and this line is mandatory.
>Main-Class: Minesweeper

- Specifies the entry point for execution.
- This tells Java *which class contains the main(String[] args) method*.
In this case, `Minesweeper.java` is the main class.

```
Manifest-Version: 1.0
Main-Class: Minesweeper

```
### STEP-3:Create the JAR!

```declarative
jar cfm Minesweeper.jar MANIFEST.MF -C out .
```

- `jar` → The Java Archive tool, used to package `.class` files into a `.jar`.
- `c` → Create a new JAR file.
- `f` → Specify the *output JAR file (Minesweeper.jar)*.
- `m` → Include the manifest file (MANIFEST.MF), which tells Java which class has main().
`-C out .`→ ***Move into*** the `out` directory and **package everything inside it**.
  - #### What Happens?
    - All `.class` files inside `out/` are packed into `Minesweeper.jar`.
    - **The manifest file is included**, *making Minesweeper.jar an executable JAR*.

---
### RUN THE JAR!
```
java -jar Minesweeper.java
```

