package com.carlos.telegrafo.componentes.concretos.canales;

import com.carlos.telegrafo.componentes.abstractos.Canal;
import com.carlos.telegrafo.modelo.Signal;

public class CableTerrestre extends Canal {

    public CableTerrestre(String nombre, int longitudKm) {
        super(nombre, longitudKm); }

    public void transportar(Signal signal) {
        signal.registrarPaso("Canal: " + this.toString());

        // Reduce progresivamente la fuerza
        // Ejemplo: Pierde 1.0 de potencia por cada Km recorrido.

        double perdida = longitudKm * 1.0;
        signal.reducirPotencia(perdida);
        System.out.printf("[Cable] [%s] -%.1f%% de fuerza. (Actual: %.1f%%)\n", nombre, perdida, signal.getPotencia());
    }
}