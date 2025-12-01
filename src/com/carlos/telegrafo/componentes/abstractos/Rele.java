package com.carlos.telegrafo.componentes.abstractos;

import com.carlos.telegrafo.modelo.Signal;

public abstract class Rele {
    protected String id; // Identificador único para el relé (opcional, pero útil para depurar)

    // Constructor
    public Rele(String id) {
        this.id = id;
    }


    // Métodos para procesar la señal (Amplificar o ignorar)

    public abstract void procesar(Signal signal);

    public String toString() {
        return id;
    }
}
