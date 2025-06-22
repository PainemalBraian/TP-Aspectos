package aop.ejercicio3.model.DAO;

import aop.ejercicio3.model.entities.Persona;
import aop.ejercicio3.model.exceptions.InscripcionException;

public interface InscripcionDAO {
    void guardarInscripcion(Persona persona) throws InscripcionException;
}
