package com.carlos.telegrafo.demos;


import com.carlos.telegrafo.componentes.concretos.canales.*;
import com.carlos.telegrafo.componentes.concretos.emisores.*;
import com.carlos.telegrafo.componentes.concretos.receptores.*;
import com.carlos.telegrafo.componentes.concretos.reles.*;
import com.carlos.telegrafo.componentes.concretos.codificadores.CodificadorMorseV2;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;


public class V1_DemoBasica {
    public static void main(String[] args) {
        System.out.println("=== DEMO 1: FLUJO ESTÁNDAR (REQ. PDF) ===\n");

        // Configuración
        Codificador morse = new CodificadorMorseV2(); // Usamos la V2 que es más robusta

        EmisorEstandar emisor = new EmisorEstandar(morse);
        CableTerrestre tramoA = new CableTerrestre("TramoA", 40); // 40km
        ReleBateria repetidor = new ReleBateria("RepetidorH1", 100);   // Batería llena
        CableTerrestre tramoB = new CableTerrestre("TramoB", 50); // 50km
        ReceptorConsola receptor = new ReceptorConsola(morse);

        // Ejecución
        emisor.encender(true);
        Signal signal = emisor.enviar("HOLA 480S"); // Mensaje simple

        if (signal != null) {
            tramoA.transportar(signal);  // Se degrada
            repetidor.procesar(signal);  // Se regenera
            tramoB.transportar(signal);  // Se degrada de nuevo
            receptor.recibir(signal);    // Se muestra
        }
    }
}