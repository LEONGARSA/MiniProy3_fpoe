/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.contactos.model;
import java.util.List;

import co.edu.univalle.contactos.dao.Dao;
import co.edu.univalle.contactos.vo.Contacto;

/**
 *
 * @author LEONARDO
 */
public class Model {
	private List<Contacto> contactos;
	private Contacto contacto;
	
	private Dao dao;
	
	public Model() {
		dao = Dao.getInstance();
		contacto = null;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Contacto save(Contacto contacto) {
		List<Contacto> filtered = dao.findByIdentificacion(contacto.getIdentificacion());
		
		if (filtered.size() > 0) {
			//El contacto con ese número de documento ya existe
			return null;
		} else {
			insert(contacto);
		}
		
		return contacto;
	}
	
	public void insert(Contacto contacto) {
		dao.insert(contacto);
	}

	public void delete(Long identificacion) {
		dao.delete(identificacion);
	}

	public void loadContacto(Long identificacion) {
		if (dao.findByIdentificacion(identificacion).size() > 0) {
			contacto = dao.findByIdentificacion(identificacion).get(0);
		}
	}
	
	public void findByIdentificacion(Long identificacion) {
		contactos = dao.findByIdentificacion(identificacion);
	}
	
	public void findAll() {
		contactos = dao.findAll();
	}

	public void update(Contacto contacto) {
		dao.update(contacto);
	}
}