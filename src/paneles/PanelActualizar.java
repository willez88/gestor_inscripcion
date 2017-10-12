package paneles;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class PanelActualizar extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4309752679602285442L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Panel1 panel1;
	JButton btnActualizar;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public PanelActualizar(final java.sql.Connection conn)
	{
		setLayout(null);
		
		JLabel lblActualizarDatosDe = new JLabel("Actualizar Datos de Alumno");
		lblActualizarDatosDe.setBounds(135, 23, 208, 23);
		add(lblActualizarDatosDe);
		
		JLabel lblBuscarAlumno = new JLabel("Buscar Alumno");
		lblBuscarAlumno.setBounds(26, 66, 112, 23);
		add(lblBuscarAlumno);
		
		textField = new JTextField();
		textField.setBounds(145, 68, 133, 19);
		add(textField);
		textField.setColumns(10);
		
		final JButton btnConsultar = new JButton("Consultar");
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
						textField_1.setText(consulta.getString("Nombre"));
						textField_2.setText(consulta.getString("Apellido"));
						textField_3.setText(consulta.getString("Cedula"));
						textField_4.setText(consulta.getString("Edad"));
						textField_5.setText(consulta.getString("Peso"));
						textField_6.setText(consulta.getString("FechaNacimiento"));
						textField_7.setText(consulta.getString("Estatura"));
						textField_8.setText(consulta.getString("Grado"));
						textField_9.setText(consulta.getString("Enfermedades"));
						
						JOptionPane.showMessageDialog(null, "Consulta exitosa!!!");
						btnActualizar.setEnabled(true);
						btnConsultar.setEnabled(false);
					}
					else
					{
						btnActualizar.setEnabled(false);
						btnConsultar.setEnabled(true);
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
		btnConsultar.setBounds(290, 65, 117, 25);
		add(btnConsultar);
		
		JLabel lblCamposModificablesPara = new JLabel("Campos Modificables para el Alumno");
		lblCamposModificablesPara.setBounds(61, 101, 282, 23);
		add(lblCamposModificablesPara);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 136, 70, 23);
		add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 136, 150, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(26, 155, 70, 15);
		add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 153, 150, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCdula = new JLabel("Cédula");
		lblCdula.setBounds(26, 171, 70, 15);
		add(lblCdula);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 171, 150, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel1= new Panel1(conn);
				remove(getRootPane());
				getRootPane().setContentPane(panel1);
				panel1.setLayout(null);
				panel1.setSize(800, 600);
			}
		});
		btnVolver.setBounds(651, 516, 117, 25);
		add(btnVolver);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		btnActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					PreparedStatement ps = null;
					ps = (PreparedStatement) conn.prepareStatement("update Alumno set Nombre='"+textField_1.getText()+"', Apellido='"+textField_2.getText()+"', Edad='"+textField_4.getText()+"', Peso='"+textField_5.getText()+"', FechaNacimiento='"+textField_6.getText()+"', Estatura='"+textField_7.getText()+"', Grado='"+textField_8.getText()+"', Enfermedades='"+textField_9.getText()+"' WHERE Cedula="+textField_3.getText()+";");
					if(ps.executeUpdate()== 1);
					{
						JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
					}
					//JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					btnConsultar.setEnabled(true);
					btnActualizar.setEnabled(false);
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error "+e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		btnActualizar.setBounds(92, 334, 117, 25);
		add(btnActualizar);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(412, 140, 42, 15);
		add(lblEdad);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(412, 155, 42, 15);
		add(lblPeso);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setToolTipText("Formato: Año-Mes-Día");
		lblFechaDeNacimiento.setBounds(298, 171, 156, 15);
		add(lblFechaDeNacimiento);
		
		textField_4 = new JTextField();
		textField_4.setBounds(455, 138, 133, 19);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(455, 153, 133, 19);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(455, 169, 133, 19);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEstatura = new JLabel("Estatura");
		lblEstatura.setBounds(68, 230, 70, 15);
		add(lblEstatura);
		
		JLabel lblGrado = new JLabel("Grado");
		lblGrado.setBounds(78, 257, 60, 15);
		add(lblGrado);
		
		JLabel lblEnfermedades = new JLabel("Enfermedades");
		lblEnfermedades.setBounds(26, 274, 112, 15);
		add(lblEnfermedades);
		
		textField_7 = new JTextField();
		textField_7.setBounds(148, 228, 130, 19);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(145, 272, 133, 19);
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(145, 252, 133, 19);
		add(textField_8);
		textField_8.setColumns(10);
	}
}
