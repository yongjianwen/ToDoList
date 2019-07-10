import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
	private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask(Task task) {
		tasks.put(task.getDescription(), task);
	}

	public void completeTask(String description) {
		tasks.get(description).setComplete(true);
	}

	public boolean getStatus(String description) {
		return tasks.get(description).isComplete();
	}

	public Task getTask(String description) {
		return tasks.get(description);
	}

	public Task removeTask(String description) {
		return tasks.remove(description);
	}

	public Collection<Task> getAllTasks() {
		return tasks.values();
	}

	public Collection<Task> getCompletedTasks() {
		Collection<Task> allTasks = getAllTasks();
		Collection<Task> completedTasks = new ArrayList<Task>();

		for (Task task : allTasks) {
			if (task.isComplete() == true) {
				completedTasks.add(task);
			}
		}

		return completedTasks;
	}
}
