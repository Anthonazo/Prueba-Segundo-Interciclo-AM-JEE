package ec.edu.ups.prueba.PruebaPW.bussines;

import java.util.List;

import ec.edu.ups.prueba.PruebaPW.dao.PersonaDao;
import ec.edu.ups.prueba.PruebaPW.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class Gestion {

	@Inject
	private PersonaDao personaDao;
	
	public Persona buscarDeuda(String cedula) throws Exception {
		if(cedula.length() < 10){
			return personaDao.getPersonaConDeudasPorCedula(cedula)	;
		}
		else {
			throw new Exception("No se encuentra en la base de datos");
		}
	}
	
	public List<Persona> getAll() {
		return personaDao.getAll();
	}
	
	
	
	
}
