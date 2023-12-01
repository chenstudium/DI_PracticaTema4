package es.studium.tiendecitaKC;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AltaArticulo extends JDialog
{
	// Datos para la conexión a la BD
	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaKC";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2022;";

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcion;
	private JTextField txtId;
	private JTextField txtPrecio;
	private JTextField txtCantidad;

	// Método principal que inicia el programa
	public static void main(String[] args)
	{
		try
		{
			// Mostrar la ventana al iniciarse el programa
			AltaArticulo dialog = new AltaArticulo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Constructor
	public AltaArticulo()
	{
		setTitle("Programa de gestión - Artículos - Alta ");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		txtDescripcion = new JTextField();
		txtDescripcion.setForeground(new Color(128, 128, 128));
		txtDescripcion.setText("Descripción...");
		txtDescripcion.setBounds(129, 81, 276, 20);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		JButton btnTickets = new JButton("Tickets");
		btnTickets.setForeground(new Color(232, 116, 0));
		btnTickets.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		btnTickets.addActionListener(new ActionListener()
		{
			// Al clicar en Tickets, se abre la ventana ConsultaTickets y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				ConsultaTickets dig = new ConsultaTickets();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnTickets.setBounds(217, 0, 217, 30);
		contentPanel.add(btnTickets);

		JButton btnArticulos = new JButton("Artículos");
		btnArticulos.setForeground(new Color(232, 116, 0));
		btnArticulos.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnArticulos.setBounds(0, 0, 218, 30);
		contentPanel.add(btnArticulos);

		JSeparator separador = new JSeparator();
		separador.setBounds(0, 58, 434, 21);
		contentPanel.add(separador);

		JLabel lblTitulo = new JLabel("N  U  E  V  O      A  L  T  A      A  R  T   Í  C  U  L  O");
		lblTitulo.setForeground(new Color(176, 0, 176));
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setBounds(19, 34, 400, 20);
		contentPanel.add(lblTitulo);

		txtId = new JTextField();
		txtId.setText("ID...");
		txtId.setForeground(Color.GRAY);
		txtId.setColumns(10);
		txtId.setBounds(129, 116, 276, 20);
		contentPanel.add(txtId);

		txtPrecio = new JTextField();
		txtPrecio.setText("Precio...");
		txtPrecio.setForeground(Color.GRAY);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(129, 150, 276, 20);
		contentPanel.add(txtPrecio);

		txtCantidad = new JTextField();
		txtCantidad.setText("Cantidad...");
		txtCantidad.setForeground(Color.GRAY);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(129, 185, 276, 20);
		contentPanel.add(txtCantidad);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(19, 84, 100, 14);
		contentPanel.add(lblDescripcion);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(19, 119, 100, 14);
		contentPanel.add(lblId);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(19, 153, 100, 14);
		contentPanel.add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(19, 188, 100, 14);
		contentPanel.add(lblCantidad);

		JLabel lblNewLabel = new JLabel("* Todos los campos son obligatorios");
		lblNewLabel.setBounds(10, 231, 224, 14);
		getContentPane().add(lblNewLabel);

		JButton okButton = new JButton("Aceptar");
		okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener()
		{
			// Al clicar en Aceptar, agrega los datos de los campos a la BD, se abre la ventana AltaCompletadaArticulos y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				agregarDatos();
				AltaCompletadaArticulos dig = new AltaCompletadaArticulos();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		okButton.setBounds(255, 227, 85, 23);
		getContentPane().add(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			// Al clicar en Cancelar, se vuelve a abrir la ventana ConsultaArticulos y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				ConsultaArticulos dig = new ConsultaArticulos();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		cancelButton.setBounds(344, 227, 85, 23);
		getContentPane().add(cancelButton);
	}

	// Función para agregar datos a la BD
	private void agregarDatos()
	{
		Connection connection = null;

		// Obtener valores de los campos
		String descripcion = txtDescripcion.getText();
		String id = txtId.getText();
		String precio = txtPrecio.getText();
		String cantidad = txtCantidad.getText();

		try
		{
			// Conexión
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			// Sentencia SQL de inserción de datos
			String sql = "INSERT INTO articulos (descripcionArticulo, idArticulo, precioArticulo, cantidadArticulo) VALUES (?, ?, ?, ?)";

			try (PreparedStatement declaracion = connection.prepareStatement(sql))
			{
				declaracion.setString(1, descripcion);
				declaracion.setString(2, id);
				declaracion.setString(3, precio);
				declaracion.setString(4, cantidad);
				declaracion.executeUpdate();

				// Cerrar conexión
				connection.close();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}