package com.genie.restaurent.searchengine.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({"com.gogenie.restaurent.searchengine"})
public class SpringConfig {

	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}
	
	@Bean(name="gogenieDataSource")
	public DataSource getDataSource() {
		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
		jndi.setExpectedType(DataSource.class);
		jndi.setJndiName("java:comp/env/jdbc/MyGogenieDB");
		DataSource dataSource = (DataSource) jndi.getObject();
		return dataSource;
	}
	
	
}
