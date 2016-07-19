/**
 * 
 */
package com.tikal.codenote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

/**
 * @author Pniel
 *
 */
@Configuration
public class AppConfig {

	@Bean(name = "restTemplate")
	public RestTemplate RestTemplate() {
		return new RestTemplate();
	}

	@Bean(name = "gson")
	public Gson gson() {
		return new Gson();
	}

}
