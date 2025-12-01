package com.carlos.telegrafo.componentes.concretos.reles;

import com.carlos.telegrafo.componentes.abstractos.Rele;
import com.carlos.telegrafo.modelo.Signal;

public class ReleSolar extends Rele {
    private boolean esDeDia = true;// Podría cambiarse aleatoriamente

    public ReleSolar() {
        super("Relé Solar");
    }

    public void procesar(Signal signal) {
        if (esDeDia) {
            System.out.println("[Relé Solar] Paneles activos. Potencia restaurada.");
            signal.restaurarPotencia();
        } else {
            System.out.println("[Relé Solar] Es de noche. No hay energía para amplificar.");
        }
    }
}
