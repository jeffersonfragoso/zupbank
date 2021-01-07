package br.com.jeffita.zupbank;

import br.com.jeffita.zupbank.controller.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"br.com.jeffita.zupbank.entity"})
public class ZupbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupbankApplication.class, args);
	}

}
