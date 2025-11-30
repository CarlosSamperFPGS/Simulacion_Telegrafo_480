package com.carlos.telegrafo.componentes.concretos;

import com.carlos.telegrafo.componentes.abstractos.Receptor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class ReceptorConsola extends Receptor {

    public ReceptorConsola(Codificador codificador) {
        super(codificador);
    }

    public void recibir(Signal signal) {
        // Mecanismo para detectar corrupción
        if (signal != null && signal.esLegible()) {
            String texto = codificador.decodificar(signal.getMensaje());
            System.out.println("\n✅ MENSAJE RECIBIDO CORRECTAMENTE: " + texto);
        } else {
            // Generar errores informativos
            System.out.println("\n⛔ ERROR: Señal degradada irreversiblemente o nula.");
        }
    }
}