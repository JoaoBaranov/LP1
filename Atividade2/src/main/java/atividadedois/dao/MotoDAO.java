package atividadedois.dao;

import atividadedois.Classes.Moto;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {

    public void adicionar(Moto moto) {
        String sql = "INSERT INTO moto (nome, marca, cilindrada) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, moto.getNome());
            stmt.setString(2, moto.getMarca());
            stmt.setInt(3, moto.getCilindrada());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Moto moto) {
        String sql = "UPDATE moto SET nome = ?, marca = ?, cilindrada = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, moto.getNome());
            stmt.setString(2, moto.getMarca());
            stmt.setInt(3, moto.getCilindrada());
            stmt.setInt(4, moto.getId()); // Atualizando pelo ID
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM moto WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Moto> listar() {
        List<Moto> lista = new ArrayList<>();
        String sql = "SELECT * FROM moto";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Moto moto = new Moto();
                moto.setId(rs.getInt("id"));
                moto.setNome(rs.getString("nome"));
                moto.setMarca(rs.getString("marca"));
                moto.setCilindrada(rs.getInt("cilindrada"));
                lista.add(moto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}