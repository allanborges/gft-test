package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import domain.repository.IUsuarioRepoPort;
import domain.service.IUsuarioServicePort;
import domain.service.UsuarioService;
import infrastructure.adapters.UsuarioJpaAdapter;

@Configuration
public class UsuarioConfig {
	
	@Bean
    public IUsuarioRepoPort usuarioRepoPort(){
        return new UsuarioJpaAdapter();
    }

	@Bean
    public IUsuarioServicePort usuarioService(){
        return new UsuarioService(usuarioRepoPort());
    }
}
