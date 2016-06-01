package Acciones;

public class Iluminacion implements EstadoIluminacion{

	@Override
	public boolean luzAlcoba1(boolean alcoba1) {
		// Teniendo en cuenta este booleano se encenderá o apagará la luz	
		//Aqui se debería enviar al comando al Arduino
		return alcoba1;
	}

	@Override
	public boolean luzAlcoba2(boolean alcoba2) {
		// Teniendo en cuenta este booleano se encenderá o apagará la luz	
		//Aqui se debería enviar al comando al Arduino
		return alcoba2;
	}

	@Override
	public boolean luzLavanderia(boolean lavanderia) {
		// Teniendo en cuenta este booleano se encenderá o apagará la luz	
		//Aqui se debería enviar al comando al Arduino		
		return lavanderia;
	}

	@Override
	public boolean luzBano(boolean bano) {
		// Teniendo en cuenta este booleano se encenderá o apagará la luz	
		//Aqui se debería enviar al comando al Arduino		
		return bano;
	}

	@Override
	public boolean luzEntretenimiento(boolean entretenimiento) {
		// Teniendo en cuenta este booleano se encenderá o apagará la luz	
		//Aqui se debería enviar al comando al Arduino		
		return entretenimiento;
	}

	@Override
	public boolean luzCocina(boolean cocina) {
		// Teniendo en cuenta este booleano se encenderá o apagará la luz	
		//Aqui se debería enviar al comando al Arduino		
		return cocina;
	}

	@Override
	public boolean luzSalaComedor(boolean salaComedor) {
		// Teniendo en cuenta este booleano se encenderá o apagará la luz	
		//Aqui se debería enviar al comando al Arduino		
		return salaComedor;
	}
}
