package arreglo;

import java.io.*;
import java.util.ArrayList;
import clases.Producto;

public class Arreglo_Producto {
    
    private ArrayList<Producto> pro;
    
    public Arreglo_Producto() {
        pro = new ArrayList<Producto>();
        cargarProductos();
    }
    
    public void adicionar(Producto x) {  
        pro.add(x);
        grabarProductos();
    }
    
    public int tamanio() { 
        return pro.size(); 
    } 
    
    public Producto obtener(int i) { 
        return pro.get(i); 
    }
    
    public Producto buscar(int cod) {
    	Producto pro;
        for (int i = 0; i < tamanio(); i++) 
        {	pro=obtener(i);
            if (pro.getCodigoProducto() == cod) {
                return pro;
            }
        }
        return null;
    }
    
    public void eliminar(Producto x) {
        pro.remove(x);
        grabarProductos();
    }
    
	//Metodo para aumentar codigo de 1 en 1
	public int codigoCorrelativoProducto() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigoProducto() + 1;		
	}

    public void actualizarArchivo() {
        grabarProductos();
    }
    
    private void grabarProductos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Productos.txt"))) {
            for (int i = 0; i < tamanio(); i++) {
                Producto x = obtener(i);
                String linea = x.getNombre() + ";" +
                               x.getPrecio() + ";" +
                               x.getStockActual() + ";" +
                               x.getStockMinimo() + ";" +
                               x.getStockMaximo() + ";" +
                               x.getCodigoProducto();
                pw.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al grabar productos: " + e.getMessage());
        }
    }
    
    private void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader("Productos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] s = linea.split(";");
                String nombre = s[0].trim();
                double precio = Double.parseDouble(s[1].trim());
                int stockActual = Integer.parseInt(s[2].trim());
                int stockMinimo = Integer.parseInt(s[3].trim());
                int stockMaximo = Integer.parseInt(s[4].trim());
                int codigoProducto = Integer.parseInt(s[5].trim());
                pro.add(new Producto(nombre, precio, stockActual, stockMinimo, stockMaximo, codigoProducto));
            }
			br.close();
		}
		catch (Exception e) {
		}
	}
    
}



