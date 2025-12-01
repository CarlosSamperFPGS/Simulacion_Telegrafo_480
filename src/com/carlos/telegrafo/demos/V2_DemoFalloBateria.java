package com.carlos.telegrafo.demos;

import com.carlos.telegrafo.componentes.concretos.canales.CableTerrestre;
import com.carlos.telegrafo.componentes.concretos.emisores.EmisorAutomatico;
import com.carlos.telegrafo.componentes.concretos.receptores.ReceptorConsola;
import com.carlos.telegrafo.componentes.concretos.reles.ReleBateria;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;
import com.carlos.telegrafo.componentes.concretos.codificadores.CodificadorMorseV2;

public class V2_DemoFalloBateria {
    public static void main(String[] args) {
        System.out.println("=== DEMO 2: FALLO POR BATERÍA AGOTADA ===\n");

        Codificador morse = new CodificadorMorseV2();
        EmisorAutomatico emisor = new EmisorAutomatico(morse);

        // Relé con batería CRÍTICA (Solo 15%. Gasta 10% por uso. El segundo uso fallará)
        ReleBateria releViejo = new ReleBateria(15);

        // Cable muy largo que MATA la señal si no se amplifica
        CableTerrestre desierto = new CableTerrestre(80); // Pierde 80%
        ReceptorConsola receptor = new ReceptorConsola(morse);

        emisor.encender(true);

        // Bucle de estrés
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n>>> Intento de envío #" + i);
            Signal signal = emisor.enviar("MENSAJE " + i);

            desierto.transportar(signal); // Baja al 20%
            releViejo.procesar(signal);   // Intenta regenerar

            // Comprobación manual de fallo
            if (signal.getPotencia() < 30) {
                System.out.println("❌ CRÍTICO: El relé no funcionó. Señal demasiado débil.");
                // El receptor intentará leerla pero fallará
                receptor.recibir(signal);
            } else {
                receptor.recibir(signal);
            }
        }
    }
}