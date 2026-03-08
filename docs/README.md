# KopiOKosongPeng User Guide

Welcome to **KopiOKosongPeng**, or in short, Kopi! Kopi is your friendly local task manager, modeled after the drinks stall auntie/uncle at the Kopitiam below your house! It is a local desktop app for managing personal tasks, optimized for use via Command Line Interface (CLI).

Better type properly, Kopi can help you settle and tidy your tasks faster than the drinks stall uncle/auntie can brew that Kopi. Type wrongly and it'll be just as cranky too.

---

## FEATURES

### 1. Adding a Todo task: `todo`
Adds a basic task without any date/time restrictions.
**Format:** `todo <description>`
**Example:** `todo buy toto and bet on Manchester United`

### 2. Adding a Deadline task: `deadline`
Adds a task that needs to be done before a specific date/time.
**Format:** `deadline <description> by <date/time>`
**Example:** `deadline cook dinner for you-know-who by today 1800 hrs`

### 3. Adding an Event task: `event`
Adds a task that starts at a specific date/time and ends at a specific date/time.
**Format:** `event <description> from <start time> to <end time>`
**Example:** `event dinner date with family Friday 20 Feb 2026 from 7 to 9pm`

### 4. Listing all tasks in current list: `list`
Shows you a complete list of all the tasks you have currently saved.
**Format:** `list`

### 5. Marking a task as done: `mark`
Marks a specific task in your list as completed, with an 'X'.
**Format:** `mark <task_number>`
**Example:** `mark 1` (Marks the 1st task in your list as done)

### 6. Unmarking a task: `unmark`
Reverts a completed task back to an incomplete status, removing the 'X'.
**Format:** `unmark <task_number>`
**Example:** `unmark 1`

### 7. Finding a task: `find`
Searches for tasks that contain a specific keyword in their description.
**Format:** `find <keyword>`
**Example:** `find dinner`

### 8. Deleting a task: `delete`
Permanently removes a task from your list, based on the index of the task.
**Format:** `delete <task_number>`
**Example:** `delete 2`

### 9. Exiting the app: `bye`
Saves your data and closes the Kopi app.
**Format:** `bye`

---

## Data Storage
Kopi automatically saves all your tasks to the hard drive (`./data/kopi.txt`) after every single command, thus there is no need to manually save your data. When you reboot Kopi, he will remember everything, like the drinks stall uncle/auntie that remembers your usual Kopi order!