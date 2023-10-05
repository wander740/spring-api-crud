package com.wanderson.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wanderson.blog.model.Category;
import com.wanderson.blog.model.News;
import com.wanderson.blog.repository.CategoryRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Defaoult Server URL")})
@SpringBootApplication(scanBasePackages = "com.wanderson")
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CategoryRepository categoryRepository) {
		return args -> {
			categoryRepository.deleteAll();

			Category category = new Category();
			category.setTitle("Sports");

			Category category1 = new Category();
			category1.setTitle("news");

			News c = new News();
			c.setTitle("Teste um");
			c.setText("adfasdfsadfsadfsadf");
			c.setCategory(category);

			category.getNews().add(c);
			
			News c1 = new News();
			c1.setTitle("Teste dois");
			c1.setText("adfasdfsadfsafasdfaadfsadf");
			c1.setCategory(category1);

			category1.getNews().add(c1);

			categoryRepository.save(category);

			categoryRepository.save(category1);
		};
	}
}
