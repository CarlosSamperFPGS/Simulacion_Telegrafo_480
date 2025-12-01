package com.carlos.telegrafo.componentes.concretos.receptores;

import com.carlos.telegrafo.componentes.abstractos.Receptor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class ReceptorConsola extends Receptor {

    public ReceptorConsola(Codificador codificador) {
        super(codificador);
    }


    public void recibir(Signal signal) {
        System.out.println("Cargando señal...");

        if (signal != null && signal.esLegible()) {
            String raw = signal.getMensaje();
            String texto = codificador.decodificar(raw);

            // Formato visual
            System.out.println("SEÑAL RECIBIDA");
            System.out.println("--- " + signal.getRutaCompleta() + " ---");
            System.out.println("CÓDIGO: " + raw);
            System.out.println("[Descodificando...]");
            System.out.println("MENSAJE : " + texto);

        } else {
            System.out.println("ERROR DE TRANSMISIÓN");
            System.out.println("Señal ilegible o degradada.");

            if (signal != null) {
                System.out.println("Última ubicación conocida: " + signal.getUltimoComponente());
            }
        }
    }
}
