package atividadedois.dao;

import atividadedois.Classes.Filme;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public void adicionar(Filme filme) {
        String sql = "INSERT INTO filme (nome, genero, ano) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getGenero());
            stmt.setInt(3, filme.getAno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Filme filme) {
        String sql = "UPDATE filme SET nome = ?, genero = ?, ano = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getGenero());
            stmt.setInt(3, filme.getAno());
            stmt.setInt(4, filme.getId()); // Atualizando pelo ID
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM filme WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Filme> listar() {
        List<Filme> lista = new ArrayList<>();
        String sql = "SELECT * FROM filme";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setGenero(rs.getString("genero"));
                filme.setAno(rs.getInt("ano"));
                lista.add(filme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
