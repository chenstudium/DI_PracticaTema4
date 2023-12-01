package es.studium.tiendecitaKC;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AltaTicket extends JDialog
{
	// Datos para la conexión a la BD
	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaKC";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2022;";

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFecha;
	private JTextField textId;
	private JTextField txtArticulosId;
	private JTextField txtTotal;

	// Método principal que inicia el programa
	public static void main(String[] args)
	{
		try
		{
			// Mostrar la ventana al iniciarse el programa
			AltaTicket dig = new AltaTicket();
			dig.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dig.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Constructor
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
			// Al clicar en Artículos, se abre la ventana ConsultaArticulos y se cierra la actual
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
			// Al clicar en Aceptar, agrega los datos de los campos a la BD, se abre la ventana AltaCompletadaTickets y se cierra la actual
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
			// Al clicar en Cancelar, se vuelve a abrir la ventana ConsultaTickets y se cierra la actual
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

	// Función para agregar datos a la BD
	private void agregarDatos()
	{
		Connection connection = null;

		// Obtener valores de los campos
		String fecha = txtFecha.getText();
		String id = textId.getText();
		String articulosId = txtArticulosId.getText();
		String total = txtTotal.getText();

		try
		{
			// Conexión
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			// Sentencia SQL de inserción de datos
			String sql = "INSERT INTO tickets (fechaTicket, idTicket, idArticuloFK, totalTicket) VALUES (?, ?, ?, ?)";

			try (PreparedStatement declaracion = connection.prepareStatement(sql))
			{
				declaracion.setString(1, fecha);
				declaracion.setString(2, id);
				declaracion.setString(3, articulosId);
				declaracion.setString(4, total);
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