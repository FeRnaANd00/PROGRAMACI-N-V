package com.uma.webproductos.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("javaee")
public class JakartaEE11Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping Java EE")
                .build();
    }
}
