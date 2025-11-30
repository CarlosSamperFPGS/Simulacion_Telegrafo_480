package com.carlos.telegrafo.componentes.abstractos;

import com.carlos.telegrafo.modelo.Signal;

public abstract class Rele {
    // Métodos para procesar la señal (Amplificar o ignorar)
    public abstract void procesar(Signal signal);
}
