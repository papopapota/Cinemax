package com.cinemax.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Pelicula")
public class Peliculas {
	
	@Id
	private int id_pelicula;
	private String titulo_pelicula;
	private int id_genero;
	private String img_pelicula;
	private String duracion;
	private String idioma;
	private String dia_estreno;
	
	  @ManyToOne
	    @JoinColumn(name = "id_genero",insertable=false, updatable=false)
	
	private Genero genero;

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getTitulo_pelicula() {
		return titulo_pelicula;
	}

	public void setTitulo_pelicula(String titulo_pelicula) {
		this.titulo_pelicula = titulo_pelicula;
	}

	public int getId_genero() {
		return id_genero;
	}

	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}

	public String getImg_pelicula() {
		return img_pelicula;
	}

	public void setImg_pelicula(String img_pelicula) {
		this.img_pelicula = img_pelicula;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getDia_estreno() {
		return dia_estreno;
	}

	public void setDia_estreno(String dia_estreno) {
		this.dia_estreno = dia_estreno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Peliculas [id_pelicula=" + id_pelicula + ", titulo_pelicula=" + titulo_pelicula + ", id_genero="
				+ id_genero + ", img_pelicula=" + img_pelicula + ", duracion=" + duracion + ", idioma=" + idioma
				+ ", dia_estreno=" + dia_estreno + ", genero=" + genero + "]";
	}


	  
	
	

	
	
}
