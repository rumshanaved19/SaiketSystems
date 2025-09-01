package SAIKETINTERN;
import java.util.*;
class Task {
    private String title;
    private boolean isCompleted;

    // This is a special method called a "constructor" that sets up a new Task object.
    public Task(String title) {
        this.title = title;
        this.isCompleted = false; // Every new task starts as not completed.
    }

    // This method lets  get the title of the task.
    public String getTitle() {
        return title;
    }

    // This method is for marking the task as finished.
    public void markComplete() {
        isCompleted = true;
    }

    // This method checks if the task is completed.
    public boolean isCompleted() {
        return isCompleted;
    }

    // This method gives a nice way to print the task.
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + title;
    }
}

public class ToDoListApp {

   
    private static List<Task> tasks = new ArrayList<>();
    // This tool helps read what the user types in the console.
    private static Scanner scanner = new Scanner(System.in);

    // This is where the program starts.
    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List Application!");

        // This loop keeps the program running until you choose to exit.
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            
            // This checks what the user typed and decides what to do.
            if (input.equals("1")) {
                addTask();
            } else if (input.equals("2")) {
                markTaskComplete();
            } else if (input.equals("3")) {
                viewTasks();
            } else if (input.equals("4")) {
                System.out.println("Exiting application. Goodbye!");
                break; // This command stops the loop and the program ends.
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // This method just prints the menu for the user.
    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add a new task");
        System.out.println("2. Mark a task as complete");
        System.out.println("3. View all tasks");
        System.out.println("4. Exit");
    }

    // This method adds a new task to the list.
    private static void addTask() {
        System.out.print("Enter the task title: ");
        String title = scanner.nextLine();
        tasks.add(new Task(title));
        System.out.println("Task added successfully.");
    }

    // This method shows all the tasks in the list.
    private static void viewTasks() {
        System.out.println("\n--- Your Tasks ---");
        if (tasks.isEmpty()) {
            System.out.println("You have no tasks yet.");
        } else {
            // This loop goes through each task and prints it.
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // This method lets you mark a task as done.
    private static void markTaskComplete() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to mark as complete.");
            return;
        }

        viewTasks(); // We show the tasks so user know which one to choose.
        System.out.print("Enter the number of the task to mark as complete: ");
        String input = scanner.nextLine();
        int taskNumber = Integer.parseInt(input);

        // This checks if the number user entered is valid.
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task taskToComplete = tasks.get(taskNumber - 1); // We get the task from the list.
            if (taskToComplete.isCompleted()) {
                System.out.println("Task is already completed.");
            } else {
                taskToComplete.markComplete();
                System.out.println("Task marked as complete.");
            }
        } else {
            System.out.println("Invalid task number.");
        }
    }
}