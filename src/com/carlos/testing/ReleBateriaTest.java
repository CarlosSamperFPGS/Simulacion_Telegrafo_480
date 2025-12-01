package com.carlos.testing;

import com.carlos.telegrafo.componentes.concretos.reles.ReleBateria;
import com.carlos.telegrafo.modelo.Signal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReleBateriaTest {

    @Test
    void testConsumoBateria() {
        // Relé con 20 de batería. Gasta 10 por uso.
        ReleBateria rele = new ReleBateria("Rele", 20);

        Signal signal1 = new Signal("MSG1");
        signal1.reducirPotencia(50); // Está al 50%

        // USO 1: Tiene 20 bateria. Debería funcionar.
        rele.procesar(signal1);

        assertEquals(100.0, signal1.getPotencia(), "La señal 1 debió ser regenerada");

        // USO 2: Le quedan 10 bateria. Debería funcionar (limite).
        Signal signal2 = new Signal("MSG2");
        signal2.reducirPotencia(50);
        rele.procesar(signal2);
        assertEquals(100.0, signal2.getPotencia(), "La señal 2 debió ser regenerada (quedaban 10)");

        // USO 3: Le queda 0 bateria. NO debería funcionar.
        Signal signal3 = new Signal("MSG3");
        signal3.reducirPotencia(50);
        rele.procesar(signal3);

        assertEquals(50.0, signal3.getPotencia(), "La señal 3 NO debió regenerarse (Batería 0)");
    }
}