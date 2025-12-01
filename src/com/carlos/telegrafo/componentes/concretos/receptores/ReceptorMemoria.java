package com.carlos.telegrafo.componentes.concretos.receptores;

import com.carlos.telegrafo.componentes.abstractos.Receptor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;
import java.util.ArrayList;
import java.util.List;

public class ReceptorMemoria extends Receptor {

    // Estructura interna (Lista en RAM)
    private List<String> historialMensajes;

    public ReceptorMemoria(Codificador codificador) {
        super(codificador);
        this.historialMensajes = new ArrayList<>();
    }

    public void recibir(Signal signal) {
        if (signal != null && signal.esLegible()) {
            String raw = signal.getMensaje();
            String texto = codificador.decodificar(raw);

            // Guardamos un string formateado con toda la info
            String entradaMemoria = String.format("MSG: '%s' (Cod: %s) [Vía: %s]",
                    texto, raw, signal.getUltimoComponente());

            historialMensajes.add(entradaMemoria);
            System.out.println("[Receptor Memoria] Guardado en RAM. Total entradas: " + historialMensajes.size());
        }
    }

    // Métodos para consultar lo guardado (útil para debug)
    public void imprimirHistorial() {
        System.out.println("\n--- VOLCADO DE MEMORIA RAM ---");
        if (historialMensajes.isEmpty()) {
            System.out.println("(Memoria vacía)");
        } else {
            for (int i = 0; i < historialMensajes.size(); i++) {
                System.out.println("[" + (i+1) + "] " + historialMensajes.get(i));
            }
        }
    }
}