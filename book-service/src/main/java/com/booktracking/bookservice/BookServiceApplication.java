package com.booktracking.bookservice;

import com.booktracking.bookservice.model.Book;
import com.booktracking.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository repository;

	public BookServiceApplication(BookRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Dünyanın gözü", 2000 , "Robert Jordan", "Cengiz A. Mataracı", "ASA1A3434");
		Book book2 = new Book("Suç ve Ceza", 1866, "Dostoyevskı", "Fyodor Dostoyevski", "CGS1223A4");
		Book book3 = new Book("Istanbulun Gezegeni", 1920, "Ahmet Umit", "Ahmet Umit", "CGS1223A4");

		List<Book> books = repository.saveAll(Arrays.asList(book1, book2, book3));

		System.out.println(books);
	}
}
