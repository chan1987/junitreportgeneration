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
		assertEquals(10, MyUtils.add(7, 8));
	}

	 @Test
	 public void test_reverse() {
		assertEquals("cba", MyUtils.reverse("abc"));
	}
}
