package com.senla.javadbtask.configuration;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class HibernateConfiguration {

    @Value("${url}")
    private String databaseUrl;
    @Value("${name}")
    private String name;
    @Value("${password}")
    private String password;
    @Value("#{${hibernate}}")
    private Map<String, String> hibernateAdditionalPropertiesMap;

    @Bean
    public DataSource getDataSource(){ return new DriverManagerDataSource(databaseUrl, name, password); }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("com.senla.javadbtask.entity");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.setJpaPropertyMap(hibernateAdditionalPropertiesMap);
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return em;
    }

    @Bean
    public TransactionManager transactionManager() throws ClassNotFoundException {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean().getObject()));
    }

}
