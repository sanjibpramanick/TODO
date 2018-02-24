package com.interglobe.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.interglobe.test.entity.Note;

/**
 * 
 * @author Sanjib Pramanick
 *
 */
@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Note.class);
	}

	
}
