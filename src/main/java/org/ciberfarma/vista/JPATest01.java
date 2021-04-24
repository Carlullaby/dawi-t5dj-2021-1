package org.ciberfarma.vista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ciberfarma.modelo.Usuario;



public class JPATest01 {

	public static void main(String[] args) {
		
		// Crear un objeto de Usuario a grabar
		Usuario u = new Usuario();
		u.setCodigo(6);
		u.setNombre("Eren");
		u.setApellido("Lopez");
		u.setUsuario("usuario3@ciber.com");
		u.setClave("123");
		u.setFnacim("2000/10/15");
		u.setTipo(1);
		u.setEstado(1);
		
		// grabar el objetod
		// 1. fabricar el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// 3. empezar mi transacción
		em.getTransaction().begin();
		// proceso a realizar (persistencia)
		//em.persist(u);  // merge si no encuentra un usuario con el codigo que 
		//le escribas, en este caso es 6, lo qu va a hacere es agregarlo, asi que este merge 
		//sirve para un registro como para una actualizacion
		em.merge(u);
		// 4. confirmar la transacción
		em.getTransaction().commit();
	}

}
