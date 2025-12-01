package com.carlos.telegrafo.demos;

import com.carlos.telegrafo.componentes.concretos.codificadores.CodificadorMorseV2;
import com.carlos.telegrafo.componentes.concretos.emisores.EmisorEstandar;
import com.carlos.telegrafo.excepciones.TelegraphException;

public class DemoExceptionTest {
    public static void main(String[] args) {
        System.out.println("=== TEST DE GESTIÓN DE ERRORES ===\n");

        EmisorEstandar emisor = new EmisorEstandar(new CodificadorMorseV2());

        // CASO A: INTENTO FALLIDO (El emisor nace apagado)
        try {
            System.out.println(">>> Intentando enviar mensaje sin encender...");
            emisor.enviar("HOLA"); // Esto va a explotar

            // Esta línea NUNCA se ejecutará si lo de arriba falla
            System.out.println("Esto no deberías verlo.");

        } catch (TelegraphException e) {
            // AQUÍ CAPTURAMOS NUESTRO ERROR PERSONALIZADO
            System.err.println("\nERROR CONTROLADO DETECTADO:");
            System.err.println("   " + e.getMessage()); // Muestra el mensaje que escribimos en el Emisor
        }


        // CASO B: ÉXITO
        try {
            System.out.println(">>> Encendiendo y reintentando...");
            emisor.encender(true);
            emisor.enviar("AHORA SI");
            System.out.println("Mensaje enviado correctamente.");

        } catch (TelegraphException e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
