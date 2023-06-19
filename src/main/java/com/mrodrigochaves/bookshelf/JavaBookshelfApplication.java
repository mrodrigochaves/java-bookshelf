package com.mrodrigochaves.bookshelf;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

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

			Books bk = new Books();
			bk.setTitle("Livro");
			bk.setAuthor("Marcio");
			bk.setDescription("Livro teste");
			String publishedDate = "2020/01/02";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date published;
			try {
				published = dateFormat.parse(publishedDate);
				bk.setPublished(published);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			booksRepository.save(bk);

		

		};
	}
}