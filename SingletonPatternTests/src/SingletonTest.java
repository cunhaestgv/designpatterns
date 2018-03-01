import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.singleton.Registry;

class SingletonTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Test Path variable")
	void testPath() {
		Registry.getInstance().setPath("/user/abc");
		assertEquals("/user/abc", Registry.getInstance().getPath());
	}
	
	@Test
	@DisplayName("Test ConnectionString")
	void testConnectionString() {
		Registry.getInstance().setConnectionString("jdbc://sql");
		assertEquals("jdbc://sql", Registry.getInstance().getConnectionString());
	}

}
