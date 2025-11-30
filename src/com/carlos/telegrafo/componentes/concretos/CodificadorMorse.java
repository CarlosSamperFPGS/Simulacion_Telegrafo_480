package com.carlos.telegrafo.componentes.concretos;

import com.carlos.telegrafo.interfaces.Codificador;

public class CodificadorMorse implements Codificador {
    public String codificar(String texto) {
        // Ejemplo SOS TODO (Página para convertir ASCII a Morse) https://www.traductorbinario.com/morse/
        return texto.toUpperCase()
                .replace("S", "...")
                .replace("O", "---")
                .replace(" ", " / ");
    }

    public String decodificar(String pulsos) {
    return pulsos
            .replace("...", "S")
            .replace("---", "O")
            .replace(" / ", " ");
    }
}
