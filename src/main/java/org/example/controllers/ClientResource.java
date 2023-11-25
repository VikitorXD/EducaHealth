package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Models.Client;
import org.example.repository.ClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


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
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getUserBy(@PathParam("email") String email) throws SQLException {
        return repository.findby(email).orElse(null);
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
        if(repository.findbyid(idUser).isPresent()){
            client.setIdUser(idUser);
            repository.update(client);
            var livroAtualizado = repository.findbyid(idUser);
            return Response.status(Response.Status.OK)
                    .entity(livroAtualizado).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity(client).build();
    }


    @POST
    @Path("Login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Client loginRequest) {
        try {
            Optional<Client> client = repository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

            return client.map(c -> Response.ok(c).build())
                    .orElse(Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Favor rever suas credenciais")
                            .type(MediaType.TEXT_PLAIN_TYPE)
                            .build());
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Bug no sistema: " + e.getMessage())
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long idUser) throws SQLException {
        repository.delete(idUser);
    }
}
