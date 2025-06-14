package atividadedois.dao;

import atividadedois.Classes.Instrumento;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentoDAO {

    public void adicionar(Instrumento instrumento) {
        String sql = "INSERT INTO instrumento (nome, tipo, marca) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, instrumento.getNome());
            stmt.setString(2, instrumento.getTipo());
            stmt.setString(3, instrumento.getMarca());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Instrumento instrumento) {
        String sql = "UPDATE instrumento SET nome = ?, tipo = ?, marca = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, instrumento.getNome());
            stmt.setString(2, instrumento.getTipo());
            stmt.setString(3, instrumento.getMarca());
            stmt.setInt(4, instrumento.getId()); // Atualizando pelo ID
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM instrumento WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Instrumento> listar() {
        List<Instrumento> lista = new ArrayList<>();
        String sql = "SELECT * FROM instrumento";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Instrumento instrumento = new Instrumento();
                instrumento.setId(rs.getInt("id"));
                instrumento.setNome(rs.getString("nome"));
                instrumento.setTipo(rs.getString("tipo"));
                instrumento.setMarca(rs.getString("marca"));
                lista.add(instrumento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}