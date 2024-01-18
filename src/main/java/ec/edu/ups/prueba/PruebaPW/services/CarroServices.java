package ec.edu.ups.prueba.PruebaPW.services;

import java.util.List;

import ec.edu.ups.prueba.PruebaPW.bussines.Gestion;
import ec.edu.ups.prueba.PruebaPW.model.Persona;
import jakarta.faces.render.ResponseStateManager;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("carros")
public class CarroServices {

	@Inject
	private Gestion gc;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leerId(@QueryParam("id") String cedula) {
		try {
			Persona c = gc.buscarDeuda(cedula);
			return Response.ok(c).build();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Persona no existe");
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getCarros() {
		List<Persona> c = gc.getAll();
		if (c.size() > 0)
			return Response.ok(c).build();
		ErrorMessage error = new ErrorMessage(6, "No se registran carros");
		return Response.status(Response.Status.NOT_FOUND).entity(error).build();
	}

}
