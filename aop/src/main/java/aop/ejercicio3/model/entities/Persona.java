package aop.ejercicio3.model.entities;

import aop.ejercicio3.model.exceptions.PersonaException;

import static java.util.Objects.isNull;

public class Persona {
    private String name;
    private String lastName;
    private String dni;
    private Email email;
    private Phone phone;
    private Concurso concurso;

    public Persona(String name, String lastName, String dni, Email email, Phone phone, Concurso concurso) throws PersonaException {
        validarNombres(name, lastName);
        validarDNI(dni);

        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.concurso = concurso;
    }

    private static void validarNombres(String name, String lastName) throws PersonaException {
        if (name.isEmpty() || isNull(name)) // Es correcto el uso de Null ?, seria muy engorrozo cambiar todos los datos por un Optional<String>
            throw new PersonaException("El nombre no puede estar vacio");
        if (lastName.isEmpty() || isNull(lastName))
            throw new PersonaException("El apellido no puede estar vacio");
    }

    private static void validarDNI(String dni) throws PersonaException {
        if (dni.isEmpty() || isNull(dni))
            throw new PersonaException("El DNI no puede estar vacio");
        if (!dni.matches("\\d{8}"))
            throw new PersonaException("El DNI debe tener exactamente 8 dígitos numéricos");
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDni() {
        return dni;
    }

    public Email getEmail() {
        return email;
    }

    public Phone getPhone() {
        return phone;
    }

    public Concurso getConcurso() {
        return concurso;
    }

}
