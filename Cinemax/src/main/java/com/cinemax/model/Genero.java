package com.cinemax.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "tb_Genero")

public class Genero {
	
	@Id
	private int id_genero;
	private String descripcion_genero;
	public int getId_genero() {
		return id_genero;
	}
	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}
	public String getDescripcion_genero() {
		return descripcion_genero;
	}
	public void setDescripcion_genero(String descripcion_genero) {
		this.descripcion_genero = descripcion_genero;
	}
	
	
	
}
