package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Models.Client;
import org.example.Models.Disease;
import org.example.repository.ClienteRepository;
import org.example.repository.DiseaseRepository;

import java.sql.SQLException;
import java.util.List;

@Path("doencas")
public class DisseaseResource {

    private final DiseaseRepository repository = new DiseaseRepository();
    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Disease> getAll() throws SQLException {
        return repository.findDisease();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Disease getBy(@PathParam("id") long idDisease) throws SQLException {
        return repository.findBy(idDisease).orElse(null);
    }
}
