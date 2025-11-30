package com.carlos.telegrafo.componentes.concretos.canales;

import com.carlos.telegrafo.componentes.abstractos.Canal;
import com.carlos.telegrafo.modelo.Signal;

public class CableTerrestre extends Canal {

    public CableTerrestre(int longitudKm) {
        super(longitudKm);
    }

    public void transportar(Signal signal) {

        // Reduce progresivamente la fuerza
        // Ejemplo: Pierde 1.0 de potencia por cada Km recorrido.

        double perdida = longitudKm * 1.0;
        signal.reducirPotencia(perdida);

        System.out.printf("[Cable Terrestre] Transporte por %d km. Potencia restante: %.1f%%\n", longitudKm, signal.getPotencia());
    }
}