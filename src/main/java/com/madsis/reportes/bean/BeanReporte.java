package com.madsis.reportes.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.madsis.reportes.Deserializar.OrdenDeserializer;

import java.util.List;

@JsonDeserialize(using = OrdenDeserializer.class)
public class BeanReporte {
	@JsonProperty("OrdenID")
	private String ordenID;

	@JsonProperty("Fecha")
	private String fecha;

	@JsonProperty("Cedula")
	private String cedula;

	@JsonProperty("NombreCompleto")
	private String nombreCompleto;

	@JsonProperty("Direccion")
	private String direccion;

	@JsonProperty("Referencia")
	private String referencia;

	@JsonProperty("Telefono")
	private String telefono;

	@JsonProperty("Correo")
	private String correo;

	@JsonProperty("Provincia")
	private String provincia;

	@JsonProperty("Canton")
	private String canton;

	@JsonProperty("Parroquia")
	private String parroquia;

	@JsonProperty("Plazo")
	private String plazo;

	@JsonProperty("Notas")
	private String notas;

	@JsonProperty("EstadoOrden")
	private String estadoOrden;

	@JsonProperty("Convenio")
	private String convenio;

	@JsonProperty("Productos")
	private List<BeanProducto> productos;

	public String getOrdenID() {
		return ordenID;
	}

	public void setOrdenID(String ordenID) {
		this.ordenID = ordenID;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getEstadoOrden() {
		return estadoOrden;
	}

	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public List<BeanProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<BeanProducto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "BeanReporte [ordenID=" + ordenID + ", fecha=" + fecha + ", cedula=" + cedula + ", nombreCompleto="
				+ nombreCompleto + ", direccion=" + direccion + ", referencia=" + referencia + ", telefono=" + telefono
				+ ", correo=" + correo + ", provincia=" + provincia + ", canton=" + canton + ", parroquia=" + parroquia
				+ ", plazo=" + plazo + ", notas=" + notas + ", estadoOrden=" + estadoOrden + ", convenio=" + convenio
				+ ", productos=" + productos + "]";
	}

}
