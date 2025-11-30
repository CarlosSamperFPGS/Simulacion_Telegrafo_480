package com.carlos.telegrafo.demos;

import com.carlos.telegrafo.componentes.abstractos.*;
import com.carlos.telegrafo.componentes.concretos.canales.CableTerrestre;
import com.carlos.telegrafo.componentes.concretos.codificadores.CodificadorMorse;
import com.carlos.telegrafo.componentes.concretos.emisores.EmisorEstandar;
import com.carlos.telegrafo.componentes.concretos.receptores.ReceptorConsola;
import com.carlos.telegrafo.componentes.concretos.reles.ReleBateria;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;

public class V1_DemoFuncional {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SIMULACIÓN DE TELÉGRAFO ===\n");

        // 1. CONFIGURACIÓN Utiliza el codificador v1
        Codificador morse = new CodificadorMorse();

        // Construcción dinámica de componentes
        Emisor emisor = new EmisorEstandar(morse);
        Canal tramoA = new CableTerrestre(40); // 40km -> perderá 40%
        Rele repetidor = new ReleBateria(100); // Batería llena
        Canal tramoB = new CableTerrestre(50); // 50km -> perderá 50%
        Receptor receptor = new ReceptorConsola(morse);

        // 2. EJECUCIÓN (Flujo de la señal)
        // Entrada: SOS [cite: 112]
        emisor.encender(true);
        Signal signal = emisor.enviar("SOS");

        if (signal != null) {
            // Simulación del viaje paso a paso
            tramoA.transportar(signal);   // Sale con 60%

            repetidor.procesar(signal);   // Detecta 60%, Sube a 100%, Gasta batería

            tramoB.transportar(signal);   // Sale con 50%

            receptor.recibir(signal);     // Recibe 50% -> Éxito
        }
    }
}