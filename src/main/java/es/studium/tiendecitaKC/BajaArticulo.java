package es.studium.tiendecitaKC;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.Choice;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BajaArticulo extends JDialog
{
	// Datos para la conexión a la BD
	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaKC";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2022;";

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtFieldDescripcion;
	private JTextField txtFieldId;
	private JTextField txtFieldPrecio;
	private JTextField txtFieldCantidad;

	// Método principal que inicia el programa
	public static void main(String[] args)
	{
		try
		{
			// Mostrar la ventana al iniciarse el programa
			BajaArticulo dig = new BajaArticulo();
			dig.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dig.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Constructor
	public BajaArticulo()
	{
		Connection connection = null;

		setTitle("Programa de gestión - Artículos - Baja");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

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

		JLabel lblTitulo = new JLabel("B  A  J  A    A  R  T   Í  C  U  L  O");
		lblTitulo.setForeground(new Color(176, 0, 176));
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setBounds(88, 34, 305, 20);
		contentPanel.add(lblTitulo);

		JSeparator separador = new JSeparator();
		separador.setBounds(0, 58, 434, 8);
		contentPanel.add(separador);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(20, 105, 100, 14);
		contentPanel.add(lblDescripcion);

		txtFieldDescripcion = new JTextField();
		txtFieldDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFieldDescripcion.setText("");
		txtFieldDescripcion.setForeground(new Color(0, 0, 0));
		txtFieldDescripcion.setColumns(10);
		txtFieldDescripcion.setBounds(160, 102, 260, 20);
		txtFieldDescripcion.setEditable(false);
		contentPanel.add(txtFieldDescripcion);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 138, 100, 14);
		contentPanel.add(lblId);

		txtFieldId = new JTextField();
		txtFieldId.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFieldId.setText("");
		txtFieldId.setForeground(new Color(0, 0, 0));
		txtFieldId.setColumns(10);
		txtFieldId.setBounds(160, 135, 260, 20);
		txtFieldId.setEditable(false);
		contentPanel.add(txtFieldId);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(20, 170, 100, 14);
		contentPanel.add(lblPrecio);

		txtFieldPrecio = new JTextField();
		txtFieldPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFieldPrecio.setText("");
		txtFieldPrecio.setForeground(new Color(0, 0, 0));
		txtFieldPrecio.setColumns(10);
		txtFieldPrecio.setBounds(160, 167, 260, 20);
		txtFieldPrecio.setEditable(false);
		contentPanel.add(txtFieldPrecio);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(20, 203, 100, 14);
		contentPanel.add(lblCantidad);

		txtFieldCantidad = new JTextField();
		txtFieldCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFieldCantidad.setText("");
		txtFieldCantidad.setForeground(new Color(0, 0, 0));
		txtFieldCantidad.setColumns(10);
		txtFieldCantidad.setBounds(160, 200, 260, 20);
		txtFieldCantidad.setEditable(false);
		contentPanel.add(txtFieldCantidad);

		Choice choiceDesplegable = new Choice();
		choiceDesplegable.setBounds(160, 70, 260, 20);
		contentPanel.add(choiceDesplegable);

		JLabel lblDesplegable = new JLabel("Selecciona un artículo:");
		lblDesplegable.setBounds(20, 73, 131, 14);
		contentPanel.add(lblDesplegable);

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
		cancelButton.setBounds(260, 231, 85, 23);
		contentPanel.add(cancelButton);

		JButton okButton = new JButton("Dar de baja");
		okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener()
		{
			// Al clicar en Dar de baja, obtiene los valores de los campos para eliminarlos y se abre la ventana BajaCompletada y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
		        String selectedItem = choiceDesplegable.getSelectedItem().trim();
		        int id = Integer.parseInt(selectedItem.split(" -")[0]);

		        Connection connection = conectar();

		        try
		        {
		        	// Sentencia SQL de eliminar de un artículo
		            String query = "DELETE FROM articulos WHERE idArticulo = ?";
		            PreparedStatement preparedStatement = connection.prepareStatement(query);
		            preparedStatement.setInt(1, id);
		            preparedStatement.executeUpdate();
		            
		            preparedStatement.close();
		            connection.close();
		            
		            BajaCompletada dig = new BajaCompletada();
		            dig.setVisible(true);
		            setVisible(false);
		        }
		        catch (SQLException ex)
		        {
		            ex.printStackTrace();
		        }
			}
		});
		okButton.setBounds(90, 231, 100, 23);
		contentPanel.add(okButton);

		// Desplegable donde elegir el artículo a eliminar
		choiceDesplegable.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				Object fuente = ie.getItem();
				if (fuente.equals(choiceDesplegable.getSelectedItem()))
				{
					Connection connection = conectar();
					choiceDesplegable.getSelectedItem().trim();
					int id = Integer.parseInt(choiceDesplegable.getSelectedItem().split(" -")[0]);
					mostrarDatos(connection, id);
				}
				else
				{
					txtFieldDescripcion.setText("");
				}
			}
		});

		connection = conectar();
		
		// Sentencia SQL para obtener los artículos
		String sql = "SELECT * FROM articulos";

		try
		{
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(sql);

			while (resultset.next())
			{
				// Mostrar en el desplegable dos datos principales de los artículos existentes
				choiceDesplegable.add(resultset.getInt("idArticulo") + " - " + resultset.getString("descripcionArticulo"));
			}
			// Cerrar recursos
			resultset.close();
			statement.close();
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	// Función para conectar a la BD
	public Connection conectar()
	{
		Connection conexion = null;
		try
		{
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conexion;
	}

	// Función para mostrar los datos de un artículo en los campos de texto
	private void mostrarDatos(Connection connection, int id)
	{
		String sql = "SELECT * FROM articulos WHERE idArticulo = " + id;
		try
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next())
			{
				// Mostrar dichos datos en sus campos correspondientes
				String txtId = resultSet.getString("idArticulo");
				txtFieldId.setText((txtId));
				String txtDescr = resultSet.getString("descripcionArticulo");
				txtFieldDescripcion.setText((txtDescr));
				String txtPrecio = resultSet.getString("precioArticulo");
				txtFieldPrecio.setText((txtPrecio));
				String txtCant = resultSet.getString("cantidadArticulo");
				txtFieldCantidad.setText((txtCant));
			}
			statement.close();
			connection.close();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}

		try
		{
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		JLabel lblSeleccionar = new JLabel("Seleccionar artículo:");
		lblSeleccionar.setBounds(24, 74, 100, 14);
		contentPanel.add(lblSeleccionar);
	}
}