package aop.ejercicio3.persistence;

import aop.ejercicio3.model.DAO.ConcursoDAO;
import aop.ejercicio3.model.exceptions.ConcursoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConcursoAlmacenamientoMySQL implements ConcursoDAO {
    private Connection conexion;

    public ConcursoAlmacenamientoMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<String> obtenerConcursos() throws ConcursoException {
        List<String> concursos = new ArrayList<>();
        String sql = "SELECT nombre FROM concursos";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                concursos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new ConcursoException("Error al obtener concursos: " + e.getMessage());
        }

        return concursos;
    }
}
