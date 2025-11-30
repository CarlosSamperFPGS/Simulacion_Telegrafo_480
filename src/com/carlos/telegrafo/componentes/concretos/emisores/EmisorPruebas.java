package com.carlos.telegrafo.componentes.concretos.emisores;

import com.carlos.telegrafo.componentes.abstractos.Emisor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class EmisorPruebas extends Emisor {

    public EmisorPruebas(Codificador codificador) { super(codificador); }


    public Signal enviar(String mensajeIgnorado) {

        // Ignora el mensaje del usuario y envía un PING técnico
        System.out.println("[Emisor TEST] Calibrando línea...");
        return new Signal(codificador.codificar("PING TEST 123"));
    }
}