package com.mrodrigochaves.bookshelf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mrodrigochaves.bookshelf.model.Books;
import com.mrodrigochaves.bookshelf.repository.BooksRepository;

@SpringBootApplication
public class JavaBookshelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBookshelfApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(BooksRepository booksRepository) {
		return args -> {
			booksRepository.deleteAll();

			Books bk = new Book();
			bk.setTitle("Meu livro");
			bk.setAuthor("José");
			bk.setDescription("Livro");
			bk.setPublished("01012001");

			booksRepository.save(bk);
		};
	}
}