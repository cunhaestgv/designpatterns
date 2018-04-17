import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.es2.causeeffect.GenericList;
import com.es2.causeeffect.PatternNotFoundException;
import com.es2.causeeffect.BoyerMoore;

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
	
	//******************************
	// BoyerMoore
	//******************************
	
	@Test
	void testSearchBoyerTextNull() {
		assertThrows(AssertionError.class, ()->{
			BoyerMoore bm = new BoyerMoore("abc");
			bm.search(null,0);
		});
	}
	@Test
	void testSearchBoyerPatternNull() {
		assertThrows(AssertionError.class, ()->{
			BoyerMoore bm = new BoyerMoore(null);
			bm.search("abc",0);
		});
	}
	
	@Test
	void testSearchBoyerPatternNotFound() {
		BoyerMoore bm = new BoyerMoore("C");
		assertThrows(PatternNotFoundException.class, ()->{
			System.out.println(bm.search("António A",0));
		});
	}
	
	@Test
	void testSearchBoyerPatternLongerThanText() {
		BoyerMoore bm = new BoyerMoore("Carlos Cunha");
		assertThrows(PatternNotFoundException.class, ()->{
			System.out.println(bm.search("Carlos",0));
		});
	}
	
	@Test
	void testSearchBoyerMinCharsHigherThanPatternLength() {
		BoyerMoore bm = new BoyerMoore("Carlos Cunha");
		assertThrows(AssertionError.class, ()->{
			System.out.println(bm.search("Carlos Cunha",15));
		});
	}
	
	@Test
	void testSearchBoyerMinCharsLowerThan0() {
		BoyerMoore bm = new BoyerMoore("Carlos Cunha");
		assertThrows(AssertionError.class, ()->{
			System.out.println(bm.search("Carlos",-1));
		});
	}
	
	@Test
	void testSearchBoyerMinCharsEquals0() throws PatternNotFoundException {
		BoyerMoore bm = new BoyerMoore("Carlos Cunha");
		assertEquals(0, bm.search("Carlos Cunha",0));
	}
	
	@Test
	void testSearchBoyerMinCharsEquals8() throws PatternNotFoundException {
		BoyerMoore bm = new BoyerMoore("Carlos Cunha");
		assertEquals(8, bm.search("António Carlos Cunha",5));
	}
}
