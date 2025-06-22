package aop.ejercicio3;

import aop.ejercicio3.model.ConcursoAPI;
import aop.ejercicio3.model.ConcursoController;
import aop.ejercicio3.model.DAO.ConcursoDAO;
import aop.ejercicio3.model.DAO.InscripcionDAO;
import aop.ejercicio3.persistence.ConcursoAlmacenamiento;
import aop.ejercicio3.persistence.InscripcionAlmacenamiento;

public class LoggingTest {
    public static void main(String[] args) {
        try {
            // Configurar el controller
            ConcursoDAO concursoDAO = new ConcursoAlmacenamiento();
            InscripcionDAO inscripcionDAO = new InscripcionAlmacenamiento();
            ConcursoAPI controller = new ConcursoController(concursoDAO, inscripcionDAO);

            System.out.println("=== Probando Logging ===");

            // Probar saveInscription - este generará log con parámetros
            System.out.println("\n1. Probando saveInscription:");
            controller.saveInscription("Juan", "Pérez", "12345678", "2991-123456", "asdadsa", "Concurso de Fotografía");

            // Esperar un poco para que cambie el timestamp
            Thread.sleep(2000);

            controller.saveInscription("María", "García", "87654321", "2991-654321", "asdasdas", "Concurso de Pintura");

            // Probar getTodosLosConcursos - este generará log sin parámetros
            System.out.println("\n2. Probando getTodosLosConcursos:");
            controller.getTodosLosConcursos();

            System.out.println("\n=== Revisar el archivo Concurso_logs.txt en la raiz del proyecto ===");

        } catch (Exception e) {
            System.err.println("Error durante la prueba: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

//2. Compilar con Maven:
//   mvn clean compile
//
//3. Ejecutar la aplicación principal:
//
//4. Ejecutar la prueba de logging: