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

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;

public class ModificacionCompletada extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	// Método principal que inicia la programa
	public static void main(String[] args)
	{
		try
		{
			// Mostrar la ventana al iniciarse el programa
			ModificacionCompletada dig = new ModificacionCompletada();
			dig.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dig.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	// Constructor
	public ModificacionCompletada()
	{
		setTitle("Programa de gestión - Artículos - Modificación completada");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton btnNuevaModificacion = new JButton("Nueva modificación");
		btnNuevaModificacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnNuevaModificacion.setActionCommand("Cancel");
		btnNuevaModificacion.addActionListener(new ActionListener()
		{
			// Al clicar en Nueva modificación, se abre la ventana ModificacionArticulo y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				ModificacionArticulo dig = new ModificacionArticulo();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnNuevaModificacion.setBounds(250, 165, 144, 23);
		contentPanel.add(btnNuevaModificacion);

		JButton okButton = new JButton("Aceptar");
		okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener()
		{
			// Al clicar en Aceptar, se abre la ventana ConsultaArticulos y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				ConsultaArticulos dig = new ConsultaArticulos();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		okButton.setBounds(85, 165, 102, 23);
		contentPanel.add(okButton);

		JLabel lblTitulo = new JLabel("¡  M  O  D  I  F  I  C  A  C  I  Ó  N     C  O  M  P  L  E  T  A  D  A  !");
		lblTitulo.setForeground(new Color(176, 0, 176));
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblTitulo.setBounds(3, 111, 466, 20);
		contentPanel.add(lblTitulo);

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

		JSeparator separadorHorizontal1 = new JSeparator();
		separadorHorizontal1.setBounds(0, 132, 434, 8);
		contentPanel.add(separadorHorizontal1);

		JSeparator separadorHorizontal2 = new JSeparator();
		separadorHorizontal2.setBounds(0, 108, 434, 8);
		contentPanel.add(separadorHorizontal2);
	}
}