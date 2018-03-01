import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.objectpool.ObjectNotFoundException;
import com.es2.objectpool.PoolExhaustedException;
import com.es2.objectpool.ReusablePool;

class ObjectPoolTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Test whether important methods are synchronized")
	void testSynchronized() throws NoSuchMethodException, SecurityException {
		if( ! Modifier.isSynchronized(ReusablePool.class.getMethod("acquire").getModifiers()) || 
			! Modifier.isSynchronized(ReusablePool.class.getMethod("release",HttpURLConnection.class).getModifiers()) ||
			! Modifier.isSynchronized(ReusablePool.class.getMethod("resetPool").getModifiers())
		){
			fail("Methods are not thread safe!!! Don't forget that you are moving connections between two lists!!!");	
		}
	}
	
	@Test
	@DisplayName("Test if constructor is not public")
	void testPrivateConstructor() throws NoSuchMethodException, SecurityException{
		if(Modifier.isPublic(ReusablePool.class.getDeclaredConstructor().getModifiers())){
			fail("Singleton objects should protect their constructor!!!");	
		}
	}
	
	@Test
	@DisplayName("Test maximum number of connections for acquiring")
	void testMaxConnectionsWithoutInitMaxConnections() throws IOException, PoolExhaustedException, ObjectNotFoundException {
		ArrayList<HttpURLConnection> conns = new ArrayList<HttpURLConnection>();
		ReusablePool.getInstance().setMaxPoolSize(11);
		for(int i =0; i< 11; i++)
			conns.add(ReusablePool.getInstance().acquire());
		for(int i =0; i< 11; i++)
			ReusablePool.getInstance().release(conns.get(i));
		
		ReusablePool.getInstance().resetPool();
	}
	
	@Test
	@DisplayName("Test if max connections are initialized")
	void testInitMaxConnections() throws IOException, PoolExhaustedException, ObjectNotFoundException {
		ArrayList<HttpURLConnection> conns = new ArrayList<HttpURLConnection>();
		for(int i =0; i< 10; i++)
			conns.add(ReusablePool.getInstance().acquire());
		for(int i =0; i< 10; i++)
			ReusablePool.getInstance().release(conns.get(i));
		ReusablePool.getInstance().resetPool();
	}
	
	@Test
	@DisplayName("Test if PoolExhaustedException is thrown")
	void testThrowsPoolExhaustedException() throws ObjectNotFoundException {
		ArrayList<HttpURLConnection> conns = new ArrayList<HttpURLConnection>();
		assertThrows(PoolExhaustedException.class,
	            ()->{
	            	for(int i =0; i< 11; i++)
	        			conns.add(ReusablePool.getInstance().acquire());
	            });
		
		ReusablePool.getInstance().resetPool();
	}
	
	@Test
	@DisplayName("Test if ObjectNotFoundException is thrown when object released not exists in the pool")
	void testThrowsObjectNotFoundException() {
		assertThrows(ObjectNotFoundException.class,
	            ()->{
	            		HttpURLConnection conn = ReusablePool.getInstance().acquire();
	            		ReusablePool.getInstance().release(conn);
	            		ReusablePool.getInstance().release(conn);
	            });
		ReusablePool.getInstance().resetPool();
	}
}
