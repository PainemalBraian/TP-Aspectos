package aop.ejercicio3.persistence;

import aop.ejercicio3.model.DAO.ConcursoDAO;
import aop.ejercicio3.model.exceptions.ConcursoException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConcursoAlmacenamiento implements ConcursoDAO {
    private static final String ARCHIVO_CONCURSOS;

    static {
        try {
            // Crear archivo temporal
            File archivoTemporal = File.createTempFile("concursos", ".txt");
//            archivoTemporal.deleteOnExit(); // Se borra al cerrar la app
            ARCHIVO_CONCURSOS = archivoTemporal.getAbsolutePath();


            // Contenido para el archivo temporal
            String contenidoConcursos = """
            Concurso de Fotografía
            Concurso de Pintura
            Concurso de Cocina
            Concurso de Escritura
            Concurso de Baile
            """;

            // Escribir contenido en el archivo temporal recién creado
            Files.writeString(Path.of(ARCHIVO_CONCURSOS), contenidoConcursos);
            System.out.println("Path concursos TMP: " + ARCHIVO_CONCURSOS);

        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el archivo temporal", e);
        }
    }



    @Override
    public List<String> obtenerConcursos() throws ConcursoException {
        List<String> concursos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CONCURSOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    concursos.add(linea.trim());
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new ConcursoException("Error al cargar los concursos" + e.getMessage());
        }

        return concursos;
    }
}

