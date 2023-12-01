package es.studium.tiendecitaKC;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class BajaCompletada extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	// Método principal que inicia el programa
	public static void main(String[] args)
	{
		try
		{
			// Mostrar la ventana al iniciarse el programa
			BajaCompletada dig = new BajaCompletada();
			dig.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dig.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Constructor
	public BajaCompletada()
	{
		setTitle("Programa de gestión - Artículos - Baja completada");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel contentPanel_1 = new JPanel();
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel_1.setBounds(0, 0, 434, 261);
		contentPanel.add(contentPanel_1);

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
		contentPanel_1.add(btnTickets);

		JButton btnArticulos = new JButton("Artículos");
		btnArticulos.setForeground(new Color(232, 116, 0));
		btnArticulos.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnArticulos.setBounds(0, 0, 218, 30);
		contentPanel_1.add(btnArticulos);

		JLabel lblTitulo = new JLabel("¡  B  A  J  A      C  O  M  P  L  E  T  A  D  A  !");
		lblTitulo.setForeground(new Color(176, 0, 176));
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setBounds(50, 111, 340, 20);
		contentPanel_1.add(lblTitulo);

		JSeparator separadorHorizontal2 = new JSeparator();
		separadorHorizontal2.setBounds(0, 133, 434, 11);
		contentPanel_1.add(separadorHorizontal2);

		JButton btnNuevaBaja = new JButton("Nueva baja");
		btnNuevaBaja.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Al clicar en Nueva baja, se abre la ventana BajaArticulo y se cierra la actual
				BajaArticulo dig = new BajaArticulo();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		btnNuevaBaja.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnNuevaBaja.setActionCommand("Cancel");
		btnNuevaBaja.setBounds(250, 165, 102, 23);
		contentPanel_1.add(btnNuevaBaja);

		JButton okButton = new JButton("Aceptar");
		okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Al clicar en Aceptar, se vuelve a abrir la ventana ConsultaArticulos y se cierra la actual
				ConsultaArticulos dig = new ConsultaArticulos();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		okButton.setBounds(85, 165, 102, 23);
		contentPanel_1.add(okButton);

		JSeparator separadorHorizontal1 = new JSeparator();
		separadorHorizontal1.setBounds(0, 109, 434, 11);
		contentPanel_1.add(separadorHorizontal1);
	}
}