package es.studium.tiendecitaKC;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaArticulos extends JDialog
{
	// Datos para la conexión a la BD
	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaKC";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2022;";

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField textFieldDescripcion1;
	private JTextField textFieldDescripcion2;
	private JTextField textFieldDescripcion3;
	private JTextField textFieldDescripcion4;
	private JTextField textFieldDescripcion5;
	private JTextField textFieldDescripcion6;
	private JTextField textFieldDescripcion7;
	private JTextField textFieldId1;
	private JTextField textFieldId2;
	private JTextField textFieldId3;
	private JTextField textFieldId4;
	private JTextField textFieldId5;
	private JTextField textFieldId6;
	private JTextField textFieldId7;
	private JTextField textFieldPrecio1;
	private JTextField textFieldPrecio2;
	private JTextField textFieldPrecio3;
	private JTextField textFieldPrecio4;
	private JTextField textFieldPrecio5;
	private JTextField textFieldPrecio6;
	private JTextField textFieldPrecio7;
	private JTextField textFieldCantidad1;
	private JTextField textFieldCantidad2;
	private JTextField textFieldCantidad3;
	private JTextField textFieldCantidad4;
	private JTextField textFieldCantidad5;
	private JTextField textFieldCantidad6;
	private JTextField textFieldCantidad7;
	private JLabel lblProgramaDeGestion;

	// Método principal que inicia el programa
	public static void main(String[] args)
	{
		try
		{
			// Mostrar la ventana al iniciarse el programa
			ConsultaArticulos dig = new ConsultaArticulos();
			dig.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dig.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Constructor
	public ConsultaArticulos()
	{
		setTitle("Programa de gestión - Artículos - Consulta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnArticulos = new JButton("Artículos");
		btnArticulos.setBounds(0, 36, 218, 30);
		btnArticulos.setForeground(new Color(232, 116, 0));
		btnArticulos.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		contentPanel.add(btnArticulos);

		JButton btnTickets = new JButton("Tickets");
		btnTickets.setBounds(217, 36, 217, 30);
		btnTickets.setForeground(new Color(232, 116, 0));
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
		btnTickets.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		contentPanel.add(btnTickets);

		JSeparator separadorHorizontal1 = new JSeparator();
		separadorHorizontal1.setBounds(0, 65, 434, 9);
		contentPanel.add(separadorHorizontal1);

		JSeparator separadorHorizontal2 = new JSeparator();
		separadorHorizontal2.setBounds(0, 86, 434, 9);
		contentPanel.add(separadorHorizontal2);

		JLabel lblOpciones = new JLabel("Selecciona una opción:");
		lblOpciones.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOpciones.setBounds(50, 65, 123, 22);
		contentPanel.add(lblOpciones);

		JButton btnNuevoAlta = new JButton("Nuevo alta");
		btnNuevoAlta.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		btnNuevoAlta.setForeground(new Color(176, 0, 176));
		btnNuevoAlta.addActionListener(new ActionListener()
		{
			// Al clicar en Nuevo alta, se abre la ventana AltaArticulo y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				AltaArticulo dig = new AltaArticulo();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnNuevoAlta.setBounds(186, 65, 87, 22);
		contentPanel.add(btnNuevoAlta);

		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		btnBaja.setForeground(new Color(176, 0, 176));
		btnBaja.addActionListener(new ActionListener()
		{
			// Al clicar en Baja, se abre la ventana BajaArticulo y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				BajaArticulo dig = new BajaArticulo();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnBaja.setBounds(370, 65, 64, 22);
		contentPanel.add(btnBaja);

		JButton btnModificacion = new JButton("Modificación");
		btnModificacion.setForeground(new Color(176, 0, 176));
		btnModificacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		btnModificacion.addActionListener(new ActionListener()
		{
			// Al clicar en Modificación, se abre la ventana ModificacionArticulo y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				ModificacionArticulo dig = new ModificacionArticulo();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnModificacion.setBounds(272, 65, 99, 22);
		contentPanel.add(btnModificacion);

		JSeparator separadorHorizontal3 = new JSeparator();
		separadorHorizontal3.setBounds(0, 106, 417, 11);
		contentPanel.add(separadorHorizontal3);

		JSeparator separadorHorizontal4 = new JSeparator();
		separadorHorizontal4.setBounds(0, 128, 417, 11);
		contentPanel.add(separadorHorizontal4);

		JSeparator separadorHorizontal5 = new JSeparator();
		separadorHorizontal5.setBounds(0, 150, 417, 11);
		contentPanel.add(separadorHorizontal5);

		JSeparator separadorHorizontal6 = new JSeparator();
		separadorHorizontal6.setBounds(0, 172, 417, 11);
		contentPanel.add(separadorHorizontal6);

		JSeparator separadorHorizontal7 = new JSeparator();
		separadorHorizontal7.setBounds(0, 194, 417, 11);
		contentPanel.add(separadorHorizontal7);

		JSeparator separadorHorizontal8 = new JSeparator();
		separadorHorizontal8.setBounds(0, 216, 417, 11);
		contentPanel.add(separadorHorizontal8);

		JSeparator separadorHorizontal9 = new JSeparator();
		separadorHorizontal9.setBounds(0, 238, 417, 11);
		contentPanel.add(separadorHorizontal9);

		JSeparator separadorVertical3 = new JSeparator();
		separadorVertical3.setOrientation(SwingConstants.VERTICAL);
		separadorVertical3.setBounds(344, 86, 14, 175);
		contentPanel.add(separadorVertical3);

		JSeparator separadorVertical2 = new JSeparator();
		separadorVertical2.setOrientation(SwingConstants.VERTICAL);
		separadorVertical2.setBounds(279, 86, 14, 175);
		contentPanel.add(separadorVertical2);

		JSeparator separadorVertical1 = new JSeparator();
		separadorVertical1.setOrientation(SwingConstants.VERTICAL);
		separadorVertical1.setBounds(196, 86, 14, 175);
		contentPanel.add(separadorVertical1);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblDescripcion.setBounds(65, 90, 96, 14);
		contentPanel.add(lblDescripcion);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblId.setBounds(230, 90, 21, 14);
		contentPanel.add(lblId);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblPrecio.setBounds(293, 90, 46, 14);
		contentPanel.add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCantidad.setBounds(353, 90, 56, 14);
		contentPanel.add(lblCantidad);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(417, 86, 17, 175);
		contentPanel.add(scrollBar);

		textFieldDescripcion1 = new JTextField();
		textFieldDescripcion1.setBounds(3, 108, 191, 19);
		contentPanel.add(textFieldDescripcion1);
		textFieldDescripcion1.setColumns(10);

		textFieldDescripcion2 = new JTextField();
		textFieldDescripcion2.setColumns(10);
		textFieldDescripcion2.setBounds(3, 130, 191, 19);
		contentPanel.add(textFieldDescripcion2);

		textFieldDescripcion3 = new JTextField();
		textFieldDescripcion3.setColumns(10);
		textFieldDescripcion3.setBounds(3, 152, 191, 19);
		contentPanel.add(textFieldDescripcion3);

		textFieldDescripcion4 = new JTextField();
		textFieldDescripcion4.setColumns(10);
		textFieldDescripcion4.setBounds(3, 174, 191, 19);
		contentPanel.add(textFieldDescripcion4);

		textFieldDescripcion5 = new JTextField();
		textFieldDescripcion5.setColumns(10);
		textFieldDescripcion5.setBounds(3, 196, 191, 19);
		contentPanel.add(textFieldDescripcion5);

		textFieldDescripcion6 = new JTextField();
		textFieldDescripcion6.setColumns(10);
		textFieldDescripcion6.setBounds(3, 218, 191, 19);
		contentPanel.add(textFieldDescripcion6);

		textFieldDescripcion7 = new JTextField();
		textFieldDescripcion7.setColumns(10);
		textFieldDescripcion7.setBounds(3, 240, 191, 19);
		contentPanel.add(textFieldDescripcion7);

		textFieldId1 = new JTextField();
		textFieldId1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId1.setColumns(10);
		textFieldId1.setBounds(199, 108, 78, 19);
		contentPanel.add(textFieldId1);

		textFieldId2 = new JTextField();
		textFieldId2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId2.setColumns(10);
		textFieldId2.setBounds(199, 130, 78, 19);
		contentPanel.add(textFieldId2);

		textFieldId3 = new JTextField();
		textFieldId3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId3.setColumns(10);
		textFieldId3.setBounds(199, 152, 78, 19);
		contentPanel.add(textFieldId3);

		textFieldId4 = new JTextField();
		textFieldId4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId4.setColumns(10);
		textFieldId4.setBounds(199, 174, 78, 19);
		contentPanel.add(textFieldId4);

		textFieldId5 = new JTextField();
		textFieldId5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId5.setColumns(10);
		textFieldId5.setBounds(199, 196, 78, 19);
		contentPanel.add(textFieldId5);

		textFieldId6 = new JTextField();
		textFieldId6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId6.setColumns(10);
		textFieldId6.setBounds(199, 218, 78, 19);
		contentPanel.add(textFieldId6);

		textFieldId7 = new JTextField();
		textFieldId7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId7.setColumns(10);
		textFieldId7.setBounds(199, 240, 78, 19);
		contentPanel.add(textFieldId7);

		textFieldPrecio1 = new JTextField();
		textFieldPrecio1.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldPrecio1.setColumns(10);
		textFieldPrecio1.setBounds(282, 108, 60, 19);
		contentPanel.add(textFieldPrecio1);

		textFieldPrecio2 = new JTextField();
		textFieldPrecio2.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldPrecio2.setColumns(10);
		textFieldPrecio2.setBounds(282, 130, 60, 19);
		contentPanel.add(textFieldPrecio2);

		textFieldPrecio3 = new JTextField();
		textFieldPrecio3.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldPrecio3.setColumns(10);
		textFieldPrecio3.setBounds(282, 152, 60, 19);
		contentPanel.add(textFieldPrecio3);

		textFieldPrecio4 = new JTextField();
		textFieldPrecio4.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldPrecio4.setColumns(10);
		textFieldPrecio4.setBounds(282, 174, 60, 19);
		contentPanel.add(textFieldPrecio4);

		textFieldPrecio5 = new JTextField();
		textFieldPrecio5.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldPrecio5.setColumns(10);
		textFieldPrecio5.setBounds(282, 196, 60, 19);
		contentPanel.add(textFieldPrecio5);

		textFieldPrecio6 = new JTextField();
		textFieldPrecio6.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldPrecio6.setColumns(10);
		textFieldPrecio6.setBounds(282, 218, 60, 19);
		contentPanel.add(textFieldPrecio6);

		textFieldPrecio7 = new JTextField();
		textFieldPrecio7.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldPrecio7.setColumns(10);
		textFieldPrecio7.setBounds(282, 240, 60, 19);
		contentPanel.add(textFieldPrecio7);

		textFieldCantidad1 = new JTextField();
		textFieldCantidad1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad1.setColumns(10);
		textFieldCantidad1.setBounds(360, 108, 40, 19);
		contentPanel.add(textFieldCantidad1);

		textFieldCantidad2 = new JTextField();
		textFieldCantidad2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad2.setColumns(10);
		textFieldCantidad2.setBounds(360, 130, 40, 19);
		contentPanel.add(textFieldCantidad2);

		textFieldCantidad3 = new JTextField();
		textFieldCantidad3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad3.setColumns(10);
		textFieldCantidad3.setBounds(360, 152, 40, 19);
		contentPanel.add(textFieldCantidad3);

		textFieldCantidad4 = new JTextField();
		textFieldCantidad4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad4.setColumns(10);
		textFieldCantidad4.setBounds(360, 174, 40, 19);
		contentPanel.add(textFieldCantidad4);

		textFieldCantidad5 = new JTextField();
		textFieldCantidad5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad5.setColumns(10);
		textFieldCantidad5.setBounds(360, 196, 40, 19);
		contentPanel.add(textFieldCantidad5);

		textFieldCantidad6 = new JTextField();
		textFieldCantidad6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad6.setColumns(10);
		textFieldCantidad6.setBounds(360, 218, 40, 19);
		contentPanel.add(textFieldCantidad6);

		textFieldCantidad7 = new JTextField();
		textFieldCantidad7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCantidad7.setColumns(10);
		textFieldCantidad7.setBounds(360, 240, 40, 19);
		contentPanel.add(textFieldCantidad7);
		
		lblProgramaDeGestion = new JLabel("Programa de gestión");
		lblProgramaDeGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramaDeGestion.setForeground(new Color(176, 0, 176));
		lblProgramaDeGestion.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblProgramaDeGestion.setBounds(10, 0, 414, 36);
		contentPanel.add(lblProgramaDeGestion);

		consultarArticulos();
	}

	private void consultarArticulos()
	{
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			// Conexión
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);

			// Sentencia SQL para obtener todos los datos de los artículos
			String sql = "SELECT idArticulo, descripcionArticulo, precioArticulo, cantidadArticulo FROM articulos WHERE descripcionArticulo LIKE ?";
			preparedStatement = conexion.prepareStatement(sql);

			// Parámetro
			preparedStatement.setString(1, "%" + textFieldId1.getText() + "%");
			resultSet = preparedStatement.executeQuery();

			// Procesar resultados
			int index = 1; // Índice para rastrear el conjunto de campos de texto actual
			
			// Procesar resultados y mostrarlos
			while (resultSet.next() && index <= 7)
			{
				// Obtener los datos de la BD y guardarlos en variables
				int id = resultSet.getInt("idArticulo");
				String descripcion = resultSet.getString("descripcionArticulo");
				double precio = resultSet.getDouble("precioArticulo");
				int cantidad = resultSet.getInt("cantidadArticulo");

				// Establecer los datos en los campos de la primera fila
				asignarValoresCamposTexto(index, descripcion, id, precio, cantidad);

				// Incrementar el índice para los campos de la siguiente fila
				index++;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// Cerrar recursos
			try
			{
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (conexion != null)
					conexion.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	// Método para asignar valores a los campos de texto según el índice
	private void asignarValoresCamposTexto(int index, String descripcion, int id, double precio, int cantidad)
	{
		switch (index)
		{
		case 1:
			textFieldDescripcion1.setText(descripcion);
			textFieldId1.setText(String.valueOf(id));
			textFieldPrecio1.setText(String.valueOf(precio) + " €");
			textFieldCantidad1.setText(String.valueOf(cantidad));
			break;
		case 2:
			textFieldDescripcion2.setText(descripcion);
			textFieldId2.setText(String.valueOf(id));
			textFieldPrecio2.setText(String.valueOf(precio) + " €");
			textFieldCantidad2.setText(String.valueOf(cantidad));
			break;
		case 3:
			textFieldDescripcion3.setText(descripcion);
			textFieldId3.setText(String.valueOf(id));
			textFieldPrecio3.setText(String.valueOf(precio) + " €");
			textFieldCantidad3.setText(String.valueOf(cantidad));
			break;
		case 4:
			textFieldDescripcion4.setText(descripcion);
			textFieldId4.setText(String.valueOf(id));
			textFieldPrecio4.setText(String.valueOf(precio) + " €");
			textFieldCantidad4.setText(String.valueOf(cantidad));
			break;
		case 5:
			textFieldDescripcion5.setText(descripcion);
			textFieldId5.setText(String.valueOf(id));
			textFieldPrecio5.setText(String.valueOf(precio) + " €");
			textFieldCantidad5.setText(String.valueOf(cantidad));
			break;
		case 6:
			textFieldDescripcion6.setText(descripcion);
			textFieldId6.setText(String.valueOf(id));
			textFieldPrecio6.setText(String.valueOf(precio) + " €");
			textFieldCantidad6.setText(String.valueOf(cantidad));
			break;
		case 7:
			textFieldDescripcion7.setText(descripcion);
			textFieldId7.setText(String.valueOf(id));
			textFieldPrecio7.setText(String.valueOf(precio) + " €");
			textFieldCantidad7.setText(String.valueOf(cantidad));
			break;
		}
	}
}