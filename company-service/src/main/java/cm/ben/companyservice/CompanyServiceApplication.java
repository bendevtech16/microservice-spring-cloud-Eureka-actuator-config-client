package cm.ben.companyservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import cm.ben.companyservice.dao.CompanyRepository;
import cm.ben.companyservice.entities.Company;

@EnableDiscoveryClient // on importe le client eurekaDiscovry
@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner start(CompanyRepository companyRepository) {
		return args -> {
			companyRepository.save(new Company(null, "cs consulting", 100 + Math.random() * 2000));
			companyRepository.save(new Company(null, "bogenie sarl", 100 + Math.random() * 2000));
			companyRepository.save(new Company(null, "futuriste sarl", 100 + Math.random() * 2000));
			companyRepository.save(new Company(null, "batipro sarl", 100 + Math.random() * 2000));
			System.out.println("\n");
			companyRepository.findAll().forEach(System.out::println);
			System.out.println("-------------------------------------");

		};
	}

}
