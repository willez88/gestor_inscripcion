package paneles;

import javax.swing.JPanel;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class PanelConsultar extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3625188812724587099L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	Panel1 panel1;
	JLabel label_2;
	JLabel label_3;
	JLabel label_4;
	JLabel label_5;
	JLabel label_6;
	JLabel label_7;
	
	public PanelConsultar(final java.sql.Connection conn)
	{
		setLayout(null);
		
		JLabel lblConsultarAlumno = new JLabel("Consultar Alumno");
		lblConsultarAlumno.setBounds(167, 20, 125, 22);
		add(lblConsultarAlumno);
		
		JLabel lblPorCedula = new JLabel("Por cédula");
		lblPorCedula.setBounds(39, 51, 91, 15);
		add(lblPorCedula);
		
		textField = new JTextField();
		textField.setBounds(142, 49, 114, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(39, 115, 70, 15);
		add(lblNombre);
		
		final JLabel lblNombre_1 = new JLabel("...");
		lblNombre_1.setBounds(119, 115, 137, 15);
		add(lblNombre_1);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(39, 142, 70, 15);
		add(lblApellido);
		
		final JLabel label = new JLabel("...");
		label.setBounds(119, 142, 137, 15);
		add(label);
		
		JLabel lblCdula = new JLabel("Cédula:");
		lblCdula.setBounds(39, 177, 70, 15);
		add(lblCdula);
		
		final JLabel label_1 = new JLabel("...");
		label_1.setBounds(119, 177, 137, 15);
		add(label_1);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					ResultSet consulta;
					Statement statement= (Statement) conn.createStatement();
					consulta= (ResultSet) statement.executeQuery("select Nombre,Apellido,Cedula,Edad,Peso,FechaNacimiento,Estatura,Grado,Enfermedades from Alumno where Cedula="+textField.getText());
					if(consulta.next())
					{
						lblNombre_1.setText(consulta.getString("Nombre"));
						label.setText(consulta.getString("Apellido"));
						label_1.setText(consulta.getString("Cedula"));
						label_2.setText(consulta.getString("Edad"));
						label_3.setText(consulta.getString("Peso"));
						label_4.setText(consulta.getString("FechaNacimiento"));
						label_5.setText(consulta.getString("Estatura"));
						label_6.setText(consulta.getString("Grado"));
						label_7.setText(consulta.getString("Enfermedades"));
						JOptionPane.showMessageDialog(null, "Consulta exitosa!!!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No existe el alumno.");
					}
					statement.close();
					consulta.close();
					//conn.close();
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error "+e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnConsultar.setBounds(288, 46, 117, 25);
		add(btnConsultar);
		
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
		btnVolver.setBounds(640, 510, 117, 25);
		add(btnVolver);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(482, 115, 51, 15);
		add(lblEdad);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(482, 142, 51, 15);
		add(lblPeso);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setToolTipText("Formato: Año-Mes-Día");
		lblFechaDeNacimiento.setBounds(373, 177, 160, 15);
		add(lblFechaDeNacimiento);
		
		label_2 = new JLabel("...");
		label_2.setBounds(545, 115, 130, 15);
		add(label_2);
		
		label_3 = new JLabel("...");
		label_3.setBounds(545, 142, 130, 15);
		add(label_3);
		
		label_4 = new JLabel("...");
		label_4.setBounds(545, 177, 130, 15);
		add(label_4);
		
		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setBounds(222, 235, 70, 15);
		add(lblEstatura);
		
		label_5 = new JLabel("...");
		label_5.setBounds(305, 235, 130, 15);
		add(label_5);
		
		JLabel lblGrado = new JLabel("Grado:");
		lblGrado.setBounds(222, 262, 70, 15);
		add(lblGrado);
		
		label_6 = new JLabel("...");
		label_6.setBounds(305, 262, 130, 15);
		add(label_6);
		
		JLabel lblEnfermedades = new JLabel("Enfermedades:");
		lblEnfermedades.setBounds(183, 289, 109, 15);
		add(lblEnfermedades);
		
		label_7 = new JLabel("...");
		label_7.setBounds(305, 289, 130, 15);
		add(label_7);
	}

}
