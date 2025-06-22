package aop.ejercicio3.persistence;

import aop.ejercicio3.model.DAO.InscripcionDAO;
import aop.ejercicio3.model.entities.Persona;
import aop.ejercicio3.model.exceptions.InscripcionException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InscripcionAlmacenamiento implements InscripcionDAO {
    private static final String ARCHIVO_INSCRIPTOS;
    static {
        try {
            File archivoTemporal = File.createTempFile("inscriptos", ".txt");
//            archivoTemporal.deleteOnExit(); // Para que se borre al cerrar la app
            ARCHIVO_INSCRIPTOS = archivoTemporal.getAbsolutePath();
            System.out.println("Path inscripcion TMP: "+ARCHIVO_INSCRIPTOS); //Dirección del archivo temporal

        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el archivo temporal", e);
        }
    }
    @Override
    public void guardarInscripcion(Persona p) throws InscripcionException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_INSCRIPTOS, true))) {
            writer.write(p.getName() + "," + p.getLastName() + "," + p.getDni() + "," + p.getPhone().getPhoneNumber() + "," + p.getEmail().getEmailAdress() + "," + p.getConcurso().getConcursoName());
            writer.newLine();
        } catch (IOException e) {
//            e.printStackTrace();
            throw new InscripcionException("Error al inscribir: "+ e.getMessage() );
        }
    }
}
