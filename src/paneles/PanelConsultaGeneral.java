package paneles;

import java.awt.Rectangle;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class PanelConsultaGeneral extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2843085108069348992L;
	/**
	 * Create the panel.
	 */
	JTextArea txtNombre;
	JTextArea txtApellido;
	JTextArea txtCedula;
	JTextArea txtEdad;
	JTextArea txtPeso;
	JTextArea txtFechaNacimiento;
	JTextArea txtEstatura;
	JTextArea txtGrado;
	JTextArea txtEnfermedades;
	private JScrollPane scroll;
	private JScrollPane scroll2;
	private JScrollPane scroll3;
	private JScrollPane scroll4;
	private JScrollPane scroll5;
	private JScrollPane scroll6;
	private JScrollPane scroll7;
	private JScrollPane scroll8;
	private JScrollPane scroll9;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCdula;
	private JButton btnVolver;
	private JPanel panel1;
	private JLabel lblEdad;
	private JLabel lblPeso;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblEstatura;
	private JLabel lblGrado;
	private JLabel lblEnfermedades;
	
	public PanelConsultaGeneral(final java.sql.Connection conn)
	{
		setLayout(null);
		JLabel lblConsultaGeneralDe = new JLabel("Consulta General de Alumnos");
		lblConsultaGeneralDe.setBounds(115, 23, 227, 23);
		add(lblConsultaGeneralDe);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					ResultSet consulta;
					Statement statement= (Statement) conn.createStatement();
					consulta= (ResultSet) statement.executeQuery("select * from Alumno");
					txtNombre.setText("");
					txtApellido.setText("");
					txtCedula.setText("");
					txtEdad.setText("");
					txtPeso.setText("");
					txtFechaNacimiento.setText("");
					txtEstatura.setText("");
					txtGrado.setText("");
					txtEnfermedades.setText("");
					while(consulta.next())
					{
						txtNombre.append(consulta.getString("Nombre")+"\n");
						txtApellido.append(consulta.getString("Apellido")+"\n");
						txtCedula.append(consulta.getString("Cedula")+"\n");
						txtEdad.append(consulta.getString("Edad")+"\n");
						txtPeso.append(consulta.getString("Peso")+"\n");
						txtFechaNacimiento.append(consulta.getString("FechaNacimiento")+"\n");
						txtEstatura.append(consulta.getString("Estatura")+"\n");
						txtGrado.append(consulta.getString("Grado")+"\n");
						txtEnfermedades.append(consulta.getString("Enfermedades")+"\n");
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
		btnConsultar.setBounds(164, 55, 117, 25);
		add(btnConsultar);
		
		txtNombre = new JTextArea();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(30, 90, 117, 160);
		add(txtNombre);
		
		scroll = new JScrollPane(txtNombre);
		scroll.setBounds(new Rectangle(30, 90, 117, 160));
		add(scroll);
		
		txtApellido = new JTextArea();
		txtApellido.setEnabled(false);
		txtApellido.setBounds(170, 90, 117, 160);
		add(txtApellido);
		
		scroll2 = new JScrollPane(txtApellido);
		scroll2.setBounds(new Rectangle(170, 90, 117, 160));
		add(scroll2);
		
		txtCedula = new JTextArea();
		txtCedula.setEnabled(false);
		txtCedula.setBounds(310, 90, 117, 160);
		add(txtCedula);
		
		scroll3 = new JScrollPane(txtCedula);
		scroll3.setBounds(new Rectangle(310, 90, 117, 160));
		add(scroll3);
		
		txtEdad = new JTextArea();
		txtEdad.setEnabled(false);
		txtEdad.setBounds(450, 90, 117, 160);
		add(txtEdad);
		
		scroll4 = new JScrollPane(txtEdad);
		scroll4.setBounds(new Rectangle(450, 90, 117, 160));
		add(scroll4);
		
		txtPeso = new JTextArea();
		txtPeso.setEnabled(false);
		txtPeso.setBounds(590, 90, 117, 160);
		add(txtPeso);
		
		scroll5 = new JScrollPane(txtPeso);
		scroll5.setBounds(new Rectangle(590, 90, 117, 160));
		add(scroll5);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		scroll5.setColumnHeaderView(lblPeso);
		
		txtFechaNacimiento = new JTextArea();
		txtFechaNacimiento.setEnabled(false);
		txtFechaNacimiento.setBounds(30, 280, 155, 160);
		add(txtFechaNacimiento);
				
		scroll6 = new JScrollPane(txtFechaNacimiento);
		scroll6.setBounds(new Rectangle(30, 280, 155, 160));
		add(scroll6);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		scroll6.setColumnHeaderView(lblFechaDeNacimiento);
		
		txtEstatura = new JTextArea();
		txtEstatura.setEnabled(false);
		txtEstatura.setBounds(220, 280, 117, 160);
		add(txtEstatura);
				
		scroll7 = new JScrollPane(txtEstatura);
		scroll7.setBounds(new Rectangle(220, 280, 117, 160));
		add(scroll7);
		
		lblEstatura = new JLabel("Estatura");
		lblEstatura.setHorizontalAlignment(SwingConstants.CENTER);
		scroll7.setColumnHeaderView(lblEstatura);
		
		txtGrado = new JTextArea();
		txtGrado.setEnabled(false);
		txtGrado.setBounds(370, 280, 117, 160);
		add(txtGrado);
				
		scroll8 = new JScrollPane(txtGrado);
		scroll8.setBounds(new Rectangle(370, 280, 117, 160));
		add(scroll8);
		
		lblGrado = new JLabel("Grado");
		lblGrado.setHorizontalAlignment(SwingConstants.CENTER);
		scroll8.setColumnHeaderView(lblGrado);
		
		/************************************************/
		txtEnfermedades = new JTextArea();
		txtEnfermedades.setEnabled(false);
		txtEnfermedades.setBounds(520, 280, 117, 160);
		add(txtEnfermedades);

		scroll9 = new JScrollPane(txtEnfermedades);
		scroll9.setBounds(new Rectangle(520, 280, 117, 160));
		add(scroll9);
		
		lblEnfermedades = new JLabel("Enfermedades");
		lblEnfermedades.setHorizontalAlignment(SwingConstants.CENTER);
		scroll9.setColumnHeaderView(lblEnfermedades);
		/**************************************************/
		
		lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		scroll4.setColumnHeaderView(lblEdad);
		
		lblCdula = new JLabel("Cédula");
		lblCdula.setHorizontalAlignment(SwingConstants.CENTER);
		scroll3.setColumnHeaderView(lblCdula);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		scroll2.setColumnHeaderView(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		scroll.setColumnHeaderView(lblNombre);
		
		btnVolver = new JButton("Volver");
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
		btnVolver.setBounds(641, 486, 117, 25);
		add(btnVolver);
	}
}
