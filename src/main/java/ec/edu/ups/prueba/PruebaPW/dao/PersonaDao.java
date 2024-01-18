package ec.edu.ups.prueba.PruebaPW.dao;

import java.util.List;

import ec.edu.ups.prueba.PruebaPW.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PersonaDao {

	@PersistenceContext
	private EntityManager em;

	public void create(Persona p) {
		em.persist(p);
	}

	public void update(Persona p) {
		em.merge(p);
	}

	public Persona read(int cedula) {
		Persona pe = em.find(Persona.class, cedula);
		return pe;
	}

	public List<Persona> getAll() {
		String jpql = "SELECT c FROM Persona c";
		Query q = em.createQuery(jpql, Persona.class);
		return q.getResultList();
	}

	public Persona getPersonaConDeudasPorCedula(String cedula) {
		String jpql = "SELECT p FROM Persona p JOIN FETCH p.deudas_fk WHERE p.cedula = :cedula";
		Query query = em.createQuery(jpql, Persona.class);
		query.setParameter("cedula", cedula);
		List<Persona> personas = query.getResultList();
		if (!personas.isEmpty()) {
			return personas.get(0);
		}
		return null;
	}

}
