package domain;

import java.time.LocalDate;
import java.time.Period;

public class UsuarioValidacao {
	
	private static String REGEX_VALIDACAO_NOME = "^[\\p{L} ]+$";
	private static Integer IDADE_MINIMA_PERMITIDA = 18;
	private static String REGEX_VALIDACAO_EMAIL = "^[a-zA-Z0-9._%+-]+@(gmail|hotmail|outlook|yahoo)\\.(com|br|net)$";
	
	public static boolean validaNome(String nome) {
		if (nome.matches(REGEX_VALIDACAO_NOME)) 
			return true;
		throw new DomainUsuarioException("O nome não pode conter caracteres especiais.");			
	}
	
	public static boolean validaEmail(String nome) {
		if (nome.matches(REGEX_VALIDACAO_EMAIL)) 
			return true;
		throw new DomainUsuarioException("Email Inválido.");			
	}
	
	public static boolean validaIdade(LocalDate dtNascimento) {
		if (Period.between(dtNascimento, LocalDate.now()).getYears() >= IDADE_MINIMA_PERMITIDA) 
			return true;
		throw new DomainUsuarioException("Somente Maiores de 18 anos são permitidos.");			
	}

}
