/**
 * 
 */
package com.gustavo.projectwebservicesconsumer.client;

import java.time.LocalDateTime;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gustavo.projectwebservicesconsumer.dto.EmpleadoDTO;


/**
 * Clase cliente que permite consumir el webservice de empleados.
 * @author Calistos
 *
 */
public class EmpleadoWSClient {

	public static void main(String[] args) {
		
		// MEDIANTE GET:
		
		/*
		//Clase principal de Jersey para indicar como conectarnos con una ubicacion remota URL.
		Client client = ClientBuilder.newClient();
		
		String entity = client.target("http://localhost:8080/project-webservices/gustavo/empleadosWS").path("consultarEmpleadoPorId").path("12345")
			       .request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);
		
		EmpleadoDTO empleadoDTO = client.target("http://localhost:8080/project-webservices/gustavo/empleadosWS").path("consultarEmpleadoPorId").path("123456789")
			       .request(MediaType.APPLICATION_JSON).get().readEntity(EmpleadoDTO.class);
		
		System.out.println(entity);
		System.out.println(empleadoDTO.getNombre());
		System.out.println(empleadoDTO.getFechaCreacion());
		*/
		
		// MEDIANTE POST:
		Client client = ClientBuilder.newClient();
		
		WebTarget web = client.target("http://localhost:8080/project-webservices/gustavo/empleadosWS").path("guardarEmpleado");
		
		EmpleadoDTO em = new EmpleadoDTO();
		
		em.setNumeroEmpleado("");
		em.setNombre("Raul");
		em.setApellido("Lopez");
		em.setEdad(34);
		em.setFechaCreacion(LocalDateTime.now());
		
		Invocation.Builder invo = web.request(MediaType.APPLICATION_JSON);
		
		Response resp = invo.post(Entity.entity(em, MediaType.APPLICATION_JSON));
		
		if(resp.getStatus() == 400) {
			String error = resp.readEntity(String.class);
			System.out.println(error);
		}
		
		if(resp.getStatus() == 200) {
			EmpleadoDTO empleado = resp.readEntity(EmpleadoDTO.class);
			System.out.println(empleado.getNombre());
			System.out.println(empleado.getEdad());
			System.out.println(empleado.getFechaCreacion());
		}

	}
}

