package com.carlos.telegrafo.componentes.abstractos;

import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public abstract class Receptor {
    protected Codificador codificador;

    public Receptor(Codificador codificador) {
        this.codificador = codificador;
    }

    public abstract void recibir(Signal signal);
}
