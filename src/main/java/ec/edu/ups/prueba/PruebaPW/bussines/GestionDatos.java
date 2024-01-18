package ec.edu.ups.prueba.PruebaPW.bussines;

import ec.edu.ups.prueba.PruebaPW.dao.DeudaDao;
import ec.edu.ups.prueba.PruebaPW.dao.PersonaDao;
import ec.edu.ups.prueba.PruebaPW.model.Deuda;
import ec.edu.ups.prueba.PruebaPW.model.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private PersonaDao personaDao;
	
	@Inject
	private DeudaDao deudaDao;
	
	@PostConstruct
	public void init() {
		Persona p = new Persona();
		p.setId(1);
		p.setCedula("18018");
		p.setNombre("Pato");
		personaDao.create(p);
		
		Deuda d = new Deuda();
		d.setDeuda_id(1);
		d.setValor(500);
		d.setMes("Enero");
		d.setPersona(p);
		deudaDao.create(d);
				
		d = new Deuda();
		d.setDeuda_id(2);
		d.setValor(80);
		d.setMes("Diciembre");
		d.setPersona(p);
		deudaDao.create(d);
		
		
		Persona p2 = new Persona();
		p2.setId(2);
		p2.setCedula("010748");
		p2.setNombre("Anthony");
		personaDao.create(p2);
		
		Deuda d2 = new Deuda();
		d2.setDeuda_id(3);
		d2.setValor(50);
		d2.setMes("Julio");
		d2.setPersona(p2);
		deudaDao.create(d2);
				
		d2 = new Deuda();
		d2.setDeuda_id(4);
		d2.setValor(90);
		d2.setMes("Marzo");
		d2.setPersona(p2);
		deudaDao.create(d2);
		
		System.out.println("DEUDAS"+ personaDao.getPersonaConDeudasPorCedula("18018"));
		
	}
}
