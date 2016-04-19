package message;

import java.text.ParseException;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/messages")
@ApplicationScoped
public class MessageREST{
    MessageController mc = new MessageController();
    
    @GET
    @Produces("application/json")
    public String getAll() {
        return mc.getAll();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getMessageById(@PathParam("id") String id){
        return mc.getMessageById(id);
    }
    
    @GET 
    @Path("/{startDate}/{endDate}/")
    @Produces("application/json")
    public String getMessagebyDate(@PathParam("startDate") String start,
                                   @PathParam("endDate") String end) throws ParseException{
        return mc.getMessagebyDate(start,end);
    }

    @POST 
    @Produces("application/json")
    public Response addMessage(String json){
        return mc.addMessage(json);
    }  

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response deleteMessageById(@PathParam("id") String id){
        return mc.deleteMessageById(id);
    }

    @PUT
    @Path("{id}")
    @Produces("plain/text")
    public Response editMessage(@PathParam("id") String id, String json) {
        return mc.editMessage(id,json);
    }
}