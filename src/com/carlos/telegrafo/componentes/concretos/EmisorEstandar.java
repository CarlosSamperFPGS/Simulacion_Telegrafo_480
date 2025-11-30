package com.carlos.telegrafo.componentes.concretos;

import com.carlos.telegrafo.componentes.abstractos.Emisor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class EmisorEstandar extends Emisor {

    public EmisorEstandar(Codificador codificador) {
        super(codificador);
    }

    public Signal enviar(String mensaje) {
        if (!encendido) {
            System.out.println("❌ ERROR: El emisor está apagado.");
            return null;
        }
        System.out.println("[Emisor] Codificando mensaje: " + mensaje);
        String pulsos = codificador.codificar(mensaje);

        // Creamos la señal con potencia 100
        return new Signal(pulsos);
    }
}