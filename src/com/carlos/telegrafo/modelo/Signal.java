package com.carlos.telegrafo.modelo;

// Contiene el mensaje y la potencia

import java.util.ArrayList;
import java.util.List;

// Atributos
public class Signal {
    private String mensaje;
    private double potencia;  // Fuerza de la señal de 0 a 100
    // Trazabilidad
    private List<String> historial;
    private static final double umbralLegible = 20.0;

    // Constructor
    public Signal(String mensaje) {
        this.mensaje = mensaje;
        this.potencia = 100.0; // Empieza con la potencia al máximo al salir del emisor

        this.historial = new ArrayList<>();
        this.historial.add("[Inicio]");
    }

    // Métodos

    // Informa de la ruta completa de la señal
    public String getRutaCompleta() {
        // Une todos los elementos de la lista en una sola cadena de texto
        StringBuilder sb = new StringBuilder();
        for (String paso : historial) {
            sb.append(paso);
        }
        return sb.toString();
    }

    // Informa del último componente por donde paso la señal
    public String getUltimoComponente() {
        if (historial == null || historial.isEmpty()) {
            return "Desconocido";
        }
        return historial.get(historial.size() - 1);
    }

    // Simula la reducción de potencia por la distancia
    public void reducirPotencia(double cantidad) {
        this.potencia -= cantidad;
        if (this.potencia <= 0) this.potencia = 0;
    }

    // Usado por los Relés para restaurar la potencia
    public void restaurarPotencia() {
        this.potencia = 100.0;
    }

    // Validar si la señal es legible
    public boolean esLegible() {
        return potencia > umbralLegible;
    }

    // Hace que los Canales y Relés "Fichen"
    public void registrarPaso(String nombre) {
        this.historial.add(" -> [" + nombre + "]");
    }

    // Getters
    public String getMensaje() { return mensaje; }
    public double getPotencia() { return potencia; }
}