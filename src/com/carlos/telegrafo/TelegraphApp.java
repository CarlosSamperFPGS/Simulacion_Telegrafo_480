package com.carlos.telegrafo;

import com.carlos.telegrafo.componentes.abstractos.Canal;
import com.carlos.telegrafo.componentes.abstractos.Emisor;
import com.carlos.telegrafo.componentes.abstractos.Receptor;
import com.carlos.telegrafo.componentes.abstractos.Rele;
import com.carlos.telegrafo.componentes.concretos.canales.CableSubmarino;
import com.carlos.telegrafo.componentes.concretos.canales.CableTerrestre;
import com.carlos.telegrafo.componentes.concretos.canales.EnlaceSatelite;
import com.carlos.telegrafo.componentes.concretos.canales.EnlaceSimulado;
import com.carlos.telegrafo.componentes.concretos.codificadores.CodificadorBinario;
import com.carlos.telegrafo.componentes.concretos.codificadores.CodificadorMorseV2;
import com.carlos.telegrafo.componentes.concretos.emisores.EmisorEmergencia;
import com.carlos.telegrafo.componentes.concretos.emisores.EmisorEstandar;
import com.carlos.telegrafo.componentes.concretos.emisores.EmisorPruebas;
import com.carlos.telegrafo.componentes.concretos.receptores.ReceptorArchivo;
import com.carlos.telegrafo.componentes.concretos.receptores.ReceptorConsola;
import com.carlos.telegrafo.componentes.concretos.receptores.ReceptorMemoria;
import com.carlos.telegrafo.componentes.concretos.reles.ReleBateria;
import com.carlos.telegrafo.componentes.concretos.reles.ReleInteligente;
import com.carlos.telegrafo.componentes.concretos.reles.ReleSimple;
import com.carlos.telegrafo.componentes.concretos.reles.ReleSolar;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;
import com.carlos.telegrafo.utils.ConsoleUtils;

public class TelegraphApp {

    public static void main(String[] args) {
        ConsoleUtils.imprimirCabecera("SISTEMA TELEGRÁFICO 480S - v2.3 FINAL");

        boolean continuar = true;

        while (continuar) {
            try {
                // --- FASE 1: CONFIGURACIÓN ---
                System.out.println("\n--- CONFIGURACIÓN DEL SISTEMA ---");

                // 1. Codificador
                System.out.println("1. Protocolo:");
                System.out.println("   [1] Morse V2 (Alfanumérico)");
                System.out.println("   [2] Binario (Digital)");
                int opCod = ConsoleUtils.leerEntero("   > Opción [1-2]: ", 1, 2);

                Codificador codificador = (opCod == 2) ? new CodificadorBinario() : new CodificadorMorseV2();


                // 2. Emisor
                System.out.println("\n2. Emisor:");

                System.out.println("   [1] Estándar");
                System.out.println("   [2] Emergencia (Prioridad)");
                System.out.println("   [3] Pruebas");
                int opEmisor = ConsoleUtils.leerEntero("   > Tipo [1-3]: ", 1, 3);

                Emisor emisor;
                switch (opEmisor) {
                    case 2:
                        emisor = new EmisorEmergencia(codificador);
                        break;
                    case 3:
                        emisor = new EmisorPruebas(codificador);
                        break;
                    default:
                        emisor = new EmisorEstandar(codificador);
                        break;
                }
                emisor.encender(true);


                // 3. Canal
                System.out.println("\n3. Infraestructura (Tramo):");
                String nombreCanal = ConsoleUtils.leerTexto("   > Nombre del Tramo (ej. Madrid-Valencia): ");

                System.out.println("   [1] Terrestre");
                System.out.println("   [2] Submarino");
                System.out.println("   [3] Satélite");
                System.out.println("   [4] Laboratorio");
                int opCanal = ConsoleUtils.leerEntero("   > Tipo [1-4]: ", 1, 4);

                Canal canal;
                if (opCanal == 3) {
                    canal = new EnlaceSatelite(nombreCanal, 0);
                } else if (opCanal == 4) {
                    canal = new EnlaceSimulado(nombreCanal, 0);
                } else {
                    int km = ConsoleUtils.leerEntero("   > Distancia (Km) [10-10000]: ", 10, 10000);
                    canal = (opCanal == 2)
                            ? new CableSubmarino(nombreCanal, km)
                            : new CableTerrestre(nombreCanal, km);
                }


                // 4. Relé (Opcional)
                System.out.println("\n4. Repetidor Intermedio:");
                System.out.println("   [1] Ninguno (Directo)");
                System.out.println("   [2] Simple");
                System.out.println("   [3] Batería");
                System.out.println("   [4] Inteligente");
                System.out.println("   [5] Solar");
                int opRele = ConsoleUtils.leerEntero("   > Tipo [1-5]: ", 1, 5);

                Rele rele = null;
                if (opRele != 1) {
                    String nombreRele = ConsoleUtils.leerTexto("   > Nombre del Relé (ID): ");

                    switch (opRele) {
                        case 2:
                            rele = new ReleSimple(nombreRele);
                            break;
                        case 3:
                            // Preguntamos el nivel de batería
                            int nivelBateria = ConsoleUtils.leerEntero("   > Nivel de Batería inicial [0-100]: ", 0, 100);
                            rele = new ReleBateria(nombreRele, nivelBateria);
                            break;
                        case 4:
                            rele = new ReleInteligente(nombreRele);
                            break;
                        case 5:
                            rele = new ReleSolar(nombreRele);
                            break;
                    }
                }

                // 5. Receptor
                System.out.println("\n5. Receptor Final:");
                System.out.println("   [1] Consola (Pantalla)");
                System.out.println("   [2] Archivo (Guardar en disco)");
                System.out.println("   [3] Memoria (RAM)");
                int opReceptor = ConsoleUtils.leerEntero("   > Tipo [1-3]: ", 1, 3);

                Receptor receptor;
                switch (opReceptor) {
                    case 2:
                        receptor = new ReceptorArchivo(codificador);
                        break;
                    case 3:
                        receptor = new ReceptorMemoria(codificador);
                        break;
                    default:
                        receptor = new ReceptorConsola(codificador);
                        break;
                }


                // --- FASE 2: OPERACIÓN ---
                System.out.println("\n--- TERMINAL DE ENVÍO [" + emisor.toString() + "] ---");
                String mensaje = ConsoleUtils.leerTexto("Escriba el mensaje: ");

                System.out.println("\n>>> Procesando envío...");
                ConsoleUtils.pausar();

                Signal signal = emisor.enviar(mensaje);

                if (signal != null) {
                    // Tramo 1
                    canal.transportar(signal);

                    // Relé
                    if (rele != null && signal.esLegible()) {
                        System.out.println("   -> Llegando a nodo intermedio: " + rele.toString());
                        rele.procesar(signal);

                        System.out.println("   (Reenviando al tramo final...)");
                        canal.transportar(signal);
                    }

                    // Recepción Final
                    System.out.println("   -> Entregando paquete al receptor seleccionado...");
                    receptor.recibir(signal);

                    // Si es memoria, mostramos el contenido
                    if (receptor instanceof ReceptorMemoria) {
                        ((ReceptorMemoria) receptor).imprimirHistorial();
                    }
                }

            } catch (Exception e) {
                System.out.println("\n ERROR DEL SISTEMA: " + e.getMessage());
            }

            // --- FASE 3: BUCLE ---
            System.out.println("\n-------------------------------------------");
            System.out.println("¿Desea enviar otro telegrama?");
            System.out.println("[1] Sí, nueva configuración");
            System.out.println("[2] No, salir");
            int decision = ConsoleUtils.leerEntero("> Opción: ", 1, 2);

            if (decision == 2) {
                continuar = false;
                System.out.println("Desconectando... Adiós.");
            }
        }
    }
}