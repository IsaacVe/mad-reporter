package com.madsis.reportes.Deserializar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.madsis.reportes.bean.BeanProducto;
import com.madsis.reportes.bean.BeanReporte;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdenDeserializer extends JsonDeserializer<BeanReporte> {

	@Override
	public BeanReporte deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		BeanReporte orden = new BeanReporte();

		orden.setOrdenID(node.get("OrdenID").isNull() ? null : node.get("OrdenID").asText());
		orden.setFecha(node.get("Fecha").isNull() ? null : node.get("Fecha").asText());
		orden.setCedula(node.get("Cedula").isNull() ? null : node.get("Cedula").asText());
		orden.setNombreCompleto(node.get("NombreCompleto").isNull() ? null : node.get("NombreCompleto").asText());
		orden.setDireccion(node.get("Direccion").isNull() ? null : node.get("Direccion").asText());
		orden.setReferencia(node.get("Referencia").isNull() ? null : node.get("Referencia").asText());
		orden.setTelefono(node.get("Telefono").isNull() ? null : node.get("Telefono").asText());
		orden.setCorreo(node.get("Correo").isNull() ? null : node.get("Correo").asText());
		orden.setProvincia(node.get("Provincia").isNull() ? null : node.get("Provincia").asText());
		orden.setCanton(node.get("Canton").isNull() ? null : node.get("Canton").asText());
		orden.setParroquia(node.get("Parroquia").isNull() ? null : node.get("Parroquia").asText());
		orden.setPlazo(node.get("Plazo").isNull() ? null : node.get("Plazo").asText());
		orden.setNotas(node.get("Notas").isNull() ? null : node.get("Notas").asText());
		orden.setEstadoOrden(node.get("EstadoOrden").isNull() ? null : node.get("EstadoOrden").asText());
		orden.setConvenio(node.get("Convenio").isNull() ? null : node.get("Convenio").asText());
		List<BeanProducto> productos = new ArrayList<>();
		JsonNode productosNode = node.get("Productos");
		if (productosNode != null && productosNode.isArray()) {
			for (JsonNode productoNode : productosNode) {
				BeanProducto producto = new BeanProducto();
				producto.setNumero(productoNode.get("Numero").isNull() ? null : productoNode.get("Numero").asInt());
				producto.setSku(productoNode.get("Sku").asText());
				producto.setDescripcion(productoNode.get("Descripcion").asText());
				producto.setPrecio(productoNode.get("Precio").decimalValue());
				producto.setCantidad(productoNode.get("Cantidad").asInt());
				producto.setSubTotal(productoNode.get("SubTotal").decimalValue());
				producto.setEstadoProducto(productoNode.get("EstadoProducto").isNull() ? null
						: productoNode.get("EstadoProducto").asText());
				productos.add(producto);
			}
		}
		orden.setProductos(productos);
		return orden;
	}
}