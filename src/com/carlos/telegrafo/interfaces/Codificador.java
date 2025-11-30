package com.carlos.telegrafo.interfaces;

// Permite intercambiar Morse, ASCII, etc

public interface Codificador {

    // Texto a Pulsos
    String codificar(String texto);


    // Pulsos a Texto
    String decodificar(String pulsos);
}
