package com.carlos.telegrafo.componentes.concretos.canales;

import com.carlos.telegrafo.componentes.abstractos.Canal;
import com.carlos.telegrafo.modelo.Signal;
import java.util.Random;

public class EnlaceSatelite extends Canal {
    public EnlaceSatelite(String nombre, int longitudKm) {
        super(nombre, 0); } // La distancia física es irrelevante en la órbita


    public void transportar(Signal signal) {

        // Simula interferencia atmosférica aleatoria (ruido)
        int ruido = new Random().nextInt(25); // Pierde entre 0% y 25% de golpe

        signal.reducirPotencia(ruido);

        System.out.printf("[Satélite] Enlace orbital. Ruido atmosférico: -%d%%. Potencia: %.1f%%\n", ruido, signal.getPotencia());
    }
}