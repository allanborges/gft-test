package domain.repository;

import java.util.Optional;

import domain.Usuario;

public interface IUsuarioRepoPort {
	Usuario salvar(Usuario usuario);
	void deletar(Long id);
	Optional<Usuario> buscarPorId(Long usuario);
}
