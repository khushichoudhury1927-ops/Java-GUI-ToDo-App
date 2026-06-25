# Task 6 – Java GUI To-Do App

This is my sixth project for the ElevateLabs Java Developer Internship. After five tasks of console-based programs, this one was about stepping into desktop GUI development using Java Swing.

## What I built

A simple To-Do list app with a text field to type in tasks, an "Add Task" button, and the tasks showing up in a scrollable list below. You can select any task and hit "Delete Selected" to remove it, or "Clear All" to wipe the whole list (with a confirmation popup so you don't accidentally lose everything). I also wired up the Enter key so you can add a task without reaching for the mouse.

The app is split into two files. `ToDoApp.java` is the actual JFrame window — it builds the layout, holds the list model, and has the methods for adding, deleting, and clearing tasks. `Main.java` is just the entry point that launches the GUI safely on the Event Dispatch Thread using `SwingUtilities.invokeLater()`.

A small label at the bottom keeps a live count of how many tasks are currently in the list.

## Project structure

```
task6-todo-app/
├── ToDoApp.java    ← the GUI window and all its logic
├── Main.java       ← entry point
└── README.md
```

## How to run

```bash
cd task6-todo-app
javac *.java
java Main
```

A window titled "My To-Do List" should pop up.

## Concepts covered

**Swing Components** — `JFrame`, `JTextField`, `JButton`, `JList`, `JScrollPane`, `JLabel`, and `JPanel` are all used here to build the window.

**Layout Managers** — I used `BorderLayout` for the main window structure (input on top, list in the middle, buttons at the bottom), and `GridLayout` to split the Delete and Clear buttons evenly.

**Event Handling** — Both buttons use `ActionListener` (written as lambdas), and the text field has a `KeyListener` so pressing Enter triggers the same add-task action as clicking the button.

**Event Dispatch Thread** — The whole GUI is launched inside `SwingUtilities.invokeLater()`, which is the correct way to start a Swing app so all UI updates happen safely on the EDT instead of the main thread.

**DefaultListModel** — Instead of manually managing an array for the task list, I used `DefaultListModel<String>` paired with `JList`, which makes adding/removing items and keeping the UI in sync much simpler.
