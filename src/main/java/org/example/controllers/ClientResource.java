package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Models.Client;
import org.example.repository.ClienteRepository;

import java.sql.SQLException;
import java.util.List;


@Path("client")
public class ClientResource {

    private final ClienteRepository repository = new ClienteRepository();
    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAll() throws SQLException {
        return repository.findClient();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getUserBy(@PathParam("id") int id) throws SQLException {
        return repository.findby(id).orElse(null);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Client client) throws SQLException {
        repository.add(client);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Update(@PathParam("id") long idUser, Client client) throws SQLException{
        if(repository.findby(idUser).isPresent()){
            client.setIdUser(idUser);
            repository.update(client);
            var livroAtualizado = repository.findby(idUser);
            return Response.status(Response.Status.OK)
                    .entity(livroAtualizado).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity(client).build();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long idUser) throws SQLException {
        repository.delete(idUser);
    }
}
