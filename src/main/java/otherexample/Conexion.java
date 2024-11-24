package otherexample;

import java.io.*;
import java.net.*;

public class Conexion {
    private ServerSocket servidor;
    private Socket cliente;
    private BufferedReader lector;
    private PrintWriter escritor;

    public Conexion(int puerto) throws IOException {
        servidor = new ServerSocket(puerto);
        System.out.println("Servidor iniciado en el puerto " + puerto);
    }

    public void esperarCliente() throws IOException {
        cliente = servidor.accept();
        System.out.println("Cliente conectado desde: " + cliente.getInetAddress());
        lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        escritor = new PrintWriter(cliente.getOutputStream(), true);
    }

    public void manejarComunicacion() throws IOException {
        String mensajeCliente = lector.readLine();
        System.out.println("Mensaje recibido del cliente: " + mensajeCliente);
        escritor.println("Hola, cliente. Recibí tu mensaje: " + mensajeCliente);
    }

    public void cerrarConexion() throws IOException {
        lector.close();
        escritor.close();
        cliente.close();
        servidor.close();
        System.out.println("Conexión cerrada.");
    }
}