package paneles;

import javax.swing.JPanel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class PanelEliminar extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2246226314381975498L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	Panel1 panel1;
	
	public PanelEliminar(final java.sql.Connection conn)
	{
		setLayout(null);
		
		JLabel lblEliminarAlumno = new JLabel("Eliminar Alumno");
		lblEliminarAlumno.setBounds(169, 28, 124, 22);
		add(lblEliminarAlumno);
		
		JLabel lblEliminarPorCdula = new JLabel("Eliminar por Cédula");
		lblEliminarPorCdula.setBounds(39, 83, 148, 22);
		add(lblEliminarPorCdula);
		
		textField = new JTextField();
		textField.setBounds(205, 85, 139, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps = null;
				try
				{
					ps=  (PreparedStatement) conn.prepareStatement("delete from Alumno where Cedula="+textField.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Eliminación exitosa!!!");
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(205, 154, 117, 25);
		add(btnEliminar);
		
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
		btnVolver.setBounds(628, 502, 117, 25);
		add(btnVolver);

	}
}
