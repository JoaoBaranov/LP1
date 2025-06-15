package atividadedois.dao;

import atividadedois.Classes.Roupa;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoupaDAO {

    public void adicionar(Roupa roupa) {
        String sql = "INSERT INTO roupa (tipo, cor, tamanho) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, roupa.getTipo());
            stmt.setString(2, roupa.getCor());
            stmt.setInt(3, roupa.getTamanho());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Roupa roupa) {
        String sql = "UPDATE roupa SET tipo = ?, cor = ?, tamanho = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, roupa.getTipo());
            stmt.setString(2, roupa.getCor());
            stmt.setInt(3, roupa.getTamanho());
            stmt.setInt(4, roupa.getId()); // Atualizando pelo ID
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM roupa WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Roupa> listar() {
        List<Roupa> lista = new ArrayList<>();
        String sql = "SELECT * FROM roupa";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Roupa roupa = new Roupa();
                roupa.setId(rs.getInt("id"));
                roupa.setTipo(rs.getString("tipo"));
                roupa.setCor(rs.getString("cor"));
                roupa.setTamanho(rs.getInt("tamanho"));
                lista.add(roupa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}