package aop.ejercicio3.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
public class LoggingAspect {

    private static final String LOG_FILE = "Concurso_logs.txt";
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Before("@annotation(aop.ejercicio3.aspects.Log)")
    public void logMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String timestamp = LocalDateTime.now().format(DATE_FORMAT);

        // Formatear parámetros según especificación
        String parameters = formatParameters(args);

        // Escribir al archivo de log
        writeToLogFile(methodName, parameters, timestamp);

        // Debug en consola
        System.out.printf("LOG: \"%s\", \"%s\", \"%s\"%n", methodName, parameters, timestamp);
    }

    private String formatParameters(Object[] args) {
        if (args == null || args.length == 0) {
            return "sin parametros";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                sb.append("|");
            }
            sb.append(args[i] != null ? args[i].toString() : "null");
        }
        return sb.toString();
    }

    private void writeToLogFile(String methodName, String parameters, String timestamp) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.printf("\"%s\", \"%s\", \"%s\"%n", methodName, parameters, timestamp);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error escribiendo al archivo de log: " + e.getMessage());
        }
    }
}