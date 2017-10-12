package paneles;

import java.sql.Connection;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Panel1 extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2945031567858921157L;
	/**
	 * Create the panel.
	 */
	private PanelAgregar panelagregar;
	private PanelConsultar panelconsultar;
	private PanelEliminar paneleliminar;
	private PanelActualizar panelactualizar;
	private PanelConsultaGeneral panelconsultageneral;
	
	public Panel1(final Connection conn)
	{
		setLayout(null);
		
		JButton btnIn = new JButton("Agregar alumno");
		btnIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelagregar= new PanelAgregar(conn);
				remove(getRootPane());
				getRootPane().setContentPane(panelagregar);
				panelagregar.setLayout(null);
				panelagregar.setSize(800, 600);
			}
		});
		btnIn.setBounds(148, 74, 168, 25);
		add(btnIn);
		
		JButton button = new JButton("Consultar alumno");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelconsultar= new PanelConsultar(conn);
				remove(getRootPane());
				getRootPane().setContentPane(panelconsultar);
				panelconsultar.setLayout(null);
				panelconsultar.setSize(800, 600);
			}
		});
		button.setBounds(148, 111, 168, 25);
		add(button);
		
		JButton button_1 = new JButton("Eliminar alumno");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paneleliminar= new PanelEliminar(conn);
				remove(getRootPane());
				getRootPane().setContentPane(paneleliminar);
				paneleliminar.setLayout(null);
				paneleliminar.setSize(800, 600);
			}
		});
		button_1.setBounds(148, 148, 168, 25);
		add(button_1);
		
		JButton btnActualizarDatosDe = new JButton("Actualizar Datos");
		btnActualizarDatosDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelactualizar= new PanelActualizar(conn);
				remove(getRootPane());
				getRootPane().setContentPane(panelactualizar);
				panelactualizar.setLayout(null);
				panelactualizar.setSize(800, 600);
			}
		});
		btnActualizarDatosDe.setBounds(148, 184, 168, 25);
		add(btnActualizarDatosDe);
		
		JLabel lblPantallaPrincipal = new JLabel("Pantalla Principal");
		lblPantallaPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPantallaPrincipal.setBounds(148, 26, 168, 25);
		add(lblPantallaPrincipal);
		
		JButton btnConsultaGeneral = new JButton("Consulta General");
		btnConsultaGeneral.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelconsultageneral= new PanelConsultaGeneral(conn);
				remove(getRootPane());
				getRootPane().setContentPane(panelconsultageneral);
				panelconsultageneral.setLayout(null);
				panelconsultageneral.setSize(800, 600);
			}
		});
		btnConsultaGeneral.setBounds(148, 214, 168, 25);
		add(btnConsultaGeneral);

	}
}
