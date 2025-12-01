# 📠 Simulación de Sistema de Telégrafo Eléctrico

> **Solución Prueba Técnica para prácticas (Cuatroochenta / 480s)**.
>
> Este proyecto simula la transmisión física y lógica de mensajes a través de una infraestructura telegráfica configurable, priorizando la desacoplación y la extensibilidad del sistema.

## 📋 Descripción del Proyecto

El objetivo principal no es solo transmitir un mensaje, sino **modelar la arquitectura** de un sistema de comunicación complejo. El sistema simula:

* **Física de la Señal:** Degradación por distancia, interferencias atmosféricas y regeneración activa.

* **Gestión de Recursos:** Componentes con batería limitada y estados de fallo.

* **Trazabilidad:** Registro completo de la ruta que sigue el mensaje (Canales, Relés, Nodos).

* **Polimorfismo:** Intercambio de protocolos (Morse/Binario) y hardware sin alterar el núcleo.

## 🏗️ Arquitectura y Diseño

El proyecto sigue estrictamente los principios **SOLID**, con especial énfasis en **Open/Closed** (Abierto a extensión, cerrado a modificación).

### Diagrama Conceptual

`Emisor` ➡️ `Signal (Mensaje + Potencia)` ➡️ `Canal (Pérdida)` ➡️ `Relé (Regeneración)` ➡️ `Receptor`

### Principios Aplicados

1. **Separación de Responsabilidades:**

    * `Modelo`: Datos puros (`Signal`).

    * `Lógica`: Algoritmos de traducción (`Codificador`).

    * `Infraestructura`: Componentes físicos (`Cables`, `Relés`).

2. **Inversión de Dependencias:**

    * Los emisores no dependen de "Morse", dependen de la interfaz `Codificador`. Esto permite inyectar `CodificadorBinario` sin tocar el código del emisor.

3. **Liskov Substitution:**

    * Cualquier componente hijo (`CableSubmarino`) puede sustituir al padre (`Canal`) sin romper la lógica del sistema coordinador.

## 🛠️ Catálogo de Componentes

### 📡 Emisores

* **Estándar:** Emisión manual básica.

* **Emergencia:** Señal prioritaria.

* **De Pruebas:** Genera pings automáticos para calibración.

### 〰️ Infraestructura (Canales)

* **Cable Terrestre:** Alta degradación por Km.

* **Cable Submarino:** Baja degradación (blindado).

* **Enlace Satelital:** Introduce ruido aleatorio (sin distancia).

* **Laboratorio:** Entorno ideal (Pérdida 0%).

### 🔋 Nodos Intermedios (Relés)

* **Simple:** Regeneración pasiva conectada a red.

* **Batería:** Recursos limitados. Deja de funcionar si se agota.

* **Inteligente (AI):** Solo amplifica si la señal es débil (Eficiencia).

* **Solar:** Funciona según condiciones ambientales.

### 💾 Receptores

* **Consola:** Visualización formateada con trazabilidad.

* **Archivo:** Persistencia en disco (`registro_telegramas.txt`).

* **Memoria:** Almacenamiento volátil en estructura de datos.

## 📂 Estructura del Código

    com.carlos.telegrafo
        -componentes
            -abstractos   # Clases base
            -concretos    # Implementaciones organizadas por tipos
                -canales
                -codificadores
                -emisores
                -receptores
                -reles
        -interfaces       # Contratos
        -modelo           # Objetos de dominio
        -utils            # Herramientas de consola
        -TelegraphApp     # Main Class (App Interactiva)

## 🧪 Testing

El proyecto incluye tests unitarios con **JUnit 5** para validar:
* Física de la señal (no potencias negativas).
* Traducción correcta de Morse/Binario.
* Lógica de agotamiento de batería en relés.

### Autor

**Carlos Samper** - 1º DAW - Desarrollo de Aplicaciones Web (IES Álvaro Falomir).
*Proyecto realizado para proceso de selección en Cuatroochenta (480s).*