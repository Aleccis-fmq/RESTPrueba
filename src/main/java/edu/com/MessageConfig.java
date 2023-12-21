package edu.com;

import java.util.Locale;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig {

	//Cargar los archivos .properties
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource  rmMessage = new ReloadableResourceBundleMessageSource();
		
		rmMessage.setBasename("classpath:messages");
		return rmMessage;
	}
	
	//Estable el predeterminado , message.properties
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.ROOT);
		return slr;
	}
	
	//Conecta los .properties a los dtos. nombres.size
	@Bean
	public LocalValidatorFactoryBean getVa() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		
		bean.setValidationMessageSource(messageSource());
		return bean;
	}
}
