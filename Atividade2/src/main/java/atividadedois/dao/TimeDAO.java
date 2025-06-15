package atividadedois.dao;

import atividadedois.Classes.Time;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO {

    public void adicionar(Time time) {
        String sql = "INSERT INTO time (nome, pais, titulos) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, time.getNome());
            stmt.setString(2, time.getPais());
            stmt.setInt(3, time.getTitulos());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Time time) {
        String sql = "UPDATE time SET nome = ?, pais = ?, titulos = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, time.getNome());
            stmt.setString(2, time.getPais());
            stmt.setInt(3, time.getTitulos());
            stmt.setInt(4, time.getId()); // Atualizando pelo ID
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM time WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Time> listar() {
        List<Time> lista = new ArrayList<>();
        String sql = "SELECT * FROM time";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Time time = new Time();
                time.setId(rs.getInt("id"));
                time.setNome(rs.getString("nome"));
                time.setPais(rs.getString("pais"));
                time.setTitulos(rs.getInt("titulos"));
                lista.add(time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}