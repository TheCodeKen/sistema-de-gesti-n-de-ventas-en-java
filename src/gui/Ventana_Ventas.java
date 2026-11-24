package gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.Arreglo_Cliente;
import arreglo.Arreglo_DetalleVenta;
import arreglo.Arreglo_Producto;
import arreglo.Arreglo_Ventas;
import clases.Cliente;
import clases.DetalleVenta;
import clases.Producto;
import clases.Ventas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Ventana_Ventas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigoCliente;
	private JLabel lblCodigoProducto;
	private JTextField txtCodCliente;
	private JTextField txtCodProducto;
	private JButton btnVerificar;
	private JLabel lblNombreClie;
	private JTextField txtNombreClie;
	private JLabel lblNombreProducto;
	private JTextField txtProducto;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private DefaultTableModel modelo;
	
	private JTextField txtCantidad;
	private JButton btnVender;
	private JLabel lblDetalleClie;
	private JLabel lblDetallePro;
	private JCheckBox chckbxSelecClie;
	private JButton btnAgregarProducto;
	private JTextField txtSubTotal;
	private JTextField txtIgv;
	private JTextField txtTotal;
	private JLabel lblSubTotal;
	private JLabel lblIgv;
	private JLabel lblTotal;
	private JScrollPane scp;
	private JTable tblVenta;
	private JTextField txtCodigoVenta;
	private JLabel lblCodigoVenta;
	
	Arreglo_Cliente ac	= new Arreglo_Cliente();
	Arreglo_Producto ap	= new Arreglo_Producto();
	Arreglo_DetalleVenta adv = new Arreglo_DetalleVenta();
	Arreglo_Ventas av	= new Arreglo_Ventas();
	private JLabel imgFondoVentas;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ventana_Ventas dialog = new Ventana_Ventas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setResizable(false);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public Ventana_Ventas() {
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Media/iconVenta.png"));
		setTitle("Ventas");	
		setBounds(100, 100, 818, 597);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCodigoCliente = new JLabel("Codigo Cliente:");
		lblCodigoCliente.setBounds(10, 46, 90, 17);
		contentPanel.add(lblCodigoCliente);
		
		lblCodigoProducto = new JLabel("Codigo Producto:");
		lblCodigoProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoProducto.setBounds(10, 120, 100, 17);
		contentPanel.add(lblCodigoProducto);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setBounds(106, 43, 86, 20);
		contentPanel.add(txtCodCliente);
		txtCodCliente.setColumns(10);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setEditable(false);
		txtCodProducto.setBounds(121, 117, 76, 20);
		contentPanel.add(txtCodProducto);
		txtCodProducto.setColumns(10);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setIcon(new ImageIcon("Media/verificar.png"));
		btnVerificar.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnVerificar.setBackground(new Color(128, 255, 128));
		btnVerificar.addActionListener(this);
		btnVerificar.setBounds(638, 46, 156, 39);
		contentPanel.add(btnVerificar);
		
		lblNombreClie = new JLabel("Nombre completo");
		lblNombreClie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreClie.setBounds(208, 46, 102, 14);
		contentPanel.add(lblNombreClie);
		
		txtNombreClie = new JTextField();
		txtNombreClie.setEditable(false);
		txtNombreClie.setBounds(320, 43, 295, 20);
		contentPanel.add(txtNombreClie);
		txtNombreClie.setColumns(10);
		
		lblNombreProducto = new JLabel("Nombre producto");
		lblNombreProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreProducto.setBounds(207, 120, 103, 17);
		contentPanel.add(lblNombreProducto);
		
		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setBounds(320, 117, 157, 20);
		contentPanel.add(txtProducto);
		txtProducto.setColumns(10);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(487, 120, 40, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(529, 117, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(20, 145, 90, 17);
		contentPanel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setBounds(121, 142, 76, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.setIcon(new ImageIcon("Media/vender.png"));
		btnVender.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnVender.setBackground(new Color(202, 255, 255));
		btnVender.addActionListener(this);
		btnVender.setBounds(24, 448, 168, 39);
		contentPanel.add(btnVender);
		
		lblDetalleClie = new JLabel("DETALLE DE CLIENTE");
		lblDetalleClie.setFont(new Font("Arial", Font.BOLD, 14));
		lblDetalleClie.setBounds(24, 21, 168, 14);
		contentPanel.add(lblDetalleClie);
		
		lblDetallePro = new JLabel("DETALLE PRODUCTO");
		lblDetallePro.setFont(new Font("Arial", Font.BOLD, 14));
		lblDetallePro.setBounds(24, 95, 153, 14);
		contentPanel.add(lblDetallePro);
		
		chckbxSelecClie = new JCheckBox("Seleccionar cliente");
		chckbxSelecClie.addActionListener(this);
		chckbxSelecClie.setBounds(93, 67, 162, 23);
		contentPanel.add(chckbxSelecClie);
		
		btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBackground(new Color(255, 255, 255));
		btnAgregarProducto.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAgregarProducto.setIcon(new ImageIcon("Media/agregProd.png"));
		btnAgregarProducto.addActionListener(this);
		btnAgregarProducto.setBounds(24, 173, 183, 39);
		contentPanel.add(btnAgregarProducto);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setEditable(false);
		txtSubTotal.setBounds(638, 451, 139, 20);
		contentPanel.add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		txtIgv = new JTextField();
		txtIgv.setEditable(false);
		txtIgv.setBounds(638, 482, 139, 20);
		contentPanel.add(txtIgv);
		txtIgv.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(638, 513, 139, 20);
		contentPanel.add(txtTotal);
		
		lblSubTotal = new JLabel("SubTotal:");
		lblSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubTotal.setBounds(561, 452, 67, 17);
		contentPanel.add(lblSubTotal);
		
		lblIgv = new JLabel("IGV:");
		lblIgv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIgv.setBounds(597, 485, 31, 14);
		contentPanel.add(lblIgv);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(590, 514, 38, 17);
		contentPanel.add(lblTotal);
		
		scp = new JScrollPane();
		scp.setBounds(24, 221, 753, 219);
		contentPanel.add(scp);
		
		tblVenta = new JTable();
		scp.setViewportView(tblVenta);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Producto");
		modelo.addColumn("Nombre Producto");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		modelo.addColumn("SubTotal");
		tblVenta.setModel(modelo);
		
		txtCodigoVenta = new JTextField();
		txtCodigoVenta.setText(String.valueOf(av.codigoCorrelativoVentas()));
		txtCodigoVenta.setEditable(false);
		txtCodigoVenta.setBounds(106, 497, 86, 20);
		contentPanel.add(txtCodigoVenta);
		txtCodigoVenta.setColumns(10);
		
		lblCodigoVenta = new JLabel("Codigo Venta:");
		lblCodigoVenta.setBounds(24, 500, 81, 14);
		contentPanel.add(lblCodigoVenta);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Media/decoVentas.png"));
		lblNewLabel.setBounds(638, 111, 156, 101);
		contentPanel.add(lblNewLabel);
		
		imgFondoVentas = new JLabel("");
		imgFondoVentas.setHorizontalAlignment(SwingConstants.CENTER);
		imgFondoVentas.setIcon(new ImageIcon("Media/fondoVentas.jpg"));
		imgFondoVentas.setBounds(0, 0, 804, 560);
		contentPanel.add(imgFondoVentas);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregarProducto) {
			actionPerformedBtnAgregarProducto(e);
		}
		if (e.getSource() == chckbxSelecClie) {
			actionPerformedChckbxSelecCliente(e);
		}
		if (e.getSource() == btnVerificar) {
			actionPerformedBtnVerificar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}
	
	protected void actionPerformedBtnVerificar(ActionEvent e) {
		
		if (!txtCodCliente.getText().isEmpty()) {
			int codCliente=Integer.parseInt(txtCodCliente.getText().trim());
			Cliente x= ac.buscar(codCliente);
			 if (x != null) 
			 	{ txtNombreClie.setText(x.getNombre()+ " "+ x.getApellido()); }
			 else mensaje("No existe el codigo del cliente", txtCodCliente);
		}

		if (!txtCodProducto.getText().isEmpty()) {
			int codProducto=Integer.parseInt(txtCodProducto.getText().trim());
		
			Producto p = ap.buscar(codProducto);
			if (p != null) 
			{	txtProducto.setText(p.getNombre());
            	txtCantidad.setEditable(true);
				txtPrecio.setText(String.valueOf(p.getPrecio()));
			}
			else mensaje("No existe el codigo del producto", txtCodProducto);
		}
	}
	protected void actionPerformedChckbxSelecCliente(ActionEvent e) {
		 if(chckbxSelecClie.isSelected()) //selecciona el evento
		 {
		        if(!txtNombreClie.getText().isEmpty()) {
		            txtCodProducto.setEditable(true);
		            txtCodCliente.setEditable(false);
		        }
		    } else {
		        txtCodProducto.setEditable(false);
		        txtCantidad.setEditable(false);
		        txtCodCliente.setEditable(true);
		        txtNombreClie.setText("");
		    }
	}

	protected void actionPerformedBtnAgregarProducto(ActionEvent e) {

	    if (txtCodCliente.getText().isEmpty() || txtNombreClie.getText().isEmpty()) {
	        mensaje("Por favor, ingrese un Cliente", txtCodCliente);
	        txtCodCliente.requestFocus();
	        return;
	    }

	    if (txtCodProducto.getText().isEmpty() || txtProducto.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
	        mensaje("Por favor, ingrese un producto", txtCodProducto);
	        txtCodProducto.requestFocus();
	        return;
	    }

	    if (txtCantidad.getText().isEmpty()) {
	        mensaje("Por favor, ingrese una cantidad.", txtCantidad);
	        txtCantidad.requestFocus();
	        return;
	    }
	    
		int codigoVenta = leerCodigoVenta();
		int codigoCliente = leerCodigoCliente();
		int codigoProducto= leerCodigoProducto();
		double precio= leerPrecio();
		int cantidad= leerCantidad();
        String fechaActual = fechaActual();
        
	    Producto productoAgregado = ap.buscar(codigoProducto);
        int stockActual = productoAgregado.getStockActual();

		if(stockActual >= cantidad ) {
	        DetalleVenta nuevo = new DetalleVenta(codigoVenta,codigoCliente,fechaActual,codigoProducto,cantidad,precio);
	        adv.adicionar(nuevo);
	        adv.actualizarArchivo();
			listado(codigoVenta, tblVenta.getRowCount());
			productoAgregado.setStockActual(stockActual-cantidad);
			ap.actualizarArchivo();
			txtCodProducto.setText("");
			txtProducto.setText("");
			txtPrecio.setText("");
			txtCantidad.setText("");
			txtCantidad.setEditable(false);
			txtCodProducto.requestFocus();
			
			double subTotal=0;
			double importeIgv=0;
			double total=0;
		    DetalleVenta[] detalles = adv.buscarPorCodigoVenta(codigoVenta);
		    for(DetalleVenta x : detalles) {
		        subTotal += x.calcImportePagar();
		        importeIgv += x.calcIporteIgv();
		        total += x.calcImporteTotal();
		    }
			
			txtSubTotal.setText(String.format("%.2f", subTotal));
			txtIgv.setText(String.format("%.2f", importeIgv));
			txtTotal.setText(String.format("%.2f", total));
		}else {
			mensaje("El stock actual no es suficiente", txtCantidad);
		}
	}
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		
		if(modelo.getRowCount() == 0) {
			mensaje("Por favor agregue un producto", txtCodCliente);
			txtCodProducto.requestFocus();
			return;
		}
		
		int codigoVenta = leerCodigoVenta();
		int codigoCliente = leerCodigoCliente();
		String fechaActual = fechaActual();
		
		Ventas nuevo = new Ventas(codigoVenta, codigoCliente, fechaActual);
		av.adicionar(nuevo);
		
		
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Código de venta: ").append(leerCodigoVenta()).append("\n");
		mensaje.append("Código del cliente: ").append(leerCodigoCliente()).append("\n");
		mensaje.append("Nombres y apellidos: ").append(leerNombreCliente()).append("\n");
		mensaje.append("+-----------------------------+\n");
		mensaje.append("Código | Producto    | Precio   | Cantidad |\n");

		for (int i = 0; i < tblVenta.getRowCount(); i++) {
		    mensaje.append(String.format("%-7s", tblVenta.getValueAt(i, 0))).append("  | "); // Código del producto
		    mensaje.append(String.format("%-12s", tblVenta.getValueAt(i, 1))).append("  | "); // Nombre del producto
		    mensaje.append(String.format("%-8s", tblVenta.getValueAt(i, 2))).append("  | "); // Precio unitario
		    mensaje.append(String.format("%-9s", tblVenta.getValueAt(i, 3))).append("  |\n"); // Cantidad de unidades
		}

		mensaje.append("+-----------------------------+\n");
		mensaje.append("Importe subtotal: ").append(leerSubTotal()).append("\n");
		mensaje.append("Importe del IGV: ").append(leerIgv()).append("\n");
		mensaje.append("Importe total a pagar: ").append(leerTotal()).append("\n");
		mensaje.append("+-----------------------------+\n");
		
		limpieza();
		mensajeConfirmado(mensaje.toString());
	}
	
	
	//----------------------------------------------------------------------------
	///metodos 
	void limpieza() {
		txtCodigoVenta.setText("" + av.codigoCorrelativoVentas());
		txtCodProducto.setText("");
		txtProducto.setText("");
		txtCantidad.setText("");
		modelo.setRowCount(0);
	}
	
	void listado(int codigoVenta, int posFila) {
	    modelo.setRowCount(0);
	    DetalleVenta[] detalles = adv.buscarPorCodigoVenta(codigoVenta); // Obtener los DetalleVenta por codigoVenta

	    for(DetalleVenta x : detalles) {
	        Producto p = ap.buscar(x.getCodProducto());
	        Object[] fila = {
	            x.getCodProducto(),
	            p.getNombre(),
	            x.getPrecio(),
	            x.getCantidad(),
	            x.calcImportePagar()
	        };
	        modelo.addRow(fila);
	    }

	    if (modelo.getRowCount() > 0) {
	        tblVenta.getSelectionModel().setSelectionInterval(posFila, posFila);
	    }
	}
	
	public String fechaActual() {
		LocalDate fechaActual = LocalDate.now();     
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String fechaFormateada = fechaActual.format(formato);
        return fechaFormateada;
	}
	
	 public void mensaje(String s,JTextField txt) {
		JOptionPane.showMessageDialog(this, s, "ERROR", 0);//El 0 indica que el cuadro de di�logo es un mensaje simple sin �conos especiales.
		txt.setText("");
		txt.requestFocus();
	 }
	 
	 public void mensajeConfirmado(String s) {
		    JOptionPane.showMessageDialog(this, s, "BOLETA VENTA", JOptionPane.INFORMATION_MESSAGE);
	}
	 
	//  M�todos que retornan valor (sin parametros)
	String leerNombreCliente() {
		return txtNombreClie.getText().trim();
	}
	
	int leerCodigoVenta() {
		return Integer.parseInt(txtCodigoVenta.getText().trim());
	} 
	int leerCodigoCliente() {
		return Integer.parseInt(txtCodCliente.getText().trim());
	}
	int leerCodigoProducto() {
		return Integer.parseInt(txtCodProducto.getText().trim());
	}
	String leerNombreProducto() {
		return txtProducto.getText().trim();
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText().trim());
	}
	
	double leerSubTotal() {
		return Double.parseDouble(txtSubTotal.getText().trim());
	}
	
	double leerIgv() {
		return Double.parseDouble(txtIgv.getText().trim());
	}
	
	double leerTotal() {
		return Double.parseDouble(txtTotal.getText().trim());
	}
}
