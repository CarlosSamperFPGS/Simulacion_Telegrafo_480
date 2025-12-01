package com.carlos.telegrafo.componentes.concretos.receptores;

import com.carlos.telegrafo.componentes.abstractos.Receptor;
import com.carlos.telegrafo.interfaces.Codificador;
import com.carlos.telegrafo.modelo.Signal;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceptorArchivo extends Receptor {
    public ReceptorArchivo(Codificador codificador) { super(codificador); }


    public void recibir(Signal signal) {
        if (signal != null && signal.esLegible()) {
            // 1. Obtenemos datos
            String rawCodigo = signal.getMensaje();
            String textoDecodificado = codificador.decodificar(rawCodigo);
            String ruta = signal.getRutaCompleta();

            // Formateador de fecha para que quede limpio
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // 2. Escribimos en disco con el nuevo formato
            try (FileWriter writer = new FileWriter("registro_telegramas.txt", true)) {

                // FORMATO: [Fecha] TEXTO | CODIGO_RAW | TRAZA
                String logLine = String.format("[%s] MSG: %-20s | RAW: %-20s | RUTA: %s\n",
                        fecha,
                        textoDecodificado,
                        rawCodigo,
                        ruta);

                writer.write(logLine);
                System.out.println("[Receptor Archivo] Telegrama guardado en 'registro_telegramas.txt'");

            } catch (IOException e) {
                System.err.println("Error escribiendo en disco: " + e.getMessage());
            }
        }
    }
}
