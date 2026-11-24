package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Ventas;

public class Arreglo_Ventas {

	private ArrayList<Ventas> ven;
	
	public Arreglo_Ventas  () 
	{
		ven = new ArrayList<Ventas>();
		cargarVentas();
	}
	
	//Operaciones basicas
		public void adicionar(Ventas c)
		{ ven.add(c);
		  grabarVentas();
		}
		
		public int tamanio()
		{ return ven.size();}
		
		public Ventas obtener(int c)
		{ return ven.get(c);}
		
		public Ventas buscar(int codigo)
		{ 
			Ventas mc;
			for(int i=0; i<tamanio(); i++)
			{	mc=obtener(i);
				if (mc.getCodigoVenta()==codigo)
					return mc;
			}
			return null;
		}
		
		public int codigoCorrelativoVentas() {
			if (tamanio() == 0)
				return 3001;
			else
				return obtener(tamanio()-1).getCodigoVenta() + 1;		
		}
		
		public void eliminar(Ventas x) 
			{ven.remove(x);
			grabarVentas();
			}
		
		
		public void actualizarArchivo() {
			grabarVentas();
	    }
	    
	    private void grabarVentas() {
	        try (PrintWriter pw = new PrintWriter(new FileWriter("Ventas.txt"))) {
	            for (int i = 0; i < tamanio(); i++) {
	                Ventas x = obtener(i);
	                String linea = x.getCodigoVenta() + ";" +
	                			   x.getCodigoCliente() + ";" +
	                               x.getFecha();
	                pw.println(linea);
	            }
	        } catch (IOException e) {
	            System.err.println("Error al grabar productos: " + e.getMessage());
	        }
	    }
	    
	    public void cargarVentas() {
	        try (BufferedReader br = new BufferedReader(new FileReader("Ventas.txt"))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] s = linea.split(";");
	                int codigoVenta= Integer.parseInt(s[0].trim());
	                int codigoCliente= Integer.parseInt(s[1].trim());       
	                String fecha = s[2].trim();
	              
	                ven.add(new Ventas(codigoVenta, codigoCliente, fecha));
	            }
				br.close();
			}
			catch (Exception e) {
			}
		}
}
