package org.example.repository;

import org.example.Infraestructure.DatabaseFactory;
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
                        result.getLong("NR_CPF"),
                        result.getString("NM_EMAIL"),
                        result.getString("NM_CLIENTE"),
                        result.getString("NM_PASSWORD")
                ));

            }
        }
        return client;
    }

    public Optional<Client> findby(long idUser) throws SQLException {
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
                            rs.getLong("NR_CPF"),
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

    public void add(Client client) throws SQLException {
        var sql = "INSERT INTO  EH_CLIENT (ID_CLIENT, NM_CLIENTE, NR_CPF,NM_EMAIL, NM_PASSWORD, BIRTH_DATE) VALUES(NUM_ID.NEXTVAL,?,?,?,?,?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1,client.getNmCliente());
            statement.setLong(2,client.getnrcpf());
            statement.setString(3,client.getEmail());
            statement.setString(4, client.getPassword());
            statement.setDate(5, Date.valueOf(client.getBirth_date()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    public Client update(Client client) throws SQLException {

        var sql = "UPDATE EH_CLIENT SET NM_CLIENTE = ?, NR_CPF = ?, NM_EMAIL = ?, NM_PASSWORD = ?, BIRTH_DATE = ? WHERE ID_CLIENT = ?";
        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, client.getNmCliente());
            statement.setLong(2, client.getnrcpf());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getPassword());
            statement.setDate(5, Date.valueOf(client.getBirth_date()));
            statement.setLong(6,client.getIdUser());
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
