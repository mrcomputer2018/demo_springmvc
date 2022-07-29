package com.famadev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class DemoMvcApplication {

	public static void main(String[] args) { SpringApplication.run(DemoMvcApplication.class, args);	}

	// Setando para portugues brasil
	@Bean
	public LocaleResolver lccaleResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
