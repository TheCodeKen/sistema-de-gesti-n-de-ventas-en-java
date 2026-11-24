package clases;

public class Ventas {
	private int codigoVenta,codigoCliente;
	private String fecha;
	
	public Ventas(int codigoVenta, int codigoCliente, String fecha) 
	{
		this.codigoVenta = codigoVenta;
		this.codigoCliente = codigoCliente;
		this.fecha = fecha;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}
	

	
}
