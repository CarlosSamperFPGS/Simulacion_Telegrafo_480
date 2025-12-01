package com.carlos.telegrafo.componentes.abstractos;

import com.carlos.telegrafo.modelo.Signal;

public abstract class Canal {
    protected String nombre; // Nuevo atributo, identificar el canal
    protected int longitudKm; // Determina la pérdida

    // Constructor
    public Canal(String nombre, int longitudKm) {
        this.nombre = nombre;
        this.longitudKm = longitudKm;
    }

    public abstract void transportar(Signal signal);
}
