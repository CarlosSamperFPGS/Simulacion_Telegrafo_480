package com.carlos.telegrafo.componentes.concretos.emisores;

import com.carlos.telegrafo.componentes.abstractos.Emisor;
import com.carlos.telegrafo.excepciones.TelegraphException;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class EmisorEstandar extends Emisor {

    public EmisorEstandar(Codificador codificador) {
        super(codificador);
    }

    public Signal enviar(String mensaje) {
        if (mensaje == null || mensaje.trim().isEmpty()) {
           throw new TelegraphException("El mensaje no puede estar vacío.");
        }
        if (!encendido) {
            throw new TelegraphException("El emisor debe estar encendido para enviar.");
        }
        System.out.println("[Emisor] Codificando mensaje: " + mensaje);
        String pulsos = codificador.codificar(mensaje);

        // Creamos la señal con potencia 100
        return new Signal(pulsos);
    }
}