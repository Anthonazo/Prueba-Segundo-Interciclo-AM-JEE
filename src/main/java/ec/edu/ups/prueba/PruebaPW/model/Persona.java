package ec.edu.ups.prueba.PruebaPW.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Persona {
	
	@Id
	private int id;
	private String cedula;
	private String nombre;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private List<Deuda> deudas_fk  = new ArrayList<Deuda>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Deuda> getDeudas_fk() {
		return deudas_fk;
	}
	public void setDeudas_fk(List<Deuda> deudas_fk) {
		this.deudas_fk = deudas_fk;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", deudas_fk=" + deudas_fk + "]";
	}
}
