

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestWebService {

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
	void testClientDetailsOK() throws IOException {
		URL url = new URL("http://localhost:8080/client/2");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Authorization", "Bearer 123456789");
				
		assertEquals(200, con.getResponseCode());
		
		JSONObject json = new JSONObject(readContent(con));
		
		assertEquals(2,json.getInt("id"));		
		assertTrue(json.getString("name")!= null && json.getString("name") != "");
		assertTrue(json.getString("address")!= null && json.getString("address") != "");
		
		try {
			String nif = json.getString("ssn");
			String prof = json.getString("job");
			
			assertTrue(nif.length()>0);
			assertTrue(prof.length()>0);
		}catch(JSONException e) {}
	}

	@Test
	void testContentType() throws IOException {
		URL url = new URL("http://localhost:8080/client/-1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Authorization", "Bearer 123456789");
		
		con.getResponseCode();
		assertEquals("application/json", con.getHeaderField("Content-type"));
	}
	
	@Test
	void testClientNotExists() throws IOException {
		URL url = new URL("http://localhost:8080/client/-1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Authorization", "Bearer 123456789");
				
		assertEquals(404, con.getResponseCode());
	}
	
	@Test
	void testClientAuthenticationError1() throws IOException {
		URL url = new URL("http://localhost:8080/client/1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
				
		assertEquals(401, con.getResponseCode());
	}
	
	@Test
	void testClientAuthenticationError2() throws IOException {
		URL url = new URL("http://localhost:8080/client/1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Authorization", "Bearer 12345678");
				
		assertEquals(401, con.getResponseCode());
	}
	
	private String readContent(HttpURLConnection con) throws IOException {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		return content.toString();
	}

}
