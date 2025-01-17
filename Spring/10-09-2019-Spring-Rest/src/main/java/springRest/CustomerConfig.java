package springRest;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;
	

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "springRest")
public class CustomerConfig implements WebMvcConfigurer {
	
	
	@Bean
	public DataSource myDataSource()
	{
		
		ComboPooledDataSource myDataSource=new ComboPooledDataSource();
		myDataSource.setUser("root");
		try {
			myDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		myDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
		myDataSource.setPassword("admin");
		
		
		
		return myDataSource;
		
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setHibernateProperties(getProperties());
		sessionFactory.setPackagesToScan("springRest");
		return sessionFactory;
	}

	private Properties getProperties() {
		// TODO Auto-generated method stub
		
		Properties props=new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", "true");
		return props;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
	
	

}