package GUI;

public class Principal {
	//Atencion este protecto se encuentra en la carpeta reservas de documentos
	public static void main(String[] args) {
		
		LoginFrame logFr = new LoginFrame();
		logFr.setLocationRelativeTo(null);
		logFr.setResizable(false);
		logFr.setVisible(true);
                
		/*
		RegistroFrame regFr = new RegistroFrame();
		regFr.setTitle("SmartHouse v1.0");
		regFr.setLocationRelativeTo(null);
		regFr.setVisible(true);
		
		/*
		ControlFrame ctlFr = new ControlFrame();
		ctlFr.setTitle("SmartHouse v1.0");
		ctlFr.setLocationRelativeTo(null);
		ctlFr.setVisible(true);
		*/
	}
}
