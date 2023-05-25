package domain;

import java.time.LocalDate;
import java.util.HashSet;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Builder
@Getter
@EqualsAndHashCode
public class Usuario {

	private String nome;
	private String email;
	private LocalDate dtNascimento;
	private HashSet<String> habilidades;

	public Usuario (final String nome, final String email, LocalDate dtNascimento, HashSet<String> habilidades) {
		UsuarioValidacao.validaNome(nome);
		UsuarioValidacao.validaEmail(email);
		UsuarioValidacao.validaIdade(dtNascimento);
		this.nome = nome;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.habilidades = habilidades;
	}
	
	public static UsuarioBuilder builder() {
		return new UsuarioValidacaoBuilder();
	}
	
	private static class UsuarioValidacaoBuilder extends UsuarioBuilder {
       
        public Usuario build() {
    		UsuarioValidacao.validaNome(super.nome);
    		UsuarioValidacao.validaEmail(super.email);
    		UsuarioValidacao.validaIdade(super.dtNascimento);
            return super.build();
        }
	}
        
}
