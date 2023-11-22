package org.example.repository;

import org.example.Infraestructure.DatabaseFactory;
import org.example.Models.Disease;
import org.example.Models.Tratament;

import java.lang.annotation.Target;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TratamentRepository {

    public List<Tratament> findTratament() throws SQLException {
        var trat = new ArrayList<Tratament>();
        var sql = "SELECT * FROM EH_TREATMENT";
        try (
                var conn = DatabaseFactory.getConnection();
                var statement = conn.prepareStatement(sql);
                var result = statement.executeQuery()
        ) {
            while (result.next()) {
                trat.add(new Tratament(
                        result.getInt("ID_TREATMENT"),
                        result.getString("RT_MEDICATION"),
                        result.getString("FQ_USE"),
                        result.getString("DS_TREATMETN")
                ));
            }
        }
        return trat;
    }


    public Optional<Tratament> findBy(long IdTreatment) throws SQLException {
        var sql = "SELECT * FROM EH_TREATMENT WHERE ID_TREATMENT = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, IdTreatment);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    var tra = new Tratament(
                            rs.getInt("ID_TREATMENT"),
                            rs.getString("RT_MEDICATION"),
                            rs.getString("FQ_USE"),
                            rs.getString("DS_TREATMETN")
                    );
                    return Optional.ofNullable(tra);
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