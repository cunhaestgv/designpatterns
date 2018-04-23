package test;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;

@Path("/client/{idclient}")
public class Controller {
	@Context HttpServletRequest req; 

	@GET
	@Produces("application/json")
    public Response clientDetails(@PathParam("idclient") Integer idClient) {
		String key = req.getHeader("Authorization");
		if(key==null || !key.split(" ")[1].equals("123456789")) return Response.status(401).entity("Bad Token").build();
			
		return getClientDetails(req, idClient);
    }

	private Response getClientDetails(HttpServletRequest req, Integer idClient) {

		JSONObject clients = new JSONObject();
		
				
		switch(idClient) {
			case 1 : 
				clients.put("id", idClient);
				clients.put("name", "José das Couves");
				clients.put("address", "Viseu");
				clients.put("ssn", "211888999");
				clients.put("job", "ajudante");
				break;
			case 2 : 
				clients.put("id", idClient);
				clients.put("name", "Maria da Sé");
				clients.put("address", "Porto");
				break;
			case 3 : 
				String s = "<data><id>3</id><name>João dos Coices</name><address>Alentejo</address></data>";
				return Response.status(200).entity(s).build();
			default:
				return Response.status(404).entity("Not found").build();
		}
				
		return Response.status(200).entity(clients.toString()).build();
	}
}
