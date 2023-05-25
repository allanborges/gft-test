package domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import domain.DomainUsuarioException;
import domain.Usuario;
import domain.dto.UsuarioDTO;
import domain.repository.IUsuarioRepoPort;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
	
	@Mock
	private IUsuarioRepoPort usuarioRepo;

	@InjectMocks
	private IUsuarioServicePort usuarioService = new UsuarioService();
	
	private static HashSet<String> habilidades;
	
	
	@BeforeAll
	public static void inicializaHabilidades() {
		habilidades = new HashSet<>();
		habilidades.add("programdor");
		habilidades.add("Jogador");
		habilidades.add("Cozinheiro");
	}
	
	@Test
	public void deveCadastrarUmUsuario() {
		UsuarioDTO usuarioDTO = new UsuarioDTO("teste", "joseinacio@gmail.com", LocalDate.now().plusYears(-18), habilidades);
		Usuario usuario = Usuario.builder().
				email(usuarioDTO.email()).
				dtNascimento(usuarioDTO.dtNascimento()).
				nome(usuarioDTO.nome()).
				build();
		usuarioService.cadastrarUsuario(usuarioDTO);
		verify(usuarioRepo, times(1)).salvar(usuario);
	}
	
	@Test
	public void deveTerUmEmailValido() {
		UsuarioDTO usuarioDTO = new UsuarioDTO("teste", "joséinacio@uol.com", LocalDate.now().plusYears(-18), habilidades);
		DomainUsuarioException exception = assertThrows(DomainUsuarioException.class, () -> usuarioService.cadastrarUsuario(usuarioDTO));
		assertEquals(exception.getMessage(), "Email Inválido.");
	}
	
	@Test
	public void naoDevePermitirMenoresDe18Anos() {
		UsuarioDTO usuarioDTO = new UsuarioDTO("teste", "teste@hotmail.com", LocalDate.now().plusYears(-15), habilidades);
		DomainUsuarioException illegalArgException = assertThrows(DomainUsuarioException.class, () -> usuarioService.cadastrarUsuario(usuarioDTO));
		assertEquals(illegalArgException.getMessage(), "Somente Maiores de 18 anos são permitidos.");
	}
	
	@Test
	public void naoDevePermitirCaracteresEspeciaisNoNome() {
		UsuarioDTO usuarioDTO = new UsuarioDTO("José Pereira#$#$", "teste@hotmail.com", LocalDate.now().plusYears(-18), habilidades);
		DomainUsuarioException illegalArgException = assertThrows(DomainUsuarioException.class, () -> usuarioService.cadastrarUsuario(usuarioDTO));
		assertEquals(illegalArgException.getMessage(), "O nome não pode conter caracteres especiais.");
	}
}
