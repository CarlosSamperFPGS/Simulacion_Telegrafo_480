package com.carlos.testing;

import com.carlos.telegrafo.modelo.Signal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignalTest {

    @Test
    @DisplayName("La señal debe nacer con 100 de potencia")
    void testEstadoInicial() {
        Signal signal = new Signal("TEST");
        assertEquals(100.0, signal.getPotencia(), "La potencia inicial debería ser 100");
    }

    @Test
    @DisplayName("Reducir potencia funciona correctamente")
    void testReducirPotencia() {
        Signal signal = new Signal("TEST");
        signal.reducirPotencia(30.5);
        assertEquals(69.5, signal.getPotencia(), 0.01);
    }

    @Test
    @DisplayName("La potencia nunca debe ser negativa")
    void testPotenciaNoNegativa() {
        Signal signal = new Signal("TEST");
        signal.reducirPotencia(200); // Intentamos bajarla a -100

        assertEquals(0.0, signal.getPotencia(), "La potencia mínima debe ser 0");
        assertFalse(signal.esLegible(), "Con potencia 0 no debe ser legible");
    }
}