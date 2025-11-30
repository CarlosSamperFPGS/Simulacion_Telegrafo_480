package com.carlos.telegrafo.modelo;

// Contiene el mensaje y la potencia

// Atributos
public class Signal {
    private String mensaje;
    private double potencia;  // Fuerza de la señal de 0 a 100

    // Constructor
    public Signal(String mensaje) {
        this.mensaje = mensaje;
        this.potencia = 100.0; // Empieza con la potencia al máximo al salir del emisor
    }

    // Métodos

    // Simula la reducción de potencia por la distancia
    public void reducirPotencia(double cantidad) {
        this.potencia -= cantidad;
        if (this.potencia < 0) this.potencia = 0;
    }

    // Usado por los Relés para restaurar la potencia
    public void restaurarPotencia() {
        this.potencia = 100.0;
    }

    // Validar si la señal es legible
    public boolean esLegible() {
        return potencia > 0;
    }

    // Getters
    public String getMensaje() { return mensaje; }
    public double getPotencia() { return potencia; }
}