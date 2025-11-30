package com.carlos.telegrafo.componentes.concretos.emisores;

import com.carlos.telegrafo.componentes.abstractos.Emisor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class EmisorEmergencia extends Emisor {
    public EmisorEmergencia(Codificador codificador) { super(codificador); }

    public Signal enviar(String mensaje) {

        // Simula un boost de energía inicial
        System.out.println("[EMERGENCIA] INYECTANDO SEÑAL DE ALTA PRIORIDAD");
        return new Signal(codificador.codificar("ALERTA: " + mensaje));
    }
}
