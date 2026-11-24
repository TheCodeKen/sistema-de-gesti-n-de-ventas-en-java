package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;

import arreglo.Arreglo_Cliente;
import clases.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Ventana_Clientes extends JDialog implements ActionListener, KeyListener, MouseListener {

    private static final long serialVersionUID = 1L; // Campo serialVersionUID
    
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDireccion;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JButton btnOK;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminacionar;
	private JScrollPane scp;
	private JTable tblCliente;
	private DefaultTableModel modelo;
	
	//Declaraci�n global 
	Arreglo_Cliente ac= new Arreglo_Cliente();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Clientes dialog = new Ventana_Clientes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Ventana_Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Media/iconCli.png"));
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Mantenimiento - Clientes");
		setBounds(100, 100, 845, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombres:");
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNombre.setBounds(23, 71, 84, 27);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("Apellidos:");
		lblApellido.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblApellido.setBounds(23, 113, 84, 27);
		contentPanel.add(lblApellido);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblDireccion.setBounds(383, 27, 75, 27);
		contentPanel.add(lblDireccion);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblDni.setBounds(418, 116, 40, 21);
		contentPanel.add(lblDni);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblTelefono.setBounds(385, 71, 73, 27);
		contentPanel.add(lblTelefono);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblCodigo.setBounds(34, 28, 73, 24);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(116, 30, 101, 27);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(116, 72, 243, 26);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(116, 116, 243, 27);
		contentPanel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(468, 31, 295, 26);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(468, 75, 141, 26);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(468, 114, 141, 26);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setIcon(new ImageIcon("Media/agreCli.png"));
		btnIngresar.addActionListener(this);
		btnIngresar.setBackground(new Color(9, 4, 79));
		btnIngresar.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		btnIngresar.setBounds(10, 175, 162, 31);
		contentPanel.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon("Media/modiCli.png"));
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(9, 4, 79));
		btnModificar.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		btnModificar.setBounds(228, 175, 162, 31);
		contentPanel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setIcon(new ImageIcon("Media/consCli.png"));
		btnConsultar.addActionListener(this);
		btnConsultar.setBackground(new Color(9, 4, 79));
		btnConsultar.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		btnConsultar.setBounds(434, 175, 162, 31);
		contentPanel.add(btnConsultar);
		
		btnEliminacionar = new JButton("Eliminar");
		btnEliminacionar.setIcon(new ImageIcon("Media/elimCli.png"));
		btnEliminacionar.setForeground(new Color(0, 0, 0));
		btnEliminacionar.addActionListener(this);
		btnEliminacionar.setBackground(new Color(255, 0, 0));
		btnEliminacionar.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		btnEliminacionar.setBounds(645, 175, 162, 31);
		contentPanel.add(btnEliminacionar);
		
		scp = new JScrollPane();
		scp.setBounds(10, 241, 811, 262);
		contentPanel.add(scp);
		
		tblCliente = new JTable();
		tblCliente.setBackground(new Color(230, 255, 255));
		tblCliente.addKeyListener(this);
		tblCliente.addMouseListener(this);
		tblCliente.setFillsViewportHeight(true);
		scp.setViewportView(tblCliente);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		tblCliente.setModel(modelo);
			
		btnOK = new JButton("OK");
		btnOK.setBackground(new Color(192, 192, 192));
		btnOK.setForeground(new Color(0, 0, 0));
		btnOK.setEnabled(false);
		btnOK.addActionListener(this);
		btnOK.setFont(new Font("Arial", Font.BOLD, 16));
		btnOK.setBounds(716, 75, 91, 65);
		contentPanel.add(btnOK);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Media/fondoCli.jpg"));
		lblNewLabel.setBounds(0, 0, 831, 513);
		contentPanel.add(lblNewLabel);
		
		habilitarEntradas(false);
		listado(0);
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

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			actionPerformedBtnOk(e);
		}
		if (e.getSource() == btnEliminacionar) {
			actionPerformedBtnEliminacion(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsulta(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificacion(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngreso(e);
		}
	}
	
	protected void actionPerformedBtnIngreso(ActionEvent e) {
		btnIngresar.setEnabled(false);
		txtCodigo.setEditable(false);
		btnOK.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnModificar.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtNombres.requestFocus();
	}
	
	protected void actionPerformedBtnConsulta(ActionEvent e) {
		btnConsultar.setEnabled(false);
		txtCodigo.setEditable(true);
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOK.setEnabled(true);
		habilitarEntradas(false);
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnModificacion(ActionEvent e) {
		txtCodigo.setEditable(false);
		btnModificar.setEnabled(false);
		btnIngresar.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnOK.setEnabled(true);
		if (ac.tamanio() == 0) {
			btnOK.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen personas");	
		}
		else {
			btnOK.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtNombres.requestFocus();
		}
	}

	protected void actionPerformedBtnEliminacion(ActionEvent e) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOK.setEnabled(false);
		if (ac.tamanio() == 0) {
			btnEliminacionar.setEnabled(false);
			mensaje("No existen personas");
		}
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿Desea eliminar el registro?");
			if (ok == 0) {                                   //Verifica si el usuario seleccion� "S�"
				Cliente x = ac.buscar(leerCodigo());
				int posFila = tblCliente.getSelectedRow();
				if (posFila == ac.tamanio()-1)   //Verifica si la fila seleccionada es la �ltima en la tabla (ac.tamanio() - 1).
					posFila --;  //decrementa posFila en 1 para seleccionar la fila anterior
				ac.eliminar(x);
				listado(posFila);
				editarFila();
			}
		}
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		int codigo= leerCodigo();
		String nombre= leerNombre();
		String apellidos= leerApellido();
		String dni= leerDni();
		String telefono= leerTelefono();
		String direccion=leerDireccion();
		
	
		if(btnIngresar.isEnabled() == false) {  //Se verifica si el bot�n est� deshabilitado
			if (nombre.length()==0 || apellidos.length()==0 || dni.length()==0 || telefono.length()==0 || direccion.length()==0)  {		
				error("Todos los campos son obligatorios", txtNombres);
				return;
			}
			
			if (ac.buscar(dni) == null)	{ //Se verifica si no existe una persona con el mismo DNI en la lista ac
				Cliente nuevo = new Cliente(codigo, dni, telefono, nombre, apellidos, direccion); 
				ac.adicionar(nuevo);
				ac.actualizarArchivo();
                btnIngresar.setEnabled(true);
				btnOK.setEnabled(false);
                listado(tblCliente.getRowCount());
                habilitarEntradas(false);
			} else	{
				error("El DNI " + dni + " ya existe", txtDni);
				return;
			}
		}
		
		if (btnModificar.isEnabled() == false) {	//verifica si el bot�n btnModificacion est� deshabilitado.
			if (nombre.length()==0 || apellidos.length()==0 || dni.length()==0 || telefono.length()==0 || direccion.length()==0)  {		
				error("Todos los campos son obligatorios", txtNombres);
				return;
			}
			Cliente clienteExiste = ac.buscar(codigo);
			if (clienteExiste == null)	{ 
				error("El codigo no existe", txtCodigo);
			} else	{
				Cliente clienteRepetido = ac.buscar(dni);
				if (clienteRepetido != null) { //Se verifica si no existe una persona con el mismo DNI en la lista ac
					error("El DNI " + dni + " ya existe", txtDni);
				} else {
					clienteExiste.setNombre(nombre);
					clienteExiste.setApellido(apellidos);
					clienteExiste.setDni(dni);
					clienteExiste.setTelefono(telefono);
					clienteExiste.setDireccion(direccion);
					ac.actualizarArchivo();
		            btnModificar.setEnabled(true);
		            btnOK.setEnabled(false);
		            listado(tblCliente.getRowCount());
		            habilitarEntradas(false);
				}
			}
		}
		try {
			Cliente x = ac.buscar(codigo);
			if (x != null) {               //Verifica si se encontr� una persona con el c�digo proporcionado 
				txtNombres.setText(x.getNombre());			
				txtApellidos.setText(x.getApellido());
				txtDireccion.setText(x.getDireccion());
				txtTelefono.setText(x.getTelefono());
				txtDni.setText(x.getDni());
				btnConsultar.setEnabled(true);
			}
			else
				error("El codigo " + codigo + " no existe", txtCodigo);
		}
		catch (Exception x) 
		{error("Ingrese codigo correcto", txtCodigo);}
	}
	
	public void listado (int posFila) {
		modelo.setRowCount(0);
		Cliente x;
		for (int i=0; i<ac.tamanio(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getCodigo(),
					          x.getNombre(),
					          x.getApellido(),					         
					          x.getDireccion(),
					          x.getTelefono(), 
					          x.getDni(),
					          };
			modelo.addRow(fila);
		}
		tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	
	//----------------------------------------------------------------------------
	//----------------------------------------------------------------------------
	///metodos 
	void limpieza() {
		txtCodigo.setText("" + ac.codigoCorrelativoCliente());
		txtNombres.setText("");
		txtDni.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtNombres.requestFocus(); //para fijar cursor en el nombre
	}
	
	void editarFila() {
		if (ac.tamanio() == 0)
			limpieza();
		else {
			Cliente x = ac.obtener(tblCliente.getSelectedRow());//devuelve el �ndice de la fila seleccionada en tablaCliente
			txtCodigo.setText(String.valueOf(x.getCodigo()));
			txtNombres.setText(x.getNombre());
			txtApellidos.setText(x.getApellido());
			txtDni.setText(x.getDni());
			txtTelefono.setText(x.getTelefono());
			txtDireccion.setText(x.getDireccion());
		}
	}

	void habilitarEntradas(boolean b) {
			txtNombres.setEditable(b);
			txtDni.setEditable(b);
			txtApellidos.setEditable(b);
			txtTelefono.setEditable(b);
			txtDireccion.setEditable(b);
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
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombres.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}
	String leerApellido() {
		return txtApellidos.getText().trim();
	}
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	String leerDireccion() {
		return txtDireccion.getText().trim();
	}
}
