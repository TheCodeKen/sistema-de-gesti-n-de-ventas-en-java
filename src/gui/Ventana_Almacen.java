package gui;

import javax.swing.*;

import arreglo.Arreglo_Producto;
import clases.Producto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_Almacen extends JDialog {
	private static final long serialVersionUID = 1L;
    private JTextField txtCodigo;
    private JTextField txtCantidad;
    private JLabel lblResultado;
    
    Arreglo_Producto ap = new Arreglo_Producto();
    private JLabel lblNewLabel;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Almacen dialog = new Ventana_Almacen();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public Ventana_Almacen() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("Media/iconAlmacen.png"));
    	setTitle("Almacén - Ingresar Stock");
    	setResizable(false);
        // Configuración del diseño general y paneles
        JPanel panelCentral = new JPanel();
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Componentes de entrada de datos
        JLabel lblCodigo = new JLabel("Código del Producto:");
        lblCodigo.setForeground(new Color(255, 255, 255));
        lblCodigo.setBounds(20, 20, 168, 31);
        lblCodigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtCodigo = new JTextField();
        txtCodigo.setBounds(198, 20, 168, 31);
        txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel lblCantidad = new JLabel("Cantidad a Ingresar:");
        lblCantidad.setForeground(new Color(255, 255, 255));
        lblCantidad.setBounds(20, 61, 168, 31);
        lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
        txtCantidad = new JTextField();
        txtCantidad.setBounds(198, 61, 168, 31);
        txtCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panelCentral.setLayout(null);

        panelCentral.add(lblCodigo);
        panelCentral.add(txtCodigo);
        panelCentral.add(lblCantidad);
        panelCentral.add(txtCantidad);

        // Botón de ingreso y panel de resultado
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnIngresar.setForeground(new Color(0, 0, 0));
        btnIngresar.setBackground(new Color(255, 217, 217)); // Color azul claro
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarStock();
            }
        });

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(new Color(255, 87, 87));
        panelBotones.add(btnIngresar);

        // Etiqueta de resultado
        lblResultado = new JLabel("", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResultado.setForeground(Color.RED);

        // Configuración del layout principal y añadir componentes
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelCentral, BorderLayout.CENTER);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("Media/fondoAlm.jpeg"));
        lblNewLabel.setBounds(0, 0, 386, 162);
        panelCentral.add(lblNewLabel);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
        getContentPane().add(lblResultado, BorderLayout.NORTH);

        // Configuración de la ventana
        setSize(400, 230);
        setAlwaysOnTop(true);
    }

    private void ingresarStock() {
        String codigo = txtCodigo.getText();
        String cantidadStr = txtCantidad.getText();

        if (codigo.isEmpty() || cantidadStr.isEmpty()) {
        	lblResultado.setForeground(Color.RED);
            lblResultado.setText("Por favor, complete todos los campos.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            int codigoProducto = Integer.parseInt(codigo);

            Producto p = ap.buscar(codigoProducto);
            if (p != null) {
            	int cantidadIngresar = p.getStockActual()+cantidad;
            	if(p.getStockMaximo()>=cantidadIngresar) {
            		p.setStockActual(cantidadIngresar);
            		ap.actualizarArchivo();
                    lblResultado.setForeground(new Color(46, 204, 113)); // Color verde esmeralda
                    txtCodigo.setText("");
                    txtCantidad.setText("");
                    lblResultado.setText("Stock ingresado exitosamente.");
            	} else {
	               	lblResultado.setForeground(Color.RED);
	                lblResultado.setText("Verifique que el stock máximo no sea excedido.");
            	}
            	

            } else {
            	lblResultado.setForeground(Color.RED);
                lblResultado.setText("Codigo de Producto no existe");
            }
        } catch (NumberFormatException ex) {
            lblResultado.setText("La cantidad debe ser un número válido.");
        }
    }
}
