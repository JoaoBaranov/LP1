package atividadedois.dao;

import atividadedois.Classes.Animal;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void adicionar(Animal animal) {
        String sql = "INSERT INTO animais (nome, especie, idade) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setInt(3, animal.getIdade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Animal animal) {
        String sql = "UPDATE animais SET nome = ?, especie = ?, idade = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setInt(3, animal.getIdade());
            stmt.setInt(4, animal.getId()); // Atualizando pelo ID
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM animais WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> listar() {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animais";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setIdade(rs.getInt("idade"));
                lista.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
