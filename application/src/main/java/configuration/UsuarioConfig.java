package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import domain.service.IUsuarioServicePort;
import domain.service.UsuarioService;

@Configuration
public class UsuarioConfig {

	@Bean
    public IUsuarioServicePort usuarioService(){
        return new UsuarioService();
    }
}
