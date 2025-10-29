# DevelopmentDAM

Repository of Development (DAM) exercises and assignments in Java.

This project contains examples and tasks organized by units (u1, u2, u3, ...). It's intended as a collection of small Java programs to practice basic concepts: variables, operators, input/output, conditionals, loops, etc.

License: MIT — source files include license headers.

---

## Requirements

- JDK 11+ installed (also works with JDK 17, 21, etc.).
- Shell: zsh/bash recommended for the example commands.

## Compile and run

The project doesn't include a build system (Maven/Gradle) by default. Here are commands to compile and run from the command line.

Compile all Java files and place compiled classes in the `out` folder:

```bash
# from the repository root
mkdir -p out
javac -d out $(find src -name "*.java")
```

Run the main class `Main` (if present):

```bash
java -cp out Main
```

Run a specific task that uses packages (for example `u3.tasks.task12`):

```bash
# compile only the task (optional)
javac -d out src/u3/tasks/task12.java
# run using the fully qualified package name
java -cp out u3.tasks.task12
```

If you want to compile and run in one go (useful for quick tests):

```bash
# compile
javac -d out src/u3/tasks/task12.java
# run
java -cp out u3.tasks.task12
```

## Example usage

The task `u3.tasks.task12` implements a "Guess the number" game. When you run it you'll be prompted to enter numbers and the program will give hints until you guess the secret number.

## Best practices and recommendations

- Consider adding a `build.gradle` or `pom.xml` if you want automated builds and IDE/CI integration.
- Add a `run.sh` script or `Makefile` with common build/run commands to simplify the workflow.
- Add unit tests if parts of the repository grow and need automated verification.

## Contributions

If you'd like to contribute:
- Fork the repository
- Add your exercises/solutions inside the appropriate folder (`u4`, `u5`, etc.)
- Open a pull request describing your changes

## Author
Tomas Palma Sanchez

---

If you'd like, I can also generate a `Makefile`, a basic `build.gradle`, or run scripts (or translate the README into another language); tell me which option you prefer and I'll add it.
