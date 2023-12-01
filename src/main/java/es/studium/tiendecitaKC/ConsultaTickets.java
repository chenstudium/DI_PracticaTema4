package es.studium.tiendecitaKC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollBar;

public class ConsultaTickets extends JDialog
{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	// Datos para la conexión a la base de datos
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaKC";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2022;";
	
	private JTextField textFieldArticulo1;
	private JTextField textFieldArticulo2;
	private JTextField textFieldArticulo3;
	private JTextField textFieldArticulo4;
	private JTextField textFieldArticulo5;
	private JTextField textFieldArticulo6;
	private JTextField textFieldArticulo7;
	private JTextField textFieldId3;
	private JTextField textFieldId1;
	private JTextField textFieldId2;
	private JTextField textFieldId4;
	private JTextField textFieldId5;
	private JTextField textFieldId6;
	private JTextField textFieldId7;
	private JTextField textFieldTotal1;
	private JTextField textFieldTotal2;
	private JTextField textFieldTotal3;
	private JTextField textFieldTotal4;
	private JTextField textFieldTotal5;
	private JTextField textFieldTotal6;
	private JTextField textFieldTotal7;
	private JTextField textFieldFecha1;
	private JTextField textFieldFecha2;
	private JTextField textFieldFecha3;
	private JTextField textFieldFecha4;
	private JTextField textFieldFecha5;
	private JTextField textFieldFecha6;
	private JTextField textFieldFecha7;
	private JLabel lblProgramaDeGestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			ConsultaTickets dialog = new ConsultaTickets();
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
	public ConsultaTickets()
	{
		setTitle("Programa de gestión - Tickets - Consulta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

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
		btnArticulos.setBounds(0, 36, 218, 30);
		contentPanel.add(btnArticulos);

		JButton btnTickets = new JButton("Tickets");
		btnTickets.setForeground(new Color(232, 116, 0));
		btnTickets.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnTickets.setBounds(217, 36, 217, 30);
		contentPanel.add(btnTickets);

		JSeparator separadorHorizontal1 = new JSeparator();
		separadorHorizontal1.setBounds(0, 65, 434, 11);
		contentPanel.add(separadorHorizontal1);

		JSeparator separadorHorizontal2 = new JSeparator();
		separadorHorizontal2.setBounds(0, 86, 434, 11);
		contentPanel.add(separadorHorizontal2);

		JLabel lblNuevoAlta = new JLabel("Para un alta de ticket nuevo, selecciona:");
		lblNuevoAlta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNuevoAlta.setBounds(90, 65, 188, 22);
		contentPanel.add(lblNuevoAlta);

		JButton btnNuevoAlta = new JButton("Nuevo alta");
		btnNuevoAlta.setForeground(new Color(176, 0, 176));
		btnNuevoAlta.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		btnNuevoAlta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AltaTicket dig = new AltaTicket();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnNuevoAlta.setBounds(282, 65, 87, 22);
		contentPanel.add(btnNuevoAlta);

		JSeparator separadorVertical1 = new JSeparator();
		separadorVertical1.setOrientation(SwingConstants.VERTICAL);
		separadorVertical1.setBounds(75, 86, 14, 175);
		contentPanel.add(separadorVertical1);

		JSeparator separadorVertical2 = new JSeparator();
		separadorVertical2.setOrientation(SwingConstants.VERTICAL);
		separadorVertical2.setBounds(158, 86, 14, 175);
		contentPanel.add(separadorVertical2);

		JSeparator separadorVertical3 = new JSeparator();
		separadorVertical3.setOrientation(SwingConstants.VERTICAL);
		separadorVertical3.setBounds(362, 86, 14, 175);
		contentPanel.add(separadorVertical3);

		JSeparator separadorHorizontal3 = new JSeparator();
		separadorHorizontal3.setBounds(0, 107, 417, 11);
		contentPanel.add(separadorHorizontal3);

		JSeparator separadorHorizontal4 = new JSeparator();
		separadorHorizontal4.setBounds(0, 129, 417, 11);
		contentPanel.add(separadorHorizontal4);

		JSeparator separadorHorizontal5 = new JSeparator();
		separadorHorizontal5.setBounds(0, 151, 417, 11);
		contentPanel.add(separadorHorizontal5);

		JSeparator separadorHorizontal6 = new JSeparator();
		separadorHorizontal6.setBounds(0, 173, 417, 11);
		contentPanel.add(separadorHorizontal6);

		JSeparator separadorHorizontal7 = new JSeparator();
		separadorHorizontal7.setBounds(0, 195, 417, 11);
		contentPanel.add(separadorHorizontal7);

		JSeparator separadorHorizontal8 = new JSeparator();
		separadorHorizontal8.setBounds(0, 217, 417, 11);
		contentPanel.add(separadorHorizontal8);

		JSeparator separadorHorizontal9 = new JSeparator();
		separadorHorizontal9.setBounds(0, 239, 417, 11);
		contentPanel.add(separadorHorizontal9);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblFecha.setBounds(20, 90, 46, 14);
		contentPanel.add(lblFecha);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblId.setBounds(110, 90, 46, 14);
		contentPanel.add(lblId);

		JLabel lblArticulos = new JLabel("Artículos (ID)");
		lblArticulos.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblArticulos.setBounds(215, 90, 94, 14);
		contentPanel.add(lblArticulos);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTotal.setBounds(374, 90, 46, 14);
		contentPanel.add(lblTotal);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(417, 86, 17, 175);
		contentPanel.add(scrollBar);

		textFieldArticulo1 = new JTextField();
		textFieldArticulo1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticulo1.setColumns(10);
		textFieldArticulo1.setBounds(161, 109, 199, 19);
		contentPanel.add(textFieldArticulo1);

		textFieldArticulo2 = new JTextField();
		textFieldArticulo2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticulo2.setColumns(10);
		textFieldArticulo2.setBounds(161, 131, 199, 19);
		contentPanel.add(textFieldArticulo2);

		textFieldArticulo3 = new JTextField();
		textFieldArticulo3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticulo3.setColumns(10);
		textFieldArticulo3.setBounds(161, 153, 199, 19);
		contentPanel.add(textFieldArticulo3);

		textFieldArticulo4 = new JTextField();
		textFieldArticulo4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticulo4.setColumns(10);
		textFieldArticulo4.setBounds(161, 175, 199, 19);
		contentPanel.add(textFieldArticulo4);

		textFieldArticulo5 = new JTextField();
		textFieldArticulo5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticulo5.setColumns(10);
		textFieldArticulo5.setBounds(161, 197, 199, 19);
		contentPanel.add(textFieldArticulo5);

		textFieldArticulo6 = new JTextField();
		textFieldArticulo6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticulo6.setColumns(10);
		textFieldArticulo6.setBounds(161, 219, 199, 19);
		contentPanel.add(textFieldArticulo6);

		textFieldArticulo7 = new JTextField();
		textFieldArticulo7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticulo7.setColumns(10);
		textFieldArticulo7.setBounds(161, 241, 199, 19);
		contentPanel.add(textFieldArticulo7);

		textFieldId3 = new JTextField();
		textFieldId3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId3.setColumns(10);
		textFieldId3.setBounds(78, 153, 78, 19);
		contentPanel.add(textFieldId3);

		textFieldId1 = new JTextField();
		textFieldId1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId1.setColumns(10);
		textFieldId1.setBounds(78, 109, 78, 19);
		contentPanel.add(textFieldId1);

		textFieldId2 = new JTextField();
		textFieldId2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId2.setColumns(10);
		textFieldId2.setBounds(78, 131, 78, 19);
		contentPanel.add(textFieldId2);

		textFieldId4 = new JTextField();
		textFieldId4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId4.setColumns(10);
		textFieldId4.setBounds(78, 175, 78, 19);
		contentPanel.add(textFieldId4);

		textFieldId5 = new JTextField();
		textFieldId5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId5.setColumns(10);
		textFieldId5.setBounds(78, 197, 78, 19);
		contentPanel.add(textFieldId5);

		textFieldId6 = new JTextField();
		textFieldId6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId6.setColumns(10);
		textFieldId6.setBounds(78, 219, 78, 19);
		contentPanel.add(textFieldId6);

		textFieldId7 = new JTextField();
		textFieldId7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId7.setColumns(10);
		textFieldId7.setBounds(78, 241, 78, 19);
		contentPanel.add(textFieldId7);

		textFieldTotal1 = new JTextField();
		textFieldTotal1.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTotal1.setColumns(10);
		textFieldTotal1.setBounds(365, 109, 50, 19);
		contentPanel.add(textFieldTotal1);

		textFieldTotal2 = new JTextField();
		textFieldTotal2.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTotal2.setColumns(10);
		textFieldTotal2.setBounds(365, 131, 50, 19);
		contentPanel.add(textFieldTotal2);

		textFieldTotal3 = new JTextField();
		textFieldTotal3.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTotal3.setColumns(10);
		textFieldTotal3.setBounds(365, 153, 50, 19);
		contentPanel.add(textFieldTotal3);

		textFieldTotal4 = new JTextField();
		textFieldTotal4.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTotal4.setColumns(10);
		textFieldTotal4.setBounds(365, 175, 50, 19);
		contentPanel.add(textFieldTotal4);

		textFieldTotal5 = new JTextField();
		textFieldTotal5.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTotal5.setColumns(10);
		textFieldTotal5.setBounds(365, 197, 50, 19);
		contentPanel.add(textFieldTotal5);

		textFieldTotal6 = new JTextField();
		textFieldTotal6.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTotal6.setColumns(10);
		textFieldTotal6.setBounds(365, 219, 50, 19);
		contentPanel.add(textFieldTotal6);

		textFieldTotal7 = new JTextField();
		textFieldTotal7.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTotal7.setColumns(10);
		textFieldTotal7.setBounds(365, 241, 50, 19);
		contentPanel.add(textFieldTotal7);

		textFieldFecha1 = new JTextField();
		textFieldFecha1.setColumns(10);
		textFieldFecha1.setBounds(3, 109, 70, 19);
		contentPanel.add(textFieldFecha1);

		textFieldFecha2 = new JTextField();
		textFieldFecha2.setColumns(10);
		textFieldFecha2.setBounds(3, 131, 70, 19);
		contentPanel.add(textFieldFecha2);

		textFieldFecha3 = new JTextField();
		textFieldFecha3.setColumns(10);
		textFieldFecha3.setBounds(3, 153, 70, 19);
		contentPanel.add(textFieldFecha3);

		textFieldFecha4 = new JTextField();
		textFieldFecha4.setColumns(10);
		textFieldFecha4.setBounds(3, 175, 70, 19);
		contentPanel.add(textFieldFecha4);

		textFieldFecha5 = new JTextField();
		textFieldFecha5.setColumns(10);
		textFieldFecha5.setBounds(3, 197, 70, 19);
		contentPanel.add(textFieldFecha5);

		textFieldFecha6 = new JTextField();
		textFieldFecha6.setColumns(10);
		textFieldFecha6.setBounds(3, 219, 70, 19);
		contentPanel.add(textFieldFecha6);

		textFieldFecha7 = new JTextField();
		textFieldFecha7.setColumns(10);
		textFieldFecha7.setBounds(3, 241, 70, 19);
		contentPanel.add(textFieldFecha7);
		
		lblProgramaDeGestion = new JLabel("Programa de gestión");
		lblProgramaDeGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramaDeGestion.setForeground(new Color(176, 0, 176));
		lblProgramaDeGestion.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblProgramaDeGestion.setBounds(3, 0, 414, 36);
		contentPanel.add(lblProgramaDeGestion);

		consultarTickets();
	}

	private void consultarTickets()
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			// Establecer la conexión
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			// Consulta SQL (ajusta según tu esquema y necesidades)
			String sql = "SELECT fechaTicket, idTicket, idArticuloFK, totalTicket FROM tickets WHERE fechaTicket LIKE ?";
			preparedStatement = connection.prepareStatement(sql);

			// Establecer parámetro
			preparedStatement.setString(1, "%" + textFieldId1.getText() + "%");
			
			// Ejecutar la consulta
			resultSet = preparedStatement.executeQuery();

			// Procesar resultados
			int index = 1; // Índice para rastrear el conjunto de campos de texto actual
			// Procesar resultados y mostrar en la interfaz gráfica
			while (resultSet.next() && index <= 7)
			{
				// Obtener datos de la base de datos y guardarlos en variables
				String fecha = resultSet.getString("fechaTicket");
				int id = resultSet.getInt("idTicket");
				int idArticulo = resultSet.getInt("idArticuloFK");
				double total = resultSet.getDouble("totalTicket");

				// Establecer los valores en los campos de texto
				asignarValoresCamposTexto(index, fecha, id, idArticulo, total);

				// Incrementar el índice para el siguiente conjunto de campos de texto
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
				if (connection != null)
					connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void asignarValoresCamposTexto(int index, String fecha, int id, int idArticulo, double total)
	{
		switch (index)
		{
		case 1:
			textFieldFecha1.setText(String.valueOf(fecha));
			textFieldId1.setText(String.valueOf(id));
			textFieldArticulo1.setText(String.valueOf(idArticulo));
			textFieldTotal1.setText(String.valueOf(total) + " €");
			break;
		case 2:
			textFieldFecha2.setText(String.valueOf(fecha));
			textFieldId2.setText(String.valueOf(id));
			textFieldArticulo2.setText(String.valueOf(idArticulo));
			textFieldTotal2.setText(String.valueOf(total) + " €");
			break;
		case 3:
			textFieldFecha3.setText(String.valueOf(fecha));
			textFieldId3.setText(String.valueOf(id));
			textFieldArticulo3.setText(String.valueOf(idArticulo));
			textFieldTotal3.setText(String.valueOf(total) + " €");
			break;
		case 4:
			textFieldFecha4.setText(String.valueOf(fecha));
			textFieldId4.setText(String.valueOf(id));
			textFieldArticulo4.setText(String.valueOf(idArticulo));
			textFieldTotal4.setText(String.valueOf(total) + " €");
			break;
		case 5:
			textFieldFecha5.setText(String.valueOf(fecha));
			textFieldId5.setText(String.valueOf(id));
			textFieldArticulo5.setText(String.valueOf(idArticulo));
			textFieldTotal5.setText(String.valueOf(total) + " €");
			break;
		case 6:
			textFieldFecha6.setText(String.valueOf(fecha));
			textFieldId6.setText(String.valueOf(id));
			textFieldArticulo6.setText(String.valueOf(idArticulo));
			textFieldTotal6.setText(String.valueOf(total) + " €");
			break;
		case 7:
			textFieldFecha7.setText(String.valueOf(fecha));
			textFieldId7.setText(String.valueOf(id));
			textFieldArticulo7.setText(String.valueOf(idArticulo));
			textFieldTotal7.setText(String.valueOf(total) + " €");
			break;
		}
	}
}