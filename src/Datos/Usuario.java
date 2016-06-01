package Datos;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String nombreDeUsuario;
	private String contrasena;
	private String parentesco;
	private boolean prtAlcoba1;
	private boolean prtAlcoba2;
	
	public Usuario(String nombre, String nombreDeUsuario, String contrasena, String parentesco, boolean prtAlcoba1, boolean prtAlcoba2) {
		this.nombre = nombre;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;
		this.parentesco = parentesco;
		this.prtAlcoba1 = prtAlcoba1;
		this.prtAlcoba2 = prtAlcoba2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	public boolean isPrtAlcoba1() {
		return prtAlcoba1;
	}

	public void setPrtAlcoba1(boolean prtAlcoba1) {
		this.prtAlcoba1 = prtAlcoba1;
	}

	public boolean isPrtAlcoba2() {
		return prtAlcoba2;
	}

	public void setPrtAlcoba2(boolean prtAlcoba2) {
		this.prtAlcoba2 = prtAlcoba2;
	}
}
