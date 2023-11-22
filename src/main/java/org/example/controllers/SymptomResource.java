package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Models.Disease;
import org.example.Models.Symptom;
import org.example.repository.DiseaseRepository;
import org.example.repository.SymptomRepository;

import java.sql.SQLException;
import java.util.List;

@Path("symptom")
public class SymptomResource {

    private final SymptomRepository repository = new SymptomRepository();
    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Symptom> getAll() throws SQLException {
        return repository.findSymptom();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Symptom getBy(@PathParam("id") long idSymptom) throws SQLException {
        return repository.findBy(idSymptom).orElse(null);
    }
}
