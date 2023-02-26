/**
 * 
 */
package com.gustavo.projectwebservicesconsumer.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

/**
 * @author Calistos
 *
 */
public class EmpleadoDTO {
	
	private String numeroEmpleado;

	private String nombre;

	private String apellido;

	private int edad;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime fechaCreacion;

	/**
	 * @return the numeroEmpleado
	 */
	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	/**
	 * @param numeroEmpleado the numeroEmpleado to set
	 */
	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
