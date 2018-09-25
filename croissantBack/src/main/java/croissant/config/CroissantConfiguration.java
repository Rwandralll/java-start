package croissant.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "croissant.source")
public abstract class CroissantConfiguration {}