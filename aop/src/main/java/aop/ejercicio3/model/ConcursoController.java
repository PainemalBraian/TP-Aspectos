package aop.ejercicio3.model;

import aop.ejercicio3.model.DAO.*;
import aop.ejercicio3.model.entities.*;
import aop.ejercicio3.model.exceptions.*;

import java.util.List;

public class ConcursoController implements ConcursoAPI {
    private final ConcursoDAO concursoDAO;
    private final InscripcionDAO inscripcionDAO;

    public ConcursoController(ConcursoDAO concursoDAO, InscripcionDAO inscripcionDAO) {
        this.concursoDAO = concursoDAO;
        this.inscripcionDAO = inscripcionDAO;
    }

    @Override
    public List<String> getTodosLosConcursos() throws ConcursoException {
        try {
            return concursoDAO.obtenerConcursos();
        } catch (Exception e) {
            throw new ConcursoException(e.getMessage());
        }
    }

    @Override
    public void saveInscription(String name, String lastName, String dni, String telefono, String email, String concurso) throws InscripcionException {
        try {
            var persona = new Persona(name, lastName, dni, new Email(email), new Phone(telefono), new Concurso(concurso));
            inscripcionDAO.guardarInscripcion(persona);
        } catch (Exception e) {
            throw new InscripcionException(e.getMessage());
        }
    }
}
