package Acciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Puerta implements MovimientosPuerta {

    private final String host = "localhost"; //<----- Modificar para otras IPs//<----- Modificar para otras IPs
    
    @Override
    public boolean puertaAlcoba1(boolean alcoba1) {
        final int num = 1;
        try {
            enviarComando(num, alcoba1);
        } catch (IOException ex) {
            Logger.getLogger(Puerta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alcoba1;
    }

    @Override
    public boolean puertaAlcoba2(boolean alcoba2) {
	final int num = 2;
        try {
            enviarComando(num, alcoba2);
        } catch (IOException ex) {
            Logger.getLogger(Puerta.class.getName()).log(Level.SEVERE, null, ex);
        }
	return alcoba2;
    }

    @Override
    public boolean puertaBano(boolean bano) {
        final int num = 3;
        try {
            enviarComando(num, bano);
        } catch (IOException ex) {
            Logger.getLogger(Puerta.class.getName()).log(Level.SEVERE, null, ex);
        }
	return bano;
    }

    @Override
    public boolean puertaPrincipal(boolean puertaPrinc) {
	final int num = 4;
        try {
            enviarComando(num, puertaPrinc);
        } catch (IOException ex) {
            Logger.getLogger(Puerta.class.getName()).log(Level.SEVERE, null, ex);
        }
	return puertaPrinc;
    }
    
    public void enviarComando(int numero, boolean estPuerta) throws IOException{
    	System.out.println("entre a enviarComando");
        /*
    	try{
            Socket socket1 = new Socket(host, 8000);
            
            DataOutputStream datoAlServidor = new DataOutputStream(socket1.getOutputStream());
            System.out.println("Voy a enviar los datos");
            System.out.println(numero);
            System.out.println(estPuerta);
            
            datoAlServidor.writeInt(numero);
            datoAlServidor.flush();
            datoAlServidor.writeBoolean(estPuerta);
            datoAlServidor.flush();
            
        }catch (IOException ex) {
            System.err.println(ex);
        }
        */
    }    
}
