package org.example.repository;

import org.example.Infraestructure.database.DatabaseFactory;
import org.example.Models.Discovery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiscoveryRepository {

    public List<Discovery> findDiscovery() throws SQLException {
        var discoveri = new ArrayList<Discovery>();
        var sql = "SELECT * FROM EH_DISCOVERY";
        try (
                var conn = DatabaseFactory.getConnection();
                var statment = conn.prepareStatement(sql);
                var result = statment.executeQuery()
        ) {
            while (result.next()) {
                discoveri.add(new Discovery(
                        result.getInt("ID_DISCOVERY"),
                        result.getDate("DT_DISCOVERY").toLocalDate(),
                        result.getString("NM_DISCOVER"),
                        result.getString("DS_DISCOVERY")
                ));

            }
        }
        return discoveri;

    }

    public Optional<Discovery> findBy(long idTreatment) throws SQLException {
        var sql = "SELECT * FROM EH_DISCOVERY WHERE ID_DISCOVERY = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, idTreatment);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    var disccoveri = new Discovery(
                            rs.getInt("ID_DISCOVERY"),
                            rs.getDate("DT_DISCOVERY").toLocalDate(),
                            rs.getString("NM_DISCOVER"),
                            rs.getString("DS_DISCOVERY")
                    );
                    return Optional.ofNullable(disccoveri);
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
