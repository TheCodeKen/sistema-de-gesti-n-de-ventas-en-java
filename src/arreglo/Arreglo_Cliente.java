package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;

public class Arreglo_Cliente {
	
	//Atributo privado (array) 
	private ArrayList<Cliente> cli;
	
	public Arreglo_Cliente () 
	{
		cli = new ArrayList<Cliente>();
		cargarClientes();
	}
	
	//Operaciones basicas
	public void adicionar(Cliente c)
	{ cli.add(c);
	  grabarClientes();
	}
	
	public int tamanio()
	{ return cli.size();}
	
	public Cliente obtener(int c)
	{ return cli.get(c);}
	
	public Cliente buscar(int codigo)
	{ 
		Cliente mc;
		for(int i=0; i<tamanio(); i++)
		{	mc=obtener(i);
			if (mc.getCodigo()==codigo)
				return mc;
		}
		return null;
	}
	
	public Cliente buscar(String dni) {
		Cliente x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))//El m�todo equals se usa para comparar cadenas en Java.
				return x;
			}
		return null;
	}
	
	public void eliminar(Cliente x) {
		cli.remove(x);
		grabarClientes();
	}
	
	//Metodo para aumentar codigo de 1 en 1
	public int codigoCorrelativoCliente() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigo() + 1;		
	}
	
	public void actualizarArchivo() {
        grabarClientes();
    }
    
    private void grabarClientes() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("Clientes.txt"))) {
            for (int i = 0; i < tamanio(); i++) {
                Cliente x = obtener(i);
                String linea = x.getCodigo() + ";" +
                			   x.getNombre() + ";" +
                               x.getApellido() + ";" +
                               x.getDireccion() + ";" +
                               x.getTelefono() + ";" +
                               x.getDni();
                               
                pw.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al grabar productos: " + e.getMessage());
        }
    }
    
    private void cargarClientes() {
        try (BufferedReader br = new BufferedReader(new FileReader("Clientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] s = linea.split(";");
                int codigoCliente= Integer.parseInt(s[0].trim());
                String nombres = s[1].trim();
                String apellidos = s[2].trim();
                String direccion = s[3].trim();
                String telefono = s[4].trim();
                String dni = s[5].trim();
                
                cli.add(new Cliente(codigoCliente, dni, telefono,nombres, apellidos, direccion));
            }
			br.close();
		}
		catch (Exception e) {
		}
	}
	
}
