package DAO;

import Datos.Usuario;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class ArchivoUsr {
	
	ObjectOutputStream oos;
    ObjectInputStream ois;
    
    File usuarios = new File("usuarios");
    
    @SuppressWarnings("rawtypes")
	public void almacenarDatosUsr(HashMap usuariosReg) throws FileNotFoundException{
        try {
            oos = new ObjectOutputStream(new FileOutputStream(usuarios));
            oos.writeObject(usuariosReg);
            oos.close();
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        }  
        JOptionPane.showMessageDialog(null, "Se han guardado los datos");
    }
    
	@SuppressWarnings("unchecked")
	public HashMap<String, Usuario> leerDatosUsr() throws ClassNotFoundException{
        HashMap<String, Usuario> usuariosReg = new HashMap<>();
        try {
            ois = new ObjectInputStream(new FileInputStream(usuarios));
            usuariosReg = (HashMap<String, Usuario>) ois.readObject();
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(null, "Error");
        }     
        JOptionPane.showMessageDialog(null, "Se han cargado los datos");
        return usuariosReg;
    }
}
