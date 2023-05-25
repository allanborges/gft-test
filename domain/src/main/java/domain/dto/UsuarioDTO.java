package domain.dto;

import java.time.LocalDate;
import java.util.HashSet;

public record UsuarioDTO (String nome, String email, LocalDate dtNascimento,  HashSet<String> habilidades) {}
