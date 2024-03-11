package com.example.dbdemo.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;
	@Value("${spring.jpa.hibernate.ddl-auto}")
    private String hbmAuto;

    @Value("${spring.jpa.show-sql}")
    private boolean showSQL;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private boolean formatSQL;

    @Value("${driver.class.name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${packages.to.scan}")
    private String packagesToScan;
	public Properties hibernateProperties() {
		Properties properties =new Properties();
		properties.put("hibernate.dialect", dialect);
		 properties.put("hibernate.hbm2ddl.auto", hbmAuto);
	        properties.put("hibernate.show_sql", showSQL);
	        properties.put("hibernate_format_sql", formatSQL);
	        return properties;
		
	}
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan(packagesToScan);
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
