import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.bridge.APIMoodle;
import com.es2.bridge.APIRequest;
import com.es2.bridge.APIRequestContentAggregator;
import com.es2.bridge.ServiceNotFoundException;


class BridgePatternTest {
	APIRequest req;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@DisplayName("Test if the exception is thrown for not existing services")
	@Test
	void testServiceNotFoundExceptionThrown() {
		req= new APIRequest();
		assertThrows(ServiceNotFoundException.class,
	            ()->{
	            		req.getContent("abc", "12");
	            });
	}
	
	@DisplayName("Test if the request returns null for not existing content")
	@Test
	void testRequestReturnsNull() throws ServiceNotFoundException {
		req= new APIRequest();
		String idService = req.addService(new APIMoodle());
		assertNull(req.getContent(idService, "12"));
	}
	
	@DisplayName("Test if the request returns the content previously added")
	@Test
	void testContentPreviouslyAdded() throws ServiceNotFoundException {
		req= new APIRequest();
		String idService = req.addService(new APIMoodle());
		String idContent = req.setContent(idService, "12");
		assertEquals(req.getContent(idService,idContent),"12");
	}
	
	@DisplayName("Test if the aggregated content of one service is returned correctly")
	@Test
	void testAggregatedContent() throws ServiceNotFoundException {
		req= new APIRequestContentAggregator();
		String idService = req.addService(new APIMoodle());
		req.setContent(idService, "Eu vou");
		req.setContent(idService, " a Viseu");
		req.setContent(idService, " estudar");
		assertEquals(req.getContent(idService,"0"),"Eu vou a Viseu estudar");
	}

}
