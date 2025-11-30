package com.carlos.telegrafo.componentes.abstractos;

import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public abstract class Emisor {

    // Atributos protegidos (Inyecta dependencia)
    protected Codificador codificador;
    protected boolean encendido;

    // Constructor
    public Emisor(Codificador codificador) {
        this.codificador = codificador;
        this.encendido = false;
    }

    // Métodos
    public void encender(boolean b) {
        this.encendido = true;
    }

    // Las implementaciones definen cómo envian
    public abstract Signal enviar(String mensaje);

}
