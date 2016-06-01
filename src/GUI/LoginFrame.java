package GUI;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import DAO.ArchivoUsr;

import Datos.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JPasswordField pfContrasena;
	
	ArchivoUsr archvUsr = new ArchivoUsr();
	
        private final String host = "localhost";
	//Constructor de la interfaz de Usuario del Login
	public LoginFrame() {
		inicializarComponentes();
	}
	
	//Inicializa Cada Componente del Frame
	public void inicializarComponentes(){
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/casa.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 340);
		
		String texto = "<html><body>Para poder abrir la puerta principal<br>debe ingresar los campos requeridos</body></html>";
		JLabel lblAviso = new JLabel(texto);
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(135, 25, 206, 43);
		getContentPane().add(lblAviso);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(94, 96, 46, 14);
		getContentPane().add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(175, 94, 140, 20);
		getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasena.setBounds(94, 142, 75, 14);
		getContentPane().add(lblContrasena);
		
		pfContrasena = new JPasswordField();
		pfContrasena.setBounds(175, 140, 140, 20);
		getContentPane().add(pfContrasena);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                accederCasa();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		btnAcceder.setBounds(200, 179, 89, 23);
		getContentPane().add(btnAcceder);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(51, 250, 89, 23);
		getContentPane().add(btnSalir);
		
	}//Fin M�todo inicializarComponentes();
	
	//Carga y verifica los datos del usuario, una vez verificados los datos se cargar� el panel de control
	public void accederCasa() throws ClassNotFoundException{//
            String usuario = tfUsuario.getText();//si algo coloca el .trim()
            String pass = new String(pfContrasena.getPassword());
            String confirm;
            
            if ("".equals(usuario) || "".equals(pass)){
                JOptionPane.showMessageDialog(null, "Debe ingresar los campos solicitados");
            }else {
                try {
                    // Establish connection with the server
                    Socket socket = new Socket(host, 8000);
                    
                    // Create an output stream to the server
                    DataOutputStream alServidor = new DataOutputStream(socket.getOutputStream());
                    DataInputStream delServidor = new DataInputStream(socket.getInputStream());
                    
                    //Recibe un objeto de tipo Usuario
                    ObjectInputStream delServidorUsr = new ObjectInputStream(socket.getInputStream());
                    
                    //send to the server
                    alServidor.writeUTF(usuario);
                    
                    //Recibe un String del servidor confirmando el acceso
                    confirm = delServidor.readUTF();
                    
                    //Recibe el objeto usuario en variable tipo object 
                    Object user = delServidorUsr.readObject();
                    
                    //Casteamos el objeto para mirar si podemos obtener los datos 
                    Usuario acceso = (Usuario)user;
                    
                    if ("concedido".equals(confirm)){
                        LoginFrame.this.dispose();
                        String name = acceso.getNombre();
                        boolean alcb1 = acceso.isPrtAlcoba1();
                        boolean alcb2 = acceso.isPrtAlcoba2();
                                               
                        ControlFrame ctrlFrm = new ControlFrame(name, alcb1, alcb2);
                        ctrlFrm.setVisible(true);
                        ctrlFrm.setLocationRelativeTo(null);
                    }else if ("denegado".equals(confirm)){
                        JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
                    }
                }catch (IOException ex) {
                    System.err.println(ex);
                }
                
                /*HashMap<String, Usuario> registros = new HashMap<>();
                try {
                    registros = archvUsr.leerDatosUsr();
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "�Error!");
                }
            
                Usuario logIn = registros.get(usuario);
                
                if (logIn != null){ 
            	
                    JOptionPane.showMessageDialog(null, "�Ha Iniciado Sesi�n!");
                    String nm = logIn.getNombre();
                    boolean alc1 = logIn.isPrtAlcoba1();
                    boolean alc2 = logIn.isPrtAlcoba2();
                    boolean pers = logIn.isPersiana();
           		
                    LoginFrame.this.dispose();
                    ControlFrame contfrm = new ControlFrame(nm, alc1, alc2, pers);
                    contfrm.setVisible(true);
                    contfrm.setLocationRelativeTo(null);
            	
                }else{
                    JOptionPane.showMessageDialog(null, "�El Usuario no existe!");
                }*/
            } 
	}//Fin Metodo accederCasa
}
