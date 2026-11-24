package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglo.Arreglo_Producto;
import clases.Producto;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Ventana_Productos extends JDialog implements  ActionListener, KeyListener, MouseListener {
    
    private static final long serialVersionUID = 1L;
    
    private final JPanel contentPanel = new JPanel();
    private JLabel lblNombre;
    private JLabel lblPrecio;
    private JLabel lblStockActual;
    private JLabel lblStockMinimo;
    private JLabel lblStockMaximo;
    private JLabel lblCodigoProducto;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStockActual;
    private JTextField txtStockMinimo;
    private JTextField txtStockMaximo;
    private JTextField txtCodigoProducto;
    private JButton btnAdicionar;
    private JButton btnConsultar;
    private JButton btnModificar;
    private JButton btnEliminar;
	private JButton btnOK;
    private JScrollPane scp;
    private JTable tblTabla;
    private DefaultTableModel modelo;
    
	//  Declaraci�n global
	Arreglo_Producto sp= new Arreglo_Producto();
	private JLabel imgFondoProd;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Ventana_Productos dialog = new Ventana_Productos();
                	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);  // Cambiado aqu�
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the dialog.
     */
    public Ventana_Productos() {
    	setResizable(false);
    	setAlwaysOnTop(true);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("Media/iconProd.png"));
        setTitle("Mantenimiento - Productos");
		setBounds(100, 100, 820, 630);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
    
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBackground(new Color(240, 240, 240));
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
        lblNombre.setBounds(284, 8, 80, 28);
        contentPanel.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(374, 12, 253, 28);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(10);
        
        lblPrecio = new JLabel("Precio:");
        lblPrecio.setForeground(new Color(255, 255, 255));
        lblPrecio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
        lblPrecio.setBounds(306, 90, 58, 28);
        contentPanel.add(lblPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(374, 90, 80, 28);
        contentPanel.add(txtPrecio);
        txtPrecio.setColumns(10);
        
        lblStockActual = new JLabel("Stock Actual:");
        lblStockActual.setForeground(new Color(255, 255, 255));
        lblStockActual.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
        lblStockActual.setBounds(10, 90, 109, 28);
        contentPanel.add(lblStockActual);
        
        txtStockActual = new JTextField();
        txtStockActual.setBounds(128, 93, 80, 28);
        contentPanel.add(txtStockActual);
        txtStockActual.setColumns(10);
        
        lblStockMinimo = new JLabel("Stock Minimo:");
        lblStockMinimo.setForeground(new Color(255, 255, 255));
        lblStockMinimo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
        lblStockMinimo.setBounds(246, 46, 123, 28);
        contentPanel.add(lblStockMinimo);
        
        txtStockMinimo = new JTextField();
        txtStockMinimo.setBounds(374, 50, 80, 28);
        contentPanel.add(txtStockMinimo);
        txtStockMinimo.setColumns(10);
        
        lblStockMaximo = new JLabel("Stock Maximo:");
        lblStockMaximo.setForeground(new Color(255, 255, 255));
        lblStockMaximo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
        lblStockMaximo.setBounds(10, 50, 119, 28);
        contentPanel.add(lblStockMaximo);
        
        txtStockMaximo = new JTextField();
        txtStockMaximo.setBounds(128, 51, 80, 28);
        contentPanel.add(txtStockMaximo);
        txtStockMaximo.setColumns(10);
        
        lblCodigoProducto = new JLabel("Código:");
        lblCodigoProducto.setForeground(new Color(255, 255, 255));
        lblCodigoProducto.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
        lblCodigoProducto.setBounds(50, 8, 68, 28);
        contentPanel.add(lblCodigoProducto);
        
        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setEditable(false);
        txtCodigoProducto.setBounds(128, 12, 80, 28);
        contentPanel.add(txtCodigoProducto);
        txtCodigoProducto.setColumns(10);

        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setForeground(new Color(0, 0, 0));
        btnAdicionar.setBackground(new Color(208, 243, 205));
        btnAdicionar.setIcon(new ImageIcon("Media/adicProd.png"));
        btnAdicionar.setFont(new Font("Arial", Font.BOLD, 16));
        btnAdicionar.addActionListener(this);
        btnAdicionar.setBounds(20, 158, 162, 31);
        contentPanel.add(btnAdicionar);
        
        btnConsultar = new JButton("Consultar");
        btnConsultar.setForeground(new Color(0, 0, 0));
        btnConsultar.setIcon(new ImageIcon("Media/consProd.png"));
        btnConsultar.setBackground(new Color(208, 243, 205));
        btnConsultar.setFont(new Font("Arial", Font.BOLD, 16));
        btnConsultar.addActionListener(this);
        btnConsultar.setBounds(423, 158, 162, 31);
        contentPanel.add(btnConsultar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setForeground(new Color(0, 0, 0));
        btnModificar.setIcon(new ImageIcon("Media/modiProd.png"));
        btnModificar.setBackground(new Color(208, 243, 205));
        btnModificar.setFont(new Font("Arial", Font.BOLD, 16));
        btnModificar.addActionListener(this);
        btnModificar.setBounds(222, 158, 162, 31);
        contentPanel.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(new Color(255, 255, 255));
        btnEliminar.setIcon(new ImageIcon("Media/elimProd.png"));
        btnEliminar.setBackground(new Color(255, 60, 60));
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(621, 158, 162, 31);
        contentPanel.add(btnEliminar);
        
        scp = new JScrollPane();
        scp.setBounds(20, 199, 763, 384);
        contentPanel.add(scp);
        
        tblTabla = new JTable();
        tblTabla.setBackground(new Color(234, 255, 232));
        tblTabla.setFillsViewportHeight(true);
        scp.setViewportView(tblTabla);

        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock Actual");
        modelo.addColumn("Stock Minimo");
        modelo.addColumn("Stock Maximo");
        tblTabla.setModel(modelo);
        
		btnOK = new JButton("OK");
		btnOK.setBackground(new Color(208, 243, 205));
		btnOK.addActionListener(this);
		btnOK.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnOK.setBounds(650, 26, 146, 68);
		contentPanel.add(btnOK);
		
		imgFondoProd = new JLabel("");
		imgFondoProd.setIcon(new ImageIcon("Media/fondProd.jpg"));
		imgFondoProd.setBounds(0, 0, 806, 593);
		contentPanel.add(imgFondoProd);
		
		habilitarEntradas(false);
        listar(0);
    }
    
	// Implementaci�n de los m�todos de KeyListener
    public void keyTyped(KeyEvent e) {
        // Implementar la l�gica para cuando se tipea una tecla
    }
    public void keyPressed(KeyEvent e) {
        // Implementar la l�gica para cuando se presiona una tecla
    }
    public void keyReleased(KeyEvent e) {
        // Implementar la l�gica para cuando se suelta una tecla
    }

    // Implementaci�n de los m�todos de MouseListener
    public void mouseClicked(MouseEvent e) {
        // Implementar la l�gica para cuando se hace clic con el rat�n
    }
    public void mousePressed(MouseEvent e) {
        // Implementar la l�gica para cuando se presiona un bot�n del rat�n
    }
    public void mouseReleased(MouseEvent e) {
        // Implementar la l�gica para cuando se suelta un bot�n del rat�n
    }
    public void mouseEntered(MouseEvent e) {
        // Implementar la l�gica para cuando el rat�n entra en el componente
    }
    public void mouseExited(MouseEvent e) {
        // Implementar la l�gica para cuando el rat�n sale del componente
    }
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOk(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}


	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {		
		btnAdicionar.setEnabled(false);
		txtCodigoProducto.setEditable(false);
		btnOK.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnModificar.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtNombre.requestFocus();
	}
	
	
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		btnConsultar.setEnabled(false);
		txtCodigoProducto.setEditable(true);
		btnOK.setEnabled(true);
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		txtCodigoProducto.requestFocus();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		txtCodigoProducto.setEditable(false);
		btnModificar.setEnabled(false);
		btnAdicionar.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnOK.setEnabled(true);
		if (sp.tamanio() == 0) {
			btnOK.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen productos");	
		}
		else {
			btnOK.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtNombre.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOK.setEnabled(false);
		if (sp.tamanio() == 0) {
			btnEliminar.setEnabled(false);
			mensaje("No existen productos");
		}
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿Desea eliminar el registro?");
			if (ok == 0) {                                   //Verifica si el usuario seleccion� "S�"
				Producto x = sp.buscar(leerCodigoProducto());
				int posFila = tblTabla.getSelectedRow();
				if (posFila == sp.tamanio()-1)   //Verifica si la fila seleccionada es la �ltima en la tabla (ac.tamanio() - 1).
					posFila --;  //decrementa posFila en 1 para seleccionar la fila anterior
				sp.eliminar(x);
				listar(posFila);
				editarFila();
			}
		}
	}
	
    protected void actionPerformedBtnOk(ActionEvent e) {

        try {

            // Validar codigo del producto
            if (txtCodigoProducto.getText().trim().isEmpty()) {
                mensaje("Ingrese el codigo del producto");
                txtCodigoProducto.requestFocus();
                return;
            }

            int codigoProducto = leerCodigoProducto();

            // ADICIONAR O MODIFICAR
            if (!btnAdicionar.isEnabled() || !btnModificar.isEnabled()) {

                // Validar campos obligatorios
                if (leerNombre().isEmpty()
                        || txtPrecio.getText().trim().isEmpty()
                        || txtStockActual.getText().trim().isEmpty()
                        || txtStockMaximo.getText().trim().isEmpty()
                        || txtStockMinimo.getText().trim().isEmpty()) {

                    mensaje("Todos los campos son obligatorios");
                    return;
                }

                String nombre = leerNombre();
                double precio = leerPrecio();
                int stockActual = leerstockActual();
                int stockMaximo = leerstockMaximo();
                int stockMinimo = leerstockMinimo();

                // Validar precio
                if (!Double.isFinite(precio) || precio <= 0) {
                    error("Ingrese un precio valido mayor que cero", txtPrecio);
                    return;
                }

                // Validar cantidades
                if (stockActual < 0 || stockMinimo < 0 || stockMaximo < 0) {
                    mensaje("El stock no puede ser negativo");
                    return;
                }

                if (stockMinimo > stockMaximo) {
                    error("El stock minimo no puede superar al maximo",
                            txtStockMinimo);
                    return;
                }

                if (stockActual > stockMaximo) {
                    error("El stock actual no puede superar al maximo",
                            txtStockActual);
                    return;
                }

                // ADICIONAR
                if (!btnAdicionar.isEnabled()) {

                    if (sp.buscar(codigoProducto) != null) {
                        mensaje("El codigo del producto ya existe");
                        return;
                    }

                    Producto nuevo = new Producto(
                            nombre,
                            precio,
                            stockActual,
                            stockMinimo,
                            stockMaximo,
                            codigoProducto
                    );

                    sp.adicionar(nuevo);

                    btnAdicionar.setEnabled(true);
                    listar(tblTabla.getRowCount());
                    habilitarEntradas(false);
                }

                // MODIFICAR
                else if (!btnModificar.isEnabled()) {

                    Producto x = sp.buscar(codigoProducto);

                    if (x == null) {
                        mensaje("El producto no existe");
                        return;
                    }

                    x.setNombre(nombre);
                    x.setPrecio(precio);
                    x.setStockActual(stockActual);
                    x.setStockMaximo(stockMaximo);
                    x.setStockMinimo(stockMinimo);

                    btnModificar.setEnabled(true);
                    listar(tblTabla.getSelectedRow());
                    sp.actualizarArchivo();
                    habilitarEntradas(false);
                }
            }

            // CONSULTAR
            else if (!btnConsultar.isEnabled()) {

                Producto x = sp.buscar(codigoProducto);

                if (x == null) {
                    error("El codigo " + codigoProducto + " no existe",
                            txtCodigoProducto);
                    return;
                }

                txtNombre.setText(x.getNombre());
                txtPrecio.setText(String.valueOf(x.getPrecio()));
                txtStockActual.setText(String.valueOf(x.getStockActual()));
                txtStockMaximo.setText(String.valueOf(x.getStockMaximo()));
                txtStockMinimo.setText(String.valueOf(x.getStockMinimo()));

                btnConsultar.setEnabled(true);
            }

        } catch (NumberFormatException ex) {

            mensaje("Ingrese valores numericos validos");
        }
    }

	void limpieza() {
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMinimo.setText("");
		txtStockMaximo.setText("");
		txtCodigoProducto.setText("" + sp.codigoCorrelativoProducto());
		txtNombre.requestFocus();
	}
	
	void editarFila() {
		if (sp.tamanio() == 0)
			limpieza();
		else {
			Producto x = sp.obtener(tblTabla.getSelectedRow());//devuelve el �ndice de la fila seleccionada en tablaCliente
			txtCodigoProducto.setText("" + x.getCodigoProducto());//(""+) : convierte int a String
			txtNombre.setText(x.getNombre());
			txtPrecio.setText(String.valueOf(x.getPrecio()));
			txtStockActual.setText(String.valueOf(x.getStockActual()));
			txtStockMaximo.setText(String.valueOf(x.getStockMaximo()));
			txtStockMinimo.setText(String.valueOf(x.getStockMinimo()));
			sp.actualizarArchivo();
		}
	}
	
	void listar(int posFila) 
  	{	modelo.setRowCount(0);
  	   for (int i = 0; i < sp.tamanio(); i++) 
  	   { Object[] fila= {  	sp.obtener(i).getCodigoProducto(),
  			   				sp.obtener(i).getNombre(),
				  	  		sp.obtener(i).getPrecio(),
				  	  		sp.obtener(i).getStockActual(),
				  	  		sp.obtener(i).getStockMinimo(),
				  	  		sp.obtener(i).getStockMaximo()
  	   					};
			 modelo.addRow(fila);
		 }
  	 tblTabla.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void habilitarEntradas(boolean b) {
		txtNombre.setEditable(b);
		txtPrecio.setEditable(b);
		txtStockActual.setEditable(b);
		txtStockMaximo.setEditable(b);
		txtStockMinimo.setEditable(b);
	}

	
	//Mensajes
	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "ERROR", 0);//El 0 indica que el cuadro de di�logo es un mensaje simple sin �conos especiales.
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Confirmaci�n", 0, 1, null);//0 para "S�" y 1 para "No"
	}
	
	
	//  M�todos que retornan valor (sin par�metros)
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	
	int leerstockActual() {
		return Integer.parseInt(txtStockActual.getText().trim());
	}
	
	int leerstockMaximo() {
		return Integer.parseInt(txtStockMaximo.getText().trim());
	}
	
	int leerstockMinimo() {
		return Integer.parseInt(txtStockMinimo.getText().trim());
	}
	
	
	int leerCodigoProducto() {
		return Integer.parseInt(txtCodigoProducto.getText().trim());
	}
	
	
	
}