package com.mrodrigochaves.bookshelf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mrodrigochaves.bookshelf.model.Books;
import com.mrodrigochaves.bookshelf.repository.BooksRepository;

@Component
@SpringBootApplication
public class JavaBookshelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBookshelfApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(BooksRepository booksRepository) {
		return args -> {

			booksRepository.deleteAll();

			Books bk = new Books();
            bk.setTitle("Livro");
            bk.setAuthor("Marcio");
            bk.setDescription("Livro teste");
            bk.setPublished("20/01/2002");

            booksRepository.save(bk);

		

		};
	}
}