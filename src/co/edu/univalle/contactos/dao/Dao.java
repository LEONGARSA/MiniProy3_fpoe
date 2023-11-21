/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.univalle.contactos.dao;

import java.util.List;
import co.edu.univalle.contactos.model.Model;
import co.edu.univalle.contactos.vo.Contacto;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author LEONARDO
 */
public class Dao {
	private static Dao instance;
	private final List<Contacto> contactos = new ArrayList<Contacto>();
	
	private Dao() {}
	
	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}
	
	public List<Contacto> findAll() {
		return contactos;
	}

	public List<Contacto> findByIdentificacion(Long identificacion) {
		List<Contacto> filteredContactos = contactos.stream()  
				.filter(p ->p.getIdentificacion().longValue() == identificacion.longValue())  
				.collect(Collectors.toList());  
		
		return filteredContactos;
	}

	public void insert(Contacto contacto) {
		contactos.add(contacto);
	}

	public void delete(Long identificacion) {
		for (int i = 0; i < contactos.size(); i++) {
			Contacto contacto = contactos.get(i);
			if (contacto.getIdentificacion().longValue() == identificacion.longValue()) {
				contactos.remove(i);
				break;
			}
		}
		
	}
	
	public void update(Contacto contacto) {
		for (int i = 0; i < contactos.size(); i++) {
			Contacto contactoBd = contactos.get(i);
			if (contactoBd.getIdentificacion().longValue() == contacto.getIdentificacion().longValue()) {
				contactos.set(i, contacto);
				break;
			}
		}
	}
}