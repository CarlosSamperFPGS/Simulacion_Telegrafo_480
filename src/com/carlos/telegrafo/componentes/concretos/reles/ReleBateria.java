package com.carlos.telegrafo.componentes.concretos.reles;

import com.carlos.telegrafo.componentes.abstractos.Rele;
import com.carlos.telegrafo.modelo.Signal;

// Energía limitada y negarse a amplificar si se agota.

public class ReleBateria extends Rele {
    private int nivelBateria;

    public ReleBateria(String id, int nivelInicial) {
        super(id);

        this.nivelBateria = nivelInicial;
    }

    public void procesar(Signal signal) {

        signal.registrarPaso("Relé: " + this.toString());

        // Solo trabajamos si hay señal Y tenemos batería
        if (signal.esLegible() && nivelBateria > 0) {
            System.out.println("[Relé] Señal detectada. ⚡ REGENERANDO Y AMPLIFICANDO.");

            signal.restaurarPotencia();
            nivelBateria -= 10; // Coste energético por operación

            System.out.println("(Batería restante del relé: " + nivelBateria + "%)");

        } else if (nivelBateria <= 0) {
            System.out.println("[Relé] BATERÍA AGOTADA. Ignorando señal.");
            // No hacemos nada, la señal pasa tal cual (degradada)
        }
    }

    public String getStatus() {
        return String.format("Batería: %d%% | Estado: %s", nivelBateria, (nivelBateria > 10 ? "OPERATIVO" : "CRÍTICO"));
    }
}