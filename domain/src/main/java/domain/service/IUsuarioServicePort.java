package domain.service;

import java.util.Optional;

import domain.dto.UsuarioDTO;

public interface IUsuarioServicePort {
	UsuarioDTO buscarUsuarioPorId(Long id);
	UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO);
	void deletarUsuarioPorId(Long id);
	UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO);
}
