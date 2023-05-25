package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class UsuarioTest {
	
	
	private static  HashSet<String> habilidades;
	
	@BeforeAll
	public static void inicializaHabilidades() {
		habilidades = new HashSet<>();
		habilidades.add("programdor");
		habilidades.add("Jogador");
		habilidades.add("Cozinheiro");
	}
	
	@Test
	public void deveCriarUsuarioCommpleto() {
		Usuario usuario = new Usuario("teste", "joseinacio@gmail.com", LocalDate.now().plusYears(-18), habilidades);
		assertTrue(usuario != null);
	}
	
	@Test
	public void naoDevePermitirCaracteresEspeciaisNoNome() {
		DomainUsuarioException illegalArgException = assertThrows(DomainUsuarioException.class, () -> new Usuario("teste$#{}}$", "test@gmail.com", 
				LocalDate.now().plusYears(-18), habilidades));
		assertEquals(illegalArgException.getMessage(), "O nome não pode conter caracteres especiais.");
	}
	
	@ParameterizedTest(name = "{index} - {0} somente emails dos seguintes provedores são permitidos : Gmail. Hotmail e Yahoo")
	@ValueSource(strings = { "testé@gmail.com", "test2@uol.com.br", "teste3@terra.com.br" })
	public void deveSerUmEmailValido(String email) {
		DomainUsuarioException illegalArgException = assertThrows(DomainUsuarioException.class, () -> new Usuario("Jose Teste", email, LocalDate.now().plusYears(-18), 
				habilidades));
		assertEquals(illegalArgException.getMessage(), "Email Inválido.");
	}
	
	@Test
	public void naoDevePermitirMenoresDe18Anos() {
		DomainUsuarioException illegalArgException = assertThrows(DomainUsuarioException.class, () -> new Usuario("Jose Teste", "test@gmail.com", LocalDate.now().plusYears(-15),
				habilidades));
		assertEquals(illegalArgException.getMessage(), "Somente Maiores de 18 anos são permitidos.");
	}
	
	@Test
	public void deveTerUmaListaDeHabilidades() {
		Usuario usuario = new Usuario("teste", "joseinacio@gmail.com", LocalDate.now().plusYears(-18), habilidades);
		assertTrue(usuario != null);
		assertTrue(usuario.getHabilidades() != null);
		assertTrue(!usuario.getHabilidades().isEmpty());
	}

}
