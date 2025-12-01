package com.carlos.telegrafo.utils;

import java.util.Scanner;

// Herramienta estática para gestionar la entrada/salida de la consola de forma segura.
// Evita errores de tipo (NumberFormat) y problemas de buffer del Scanner.

public class ConsoleUtils {

    // Scanner único para toda la aplicación
    private static final Scanner sc = new Scanner(System.in);

    // Lee texto del usuario
    public static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("El texto no puede estar vacío. Inténtalo de nuevo.");
        }
    }

    // Lee un número entre un rango determinado
    public static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine();
            try {
                int numero = Integer.parseInt(input);
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("Opción fuera de rango (" + min + "-" + max + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número entero.");
            }
        }
    }

    // Pausa hasta que el usuario presione Enter
    public static void pausar() {
        System.out.println("\n(Pulsa ENTER para continuar...)");
        sc.nextLine();
    }

    // Imprime un encabezado estético
    public static void imprimirCabecera(String titulo) {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║ " + centro(titulo, 44) + " ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    // Métodos auxiliar privado para centrar texto
    private static String centro(String s, int size) {
        if (s == null || size <= s.length()) return s;
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(' ');
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(' ');
        }
        return sb.toString();
    }
}