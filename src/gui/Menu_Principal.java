package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Menu_Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnAlmacen;
	private JMenu mnReportes;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCliente;
	private JMenuItem mntmProductos;
	private JMenuItem mntmVentas;
	private JMenuItem mntmIngresarStock;
	private JMenuItem mntmReportes;
	private JLabel imgBanner;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu_Principal() {
		setAlwaysOnTop(true);
		setTitle("Venta de Aparatos Electrónicos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Media/icono-tec.png"));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 499);
		setResizable(false);                          //sirve para bloquear el ancho y largo de tu jframe
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(215, 255, 255));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		mnArchivo.setBackground(new Color(255, 255, 255));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setBackground(new Color(255, 255, 255));
		mnMantenimiento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		menuBar.add(mnMantenimiento);
		
		mntmCliente = new JMenuItem("Clientes");
		mntmCliente.addActionListener(this);
		mntmCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		mnMantenimiento.add(mntmCliente);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		mnMantenimiento.add(mntmProductos);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setBackground(new Color(255, 255, 255));
		mnVentas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		menuBar.add(mnVentas);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		mntmVentas.addActionListener(this);
		mnVentas.add(mntmVentas);
		
		mnAlmacen = new JMenu("Almac\u00E9n");
		mnAlmacen.setBackground(new Color(255, 255, 255));
		mnAlmacen.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		menuBar.add(mnAlmacen);
		
		mntmIngresarStock = new JMenuItem("Ingresar Stock");
		mntmIngresarStock.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		mntmIngresarStock.addActionListener(this);
		mnAlmacen.add(mntmIngresarStock);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setBackground(new Color(255, 255, 255));
		mnReportes.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		menuBar.add(mnReportes);
		
		mntmReportes = new JMenuItem("Reportes");
		mntmReportes.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		mntmReportes.addActionListener(this);
		mnReportes.add(mntmReportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		imgBanner = new JLabel("");
		imgBanner.setIcon(new ImageIcon("Media/bannerPY.jpg"));
		imgBanner.setBackground(new Color(255, 255, 255));
		imgBanner.setBounds(0, 0, 926, 438);
		contentPane.add(imgBanner);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVentas) {
			actionPerformedMntmVentas(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmCliente) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmIngresarStock) {
			actionPerformedMntmIngresarStock(e);
		}
		if (e.getSource() == mntmReportes) {
			actionPerformedMntmReportes(e);
		}
	}
	//Evento de Mantenimiento-Cliente
	protected void actionPerformedMntmClientes(ActionEvent e) {
		Ventana_Clientes cliente= new Ventana_Clientes();
		cliente.setLocationRelativeTo(this);
		cliente.setVisible(true);
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {
		Ventana_Productos productos= new Ventana_Productos();
		productos.setLocationRelativeTo(this);
		productos.setVisible(true);
	}
	//Accion salir
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	//Accion ventana ventas
	protected void actionPerformedMntmVentas(ActionEvent e) {
		Ventana_Ventas ventas= new Ventana_Ventas();
		ventas.setLocationRelativeTo(this);
		ventas.setVisible(true);
	}
	
	protected void actionPerformedMntmIngresarStock(ActionEvent e) {
		Ventana_Almacen almacen= new Ventana_Almacen();
		almacen.setLocationRelativeTo(this);
		almacen.setVisible(true);
	}
	
	protected void actionPerformedMntmReportes(ActionEvent e) {
		Ventana_Reportes reportes= new Ventana_Reportes();
		reportes.setLocationRelativeTo(this);
		reportes.setVisible(true);
	}
}
