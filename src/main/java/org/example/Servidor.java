package org.example;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 12345; // Puerto donde escuchará el servidor

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");

            // Aceptar la conexión del cliente
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado desde: " + cliente.getInetAddress());

            // Crear flujos para enviar y recibir datos
            InputStream entrada = cliente.getInputStream();
            OutputStream salida = cliente.getOutputStream();
            BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));
            PrintWriter escritor = new PrintWriter(salida, true);

            // Leer mensaje del cliente
            String mensajeCliente = lector.readLine();
            System.out.println("Mensaje del cliente: " + mensajeCliente);

            // Responder al cliente
            String respuesta = "Hola, cliente. Recibí tu mensaje: " + mensajeCliente;
            escritor.println(respuesta);

            // Cerrar conexión
            cliente.close();
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}