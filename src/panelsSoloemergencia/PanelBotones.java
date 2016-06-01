package panelsSoloemergencia;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBotones extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelBotones() {
		setBorder(new TitledBorder(null, "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnNewButton = new JButton("Principal\r\n");
		btnNewButton.setBounds(160, 92, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alcoba 1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(286, 92, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alcoba 2");
		btnNewButton_2.setBounds(411, 92, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ba\u00F1o");
		btnNewButton_3.setBounds(542, 92, 89, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Alcoba 1");
		btnNewButton_4.setBounds(160, 196, 89, 23);
		add(btnNewButton_4);
		
		JLabel lblPuertas = new JLabel("Puertas");
		lblPuertas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuertas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuertas.setBounds(354, 28, 89, 14);
		add(lblPuertas);
		
		JButton btnNewButton_5 = new JButton("Alcoba 2");
		btnNewButton_5.setBounds(286, 196, 89, 23);
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Ba\u00F1o");
		btnNewButton_6.setBounds(542, 196, 89, 23);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Lavanderia");
		btnNewButton_7.setBounds(411, 196, 100, 23);
		add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Cocina");
		btnNewButton_8.setBounds(207, 252, 89, 23);
		add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Sala-Comedor");
		btnNewButton_9.setBounds(489, 252, 131, 23);
		add(btnNewButton_9);
		
		JLabel lblLuces = new JLabel("Luces");
		lblLuces.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuces.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLuces.setBounds(354, 149, 80, 14);
		add(lblLuces);
		
		JButton btnNewButton_10 = new JButton("Entretenimiento");
		btnNewButton_10.setBounds(327, 252, 131, 23);
		add(btnNewButton_10);

	}
}
