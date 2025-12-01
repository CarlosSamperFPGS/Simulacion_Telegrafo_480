package com.carlos.telegrafo.excepciones;

// Excepción personalizada para errores específicos del dominio del telégrafo

public class TelegraphException extends RuntimeException {

    public TelegraphException(String mensaje) {
        super(mensaje);
    }
}
