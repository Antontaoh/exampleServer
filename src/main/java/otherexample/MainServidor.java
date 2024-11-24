package otherexample;

import java.io.IOException;

public class MainServidor {
    public static void main(String[] args) {
        int puerto = 12345; // Puerto donde escuchará el servidor
        try {
            Conexion servidor = new Conexion(puerto);
            servidor.esperarCliente();
            servidor.manejarComunicacion();
            servidor.cerrarConexion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}