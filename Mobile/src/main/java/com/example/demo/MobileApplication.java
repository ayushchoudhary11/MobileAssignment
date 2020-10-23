package com.example.demo;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mobile.dao.MobileDAO;
import com.mobile.model.Mobile;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class MobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(final MobileDAO repository) {

		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return args -> {
			repository.save(new Mobile(1, "Apple", 100000, format.parse("2016-01-01")));
			repository.save(new Mobile(2, "Samsung", 50000, format.parse("2020-06-01")));
			repository.save(new Mobile(3, "Vivo", 20000,  format.parse("2020-04-01")));
			repository.save(new Mobile(4, "Oppo", 15000, format.parse("2019-04-01")));
			repository.save(new Mobile(5, "Redmi", 12000, format.parse("2018-04-01")));
			repository.save(new Mobile(6, "Oneplus", 42000, format.parse("2017-01-01")));
			repository.save(new Mobile(6, "Oneplus", 42000, format.parse("2017-03-05")));
			repository.save(new Mobile(6, "Micromax", 22000, format.parse("2019-01-06")));
		};
	}

}
