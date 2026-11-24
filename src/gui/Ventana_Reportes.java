package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.Arreglo_DetalleVenta;
import arreglo.Arreglo_Producto;
import clases.DetalleVenta;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class Ventana_Reportes extends JDialog {
	private static final long serialVersionUID = 1L;
    private JPanel contentPanel;
    private JTabbedPane tabbedPane;
    private JTable tablaVentas;
    private JTable tablaStockBajo;
    private JTable tablaUnidadesVendidas;
    private JTable tablaImporteTotal;
    private JScrollPane scrollPaneVentas;
    private DefaultTableModel modeloVentas;
    private DefaultTableModel modeloStockBajo;
    private DefaultTableModel modeloUnidadesVendidas;
    private DefaultTableModel modeloImporteTotal;
    
    Arreglo_DetalleVenta adv = new Arreglo_DetalleVenta();
    Arreglo_Producto ap = new Arreglo_Producto();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            Ventana_Reportes dialog = new Ventana_Reportes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public Ventana_Reportes() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("Media/iconReporte.png"));
        setTitle("Reportes de Ventas");
        setBounds(100, 100, 900, 600);
        getContentPane().setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.setBackground(Color.WHITE);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Reportes de Ventas");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setBounds(10, 10, 866, 28);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(lblTitulo);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 38, 866, 505);
        tabbedPane.setBackground(new Color(240, 240, 240));
        contentPanel.add(tabbedPane);

        JPanel panelVentas = new JPanel();
        panelVentas.setLayout(new BorderLayout(0, 0));
        panelVentas.setBackground(Color.WHITE);
        tabbedPane.addTab("Listado General de Ventas", null, panelVentas, null);

        scrollPaneVentas = new JScrollPane();
        panelVentas.add(scrollPaneVentas, BorderLayout.CENTER);

        tablaVentas = new JTable();
        tablaVentas.setBackground(new Color(255, 234, 255));
        tablaVentas.setFillsViewportHeight(true);
        scrollPaneVentas.setViewportView(tablaVentas);
        
        modeloVentas = new DefaultTableModel();
        modeloVentas.addColumn("Código de Venta");
        modeloVentas.addColumn("Código de Cliente");
        modeloVentas.addColumn("Código de Producto");
        modeloVentas.addColumn("Fecha");
        modeloVentas.addColumn("Subtotal");
        modeloVentas.addColumn("IGV");
        modeloVentas.addColumn("Total");
        tablaVentas.setModel(modeloVentas);

        listadoVentas(0);
        
        JPanel panelStockBajo = new JPanel();
        panelStockBajo.setLayout(new BorderLayout(0, 0));
        panelStockBajo.setBackground(Color.WHITE);
        tabbedPane.addTab("Productos con Stock Bajo", null, panelStockBajo, null);

        JScrollPane scrollPaneStockBajo = new JScrollPane();
        panelStockBajo.add(scrollPaneStockBajo, BorderLayout.CENTER);

        tablaStockBajo = new JTable();
        tablaStockBajo.setBackground(new Color(255, 234, 255));
        tablaStockBajo.setFillsViewportHeight(true);
        scrollPaneStockBajo.setViewportView(tablaStockBajo);
        
        modeloStockBajo = new DefaultTableModel();
        modeloStockBajo.addColumn("Código de Producto");
        modeloStockBajo.addColumn("Nombre del Producto");
        modeloStockBajo.addColumn("Stock Actual");
        modeloStockBajo.addColumn("Stock Mínimo");
        tablaStockBajo.setModel(modeloStockBajo);

        listadoStockBajo(0);
        
        JPanel panelUnidadesVendidas = new JPanel();
        panelUnidadesVendidas.setLayout(new BorderLayout(0, 0));
        panelUnidadesVendidas.setBackground(Color.WHITE);
        tabbedPane.addTab("Productos por Unidades Vendidas", null, panelUnidadesVendidas, null);

        JScrollPane scrollPaneUnidadesVendidas = new JScrollPane();
        panelUnidadesVendidas.add(scrollPaneUnidadesVendidas, BorderLayout.CENTER);

        tablaUnidadesVendidas = new JTable();
        tablaUnidadesVendidas.setBackground(new Color(255, 234, 255));
        tablaUnidadesVendidas.setFillsViewportHeight(true);
        scrollPaneUnidadesVendidas.setViewportView(tablaUnidadesVendidas);
        
        modeloUnidadesVendidas = new DefaultTableModel();
        modeloUnidadesVendidas.addColumn("Código de Producto");
        modeloUnidadesVendidas.addColumn("Nombre del Producto");
        modeloUnidadesVendidas.addColumn("Unidades Vendidas");
        tablaUnidadesVendidas.setModel(modeloUnidadesVendidas);
        
        listadoUnidadesVendidas(0);

        JPanel panelImporteTotal = new JPanel();
        panelImporteTotal.setLayout(new BorderLayout(0, 0));
        panelImporteTotal.setBackground(Color.WHITE);
        tabbedPane.addTab("Productos por Importe Total", null, panelImporteTotal, null);

        JScrollPane scrollPaneImporteTotal = new JScrollPane();
        panelImporteTotal.add(scrollPaneImporteTotal, BorderLayout.CENTER);

        tablaImporteTotal = new JTable();
        tablaImporteTotal.setBackground(new Color(255, 234, 255));
        tablaImporteTotal.setFillsViewportHeight(true);
        scrollPaneImporteTotal.setViewportView(tablaImporteTotal);

        modeloImporteTotal = new DefaultTableModel();
        modeloImporteTotal.addColumn("Código de Producto");
        modeloImporteTotal.addColumn("Nombre del Producto");
        modeloImporteTotal.addColumn("Importe Total");
        tablaImporteTotal.setModel(modeloImporteTotal);
        
        JLabel imgFondoReporte = new JLabel("");
        imgFondoReporte.setIcon(new ImageIcon("Media/fondoReporte.jpg"));
        imgFondoReporte.setBounds(0, 0, 886, 553);
        contentPanel.add(imgFondoReporte);
        
        listadoImporteTotal(0);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.setBackground(new Color(64, 0, 64));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        setAlwaysOnTop(true);
    }
    
	void listadoVentas(int posFila) 
  	{   modeloVentas.setRowCount(0);
  	   	for (int i = 0; i < adv.tamanio(); i++) { 
  		   Object[] fila= { adv.obtener(i).getCodigoVenta(),
  			   				adv.obtener(i).getCodigoCliente(),
				  	  		adv.obtener(i).getCodProducto(),
				  	  		adv.obtener(i).getFecha(),
				  	  		adv.obtener(i).calcImportePagar(),
				  	  		adv.obtener(i).calcIporteIgv(),
				  	  		adv.obtener(i).calcImporteTotal()
  		   					};
  	   		modeloVentas.addRow(fila);
		}
  	 tablaVentas.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void listadoStockBajo(int posFila) 
  	{   modeloStockBajo.setRowCount(0);
  	   	for (int i = 0; i < ap.tamanio(); i++) {
  	   		int stockMinimo = ap.obtener(i).getStockMinimo();
  	   		int stockActual = ap.obtener(i).getStockActual();
  	   		if(stockMinimo > stockActual) {
	  		   Object[] fila= { ap.obtener(i).getCodigoProducto(),
	  				   			ap.obtener(i).getNombre(),
	  				   			ap.obtener(i).getStockActual(),
					  	  		ap.obtener(i).getStockMinimo(),
	  		   				   };
	  	   		modeloStockBajo.addRow(fila);
  	   		}
		}
  	 tablaStockBajo.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void listadoUnidadesVendidas(int posFila) {
	    modeloUnidadesVendidas.setRowCount(0);
	    List<Map<String, Object>> list = new ArrayList<>();

	    for (int i = 0; i < adv.tamanio(); i++) {
	        DetalleVenta detalle = adv.obtener(i);
	        int codigoProducto = detalle.getCodProducto();
	        String nombreProducto = ap.buscar(codigoProducto).getNombre(); // Buscar por código producto
	        int cantidad = detalle.getCantidad();

	        boolean encontrado = false;
	        for (Map<String, Object> item : list) {
	            if ((int) item.get("codigoProducto") == codigoProducto) {
	                int cantidadActual = (int) item.get("cantidad");
	                item.put("cantidad", cantidadActual + cantidad);
	                encontrado = true;
	                break;
	            }
	        }

	        if (!encontrado) {
	            Map<String, Object> nuevoProducto = new HashMap<>();
	            nuevoProducto.put("codigoProducto", codigoProducto);
	            nuevoProducto.put("nombreProducto", nombreProducto);
	            nuevoProducto.put("cantidad", cantidad);
	            list.add(nuevoProducto);
	        }
	    }

	    for (Map<String, Object> item : list) {
	        Object[] fila = {
	            item.get("codigoProducto"),
	            item.get("nombreProducto"),
	            item.get("cantidad")
	        };
	        modeloUnidadesVendidas.addRow(fila);
	    }
	    
	   tablaUnidadesVendidas.getSelectionModel().setSelectionInterval(posFila, posFila);
	}


	
	void listadoImporteTotal(int posFila) {
	    modeloImporteTotal.setRowCount(0);
	    List<Map<String, Object>> list = new ArrayList<>();

	    for (int i = 0; i < adv.tamanio(); i++) {
	        DetalleVenta detalle = adv.obtener(i);
	        int codigoProducto = detalle.getCodProducto();
	        String nombreProducto = ap.buscar(codigoProducto).getNombre(); // Buscar por código producto
	        double importe = detalle.calcImporteTotal(); // Supongo que hay un método para calcular el importe total

	        boolean encontrado = false;
	        for (Map<String, Object> item : list) {
	            if ((int) item.get("codigoProducto") == codigoProducto) {
	                double importeActual = (double) item.get("importeTotal");
	                item.put("importeTotal", importeActual + importe);
	                encontrado = true;
	                break;
	            }
	        }

	        if (!encontrado) {
	            Map<String, Object> nuevoProducto = new HashMap<>();
	            nuevoProducto.put("codigoProducto", codigoProducto);
	            nuevoProducto.put("nombreProducto", nombreProducto);
	            nuevoProducto.put("importeTotal", importe);
	            list.add(nuevoProducto);
	        }
	    }

	    for (Map<String, Object> item : list) {
	        Object[] fila = {
	            item.get("codigoProducto"),
	            item.get("nombreProducto"),
	            item.get("importeTotal")
	        };
	        modeloImporteTotal.addRow(fila);
	    }
	    
	    tablaImporteTotal.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	
	

}