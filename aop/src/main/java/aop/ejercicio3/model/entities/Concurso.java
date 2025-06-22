package aop.ejercicio3.model.entities;

import aop.ejercicio3.model.exceptions.ConcursoException;

import static java.util.Objects.isNull;

public class Concurso {
    String concurso;

    public Concurso(String concurso) throws ConcursoException {
        if (isNull(concurso)||concurso.isEmpty())
            throw new ConcursoException("El concurso no puede estar vacio, debe elegir un Concurso");
        this.concurso = concurso;
    }

    public String getConcursoName() {
        return concurso;
    }

}
