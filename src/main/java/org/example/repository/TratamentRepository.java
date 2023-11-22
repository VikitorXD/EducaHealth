package org.example.repository;

import org.example.Infraestructure.database.DatabaseFactory;
import org.example.Models.Tratament;

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
                        result.getString("DS_TREATMETN"),
                        result.getString("NM_DISEASE")
                ));
            }
        }
        return trat;
    }


    public Optional<Tratament> findBy(String NMdisease) throws SQLException {
        var sql = "SELECT * FROM EH_TREATMENT WHERE NM_DISEASE = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, NMdisease);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    var tra = new Tratament(
                            rs.getInt("ID_TREATMENT"),
                            rs.getString("RT_MEDICATION"),
                            rs.getString("FQ_USE"),
                            rs.getString("DS_TREATMETN"),
                            rs.getString("NM_DISEASE")
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
