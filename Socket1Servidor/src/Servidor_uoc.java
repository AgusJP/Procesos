import java.io.*;
import java.net.*;
public class Servidor_uoc {
	public static void main(String args[]) throws IOException {
			ServerSocket mi_servicio = null;
			String linea_recibida;
			BufferedReader entrada;
			PrintStream salida;
			Socket socket_conectado = null;
			try {
				mi_servicio = new ServerSocket(2019);
			}
			catch (IOException excepcion) {
				System.out.println(excepcion);
			}
			try {
				System.out.println("Servidor a la escucha de peticiones.------");
				socket_conectado = mi_servicio.accept();
				System.out.println("Un cliente se ha conectado "+ socket_conectado.toString());
				entrada = new BufferedReader(new InputStreamReader(socket_conectado.getInputStream()));
				salida = new PrintStream(socket_conectado.getOutputStream());
				
				
				linea_recibida = entrada.readLine();
				System.out.println("Soy el servidor, he recibido del cliente "+ linea_recibida);
				
				salida.println("Te reenvio lo que he recibido:" + linea_recibida );
				salida.close();
				entrada.close();
				socket_conectado.close();
				}
			catch (IOException excepcion) {
				System.out.println(excepcion);
				}
			
			mi_servicio.close();
			}
}