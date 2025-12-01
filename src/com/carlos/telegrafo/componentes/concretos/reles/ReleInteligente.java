package com.carlos.telegrafo.componentes.concretos.reles;

import com.carlos.telegrafo.componentes.abstractos.Rele;
import com.carlos.telegrafo.modelo.Signal;

public class ReleInteligente extends Rele {

    public ReleInteligente() {
        super("Relé Smart AI");
    }
    public void procesar(Signal signal) {
        if (!signal.esLegible()) return;

        // Solo amplifica si baja del 70% para ahorrar componentes
        if (signal.getPotencia() < 70) {
            System.out.println("[Relé Smart] Señal baja (" + signal.getPotencia() + "%). Regenerando...");
            signal.restaurarPotencia();
        } else {
            System.out.println("[Relé Smart] Señal óptima. Pase directo (Ahorro energía).");
        }
    }
}