package com.madsis.reportes.bean;

import java.math.BigDecimal;

public class BeanProducto {

	public Integer Numero;
	public String Sku;
	public String Descripcion;
	public BigDecimal Precio;
	public Integer Cantidad;
	public BigDecimal SubTotal;
	public String EstadoProducto;

	public Integer getNumero() {
		return Numero;
	}

	public void setNumero(Integer numero) {
		Numero = numero;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return Precio;
	}

	public void setPrecio(BigDecimal precio) {
		Precio = precio;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public BigDecimal getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		SubTotal = subTotal;
	}

	public String getEstadoProducto() {
		return EstadoProducto;
	}

	public void setEstadoProducto(String estadoProducto) {
		EstadoProducto = estadoProducto;
	}

	@Override
	public String toString() {
		return "BeanProducto [Numero=" + Numero + ", Sku=" + Sku + ", Descripcion=" + Descripcion + ", Precio=" + Precio
				+ ", Cantidad=" + Cantidad + ", SubTotal=" + SubTotal + ", EstadoProducto=" + EstadoProducto + "]";
	}

}
