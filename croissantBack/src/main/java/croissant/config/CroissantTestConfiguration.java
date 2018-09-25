package croissant.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HSQLDBConfiguration.class)
@ComponentScan(basePackages = "croissant.source")
public class CroissantTestConfiguration {}