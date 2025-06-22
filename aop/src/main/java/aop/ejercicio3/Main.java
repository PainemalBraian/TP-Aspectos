package aop.ejercicio3;

import aop.ejercicio3.model.ConcursoAPI;
import aop.ejercicio3.model.ConcursoController;
import aop.ejercicio3.model.DAO.ConcursoDAO;
import aop.ejercicio3.model.DAO.InscripcionDAO;
import aop.ejercicio3.persistence.*;
import aop.ejercicio3.ui.RadioCompetition;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // cambiar llamado de metodo según se quiera usar Local o bd
                    new Main().startAlmacenamientoLocal();
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        });
    }

    private void startAlmacenamientoLocal() {
        ConcursoDAO concursoDAO = new ConcursoAlmacenamiento();
        InscripcionDAO inscripcionDAO = new InscripcionAlmacenamiento();
        ConcursoAPI controller = new ConcursoController(concursoDAO, inscripcionDAO);

        new RadioCompetition(controller);
    }


    private void startAlmacenamientoBD() throws SQLException {
        Connection conexion = DBConnect.getConexion();
        ConcursoDAO concursoDAO = new ConcursoAlmacenamientoMySQL(conexion);
        InscripcionDAO inscripcionDAO = new InscripcionAlmacenamientoMySQL(conexion);
        ConcursoAPI controller = new ConcursoController(concursoDAO, inscripcionDAO);

        new RadioCompetition(controller);
    }
}