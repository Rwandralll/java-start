package croissant.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hsqldb.properties" })
@Import(DBConfiguration.class)
public class HSQLDBConfiguration {

	@Autowired
	private Environment env;
	@Autowired
	private DBConfiguration dbConfiguration;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		return dbConfiguration.sessionFactory(this.env);
	}

	@Bean
	public DataSource dataSource() {
		return dbConfiguration.dataSource(this.env);
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
        return dbConfiguration.hibernateTransactionManager(sessionFactory());
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return dbConfiguration.exceptionTranslation();
	}
	
}