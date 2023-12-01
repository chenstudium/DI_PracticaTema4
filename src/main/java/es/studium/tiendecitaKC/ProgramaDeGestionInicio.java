package es.studium.tiendecitaKC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ProgramaDeGestionInicio extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// Método principal que inicia el programa
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					// Mostrar la ventana al iniciarse el programa
					ProgramaDeGestionInicio frame = new ProgramaDeGestionInicio();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// Constructor
	public ProgramaDeGestionInicio()
	{
		setTitle("Programa de gestión - Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("Bienvenido al programa de gestión");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lbl1.setForeground(new Color(176, 0, 176));
		lbl1.setBounds(10, 37, 414, 71);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("Seleccione una opción para consultar");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lbl2.setForeground(new Color(176, 0, 176));
		lbl2.setBounds(84, 194, 267, 23);
		contentPane.add(lbl2);

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
		btnArticulos.setBounds(0, 119, 218, 30);
		contentPane.add(btnArticulos);

		JButton btnTickets = new JButton("Tickets");
		btnTickets.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
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
		btnTickets.setBounds(217, 119, 217, 30);
		contentPane.add(btnTickets);
	}
}