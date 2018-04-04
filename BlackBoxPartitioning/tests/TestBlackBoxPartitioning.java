import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.es2.blackboxpartitioning.ArrayUtils;
import com.es2.blackboxpartitioning.Die;

class TestBlackBoxPartitioning {

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
	void testDieConstructor() {
		Die d = new Die();
		assertEquals(6, d.getNumSides());
		assertEquals(1, d.getResult());
	}
	
	@Test
	void testDieConstructor1Parameter() {
		Die d = new Die(4);
		
		assertEquals(4, d.getNumSides());
		assertEquals(1, d.getResult());
		
		assertThrows(AssertionError.class, ()->{
			Die d2 = new Die(1);
		});
		assertThrows(AssertionError.class, ()->{
			Die d3 = new Die(7);
		});
	}
	
	@Test
	void testDieConstructor2Parameters() {
		Die d = new Die(4,2);		
		assertEquals(4, d.getNumSides());
		assertEquals(2, d.getResult());
		
		assertThrows(AssertionError.class, ()->{
			Die d2 = new Die(4,5);
		});
		assertThrows(AssertionError.class, ()->{
			Die d2 = new Die(4,0);
		});
	}
	
	@Test
	void testDieRoll() {
		Die d = new Die(2);
		for(int i =0 ;i< 10000;i++) {
			d.roll();
			assertTrue(d.getResult()>=1 && d.getResult()<=6);
		}
		d = new Die(6);
		for(int i =0 ;i< 10000;i++) {
			d.roll();
			assertTrue(d.getResult()>=1 && d.getResult()<=6);
		}
	}
	
	@Test
	void testDieToString() {
		Die d = new Die(2,1);
		assertEquals("Num sides 2 result 1", d.toString());
	}
	
	@Test
	void testArrayUtilsFindMin() {
		int[] lst = new int[20];
		for(int i =0; i< 20; i++) lst[i] = 20-i;		
		assertEquals(19, ArrayUtils.findMin(lst));
		
		/*assertThrows(AssertionError.class, ()->{
			ArrayUtils.findMin(null);
		});*/
		
		int[] lst2 = new int[0];
		assertThrows(AssertionError.class, ()->{
			ArrayUtils.findMin(lst2);
		});
	}
	
	@Test
	void testArrayUtilsResize() {
		int[] lst = new int[20];
		for(int i =0; i< 5; i++) lst[i] = 20-i;
		
		/*assertThrows(AssertionError.class, ()->{
			ArrayUtils.goodResize(null,1);
		});*/
		assertThrows(AssertionError.class, ()->{
			ArrayUtils.goodResize(lst,-1);
		});
		assertTrue(Arrays.equals(new int[]{20,19}, ArrayUtils.goodResize(lst,2)));
		assertTrue(ArrayUtils.goodResize(lst,22).length == 22);
	}

}
