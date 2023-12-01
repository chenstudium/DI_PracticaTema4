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

public class AltaCompletadaArticulos extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	// Método principal que inicia el programa
	public static void main(String[] args)
	{
		try
		{
			// Mostrar la ventana al iniciarse el programa
			AltaCompletadaArticulos dialog = new AltaCompletadaArticulos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Constructor
	public AltaCompletadaArticulos()
	{
		setTitle("Programa de gestión - Artículos - Alta completada");
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

		JLabel lblTitulo = new JLabel("¡  A  L  T  A      C  O  M  P  L  E  T  A  D  A  !");
		lblTitulo.setForeground(new Color(176, 0, 176));
		lblTitulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTitulo.setBounds(50, 111, 340, 20);
		contentPanel.add(lblTitulo);

		JSeparator separadorHorizontal2 = new JSeparator();
		separadorHorizontal2.setBounds(0, 133, 434, 7);
		contentPanel.add(separadorHorizontal2);

		JButton cancelButton = new JButton("Nuevo alta");
		cancelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		cancelButton.setActionCommand("Cancel");
		cancelButton.setBounds(250, 165, 102, 23);
		cancelButton.addActionListener(new ActionListener()
		{
			// Al clicar en Nuevo alta, se abre la ventana AltaArticulo y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				AltaArticulo dig = new AltaArticulo();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		contentPanel.add(cancelButton);

		JButton okButton = new JButton("Aceptar");
		okButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		okButton.setBounds(85, 165, 102, 23);
		okButton.addActionListener(new ActionListener()
		{
			// Al clicar en Aceptar, se vuelve a abrir la ventana ConsultaArticulos y se cierra la actual
			public void actionPerformed(ActionEvent e)
			{
				ConsultaArticulos dig = new ConsultaArticulos();
				dig.setVisible(true);
				setVisible(false);
			}
		});
		contentPanel.add(okButton);

		JSeparator separadorHorizontal1 = new JSeparator();
		separadorHorizontal1.setBounds(0, 109, 434, 7);
		contentPanel.add(separadorHorizontal1);
	}
}