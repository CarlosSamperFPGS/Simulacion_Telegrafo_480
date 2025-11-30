package com.carlos.telegrafo.componentes.concretos.codificadores;

import com.carlos.telegrafo.interfaces.Codificador;

public class CodificadorBinario implements Codificador {

    public String codificar(String texto) {
        if (texto == null) return "";
        StringBuilder binario = new StringBuilder();
        for (char c : texto.toCharArray()) {
            // Convierte cada char a 8 bits
            binario.append(Integer.toBinaryString(c)).append(" ");
        }
        return binario.toString().trim();
    }

    public String decodificar(String pulsos) {
        if (pulsos == null) return "";
        StringBuilder texto = new StringBuilder();
        String[] binarios = pulsos.split(" ");

        for (String b : binarios) {
            try {
                int charCode = Integer.parseInt(b, 2);
                texto.append((char) charCode);
            } catch (NumberFormatException e) {
                texto.append("?");
            }
        }
        return texto.toString();
    }
}