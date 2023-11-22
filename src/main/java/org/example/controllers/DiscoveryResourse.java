package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Models.Discovery;
import org.example.Models.Disease;
import org.example.repository.DiscoveryRepository;
import org.example.repository.DiseaseRepository;

import java.sql.SQLException;
import java.util.List;

@Path("discovery")
public class DiscoveryResourse {

    private final DiscoveryRepository repository = new DiscoveryRepository();
    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Discovery> getAll() throws SQLException {
        return repository.findDiscovery();
    }

    @GET
    @Path("{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Discovery getBy(@PathParam("nome") String NMdisease) throws SQLException {
        return repository.findBy(NMdisease).orElse(null);
    }
}
