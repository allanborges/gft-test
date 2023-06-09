package domain.service;

import domain.DomainUsuarioException;
import domain.Usuario;
import domain.dto.UsuarioDTO;
import domain.repository.IUsuarioRepoPort;

public class UsuarioService implements IUsuarioServicePort {
	
	private IUsuarioRepoPort usuarioRepo;
	
	public UsuarioService(IUsuarioRepoPort usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public UsuarioDTO buscarUsuarioPorId(Long id) {
		Usuario usuario = usuarioRepo.buscarPorId(id).
				orElseThrow(() -> new DomainUsuarioException("Usuário não encontrado"));
		return new UsuarioDTO(id, 
				usuario.getNome(), 
				usuario.getEmail(), 
				usuario.getDtNascimento(), 
				usuario.getHabilidades());
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
		return null;
	}

}
