import org.junit.*;
import org.junit.Test;
import junit.framework.*;

public class ToDoListTest extends TestCase {

	// define test fixtures
	private ToDoList toDoList;
	private Task task1;
	private Task task2;
	private Task task3;

	public ToDoListTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// initialize test fixtures
		toDoList = new ToDoList();
		task1 = new Task("1");
		task2 = new Task("2");
		task3 = new Task("3");
	}

	@After
	public void tearDown() throws Exception {
		// uninitialize test fixtures
		toDoList = null;
		task1 = null;
		task2 = null;
		task3 = null;
	}

	@Test
	public void testAddTask() {
		// check null
		assertNotNull(toDoList);
		toDoList.addTask(task1);
		// check size
		assertEquals(toDoList.getAllTasks().size(), 1);
		// check stored task
		assertSame(toDoList.getTask(task1.getDescription()), task1);
	}

	@Test
	public void testGetStatus() {
		// check null
		assertNotNull(toDoList);
		toDoList.addTask(task1);
		// check status
		assertFalse(toDoList.getStatus(task1.getDescription()));
		toDoList.completeTask(task1.getDescription());
		// check new status
		assertTrue(toDoList.getStatus(task1.getDescription()));
	}

	@Test
	public void testRemoveTask() {
		// check null
		assertNotNull(toDoList);
		toDoList.addTask(task1);
		toDoList.addTask(task2);
		toDoList.removeTask(task1.getDescription());
		// check null
		assertNull(toDoList.getTask(task1.getDescription()));
	}

	@Test
	public void testGetCompletedTasks() {
		// check null
		assertNotNull(toDoList);
		toDoList.addTask(task1);
		toDoList.addTask(task2);
		toDoList.addTask(task3);
		toDoList.completeTask(task1.getDescription());
		toDoList.completeTask(task2.getDescription());
		// check size
		assertEquals(toDoList.getCompletedTasks().size(), 2);
	}
}
