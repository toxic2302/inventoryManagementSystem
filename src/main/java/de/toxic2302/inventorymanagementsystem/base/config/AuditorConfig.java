package de.toxic2302.inventorymanagementsystem.base.config;

import de.toxic2302.inventorymanagementsystem.base.handler.AuditorAwareHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class AuditorConfig {

    // ---- Functions ----
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareHandler();
    }
}
