package ec.edu.ups.prueba.PruebaPW.dao;

import java.util.List;

import ec.edu.ups.prueba.PruebaPW.model.Deuda;
import ec.edu.ups.prueba.PruebaPW.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DeudaDao {

	@PersistenceContext
	private EntityManager em;

	public void create(Deuda d) {
		em.persist(d);
	}

	public void update(Deuda d) {
		em.merge(d);
	}

	public Deuda read(int deuda) {
		Deuda de = em.find(Deuda.class, deuda);
		return de;
	}
	
	
	public List<Deuda> getAll(){
		String jpql = "SELECT c FROM Deuda c";
		Query q = em.createQuery(jpql, Deuda.class);
		return q.getResultList();
	}
//	
//	public Carro getCarroPlaca(String p) {
//		String jpql = "SELECT c FROM Carro c WHERE c.placa = :p";
//		Query q = em.createQuery(jpql, Carro.class);
//		q.setParameter("p", p);
//		List<Carro> c = q.getResultList();
//		if(c.size()>0)
//			return c.get(0);
//		return null;
//	}
}
