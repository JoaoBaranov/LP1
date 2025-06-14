package atividadedois.dao;

import atividadedois.Classes.Calcado;
import atividadedois.database.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalcadoDAO {

    public void adicionar(Calcado calcado) {
        String sql = "INSERT INTO calcado (marca, modelo, tamanho) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, calcado.getMarca());
            stmt.setString(2, calcado.getModelo());
            stmt.setInt(3, calcado.getTamanho());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editar(Calcado calcado) {
        String sql = "UPDATE calcado SET marca = ?, modelo = ?, tamanho = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, calcado.getMarca());
            stmt.setString(2, calcado.getModelo());
            stmt.setInt(3, calcado.getTamanho());
            stmt.setInt(4, calcado.getId()); // Atualizando pelo ID
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM calcado WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Calcado> listar() {
        List<Calcado> lista = new ArrayList<>();
        String sql = "SELECT * FROM calcado";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Calcado calcado = new Calcado();
                calcado.setId(rs.getInt("id"));
                calcado.setMarca(rs.getString("marca"));
                calcado.setModelo(rs.getString("modelo"));
                calcado.setTamanho(rs.getInt("tamanho"));
                lista.add(calcado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

