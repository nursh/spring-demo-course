package com.spring.democourse;

import com.spring.democourse.model.Author;
import com.spring.democourse.model.Book;
import com.spring.democourse.model.Publisher;
import com.spring.democourse.repositories.AuthorRepository;
import com.spring.democourse.repositories.BookRepository;
import com.spring.democourse.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private PublisherRepository pubRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent cfe) {
        initData();
    }

    public void initData() {
        Author john = new Author("John", "Thomas");
        Publisher johnPub = new Publisher("John Publishing", "32 John Street");
        Book life = new Book("1234", "The Life of John", johnPub);
        john.getBooks().add(life);
        life.getAuthors().add(john);

        authorRepo.save(john);
        pubRepo.save(johnPub);
        bookRepo.save(life);


        Author killian = new Author("Killian", "Bronn");
        Publisher bronnPub = new Publisher("Bronn Publishing", "50 Bronn Street");
        Book dragons = new Book("5678", "Flying with the beasts", bronnPub);
        killian.getBooks().add((dragons));

        authorRepo.save(killian);
        pubRepo.save(bronnPub);
        bookRepo.save(dragons);

    }
}
