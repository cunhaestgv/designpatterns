import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.whiteboxconditions.Rating;

class TestWhiteBoxCondition {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("Test White-box Conditions of evaluateScoreTemperature()")
	@Test
	void test1() {
		Rating r = new Rating();
		assertEquals("It's hot out, and so am I",r.evaluateScoreTemperature(10,35));
		assertEquals("I'm balanced",r.evaluateScoreTemperature(8,24));
		assertEquals("I'm in a bad mood",r.evaluateScoreTemperature(4,5));
		assertEquals("I'm balanced",r.evaluateScoreTemperature(6,21));
	}
	
	@DisplayName("Test White-box Conditions of evaluateIfCouldBeAcceptedAtDisco()")
	@Test
	void test2() {
		Rating r = new Rating();
		assertEquals("Accepted",r.evaluateIfCouldBeAcceptedAtDisco(8, 5));
		assertEquals("Not Accepted",r.evaluateIfCouldBeAcceptedAtDisco(7,4));
	}

}
