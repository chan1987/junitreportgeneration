package junitreportgeneration;
import static org.junit.Assert.*;
import org.junit.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import junitreportgeneration.MyUtils;

public class MyUtilsTest {

	 @Test
	public void setUpBeforeClass() throws Exception {
		System.out.println("Set Up Before Class - @BeforeAll");
	}

	 @Test
	 public void tearDownAfterClass() throws Exception {
		System.out.println("Tear Down After Class - @AfterAll");
	}

	 @Test
	 public void setUp() throws Exception {
		System.out.println("Set Up @BeforeEach");
	}

	 @Test
	 public void tearDown() throws Exception {
		System.out.println("Tear Down @AfterEach");
	}

	 @Test
	 public void test_add() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		assertEquals(16, MyUtils.add(7, 9));
=======
		assertEquals(16, MyUtils.add(7, 5));
>>>>>>> 6cede9ca9d2bf2a7b96f6827bbfb91d695b3b772
=======
		assertEquals(10, MyUtils.add(7, 9));
>>>>>>> 3ddd368 (7,9 added v9.0.1)
=======
		assertEquals(16, MyUtils.add(7, 9));
>>>>>>> 7798ef3 (success test)
	}

	 @Test
	 public void test_reverse() {
		assertEquals("cba", MyUtils.reverse("abc"));
	}
}
