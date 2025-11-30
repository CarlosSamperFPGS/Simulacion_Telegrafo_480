package com.carlos.telegrafo.componentes.abstractos;

import com.carlos.telegrafo.modelo.Signal;

public abstract class Canal {
    protected int longitudKm; // Determina la pérdida

    // Constructor
    public Canal(int longitudKm) {
        this.longitudKm = longitudKm;
    }

    public abstract void transportar(Signal signal);
}
