import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.es2.causeeffect.GenericList;

class TestGCE {

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

	@Test
	void testInsert_LowerLimit() {
		GenericList list = new GenericList();
		
		list.insert(0, new Object());
		list.insert(list.size(), new Object());
		
	}
	
	@Test
	void testInsert_PosNegative() {
		GenericList list = new GenericList();
				
		assertThrows(AssertionError.class, ()->{
			list.insert(-1, new Object());
		});
	}
	
	@Test
	void testInsert_ExceedPosSize() {
		GenericList list = new GenericList();
		
		assertThrows(AssertionError.class, ()->{
			list.insert(list.size()+1, new Object());
		});
	}
	
	@Test
	void testInsert_NullObject() {
		GenericList list = new GenericList();
		
		assertThrows(AssertionError.class, ()->{
			list.insert(0, null);
		});
	}
}
