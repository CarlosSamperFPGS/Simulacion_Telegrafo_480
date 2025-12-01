package com.carlos.telegrafo.componentes.concretos.canales;

import com.carlos.telegrafo.componentes.abstractos.Canal;
import com.carlos.telegrafo.modelo.Signal;

public class EnlaceSimulado extends Canal {

    public EnlaceSimulado(String nombre, int longitudKm) {
        super("Enlace Simulado", 0); }


    public void transportar(Signal signal) {
        // Enlace de laboratorio: No hay pérdida física
        System.out.println("[Enlace Simulado] Transferencia perfecta. Potencia mantenida al " + signal.getPotencia() + "%");
    }
}