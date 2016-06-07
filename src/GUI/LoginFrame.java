package GUI;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import Datos.Usuario;


public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JPasswordField pfContrasena;
	
    private final String host = "localhost";
    
	//Constructor de la interfaz de Usuario del Login
	public LoginFrame() {
		inicializarComponentes();
	}
	
	//Inicializa Cada Componente del Frame
	public void inicializarComponentes(){
		getContentPane().setLayout(null);
		setTitle("SmartHouse v1.0 (Login)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/res/casa.png"));
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
		
	}//Fin Método inicializarComponentes();
	
	//Carga y verifica los datos del usuario, una vez verificados los datos se cargará el panel de control
	public void accederCasa() throws ClassNotFoundException{//
            String usuario = tfUsuario.getText();
            String pass = new String(pfContrasena.getPassword());
            String confirm;
            
            if ("".equals(usuario) || "".equals(pass)){
                JOptionPane.showMessageDialog(null, "Debe ingresar los campos solicitados");
            }else {
                try {
                    // Establece la conexion con el servidor
                    @SuppressWarnings("resource")
					Socket socket = new Socket(host, 8000);
                    
                    // Crea los flujos de entrada y salida al servidor
                    DataOutputStream alServidor = new DataOutputStream(socket.getOutputStream());
                    DataInputStream delServidor = new DataInputStream(socket.getInputStream());
                    
                    //Flujo de entrada que recibe un objeto de tipo Usuario
                    ObjectInputStream delServidorUsr = new ObjectInputStream(socket.getInputStream());
                    
                    //envia el usuario al servidor
                    alServidor.writeUTF(usuario);
                    
                    //Recibe un String del servidor confirmando el acceso
                    confirm = delServidor.readUTF();
                    
                    //Recibe el objeto usuario en variable tipo object 
                    Object user = delServidorUsr.readObject();
                    
                    //Casteamos el objeto para obtener los datos 
                    Usuario acceso = (Usuario)user;
                    
                    String contrasena = acceso.getContrasena();
                    
                    if ("concedido".equals(confirm)){
                        if (contrasena.equals(pass)){	
                    		LoginFrame.this.dispose();
                        	String name = acceso.getNombre();
                        	boolean alcb1 = acceso.isPrtAlcoba1();
                        	boolean alcb2 = acceso.isPrtAlcoba2();
                                               
                        	ControlFrame ctrlFrm = new ControlFrame(name, alcb1, alcb2);
                        	ctrlFrm.setVisible(true);
                        	ctrlFrm.setLocationRelativeTo(null);
                        }else{
                        	JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Aviso", JOptionPane.ERROR_MESSAGE);
                        }
                    }else if ("denegado".equals(confirm)){
                        JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
                    }
                }catch (IOException ex) {
                    System.err.println(ex);
                }
            } 
	}//Fin Metodo accederCasa
}
