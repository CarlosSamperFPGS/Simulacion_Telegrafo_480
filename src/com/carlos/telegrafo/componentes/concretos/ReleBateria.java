package com.carlos.telegrafo.componentes.concretos;

import com.carlos.telegrafo.componentes.abstractos.Rele;
import com.carlos.telegrafo.modelo.Signal;

// Energía limitada y negarse a amplificar si se agota.

public class ReleBateria extends Rele {
    private int nivelBateria;

    public ReleBateria(int nivelInicial) {
        this.nivelBateria = nivelInicial;
    }

    @Override
    public void procesar(Signal signal) {
        // Solo trabajamos si hay señal Y tenemos batería
        if (signal.esLegible() && nivelBateria > 0) {
            System.out.println("[Relé] Señal detectada. ⚡ REGENERANDO Y AMPLIFICANDO.");

            signal.restaurarPotencia();
            nivelBateria -= 10; // Coste energético por operación

            System.out.println("       (Batería restante del relé: " + nivelBateria + "%)");

        } else if (nivelBateria <= 0) {
            System.out.println("[Relé] ⚠️ BATERÍA AGOTADA. Ignorando señal.");
            // No hacemos nada, la señal pasa tal cual (degradada)
        }
    }
}