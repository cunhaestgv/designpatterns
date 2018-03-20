import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.decorator.Auth;
import com.es2.decorator.AuthException;
import com.es2.decorator.AuthInterface;
import com.es2.decorator.CommonWordsValidator;
import com.es2.decorator.Logging;

class TestDecorator {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@BeforeAll
	public static void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@AfterAll
	public static void tearDownAfterClass() {
	    System.setOut(System.out);
	}

	@DisplayName("Test if authentication is performed correctly using admin/admin")
	@Test
	void testRightAuthWithoutDecorators() throws AuthException, IOException {
		AuthInterface auth = new Auth();
		
		auth.auth("admin", "admin");
	}
	
	@DisplayName("Test if authentication exception is thrown for bad authentication")
	@Test
	void testWrongAuthWithoutDecorators() throws AuthException, IOException {
		AuthInterface auth = new Auth();
		
		assertThrows(AuthException.class, ()->{
			auth.auth("admin1", "admin1");
		});
	}
	
	@DisplayName("Test if Logging is decorating correctly the authentication")
	@Test
	void testLoggingDecorator() throws AuthException, IOException {
		AuthInterface auth = new Logging(new Auth());
		
		auth.auth("admin", "admin");
		assertTrue(outContent.toString().contains("auth()"));
	}
	
	@DisplayName("Test if CommonWordsValidator is decorating correctly the authentication")
	@Test
	void testCommonWordsValidatorDecorator() throws AuthException, IOException {
		AuthInterface auth = new CommonWordsValidator(new Auth());
		
		auth.auth("admin", "admin");
	}
	
	@DisplayName("Test if CommonWordsValidator is decorating correctly the authentication")
	@Test
	void testCommonWordsValidatorDecoratorIfFalse() throws AuthException, IOException {
		AuthInterface auth = new CommonWordsValidator(new Auth());
		
		assertThrows(AuthException.class,()->{
			auth.auth("admin1", "admin1");
		});
	}
	
	@DisplayName("Test if Logging and CommonWordsValidator is decorating correctly the authentication")
	@Test
	void testLoggingCommonWordsValidatorDecorator() throws AuthException, IOException {
		AuthInterface auth = new CommonWordsValidator(new Logging(new Auth()));
		
		auth.auth("admin", "admin");
	}

}
