package com.webservice.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.webservice.app.converters.UsuarioConverter;
import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;
import com.webservice.app.repositories.IUsuarioRepository;
import com.webservice.app.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService {

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioModel")
	private UsuarioConverter usuarioModel;

	public Usuario findByUsuario(String usuario) {
		return usuarioRepository.findByUsuario(usuario);
	}

	public Usuario findById(int id) {
		return usuarioRepository.findById(id);
	}

	public Usuario findByDni(long dni) {
		return usuarioRepository.findByDni(dni);
	}

	public UsuarioModel traerUsuario(int id) {

		return usuarioModel.entityToModel(usuarioRepository.findByIdRol(id));
	}

	public void altaUsuario(UsuarioModel usuario) throws Exception {
		try {
			Usuario user = usuarioModel.modelToEntity(usuario);
			usuarioRepository.save(user);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación,error al ingresar los datos o el usuario ya existe");
		}
	}

	public void bajaUsuario(int id) throws Exception {
		Usuario usuario = usuarioRepository.findById(id);
		usuario.setEnabled(false);
		try {
			usuarioRepository.saveAndFlush(usuario);
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public void modificacionUsuario(UsuarioModel usuario) throws Exception {
		try {
			usuarioRepository.saveAndFlush(usuarioModel.modelToEntity(usuario));
		} catch (Exception e) {
			throw new Exception("No se pudo completar la operación");
		}
	}

	public List<Usuario> findAll() {

		return usuarioRepository.findByEnabled();
	}

	// METODO PARA MOSTRAR UNA LISTA DE ELEMENTOS CON PAGINACION

	public Page<Usuario> findPaginated(Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}

	public UsuarioModel validarCredenciales(UsuarioModel usuario) throws Exception {
		try {
			UsuarioModel user = usuarioModel.entityToModel(usuarioRepository.validarCredenciales(usuario.getUsuario(),
					usuario.getUsuario(), DigestUtils.md5DigestAsHex(usuario.getClave().getBytes())));

			if (user.equals(null)) {
				throw new Exception("Usuario y Clave incorrectos");
			} else {
				return user;
			}
		} catch (Exception e) {

			throw new Exception("Usuario y Clave incorrectos");
		}
	}
}