package message;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path("/messages")
@ApplicationScoped
public class MessageService{

    MessageController mc = new MessageController();
    
    @GET
    @Produces("application/json")
    public String getAll() {
        
        return mc.toString();
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String getById(@PathParam("id") int id){
        
      return mc.getMessageById(id).toString();
    }
    
//    @GET
//    @Path("/{startDate}/{endDate}/")
//    @Produces("application/json")
//    public String getByDate(@PathParam("startDate") String start,
//                            @PathParam("endDate") String endd}
//    
//    
//      return "fdfads";
//    }

//    @POST
//    public Response adduser(@FormParam("firstName") String firstName,
//                            @FormParam("lastName") String lastName){
//                
//        JsonObject json = Json.createObjectBuilder()
//                                .add("firstName",firstName)
//                                .add("lastName",lastName)
//                                .build();
//
//        return Response.status(200).entity(json.toString()).build();
//    }
//
//    @PUT
//    @Consumes("application/xml")
//    public void putXml(String content) {
//    }
}


