package org.example.pong.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.pong.request.UsuarioRequest;
import org.example.pong.service.UsuarioService;

@Path("/v1/resource/usuarios")
public class UsuarioResource {

    private UsuarioService usuarioService = new UsuarioService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsuario() {
        System.out.println("a");
        return Response.ok(usuarioService.getUsuario()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsuarioById(@PathParam("id") long id) {
        return Response.ok(usuarioService.getUsuarioById(id)).build();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUsuario(UsuarioRequest usuarioRequest) {
        usuarioService.postUsuario(usuarioRequest);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUsuario(@PathParam("id") long id,UsuarioRequest usuarioRequest) {
        usuarioService.updateUsuario(id, usuarioRequest);
        return Response.ok().build();
    }


    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUsuarioById(@PathParam("id") long id) {
        usuarioService.deleteUsuarioById(id);
        return Response.ok().build();
    }
}
