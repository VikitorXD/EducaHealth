package org.example.repository;

import org.example.Infraestructure.database.DatabaseFactory;
import org.example.Models.Disease;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiseaseRepository {

    public List<Disease> findDisease() throws SQLException {
        var disease = new ArrayList<Disease>();
        var sql = "SELECT * FROM EH_DISEASES";
        try (
                var conn = DatabaseFactory.getConnection();
                var statment = conn.prepareStatement(sql);
                var result = statment.executeQuery()
        ) {
            while (result.next()) {
                disease.add(new Disease(
                        result.getInt("ID_DISEASE"),
                        result.getString("NM_DISEASE"),
                        result.getString("NM_TYPE"),
                        result.getString("DS_RECURRENCE")
                ));

            }
        }
        return disease;

    }

    public Optional<Disease> findBy(long idDisease) throws SQLException {
        var sql = "SELECT * FROM EH_DISEASES WHERE ID_DISEASE = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, idDisease);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    var disease = new Disease(
                            rs.getLong("ID_DISEASE"),
                            rs.getString("NM_DISEASE"),
                            rs.getString("NM_TYPE"),
                            rs.getString("DS_RECURRENCE")
                    );
                    return Optional.ofNullable(disease);
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
