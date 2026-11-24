package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.DetalleVenta;


public class Arreglo_DetalleVenta {

	private ArrayList<DetalleVenta> dv;
	
	public Arreglo_DetalleVenta() {
        dv = new ArrayList<DetalleVenta>();
        cargarDetalleVenta();
    }
    
    public void adicionar(DetalleVenta x) {  
        dv.add(x);
        grabarDetalleVenta();
    }
    
    public int tamanio() { 
        return dv.size(); 
    } 
    
    public DetalleVenta obtener(int i) { 
        return dv.get(i); 
    }

    
    //busca por codigo Venta
    public DetalleVenta[] buscarPorCodigoVenta(int codigoVenta) {
        ArrayList<DetalleVenta> resultado = new ArrayList<DetalleVenta>();
        for (DetalleVenta obj : dv) {   //recorre cada objeto de DetalleVenta (for,ech)
            if (obj.getCodigoVenta() == codigoVenta) {
                resultado.add(obj);
            }
        }
        DetalleVenta[] arrayResultado = new DetalleVenta[resultado.size()];
        return resultado.toArray(arrayResultado);
    }
    
    public void eliminar(DetalleVenta x) {
        dv.remove(x);
        grabarDetalleVenta();
    }
   
    
    public void actualizarArchivo() {
    	grabarDetalleVenta();
    }
    
    private void grabarDetalleVenta() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("DetalleVenta.txt"))) {
            for (int i = 0; i < tamanio(); i++) {
            	DetalleVenta x = obtener(i);
                String linea = x.getCodigoCliente() + ";" +
                               x.getCodigoVenta() + ";" +
                               x.getCodProducto() + ";" +
                               String.format("%.2f", x.getPrecio()) + ";" +
                               x.getCantidad()+ ";" +
                               x.fechaActual()+ ";" +
                               String.format("%.2f", x.calcImportePagar()) + ";" +
                               String.format("%.2f", x.calcIporteIgv()) + ";" +
                               String.format("%.2f", x.calcImporteTotal());          
                pw.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al grabar productos: " + e.getMessage());
        }
    }
    
    private void cargarDetalleVenta() {
        try (BufferedReader br = new BufferedReader(new FileReader("DetalleVenta.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] s = linea.split(";");
                int codCliente = Integer.parseInt(s[0].trim());
                int codVenta = Integer.parseInt(s[1].trim());
                int codProducto = Integer.parseInt(s[2].trim());
                double precio=  Double.parseDouble(s[3].trim());
                int cantidad = Integer.parseInt(s[4].trim());
                String fecha= s[5].trim();               
                dv.add(new DetalleVenta(codVenta,codCliente, fecha, codProducto,cantidad, precio));
            }
			br.close();
		}
		catch (Exception e) {
		}
	}
}
