package ec.edu.ups.prueba.PruebaPW.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Deuda {

	@Id
	private int deuda_id;
	private int valor;
	private String mes;
	
	@ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
	
	
	public int getDeuda_id() {
		return deuda_id;
	}
	public void setDeuda_id(int deuda_id) {
		this.deuda_id = deuda_id;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Deuda [deuda_id=" + deuda_id + ", valor=" + valor + ", mes=" + mes + ", persona=" + persona + "]";
	}

	
}
