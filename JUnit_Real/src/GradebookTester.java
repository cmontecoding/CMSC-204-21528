import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

	Gradebook gradebook1;
	Gradebook gradebook2;
	
	@BeforeEach
	void setUp() throws Exception {
		gradebook1 = new Gradebook(5);
		gradebook1.addScore(0);
		gradebook1.addScore(2.5);
		gradebook2 = new Gradebook(5);
		gradebook2.addScore(0);
		gradebook2.addScore(3.5);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	void testAddScore() {
		gradebook1.addScore(0.7);
		assertEquals(gradebook1.sum(), 3.2);
		gradebook2.addScore(0.7);
		assertEquals(gradebook2.sum(), 4.2);
	}

	@Test
	void testSum() {
		assertEquals(gradebook1.sum(), 2.5);
		assertEquals(gradebook2.sum(), 3.5);
	}

	@Test
	void testMinimum() {
		assertEquals(gradebook1.minimum(), 0);
		assertEquals(gradebook2.minimum(), 0);
	}

	@Test
	void testFinalScore() {
		assertEquals(gradebook1.finalScore(), 2.5);
		assertEquals(gradebook2.finalScore(), 3.5);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(gradebook1.getScoreSize(), 2);
		assertEquals(gradebook2.getScoreSize(), 2);
	}

	@Test
	void testToString() {
		assertTrue(gradebook1.toString().equals("0.0 2.5 "));
		assertTrue(gradebook2.toString().equals("0.0 3.5 "));
	}

}
