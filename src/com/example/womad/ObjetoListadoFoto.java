package com.example.womad;

public class ObjetoListadoFoto {
	String nombre;
	String comentario;
	String descripcionLarga;
	String horario;
	String pais;
	String imagen;
	String lugar;
	
	public ObjetoListadoFoto() {
	}
	
	public ObjetoListadoFoto(String nombre, String comentario, String descripcionLarga, String pais, String imagen) {
		this.nombre=nombre;
		this.comentario=comentario;
		this.descripcionLarga=descripcionLarga;
		this.pais=pais;
		this.imagen=imagen;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
