package GUI;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Acciones.Iluminacion;
import Acciones.Puerta;

/**
 * Enlace del Repositorio https://github.com/Gilbert9704/Proyecto-SmartHouse
 * @author 
 * @category Para el control de las puertas, cuando el booleano estï¿½ false, la puerta estï¿½ cerrada
 * cuando estï¿½ true la puerta estï¿½ abierta
 */

public class ControlFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private String texto;
	
	//Puertas
	private boolean prtAlcoba1 = false;
	private boolean prtAlcoba2 = false;
	private boolean prtBano = false;
	private boolean prtPrincipal = false;
	
	//Luces
	private boolean lzAlcoba1 = false;
	private boolean lzAlcoba2 = false;
	private boolean lzBano = false;
	private boolean lzLavanderia = false;
	private boolean lzEntretenimiento = false;
	private boolean lzCocina = false;
	private boolean lzSalaComedor = false;
	
	//Botones Puertas
	JButton btnPersiana = new JButton("Persiana");
	JButton btnPBanio = new JButton("Puerta Ba\u00F1o");
	JButton btnPAlcoba_2 = new JButton("Puerta Alcoba 2");
	JButton btnPAlcoba_1 = new JButton("Puerta Alcoba 1");
	JButton btnPPrincipal = new JButton("");
	
	//Label Estado Puertas
	JLabel lblPuertaPrincipal = new JLabel("- Puerta Principal : ");
	JLabel lblPuertaAlcoba_1 = new JLabel("- Puerta Alcoba 1 : ");
	JLabel lblPuertaAlcoba_2 = new JLabel("- Puerta Alcoba 2 : ");
	JLabel lblPuertaBao = new JLabel("- Puerta Ba\u00F1o : ");
	
	//Botones Iluminación
	JButton btnLuzAlcoba_1 = new JButton();
	JButton btnLuzAlcoba_2 = new JButton();
	JButton btnLuzLavanderia = new JButton();
	JButton btnLuzBanio = new JButton();
	JButton btnLuzCocina = new JButton();
	JButton btnLuzSala = new JButton();
	JButton btnLuzEntrt = new JButton();
	
	//Label Estado Iluminación
	JLabel lblIluminacionAlcoba_1 = new JLabel("- Iluminaci\u00F3n Alcoba 1 : ");
	JLabel lblIluminacinAlcoba_2 = new JLabel("- Iluminaci\u00F3n Alcoba 2 : ");
	JLabel lblIluminacinLavandea = new JLabel("- Iluminaci\u00F3n Lavande\u00EDa : ");
	JLabel lblIluminacinBao = new JLabel("- Iluminaci\u00F3n Ba\u00F1o : ");
	JLabel lblIluminacinEntretenimiento = new JLabel("- Iluminaci\u00F3n Entretenimiento : ");
	JLabel lblIluminacinCocina = new JLabel("- Iluminaci\u00F3n Cocina: ");
	JLabel lblIluminacinSalacomedor = new JLabel("- Iluminaci\u00F3n Sala-Comedor: ");
	
	Puerta puerta = new Puerta();
	Iluminacion iluminacion = new Iluminacion();
	
        
	public ControlFrame(String name, boolean alcoba1, boolean alcoba2) {
		//En esta fraccion de codigo se evaluan los datos para posteriormente generar la interfaz de control
		if (alcoba1 == false){
			btnPAlcoba_1.setEnabled(false);
			btnLuzAlcoba_1.setEnabled(false);
		}
		if (alcoba2 == false){
			btnPAlcoba_2.setEnabled(false);
			btnLuzAlcoba_2.setEnabled(false);
		}
		//<---------------------------------------------->
		
		this.getContentPane().setLayout(null);
		this.setTitle("SmartHouse v1.0 Panel de Control");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 715, 660);
		
		JLabel lblNewLabel = new JLabel("\u00A1Bienvenido " + name + "!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(180, 11, 351, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("<html><body>A continuación podrás controlar funciones de la casa como encender luces o abrir puertas<br>para ello, si deseas encender luces de un lugar en especifico deberás dar click en los botones con imagenes<br>de lo contrario si quieres abrir puertas  existen unos botones indicando cuales controlan</body></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(34, 36, 619, 76);
		getContentPane().add(lblNewLabel_2);
		
		//<---------------Botones Iluminacion--------------->		
		//Boton luz Alcoba 1
		btnLuzAlcoba_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lzAlcoba1 == false){
					lzAlcoba1 = true;
					texto = "- Iluminaci\u00F3n Alcoba 1 : Encendida";
					lblIluminacionAlcoba_1.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la alcoba 1 Encendida");
				}else{
					lzAlcoba1 = false;
					texto = "- Iluminaci\u00F3n Alcoba 1 : Apagada";
					lblIluminacionAlcoba_1.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la alcoba 1 Apagada");
				}
				iluminacion.luzAlcoba1(lzAlcoba1);
			}
		});
		btnLuzAlcoba_1.setIcon(new ImageIcon("res/alcoba_1.jpg"));
		btnLuzAlcoba_1.setBounds(99, 123, 122, 128);
		getContentPane().add(btnLuzAlcoba_1);
		
		//Boton Luz Alcoba 2
		btnLuzAlcoba_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lzAlcoba2 == false){
					lzAlcoba2 = true;
					texto = "- Iluminaci\u00F3n Alcoba 2 : Encendida";
					lblIluminacinAlcoba_2.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la alcoba 2 Encendida");
				}else{
					lzAlcoba2 = false;
					texto = "- Iluminaci\u00F3n Alcoba 2 : Apagada";
					lblIluminacinAlcoba_2.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la alcoba 2 Apagada");
				}
				iluminacion.luzAlcoba2(lzAlcoba2);
			}
		});
		btnLuzAlcoba_2.setIcon(new ImageIcon("res/alcoba_2.jpg"));
		btnLuzAlcoba_2.setBounds(218, 278, 116, 119);
		getContentPane().add(btnLuzAlcoba_2);
		
		//Boton Luz Lavanderia
		btnLuzLavanderia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lzLavanderia == false){
					lzLavanderia = true;
					texto = "- Iluminaci\u00F3n Lavande\u00EDa : Encendida";
					lblIluminacinLavandea.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la Lavandería Encendida");
				}else{
					lzLavanderia = false;
					texto = "- Iluminaci\u00F3n Lavande\u00EDa : Apagada";
					lblIluminacinLavandea.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la Lavandería Apagada");
				}
				iluminacion.luzLavanderia(lzLavanderia);
			}
		});
		btnLuzLavanderia.setIcon(new ImageIcon("res/lavanderia.jpg"));
		btnLuzLavanderia.setBounds(218, 123, 116, 128);
		getContentPane().add(btnLuzLavanderia);
		
		//Boton Luz Baño
		btnLuzBanio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lzBano == false){
					lzBano = true;
					texto = "- Iluminaci\u00F3n Ba\u00F1o : Encendida";
					lblIluminacinBao.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion del Baño Encendida");
				}else{
					lzBano = false;
					texto = "- Iluminaci\u00F3n Ba\u00F1o : Apagada";
					lblIluminacinBao.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion del Baño Apagada");
				}	
				iluminacion.luzBano(lzBano);
			}
		});
		btnLuzBanio.setIcon(new ImageIcon("res/ba\u00F1o.jpg"));
		btnLuzBanio.setBounds(330, 123, 116, 128);
		getContentPane().add(btnLuzBanio);
		
		//Boton Luz Cocina
		btnLuzCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lzCocina == false){
					lzCocina = true;
					texto = "- Iluminaci\u00F3n Cocina: Encendida";
					lblIluminacinCocina.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la Cocina Encendida");
				}else{
					lzCocina = false;
					texto = "- Iluminaci\u00F3n Cocina: Apagada";
					lblIluminacinCocina.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion de la Cocina Apagada");					
				}
				iluminacion.luzCocina(lzCocina);
			}
		});
		btnLuzCocina.setIcon(new ImageIcon("res/cocina.jpg"));
		btnLuzCocina.setBounds(440, 123, 116, 128);
		getContentPane().add(btnLuzCocina);
		
		//Boton Luz Sala-Comedor
		btnLuzSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lzSalaComedor == false){
					lzSalaComedor = true;
					texto = "- Iluminaci\u00F3n Sala-Comedor: Encendida";
					lblIluminacinSalacomedor.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion Sala-Comedor Encendida");
				}else{
					lzSalaComedor = false;
					texto = "- Iluminaci\u00F3n Sala-Comedor: Apagada";
					lblIluminacinSalacomedor.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion Sala-Comedor Apagada");					
				}
				iluminacion.luzSalaComedor(lzSalaComedor);
			}
		});
		btnLuzSala.setIcon(new ImageIcon("res/salaComedor.jpg"));
		btnLuzSala.setBounds(440, 250, 116, 119);
		getContentPane().add(btnLuzSala);
		
		//Botin Luz Entretenimiento
		btnLuzEntrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lzEntretenimiento == false){
					lzEntretenimiento = true;
					texto = "- Iluminaci\u00F3n Entretenimiento : Encendida";
					lblIluminacinEntretenimiento.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion Entretenimiento Encendida");
				}else{
					lzEntretenimiento = false;
					texto = "- Iluminaci\u00F3n Entretenimiento : Apagada";
					lblIluminacinEntretenimiento.setText(texto);
					JOptionPane.showMessageDialog(null, "Iluminacion Entretenimiento Apagada");					
				}
			}
		});
		btnLuzEntrt.setIcon(new ImageIcon("res/entretenimiento.jpg"));
		btnLuzEntrt.setBounds(332, 278, 109, 119);
		getContentPane().add(btnLuzEntrt);
		//<--------------Fin Botones Iluminacion--------------->
		
		
		//<--------------Botones Puertas--------------->
		
		//Boton Puerta Baño
		btnPBanio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prtBano == false){
					prtBano = true;
					texto = "- Puerta Ba\u00F1o : Abierta";
					lblPuertaBao.setText(texto);
					JOptionPane.showMessageDialog(null, "Puerta del Baño Abierta");
				}else{
					prtBano = false;
					texto = "- Puerta Ba\u00F1o : Cerrada";
					lblPuertaBao.setText(texto);
					JOptionPane.showMessageDialog(null, "Puerta del Baño Cerrada");
				}
				puerta.puertaBano(prtBano);
			}
		});
		btnPBanio.setBounds(330, 250, 111, 29);
		getContentPane().add(btnPBanio);
		
		//Boton Puerta Alcoba 2
		btnPAlcoba_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prtAlcoba2 == false){
					prtAlcoba2 = true;
					texto = "- Puerta Alcoba 2 : Abierta";
					lblPuertaAlcoba_2.setText(texto);
					JOptionPane.showMessageDialog(null, "Puerta de la Alcoba 2 Abierta");
				}else{
					prtAlcoba2 = false;
					texto = "- Puerta Alcoba 2 : Cerrada";
					lblPuertaAlcoba_2.setText(texto);
					JOptionPane.showMessageDialog(null, "Puerta de la Alcoba 2 Cerrada");
				}
				puerta.puertaAlcoba2(prtAlcoba2);
			}
		});
		btnPAlcoba_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPAlcoba_2.setBounds(212, 250, 123, 29);
		getContentPane().add(btnPAlcoba_2);
		
		//Boton Puerta Alcoba 1
		btnPAlcoba_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prtAlcoba1 == false){
					prtAlcoba1 = true;
					texto = "- Puerta Alcoba 1 : Abierta";
					lblPuertaAlcoba_1.setText(texto);
					JOptionPane.showMessageDialog(null, "Puerta de la Alcoba 1 Abierta");
				}else{
					prtAlcoba1 = false;
					texto = "- Puerta Alcoba 1 : Cerrada";
					lblPuertaAlcoba_1.setText(texto);
					JOptionPane.showMessageDialog(null, "Puerta de la Alcoba 1 Cerrada");
				}
				puerta.puertaAlcoba1(prtAlcoba1);
			}
		});
		btnPAlcoba_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPAlcoba_1.setBounds(99, 250, 116, 29);
		getContentPane().add(btnPAlcoba_1);
		
		//Boton Puerta Principal
		btnPPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prtPrincipal == false){
					int opcion = JOptionPane.showConfirmDialog(null, "¿Desea salir de la casa?");
					if (opcion == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, "¡Que tenga un buen día!");
						prtPrincipal = true;
						texto = "- Puerta Principal : Abierta";
						lblPuertaPrincipal.setText(texto);	
						ControlFrame.this.dispose();
						puerta.puertaPrincipal(prtPrincipal);
						
						LoginFrame login = new LoginFrame();
						login.setLocationRelativeTo(null);
						login.setVisible(true);
					}else if (opcion == JOptionPane.NO_OPTION){
						texto = "- Puerta Principal : Cerrada";
						lblPuertaPrincipal.setText(texto);
					}else if (opcion == JOptionPane.CANCEL_OPTION){
						texto = "- Puerta Principal : Cerrada";
						lblPuertaPrincipal.setText(texto);
					}
				}else{
					prtPrincipal = false;
					texto = "- Puerta Principal : Cerrada";
					lblPuertaPrincipal.setText(texto);
				}			
			}
		});
		btnPPrincipal.setIcon(new ImageIcon("res/puerta.jpg"));
		btnPPrincipal.setBounds(553, 250, 57, 83);
		getContentPane().add(btnPPrincipal);
		//<---------------Fin Botones Puertas---------------->
		
		//<----Labels Estados de las Iluminacion (Propiedades)---->
		JLabel lblEstadoDeLa = new JLabel("Estado de la Iluminaci\u00F3n");
		lblEstadoDeLa.setBounds(124, 423, 139, 14);
		getContentPane().add(lblEstadoDeLa);
		
		lblIluminacionAlcoba_1.setBounds(92, 445, 224, 14);
		getContentPane().add(lblIluminacionAlcoba_1);
		
		lblIluminacinAlcoba_2.setBounds(92, 464, 224, 14);
		getContentPane().add(lblIluminacinAlcoba_2);
		
		lblIluminacinLavandea.setBounds(92, 483, 224, 14);
		getContentPane().add(lblIluminacinLavandea);
		
		lblIluminacinBao.setBounds(92, 503, 224, 14);
		getContentPane().add(lblIluminacinBao);
		
		lblIluminacinEntretenimiento.setBounds(92, 520, 235, 14);
		getContentPane().add(lblIluminacinEntretenimiento);
		
		lblIluminacinCocina.setBounds(92, 538, 194, 14);
		getContentPane().add(lblIluminacinCocina);
		
		lblIluminacinSalacomedor.setBounds(92, 557, 224, 14);
		getContentPane().add(lblIluminacinSalacomedor);
		
		//<----Labels Estados de las puertas (Propiedades)---->
		JLabel lblEstadoDeLas = new JLabel("Estado de las Puertas");
		lblEstadoDeLas.setBounds(457, 423, 160, 14);
		getContentPane().add(lblEstadoDeLas);
		
		lblPuertaPrincipal.setBounds(431, 445, 172, 14);
		getContentPane().add(lblPuertaPrincipal);
		
		lblPuertaAlcoba_1.setBounds(431, 464, 172, 14);
		getContentPane().add(lblPuertaAlcoba_1);
		
		lblPuertaAlcoba_2.setBounds(431, 483, 172, 14);
		getContentPane().add(lblPuertaAlcoba_2);
		
		lblPuertaBao.setBounds(431, 503, 172, 14);
		getContentPane().add(lblPuertaBao);
		
		//<----Label Estado de la persiana (Propiedades)---->
		JLabel lblEstadoDeLa_1 = new JLabel("Estado de la Persiana\r\n");
		lblEstadoDeLa_1.setBounds(457, 538, 133, 14);
		getContentPane().add(lblEstadoDeLa_1);
	}
}
