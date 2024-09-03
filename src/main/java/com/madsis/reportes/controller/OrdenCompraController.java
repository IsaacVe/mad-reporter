package com.madsis.reportes.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madsis.reportes.bean.BeanProducto;
import com.madsis.reportes.bean.BeanReporte;
import com.madsis.reportes.util.UtilString;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
public class OrdenCompraController {

	@PostMapping("/reporteOrdenCompra")
	public ResponseEntity<byte[]> downloadJasperFile(@RequestBody BeanReporte reporte) {
		try {
			ClassPathResource resource = new ClassPathResource("templates/OC.jasper");
			InputStream reportStream = resource.getInputStream();
			ClassPathResource imageResource = new ClassPathResource("templates/madlogo.jpg");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("OrdenID", UtilString.defineString(reporte.getOrdenID()));
			parameters.put("imageParam", imageResource.getInputStream());
			parameters.put("detalleReport", getOrdenDetailReport(reporte.getProductos()));
			parameters.put("detalleParamReport", getOrdenParamater(reporte.getProductos(),
					UtilString.defineString(reporte.getEstadoOrden()), UtilString.defineString(reporte.getConvenio())));
			parameters.put("Fecha", UtilString.defineString(reporte.getFecha()));
			parameters.put("Cedula", UtilString.defineString(reporte.getCedula()));
			parameters.put("NombreCompleto", UtilString.defineString(reporte.getNombreCompleto()));
			parameters.put("Direccion", UtilString.defineString(reporte.getDireccion()));
			parameters.put("Referencia", UtilString.defineString(reporte.getReferencia()));
			parameters.put("Telefono", UtilString.defineString(reporte.getTelefono()));
			parameters.put("Correo", UtilString.defineString(reporte.getCorreo()));
			parameters.put("Provincia", UtilString.defineString(reporte.getProvincia()));
			parameters.put("Canton", UtilString.defineString(reporte.getCanton()));
			parameters.put("Parroquia", UtilString.defineString(reporte.getParroquia()));
			parameters.put("Plazo", UtilString.defineString(reporte.getPlazo()));
			parameters.put("Notas", UtilString.defineString(reporte.getNotas()));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Reporte_OC.pdf");
			headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");
			return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private JasperReport getOrdenDetailReport(List<BeanProducto> productos) {
		ClassPathResource resource = null;
		try {
			if (productos != null && productos.size() > 0) {
				resource = new ClassPathResource("templates/OC_Detalle.jasper");
			} else {
				resource = new ClassPathResource("templates/OC_Detalle2.jasper");
			}
			InputStream reportStream = resource.getInputStream();
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
			return jasperReport;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Map getOrdenParamater(List<BeanProducto> productos, String ordenEstado, String convenio) {
		Map<String, Object> foodParameter = new HashMap<>();
		List<BeanProducto> productos1 = new ArrayList<BeanProducto>();
		if (productos != null && productos.size() > 0) {
			productos1.addAll(productos);
		} else {
			productos.add(new BeanProducto());
			productos.add(new BeanProducto());
			productos.add(new BeanProducto());
			productos.add(new BeanProducto());
			productos.add(new BeanProducto());
			productos.add(new BeanProducto());
			productos1.addAll(productos);
		}

		foodParameter.put("productos", new JRBeanCollectionDataSource(productos1));
		foodParameter.put("ordenEstado", ordenEstado);
		foodParameter.put("convenio", convenio);
		return foodParameter;
	}
}
