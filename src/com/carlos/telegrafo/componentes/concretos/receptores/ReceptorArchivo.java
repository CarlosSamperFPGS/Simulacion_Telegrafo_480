package com.carlos.telegrafo.componentes.concretos.receptores;

import com.carlos.telegrafo.componentes.abstractos.Receptor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReceptorArchivo extends Receptor {
    public ReceptorArchivo(Codificador codificador) { super(codificador); }


    public void recibir(Signal signal) {
        if (signal != null && signal.esLegible()) {
            String texto = codificador.decodificar(signal.getMensaje());

            // Guardamos en un archivo de texto en la raíz del proyecto

            try (FileWriter writer = new FileWriter("registro_telegramas.txt", true)) {
                writer.write("[" + LocalDateTime.now() + "] RX: " + texto + "\n");
                System.out.println("[Receptor] Mensaje guardado en disco ('registro_telegramas.txt')");

            } catch (IOException e) {
                System.err.println("Error de E/S: " + e.getMessage());
            }
        }
    }
}
