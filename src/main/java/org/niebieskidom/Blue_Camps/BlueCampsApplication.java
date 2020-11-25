package org.niebieskidom.Blue_Camps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

@SpringBootApplication
public class BlueCampsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlueCampsApplication.class, args);
    }
//
//
//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean entityManagerFactoryBean
//                = new LocalEntityManagerFactoryBean();
//        entityManagerFactoryBean.setPersistenceUnitName("blueCamps");
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager jpaTransactionManager =
//                new JpaTransactionManager(emf);
//        return jpaTransactionManager;
//    }
//
//    @Bean(name = "localeResolver")
//    public LocaleContextResolver getLocaleContextResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
//        return localeResolver;
//    }
//
//    @Bean
//    public Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }

}

