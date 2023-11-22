package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Models.Symptom;
import org.example.Models.Tratament;
import org.example.repository.SymptomRepository;
import org.example.repository.TratamentRepository;

import java.sql.SQLException;
import java.util.List;

@Path("tratament")
public class TratamentResource {

    private final TratamentRepository repository = new TratamentRepository();
    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tratament> getAll() throws SQLException {
        return repository.findTratament();
    }

    @GET
    @Path("{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tratament getBy(@PathParam("nome") String NMdisease ) throws SQLException {
        return repository.findBy(NMdisease).orElse(null);
    }
}
