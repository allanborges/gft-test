package domain.service;

import java.util.Optional;

import domain.Usuario;
import domain.dto.UsuarioDTO;
import domain.repository.IUsuarioRepoPort;

public class UsuarioService implements IUsuarioServicePort {
	
	private IUsuarioRepoPort usuarioRepo;

	@Override
	public Optional<UsuarioDTO> buscarUsuarioPorId(Long id) {
		return null;
	}

	@Override
	public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = Usuario.builder().
			email(usuarioDTO.email()).
			dtNascimento(usuarioDTO.dtNascimento()).
			nome(usuarioDTO.nome()).
			build();
		usuarioRepo.salvar(usuario);
		return usuarioDTO;
	}

	@Override
	public void deletarUsuarioPorId(Long id) {
	}

	@Override
	public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
