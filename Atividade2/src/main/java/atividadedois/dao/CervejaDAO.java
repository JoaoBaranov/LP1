package atividadedois.dao;

import atividadedois.Classes.Cerveja;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CervejaDAO {

    public void adicionar(Cerveja cerveja) {
        String sql = "INSERT INTO cerveja (origem, marca, teor) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cerveja.getOrigem());
            stmt.setString(2, cerveja.getMarca());
            stmt.setInt(3, cerveja.getTeor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Cerveja cerveja) {
        String sql = "UPDATE cerveja SET origem = ?, marca = ?, teor = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cerveja.getOrigem());
            stmt.setString(2, cerveja.getMarca());
            stmt.setInt(3, cerveja.getTeor());
            stmt.setInt(4, cerveja.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cerveja WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cerveja> listar() {
        List<Cerveja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cerveja";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cerveja cerveja = new Cerveja();
                cerveja.setId(rs.getInt("id"));
                cerveja.setOrigem(rs.getString("origem"));
                cerveja.setMarca(rs.getString("marca"));
                cerveja.setTeor(rs.getInt("teor"));
                lista.add(cerveja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

