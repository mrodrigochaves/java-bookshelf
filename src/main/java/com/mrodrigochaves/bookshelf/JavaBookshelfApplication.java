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
	CommandLineRunner initDataBase(BooksRepository booksRepository){
		return args ->{
			booksRepository.deleteAll();
			
			Books bk = new Books();
			bk.setTitle("teste");
			bk.setAuthor("Marcio Rodrigo");
			bk.setDescription("Livro teste");
			bk.setPublished("01-01-2001");

			booksRepository.save(bk);

		};
	}

}
