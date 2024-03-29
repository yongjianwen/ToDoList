import java.util.Scanner;

public class ToDoListApp {

	private static ToDoList toDoList;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		//String description;

		// initialize a new to-do list
		toDoList = new ToDoList();
		boolean quit=true;
		while (quit) {
			choice = printScreenMenu(scanner);

			switch (choice) {
			case 1:
				addTaskToList(scanner);
				break;
			case 2:
				removeTaskFromList(scanner);
				break;
			case 3:
				viewAllTasks();
				break;
			case 4:
				completeATask(scanner);
				break;
			case 5:
				viewCompletedTasks();
				break;
			case 6:
				quit=false;
				break;
			case 7:
				modifyTask(scanner);
				break;
			}
		}
		System.out.println("goodbye ");

	}

	public static void viewCompletedTasks() {
		// view completed tasks
		System.out.println("All completed tasks: ");
		for (Task eachTask : toDoList.getCompletedTasks()) {
			System.out.println("\t" + eachTask.getDescription() + ": " + "Completed");
		}
	}

	public static void completeATask(Scanner scanner) {
		String description;
		// complete a task
		System.out.print("Please input the task description for the task you wish to complete: ");
		description = scanner.nextLine();
		try {
			toDoList.completeTask(description);
			System.out.println(toDoList.getTask(description).getDescription() + " successfully completed");
		} catch (Exception e) {
			System.out.println("Error in completing task");
		}
	}

	public static void viewAllTasks() {
		// view all tasks
		System.out.println("All tasks: ");
		for (Task eachTask : toDoList.getAllTasks()) {
			System.out.println(
					"\t" + eachTask.getDescription() + ": " + (eachTask.isComplete() ? "Completed" : "Pending"));
		}
	}

	public static void removeTaskFromList(Scanner scanner) {
		String description;
		// remove an existing task
		System.out.print("Please input the task description in which you want to remove: ");
		description = scanner.nextLine();
		if (toDoList.removeTask(description) == null) {
			System.out.println("Task does not exist");
		} else {
			System.out.println("Task removed");
		}
	}

	public static void addTaskToList(Scanner scanner) {
		String description;
		// ask for description of a new task
		System.out.print("Please add the description for a new task: ");
		description = scanner.nextLine();
		Task task = new Task(description);
		toDoList.addTask(task);
	}
	
	private static void modifyTask(Scanner scanner) {
		String description;
		// complete a task
		System.out.print("Please input the task description in which you want to modify: ");
		description = scanner.nextLine();
		task = new Task(description);
		try {
			toDoList.getTask(description);
			System.out.print("Change " + toDoList.getTask(description).getDescription());
			System.out.print("Please input the task description in which you want to modify: ");
			String descriptionNew = scanner.nextLine();
			toDoList.removeTask(description);
			task = new Task(descriptionNew);
			toDoList.addTask(task);
			System.out.println(toDoList.getTask(description).getDescription() + " successfully modified");
		} catch (Exception e) {
			System.out.println("Error in modfy a task");
		}
	}

	public static int printScreenMenu(Scanner scanner) {
		int choice;
		System.out.println("");

		// print system menu
		System.out.println("Please select an option: ");
		System.out.println("1. Add a new task");
		System.out.println("2. Remove an existing task");
		System.out.println("3. View all tasks");
		System.out.println("4. Complete a task");
		System.out.println("5. View completed tasks");
		System.out.println("6. Quit ");
		System.out.println("7. Modify an existing tasks");
		System.out.print("Your  choice: ");
		choice = scanner.nextInt();
		scanner.nextLine();

		System.out.println("");
		return choice;
	}

}
