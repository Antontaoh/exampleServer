package org.example;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // Dirección IP del servidor (localhost)
        int puerto = 12345;       // Puerto del servidor

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor.");

            // Crear flujos para enviar y recibir datos
            OutputStream salida = socket.getOutputStream();
            InputStream entrada = socket.getInputStream();
            PrintWriter escritor = new PrintWriter(salida, true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));

            // Enviar mensaje al servidor
            String mensaje = "Hola, servidor.";
            escritor.println(mensaje);
            System.out.println("Mensaje enviado: " + mensaje);

            // Leer respuesta del servidor
            String respuesta = lector.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}