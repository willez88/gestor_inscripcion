package main;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import paneles.Panel1;
import javax.swing.SwingConstants;


public class Ventana extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Panel1 panel1;
	Connection conexion= null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana()
	{
		setTitle("Gestor de Inscripciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestor = new JLabel("Gestor de Inscripciones");
		lblGestor.setBounds(274, 25, 176, 24);
		contentPane.add(lblGestor);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(35, 118, 67, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(16, 144, 88, 15);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(103, 116, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConectarse = new JButton("Conectarse");
		btnConectarse.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try
				 {
					 //Class.forName("com.mysql.jdbc.Driver");
					 DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
					 conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Escuela",textField.getText(), passwordField.getText());
					 System.out.println("bien");
					 panel1= new Panel1(conexion);
					 remove(contentPane);
					 setContentPane(panel1);
					 panel1.setLayout(null);
					 panel1.setSize(800, 600);
					 JOptionPane.showMessageDialog(null, "Conexion exitosa!!!");
				 } catch (Exception e)
				 {
					 JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
				    e.printStackTrace();
				    System.out.println("error");
				 }
			}
		});
		btnConectarse.setBounds(103, 193, 117, 25);
		contentPane.add(btnConectarse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 143, 114, 16);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setToolTipText("Escuela Vicente Dávila, Milla, Mérida");
		label.setBounds(255, 108, 511, 438);
		ImageIcon fot= new ImageIcon(Ventana.class.getResource("/imagenes/escuela.jpg"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
		contentPane.add(label);
	}
}
