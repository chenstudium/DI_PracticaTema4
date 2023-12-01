package es.studium.tiendecitaKC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class AltaTicket extends JDialog
{
	// Datos para la conexión a la base de datos
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaKC";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2022;";

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFecha;
	private JTextField textId;
	private JTextField txtArticulosId;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			AltaTicket dialog = new AltaTicket();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaTicket()
	{
		setTitle("Programa de gestión - Tickets - Alta ticket");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnTickets = new JButton("Tickets");
		btnTickets.setForeground(new Color(232, 116, 0));
		btnTickets.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnTickets.setBounds(217, 0, 217, 30);
		contentPanel.add(btnTickets);

		JButton btnArticulos = new JButton("Artículos");
		btnArticulos.setForeground(new Color(232, 116, 0));
		btnArticulos.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		btnArticulos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ConsultaArticulos dig = new ConsultaArticulos();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnArticulos.setBounds(0, 0, 218, 30);
		contentPanel.add(btnArticulos);

		JLabel lblTitulo = new JLabel("N  U  E  V  O      A  L  T  A      T   I  C  K  E  T  S");
		lblTitulo.setForeground(new Color(176, 0, 176));
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setBounds(32, 34, 400, 20);
		contentPanel.add(lblTitulo);

		JSeparator separador = new JSeparator();
		separador.setBounds(0, 58, 434, 21);
		contentPanel.add(separador);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(19, 84, 100, 14);
		contentPanel.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setText("Fecha (yyyy-mm-dd)...");
		txtFecha.setForeground(Color.GRAY);
		txtFecha.setColumns(10);
		txtFecha.setBounds(129, 81, 276, 20);
		contentPanel.add(txtFecha);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(19, 119, 100, 14);
		contentPanel.add(lblId);

		textId = new JTextField();
		textId.setText("ID...");
		textId.setForeground(Color.GRAY);
		textId.setColumns(10);
		textId.setBounds(129, 116, 276, 20);
		contentPanel.add(textId);

		JLabel lblArticulos = new JLabel("Artículos (ID):");
		lblArticulos.setBounds(19, 153, 100, 14);
		contentPanel.add(lblArticulos);

		txtArticulosId = new JTextField();
		txtArticulosId.setText("Artículos (ID)...");
		txtArticulosId.setForeground(Color.GRAY);
		txtArticulosId.setColumns(10);
		txtArticulosId.setBounds(129, 150, 276, 20);
		contentPanel.add(txtArticulosId);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(19, 188, 100, 14);
		contentPanel.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setText("Total...");
		txtTotal.setForeground(Color.GRAY);
		txtTotal.setColumns(10);
		txtTotal.setBounds(129, 185, 276, 20);
		contentPanel.add(txtTotal);
		
		JLabel lblNewLabel = new JLabel("* Todos los campos son obligatorios");
		lblNewLabel.setBounds(10, 231, 224, 14);
		contentPanel.add(lblNewLabel);
		
		JButton okButton = new JButton("Aceptar");
		okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				agregarDatos();
				AltaCompletadaTickets dig = new AltaCompletadaTickets();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		okButton.setBounds(255, 227, 85, 23);
		contentPanel.add(okButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ConsultaTickets dig = new ConsultaTickets();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		cancelButton.setBounds(344, 227, 85, 23);
		contentPanel.add(cancelButton);
	}

	// Método para agregar datos a la base de datos
	private void agregarDatos()
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		// Obtener valores de los campos
		String fecha = txtFecha.getText();
		String id = textId.getText();
		String articulosId = txtArticulosId.getText();
		String total = txtTotal.getText();

		// Validar que todos los campos estén completos
		/*if (fecha.isEmpty() || id.isEmpty() || articulosId.isEmpty() || total.isEmpty())
		{
			// Mostrar un mensaje de error o realizar alguna acción de manejo de errores
			System.out.println("Todos los campos son obligatorios");
			return;
		}*/

		// Realizar la inserción en la base de datos
		try
		{
			// Establecer la conexión
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			// Crear la consulta SQL para la inserción
			String sql = "INSERT INTO tickets (fechaTicket, idTicket, idArticuloFK, totalTicket) VALUES (?, ?, ?, ?)";

			// Preparar la declaración SQL con los parámetros
			try (PreparedStatement declaracion = connection.prepareStatement(sql))
			{
				declaracion.setString(1, fecha);
				declaracion.setString(2, id);
				declaracion.setString(3, articulosId);
				declaracion.setString(4, total);

				// Ejecutar la consulta
				declaracion.executeUpdate();

				// Cerrar la conexión
				connection.close();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}