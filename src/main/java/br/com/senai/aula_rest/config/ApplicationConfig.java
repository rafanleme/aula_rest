package br.com.senai.aula_rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.senai.aula_rest.services.FilmeService;

public class ApplicationConfig extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<>();
		recursos.add(FilmeService.class);
		return recursos;
	}
	
}
