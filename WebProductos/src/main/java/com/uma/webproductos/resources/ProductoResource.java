package com.uma.webproductos.resources;

import com.uma.webproductos.models.ProductoDAO;
import com.uma.webproductos.models.Producto;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.servlet.RequestDispatcher;
import com.uma.webproductos.models.*;
import javax.servlet.http.HttpSession;

@Path("productos") 
public class ProductoResource {

    ProductoDAO dao = new ProductoDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        List<Producto> lista = dao.listarProductos();
        return Response.ok(lista).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Producto p) {
        int n = dao.insertarProducto(p);
        if (n > 0) {
            return Response.status(Response.Status.CREATED).entity("Producto creado").build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al crear").build();
    }
}
