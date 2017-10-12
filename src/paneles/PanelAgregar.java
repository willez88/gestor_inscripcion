package paneles;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import clases.Alumno;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregar extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -404784324619942948L;
	/**
	 * Create the panel.
	 */
	ResultSet resultado;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCedula;
	private Panel1 panel1;
	private JTextField textEdad;
	private JTextField textPeso;
	private JTextField textFechaNacimiento;
	private JTextField textEnfermedades;
	private JTextField textGrado;
	private JTextField textEstatura;
	private Alumno alumno;
	
	public PanelAgregar(final Connection conn)
	{
		setLayout(null);
		
		JLabel lblIns = new JLabel("Agregar alumno");
		lblIns.setBounds(150, 26, 124, 22);
		add(lblIns);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(87, 63, 70, 15);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(87, 90, 70, 15);
		add(lblApellido);
		
		JLabel lblCedula = new JLabel("Cédula");
		lblCedula.setBounds(87, 117, 70, 15);
		add(lblCedula);
		
		textNombre = new JTextField();
		textNombre.setBounds(170, 60, 114, 19);
		add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(170, 88, 114, 19);
		add(textApellido);
		textApellido.setColumns(10);
		
		textCedula = new JTextField();
		textCedula.setBounds(170, 115, 114, 19);
		add(textCedula);
		textCedula.setColumns(10);
		
		JButton btnRegistrarAlumno = new JButton("Registrar Alumno");
		btnRegistrarAlumno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					alumno= new Alumno();
					alumno.setNombre(textNombre.getText());
					alumno.setApellido(textApellido.getText());
					alumno.setCedula(Integer.parseInt(textCedula.getText()));
					alumno.setEdad(Integer.parseInt(textEdad.getText()));
					alumno.setPeso(Float.parseFloat(textPeso.getText()));
					alumno.setFechaNacimiento(textFechaNacimiento.getText());
					alumno.setEstatura(Float.parseFloat(textEstatura.getText()));
					alumno.setGrado(textGrado.getText());
					alumno.setEnfermedades(textEnfermedades.getText());
					
					Statement statement= (Statement) conn.createStatement();
					statement.execute("insert into Alumno values('"+alumno.getNombre()+"','"+alumno.getApellido()+"','"+alumno.getCedula()+"','"+alumno.getEdad()+"','"+alumno.getPeso()+"','"+alumno.getFechaNacimiento()+"','"+alumno.getEstatura()+"','"+alumno.getGrado()+"','"+alumno.getEnfermedades()+"')");
					statement.close();
					//conn.close();
					JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
					textNombre.setText("");
					textApellido.setText("");
					textCedula.setText("");
					textEdad.setText("");
					textPeso.setText("");
					textFechaNacimiento.setText("");
					textEstatura.setText("");
					textGrado.setText("");
					textEnfermedades.setText("");
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnRegistrarAlumno.setBounds(306, 326, 168, 25);
		add(btnRegistrarAlumno);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel1= new Panel1(conn);
				remove(getRootPane());
				getRootPane().setContentPane(panel1);
				panel1.setLayout(null);
				panel1.setSize(800, 600);
			}
		});
		btnVolver.setBounds(652, 521, 117, 25);
		add(btnVolver);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(507, 63, 70, 15);
		add(lblEdad);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(507, 90, 70, 15);
		add(lblPeso);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setToolTipText("Formato: Año-Mes-Día");
		lblFechaDeNacimiento.setBounds(420, 117, 157, 15);
		add(lblFechaDeNacimiento);
		
		textEdad = new JTextField();
		textEdad.setBounds(579, 61, 114, 19);
		add(textEdad);
		textEdad.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setBounds(579, 88, 114, 19);
		add(textPeso);
		textPeso.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(579, 115, 114, 19);
		add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		JLabel lblEstatura = new JLabel("Estatura");
		lblEstatura.setBounds(237, 167, 70, 15);
		add(lblEstatura);
		
		JLabel lblGrado = new JLabel("Grado");
		lblGrado.setBounds(247, 196, 53, 15);
		add(lblGrado);
		
		JLabel lblEnfermedades = new JLabel("Enfermedades");
		lblEnfermedades.setBounds(193, 223, 114, 15);
		add(lblEnfermedades);
		
		textEnfermedades = new JTextField();
		textEnfermedades.setBounds(309, 221, 114, 19);
		add(textEnfermedades);
		textEnfermedades.setColumns(10);
		
		textGrado = new JTextField();
		textGrado.setBounds(309, 194, 114, 19);
		add(textGrado);
		textGrado.setColumns(10);
		
		textEstatura = new JTextField();
		textEstatura.setBounds(309, 167, 114, 19);
		add(textEstatura);
		textEstatura.setColumns(10);
	}
}
