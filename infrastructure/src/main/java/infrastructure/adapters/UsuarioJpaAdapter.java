package infrastructure.adapters;

import java.util.Optional;

import org.springframework.stereotype.Service;

import domain.Usuario;
import domain.repository.IUsuarioRepoPort;

@Service
public class UsuarioJpaAdapter implements IUsuarioRepoPort {

	@Override
	public Usuario salvar(Usuario usuario) {
		return null;
	}

	@Override
	public void deletar(Long id) {
	}

	@Override
	public Optional<Usuario> buscarPorId(Long usuario) {
		return null;
	}

}
