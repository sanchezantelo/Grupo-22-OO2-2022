package com.webservice.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.converters.UsuarioRolConverter;
import com.webservice.app.entities.UsuarioRol;
import com.webservice.app.models.UsuarioRolModel;
import com.webservice.app.repositories.IUsuarioRolRepository;
import com.webservice.app.services.IUsuarioRolService;

@Service("usuarioRolService")
public class UsuarioRolService implements IUsuarioRolService {

	@Autowired
	@Qualifier("usuarioRolRepository")
	private IUsuarioRolRepository usuarioRolRepository;

	@Autowired
	@Qualifier("usuarioRolModel")
	private UsuarioRolConverter usuarioRolModel;

	public UsuarioRol findByUsuarioRol(String usuarioRol) {
		return usuarioRolRepository.findByRol(usuarioRol);
	}

	public UsuarioRol findById(int id) {
		return usuarioRolRepository.findById(id);
	}

	public UsuarioRolModel traerUsuarioRol(int id) {

		return usuarioRolModel.entityToModel(usuarioRolRepository.findById(id));
	}

	public void altaUsuarioRol(UsuarioRolModel usuarioRol) throws Exception {
		try {
			UsuarioRol rol = usuarioRolModel.modelToEntity(usuarioRol);
			usuarioRolRepository.save(rol);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
		}
	}

	public void bajaUsuarioRol(int id) throws Exception {
		UsuarioRol usuarioRol = usuarioRolRepository.findById(id);
		usuarioRol.setEnabled(false);
		try {
			usuarioRolRepository.saveAndFlush(usuarioRol);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public void modificacionUsuarioRol(UsuarioRolModel usuarioRol) throws Exception {
		try {
			usuarioRolRepository.saveAndFlush(usuarioRolModel.modelToEntity(usuarioRol));
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public List<UsuarioRol> findAll() {

		return usuarioRolRepository.findByEnabled();
	}
}
