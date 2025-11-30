package com.carlos.telegrafo.componentes.concretos.codificadores;

import com.carlos.telegrafo.interfaces.Codificador;
import java.util.HashMap;
import java.util.Map;


 // VERSIÓN 2: Codificador avanzado.
 // Soporte alfanumérico completo (A-Z, 0-9).
 // Uso de HashMap para máxima eficiencia.

public class CodificadorMorseV2 implements Codificador {

    // Diccionarios para traducción rápida bidireccional
    private final Map<Character, String> textoAMorse = new HashMap<>();
    private final Map<String, Character> morseATexto = new HashMap<>();

    public CodificadorMorseV2() {
        inicializarDiccionario();
    }

    private void inicializarDiccionario() { // TODO (Página para convertir ASCII a Morse) https://www.traductorbinario.com/morse/
        // Datos brutos
        char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        String[] codigos = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..",
                "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
        };

        // Llenado de diccionarios
        for (int i = 0; i < letras.length; i++) {
            textoAMorse.put(letras[i], codigos[i]);
            morseATexto.put(codigos[i], letras[i]);
        }
    }

    public String codificar(String texto) {
        if (texto == null) return "";
        StringBuilder sb = new StringBuilder();

        // Convertimos a mayúsculas, ya que morse no distingue minúsculas
        for (char c : texto.toUpperCase().toCharArray()) {
            if (c == ' ') {
                sb.append(" / "); // Separador oficial de palabras
            } else if (textoAMorse.containsKey(c)) {
                sb.append(textoAMorse.get(c)).append(" "); // Espacio entre letras
            } else {
                sb.append("? "); // Carácter desconocido
            }
        }
        return sb.toString().trim();
    }

    public String decodificar(String pulsos) {
        if (pulsos == null) return "";
        StringBuilder sb = new StringBuilder();

        // Dividimos el mensaje en palabras (separador " / ")
        String[] palabras = pulsos.split(" / ");

        for (String palabra : palabras) {
            // Dividimos la palabra en letras (separador " ")
            String[] letras = palabra.trim().split(" ");

            for (String letra : letras) {
                if (morseATexto.containsKey(letra)) {
                    sb.append(morseATexto.get(letra));
                } else {
                    sb.append("?"); // Código desconocido
                }
            }
            sb.append(" "); // Espacio natural para leer el texto final
        }
        return sb.toString().trim();
    }
}
