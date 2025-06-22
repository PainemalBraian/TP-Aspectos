package aop.ejercicio3.model.DAO;

import aop.ejercicio3.model.exceptions.ConcursoException;

import java.util.List;

public interface ConcursoDAO {
    List<String> obtenerConcursos() throws ConcursoException;
}
