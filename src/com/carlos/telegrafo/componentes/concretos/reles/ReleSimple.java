package com.carlos.telegrafo.componentes.concretos.reles;

import com.carlos.telegrafo.componentes.abstractos.Rele;
import com.carlos.telegrafo.modelo.Signal;

public class ReleSimple extends Rele {

    public ReleSimple() {
        super("Relé Simple Estándar"); // Solución A
    }

    public void procesar(Signal signal) {

        // Si la señal es legible, la restaura siempre (energía infinita)
        if (signal.esLegible()) {
            System.out.println("[Relé Simple] Regenerando señal al 100%.");
            signal.restaurarPotencia();
        }
    }
}