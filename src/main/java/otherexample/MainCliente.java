package otherexample;

import java.io.IOException;

public class MainCliente {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // Dirección del servidor
        int puerto = 12345;       // Puerto del servidor
        try {
            ConexionCliente cliente = new ConexionCliente(host, puerto);
            cliente.enviarMensaje("Hola, servidor.");
            cliente.leerRespuesta();
            cliente.cerrarConexion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}