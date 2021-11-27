package com.demo.mpb.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.mpb.model.Rol;
import com.demo.mpb.model.Usuario;
import com.demo.mpb.repository.IRolRepository;
import com.demo.mpb.repository.IUsuarioRepository;
import com.demo.mpb.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService{

	@Autowired
	private IUsuarioRepository repository;
	
	@Autowired
	private IRolRepository repositoryRol;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void registrar(Usuario objeto) {
		String passwordBase64 = passwordEncoder.encode(objeto.getContrasenia());
		objeto.setContrasenia(passwordBase64);
		repository.save(objeto);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByNombreUsuario(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("El usuario no existe");
		}else {
			Usuario usuarioData = repository.findById(usuario.get().getUsuarioId()).get();
			Rol rol = repositoryRol.findById(usuarioData.getRol().getRolId()).get();
			Set<GrantedAuthority> ga = new HashSet<>();
			ga.add(new SimpleGrantedAuthority(rol.getDescripcion()));
			return new User(username,usuarioData.getContrasenia(),ga);
		}
	}

	@Override
	public void actualizar(Usuario objeto) {
		repository.save(objeto);	}

	@Override
	public void eliminar(Integer id) {
		repository.eliminar(id);
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) repository.findAll();
	}

}
