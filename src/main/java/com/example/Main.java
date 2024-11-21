package com.example;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Main {

	@Autowired
	private Environment env;

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Main.class);

		// default port
		String port = "3000";

		// checking command line arguments
		DefaultApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		if (cliOpts.containsOption("port")) {
			port = cliOpts.getOptionValues("port").get(0);
		} else {
			// checking environment variable
			String envPort = System.getenv("PORT");
			if (envPort != null) {
				port = envPort;
			}
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		System.out.printf("Starting application on port %s\n", port);

		app.run(args);
	}

}
