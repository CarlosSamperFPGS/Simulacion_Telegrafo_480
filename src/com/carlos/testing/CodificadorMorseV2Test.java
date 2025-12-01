package com.carlos.testing;

import com.carlos.telegrafo.componentes.concretos.codificadores.CodificadorMorseV2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodificadorMorseV2Test {

    private final CodificadorMorseV2 codificador = new CodificadorMorseV2();

    @Test
    void testCodificarBasico() {
        String resultado = codificador.codificar("SOS");
        assertEquals("... --- ...", resultado);
    }

    @Test
    void testCodificarNumeros() {
        String resultado = codificador.codificar("A 1");
        // A=.-  Espacio=/  1=.----
        assertEquals(".-  / .----", resultado);
    }

    @Test
    void testDecodificar() {
        String morse = "... --- ...";
        assertEquals("SOS", codificador.decodificar(morse));
    }

    @Test
    void testCaracterDesconocido() {
        String resultado = codificador.codificar("Ñ");
        assertEquals("?", resultado);
    }

    @Test
    void testNullSafe() {
        assertEquals("", codificador.codificar(null), "Si paso null no debe explotar");
    }
}