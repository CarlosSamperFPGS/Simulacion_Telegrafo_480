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
            String descodificado = codificador.decodificar(signal.getMensaje());
            historialMensajes.add(descodificado);
            System.out.println("[Receptor Memoria] Mensaje almacenado en RAM. Total guardados: " + historialMensajes.size());
        }
    }

    // Métodos extra para consultar la memoria
    public void imprimirHistorial() {
        System.out.println("--- HISTORIAL DE MEMORIA ---");
        for (String msg : historialMensajes) {
            System.out.println("• " + msg);
        }
    }
}