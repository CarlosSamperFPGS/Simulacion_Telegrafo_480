package com.carlos.telegrafo.componentes.concretos.emisores;

import com.carlos.telegrafo.componentes.abstractos.Emisor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class EmisorAutomatico extends Emisor {

    public EmisorAutomatico(Codificador codificador) { super(codificador); }

    public Signal enviar(String mensaje) {
        if(!encendido) return null;
        System.out.println("[Emisor AUTO] Generando ráfaga de datos: '" + mensaje + "'");

        // Usamos el codificador inyectado

        return new Signal(codificador.codificar(mensaje));
    }
}