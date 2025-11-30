package com.carlos.telegrafo.componentes.concretos.canales;

import com.carlos.telegrafo.componentes.abstractos.Canal;
import com.carlos.telegrafo.modelo.Signal;

public class CableSubmarino extends Canal {
    public CableSubmarino(int longitudKm) { super(longitudKm); }

    public void transportar(Signal signal) {
        // Pierde MUY POCO (0.2 por km) porque está aislado y refrigerado por el mar
        double perdida = longitudKm * 0.2;

        signal.reducirPotencia(perdida);

        System.out.printf("[Cable Submarino] %dkm. Potencia actual: %.1f%%\n", longitudKm, signal.getPotencia());
    }
}