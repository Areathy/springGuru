package com.guru.springGuru.bootstrap;

import com.guru.springGuru.domain.Author;
import com.guru.springGuru.domain.Book;
import com.guru.springGuru.domain.Publisher;
import com.guru.springGuru.repositories.AuthorRepository;
import com.guru.springGuru.repositories.BookRepository;
import com.guru.springGuru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setAddress("No 2 John street");
        publisher.setCity("Lagos");
        publisher.setName("Emeka");
        publisher.setState("Kano");
        publisher.setZip("10005");

        publisherRepository.save(publisher);

        Author henrietha = new Author("Henrietha", "C.N");
        Book dummies = new Book("Programming for Dummies", "987654");
        henrietha.getBooks().add(dummies);
        dummies.getAuthors().add(henrietha);

        dummies.setPublisher(publisher);
        publisher.getBooks().add(dummies);

        authorRepository.save(henrietha);
        bookRepository.save(dummies);
        publisherRepository.save(publisher);

        Author fatima = new Author("Fatima", "Sule");
        Book excel = new Book("Stoop to conquer", "123456");
        fatima.getBooks().add(excel);
        excel.getAuthors().add(fatima);

        excel.setPublisher(publisher);
        publisher.getBooks().add(dummies);

        authorRepository.save(fatima);
        bookRepository.save(excel);
        publisherRepository.save(publisher);

        System.out.println("Started Bootstrap");
        System.out.println("Number of books" + bookRepository.count());
        System.out.println("publisher" + publisherRepository.count());
        System.out.println("number of publisher:" + publisher.getBooks().size());
    }
}
