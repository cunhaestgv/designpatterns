import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.composite.Link;
import com.es2.composite.Menu;
import com.es2.composite.SubMenu;

class CompositePatternTest {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeAll
	public static void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@AfterAll
	public static void restoreStreams() {
	    System.setOut(System.out);
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	@DisplayName("Test If Menu is abstract")
	void testAbstractClass() {
		if(!Modifier.isAbstract(Menu.class.getModifiers() ))
			fail("Menu should be abstract");
	}
	
	@Test
	@DisplayName("Test If showOption is Abstract")
	void testShowOptionAbstract() throws NoSuchMethodException, SecurityException {
		if(! Modifier.isAbstract(Menu.class.getMethod("showOptions").getModifiers()))
			fail("showOption should be abstract");
	}
	
	@Test
	@DisplayName("Test Output With 3 Level Menus")
	void test3LevelMenu() {
		SubMenu m = new SubMenu();
		m.setLabel("Inserir");
		
		SubMenu client = new SubMenu();
		client.setLabel("Cliente");
		m.addChild(client);
		
		Link enterprise = new Link();
		enterprise.setLabel("Empresarial");
		enterprise.setURL("http://www.abc.pt/empresarial");
		client.addChild(enterprise);
		
		SubMenu particular = new SubMenu();
		particular.setLabel("Particular");
		client.addChild(particular);
		
		Link withVat = new Link();
		withVat.setLabel("Particular com contribuinte");
		withVat.setURL("http://www.abc.pt/pcc");
		particular.addChild(withVat);
		
		m.showOptions();
		
		assertEquals("Inserir\n" + 
				"Cliente\n" + 
				"Empresarial\n" + 
				"http://www.abc.pt/empresarial\n" + 
				"Particular\n" + 
				"Particular com contribuinte\n" + 
				"http://www.abc.pt/pcc\n", outContent.toString());
	}

}
