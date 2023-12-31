package org.example.repository;

import org.example.Infraestructure.database.DatabaseFactory;
import org.example.Models.Client;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {

    public List<Client> findClient() throws SQLException {
        var client = new ArrayList<Client>();
        var sql = "SELECT * FROM EH_CLIENT";
        try (
                var conn = DatabaseFactory.getConnection();
                var statment = conn.prepareStatement(sql);
                var result = statment.executeQuery()
        ) {
            while (result.next()) {
                client.add(new Client(
                        result.getLong("ID_CLIENT"),
                        result.getDate("BIRTH_DATE").toLocalDate(),
                        result.getString("NM_EMAIL"),
                        result.getString("NM_CLIENTE"),
                        result.getString("NM_PASSWORD")
                ));

            }
        }
        return client;
    }

    public Optional<Client> findby(String email) throws SQLException {
        var sql = "SELECT * FROM EH_CLIENT WHERE NM_EMAIL = ?";


        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    var client = new Client(
                            rs.getLong("ID_CLIENT"),
                            rs.getDate("BIRTH_DATE").toLocalDate(),
                            rs.getString("NM_EMAIL"),
                            rs.getString("NM_CLIENTE"),
                            rs.getString("NM_PASSWORD")
                    );
                    return Optional.ofNullable(client);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.empty();
    }

    public Optional<Client> findbyid(long idUser) throws SQLException {
        var sql = "SELECT * FROM EH_CLIENT WHERE ID_CLIENT = ?";


        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, idUser);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    var client = new Client(
                            rs.getLong("ID_CLIENT"),
                            rs.getDate("BIRTH_DATE").toLocalDate(),
                            rs.getString("NM_EMAIL"),
                            rs.getString("NM_CLIENTE"),
                            rs.getString("NM_PASSWORD")
                    );
                    return Optional.ofNullable(client);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.empty();
    }

    public Optional<Client> findByEmailAndPassword(String email, String password) throws SQLException {
        var sql = "SELECT * FROM EH_CLIENT WHERE NM_EMAIL = ? AND NM_PASSWORD = ?";

        try (var conn = DatabaseFactory.getConnection();
             var statement = conn.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (var rs = statement.executeQuery()) {
                if (rs.next()) {
                    var client = new Client(
                            rs.getLong("ID_CLIENT"),
                            rs.getDate("BIRTH_DATE").toLocalDate(),
                            rs.getString("NM_EMAIL"),
                            rs.getString("NM_CLIENTE"),
                            rs.getString("NM_PASSWORD")
                    );
                    return Optional.ofNullable(client);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error executing query", e);
            }
        } catch (SQLException e) {
            throw new SQLException("Error connecting to the database", e);
        }

        return Optional.empty();
    }

    public void add(Client client) throws SQLException {
        var sql = "INSERT INTO  EH_CLIENT (ID_CLIENT, NM_CLIENTE,NM_EMAIL, NM_PASSWORD, BIRTH_DATE) VALUES(NUM_ID.NEXTVAL,?,?,?,?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1,client.getNmCliente());
            statement.setString(2,client.getEmail());
            statement.setString(3, client.getPassword());
            statement.setDate(4, Date.valueOf(client.getBirth_date()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    public Client update(Client client) throws SQLException {

        var sql = "UPDATE EH_CLIENT SET NM_CLIENTE = ?, NM_EMAIL = ?, NM_PASSWORD = ?, BIRTH_DATE = ? WHERE ID_CLIENT = ?";
        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, client.getNmCliente());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getPassword());
            statement.setDate(4, Date.valueOf(client.getBirth_date()));
            statement.setLong(5,client.getIdUser());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    public void delete(long idUser) {
        String sql = "DELETE FROM EH_CLIENT WHERE ID_CLIENT = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, idUser);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
