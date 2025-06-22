package aop.ejercicio3.model.entities;

import aop.ejercicio3.model.exceptions.EmailException;

import static java.util.Objects.isNull;

public class Email {
    String email;

    public Email(String email) throws EmailException {
        if (checkEmail(email))
            throw new EmailException("Email debe ser válido");
        if (isNull(email)||email.isEmpty())
            throw new EmailException("El Email no debe esta vacio");

        this.email = email.trim();
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String getEmailAdress() {
        return email;
    }

}
