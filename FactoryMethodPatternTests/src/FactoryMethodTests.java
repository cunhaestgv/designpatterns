import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.factorymethod.Computer;
import com.es2.factorymethod.FactoryProduct;
import com.es2.factorymethod.Software;
import com.es2.factorymethod.UndefinedProductException;

class FactoryMethodTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Test Public Constructors")
	void testPublicConstructor() throws NoSuchMethodException, SecurityException {
	            	if(Modifier.isPublic(Computer.class.getDeclaredConstructor().getModifiers()) ||
	            			Modifier.isPublic(Software.class.getDeclaredConstructor().getModifiers()))
	            		fail("Constructors of derivated classes cannot be public");
	}
	
	@Test
	@DisplayName("Test Computer Methods")
	void testComputerMethods() throws UndefinedProductException {
		Computer c = (Computer) FactoryProduct.makeProduct("Computer");
		c.setBrand("IBM");
		assertEquals(c.getBrand(),"IBM");
	}
	
	@Test
	@DisplayName("Test Software Methods")
	void testSoftwareMethods() throws UndefinedProductException {
		Software s = (Software) FactoryProduct.makeProduct("Software");
		s.setBrand("Microsoft");
		assertEquals(s.getBrand(), "Microsoft");
	}
	
	@Test
	@DisplayName("Wrong Product Type Handled")
	void testWrongProductType() {
		assertThrows(UndefinedProductException.class,
	            ()->{
	            FactoryProduct.makeProduct("ComputSoft");
	            });
	}

}
