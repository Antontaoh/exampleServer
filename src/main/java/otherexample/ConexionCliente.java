package otherexample;

import java.io.*;
import java.net.*;

public class ConexionCliente {
    private Socket cliente;
    private BufferedReader lector;
    private PrintWriter escritor;

    public ConexionCliente(String host, int puerto) throws IOException {
        cliente = new Socket(host, puerto);
        System.out.println("Conectado al servidor en " + host + ":" + puerto);
        lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        escritor = new PrintWriter(cliente.getOutputStream(), true);
    }

    public void enviarMensaje(String mensaje) throws IOException {
        escritor.println(mensaje);
        System.out.println("Mensaje enviado al servidor: " + mensaje);
    }

    public void leerRespuesta() throws IOException {
        String respuesta = lector.readLine();
        System.out.println("Respuesta del servidor: " + respuesta);
    }

    public void cerrarConexion() throws IOException {
        lector.close();
        escritor.close();
        cliente.close();
        System.out.println("Conexión cerrada.");
    }
}