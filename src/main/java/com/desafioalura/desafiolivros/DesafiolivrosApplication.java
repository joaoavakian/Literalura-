package com.desafioalura.desafiolivros;

import com.desafioalura.desafiolivros.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafiolivrosApplication implements CommandLineRunner {
	private final Principal principal;

	@Autowired
	public DesafiolivrosApplication (Principal principal) {
		this.principal = principal;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(DesafiolivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.exibeMenu();
	}
}
