package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantUsuario extends JFrame {

	private JPanel btnEliminar;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantUsuario frame = new FrmMantUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMantUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		btnEliminar = new JPanel();
		btnEliminar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btnEliminar);
		btnEliminar.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mantenimiento de Usuarios");
		lblNewLabel.setBounds(29, 11, 134, 14);
		btnEliminar.add(lblNewLabel);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(29, 38, 56, 14);
		btnEliminar.add(lblCodigo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 63, 62, 14);
		btnEliminar.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(29, 88, 62, 14);
		btnEliminar.add(lblApellido);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(29, 113, 62, 14);
		btnEliminar.add(lblUsuario);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(29, 138, 62, 14);
		btnEliminar.add(lblClave);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(29, 163, 69, 14);
		btnEliminar.add(lblFecha);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(29, 188, 62, 14);
		btnEliminar.add(lblTipo);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(29, 213, 62, 14);
		btnEliminar.add(lblEstado);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(114, 36, 86, 20);
		btnEliminar.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(114, 63, 121, 20);
		btnEliminar.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(114, 88, 121, 20);
		btnEliminar.add(txtApellido);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(114, 113, 86, 20);
		btnEliminar.add(txtUsuario);

		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(114, 138, 86, 20);
		btnEliminar.add(txtClave);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(114, 163, 86, 20);
		btnEliminar.add(txtFecha);

		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(114, 188, 86, 20);
		btnEliminar.add(txtTipo);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(114, 213, 86, 20);
		btnEliminar.add(txtEstado);

		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				registrar();
			}
		});
		btnNewButton.setBounds(298, 59, 100, 23);
		btnEliminar.add(btnNewButton);

		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(298, 109, 100, 23);
		btnEliminar.add(btnActualizar);

		JButton btnNewButton_2 = new JButton("ELIMINAR");
		btnNewButton_2.setBounds(298, 159, 100, 23);
		btnEliminar.add(btnNewButton_2);

		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(298, 204, 100, 23);
		btnEliminar.add(btnConsultar);
	}

	void consultar() {
		// abrir fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		// --------------------------------------------------

		// consulta  /System.out.println(u.getNombre()); debajo de usuario para que me de solo el nombre
		Usuario u = em.find(Usuario.class , 	Integer.parseInt(txtCodigo.getText()));
		if(u!= null){
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
		} else {
			JOptionPane.showMessageDialog(this, "Usuariocon codigo NO existe");
		}
		
		
		

		
		
		
		// cerrar
		em.close();
		fabrica.close();
	}

	void registrar() {
		// abrir fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// abrir el entitimanager
		EntityManager em = fabrica.createEntityManager();
		// --------------------------------------------------

		// obtencion de datos
		Usuario u = new Usuario();
		// u.setCodigo(6); // el codigo en tabla es autoincrement, por eso lo omito
		u.setNombre(txtNombre.getText());
		u.setApellido(txtApellido.getText());
		u.setUsuario(txtUsuario.getText());
		u.setClave(txtClave.getText());
		u.setFnacim(txtFecha.getText());
		u.setTipo(Integer.parseInt(txtTipo.getText())); // constraint default
		u.setEstado(Integer.parseInt(txtEstado.getText())); // constraint default
		// ---------------------------------------------------

		// llamar a la trnasaccion, en lugar de merge persis,
		// luego commi para confirmar transsacccion
		// 3. empezar mi transacción
		em.getTransaction().begin();
		em.persist(u);
		// 4. confirmar la transacción
		em.getTransaction().commit();
		// cerrar
		em.close();
		fabrica.close();
		
		
	}
}
