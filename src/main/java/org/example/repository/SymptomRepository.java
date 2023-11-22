package org.example.repository;

import org.example.Infraestructure.database.DatabaseFactory;
import org.example.Models.Symptom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SymptomRepository {

    public List<Symptom> findSymptom() throws SQLException {
        var symp = new ArrayList<Symptom>();
        var sql = "SELECT * FROM EH_SYMPTOM";
        try (
                var conn = DatabaseFactory.getConnection();
                var statment = conn.prepareStatement(sql);
                var result = statment.executeQuery()
        ) {
            while (result.next()) {
                symp.add(new Symptom(
                        result.getLong("ID_SYMPTOM"),
                        result.getString("DS_SYMPTOM")
                ));

            }
        }
        return symp;
    }

    public Optional<Symptom> findBy(long idSymptom) throws SQLException {
        var sql = "SELECT * FROM EH_SYMPTOM WHERE ID_SYMPTOM = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, idSymptom);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    var symp = new Symptom(
                            rs.getLong("ID_SYMPTOM"),
                            rs.getString("DS_SYMPTOM")
                    );
                    return Optional.ofNullable(symp);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.empty();
    }

}
