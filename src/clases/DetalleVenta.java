package clases;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetalleVenta extends Ventas{
	private int codProducto,cantidad;
	private double precio;
	
	public DetalleVenta(int codigoVenta, int codigoCliente, String fecha,  int codProducto,
			int cantidad, double precio) {
		super(codigoVenta, codigoCliente, fecha);
		this.codProducto = codProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
    public double calcImportePagar() {
        BigDecimal result = BigDecimal.valueOf(precio * cantidad);
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double calcIporteIgv() {
        BigDecimal result = BigDecimal.valueOf(calcImportePagar() * 0.18);
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
	
	public double calcImporteTotal() {
		BigDecimal result = BigDecimal.valueOf(calcImportePagar() + calcIporteIgv());
	    return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	
	public String fechaActual() {
    	LocalDate fechaActual = LocalDate.now();     
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String fechaFormateada = fechaActual.format(formato);
        return fechaFormateada;
	}
	
}
