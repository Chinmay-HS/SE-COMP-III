import java.util.ArrayList; import java.util.Scanner;
public class TaskManager { private ArrayList<String> tasks;

    public TaskManager() { tasks = new ArrayList<>();
    }

    public void addTask(String task) { tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() { if (tasks.isEmpty()) {
        System.out.println("No tasks available.");
    } else {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) { System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) { String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) { TaskManager taskManager = new TaskManager(); Scanner scanner = new Scanner(System.in); String command;

        System.out.println("Welcome to Task Manager!");
        System.out.println("Available commands: add <task>, view, delete <task_number>, exit");

        while (true) {
            System.out.print("Enter command: "); command = scanner.nextLine();
            if (command.startsWith("add ")) { String task = command.substring(4); taskManager.addTask(task);
            } else if (command.equals("view")) { taskManager.viewTasks();
            } else if (command.startsWith("delete ")) { try {
                int taskNumber = Integer.parseInt(command.substring(7)) - 1; taskManager.deleteTask(taskNumber);
            } catch (NumberFormatException e) { System.out.println("Please enter a valid task number.");
            }
            } else if (command.equals("exit")) { System.out.println("Exiting Task Manager."); break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}
