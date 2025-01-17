package com.example9.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example9.model.Author;
import com.example9.model.Book;
import com.example9.model.Publisher;
import com.example9.repository.AuthorRepository;
import com.example9.repository.BookRepository;
import com.example9.repository.PublisherRepository;
@Component
public class DevJpaBootStrap implements ApplicationListener<ContextRefreshedEvent> {


	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	private AuthorRepository authorRepository;
	
	
	public DevJpaBootStrap(BookRepository bookRepository, PublisherRepository publisherRepository,
			AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
		this.authorRepository = authorRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		Publisher publisher = new Publisher();
		publisher.setName("foo");
		publisher.setAddress("12th Street, LA");
		publisherRepository.save(publisher);

		// Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);

		// Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);

	}
}
