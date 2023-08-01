package com.example.demo.bootstrap;


import com.example.demo.domain.Author;
import com.example.demo.domain.book;
import com.example.demo.domain.publisher;
import com.example.demo.repositories.AuthorRepo;
import com.example.demo.repositories.bookRepo;
import com.example.demo.repositories.publisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstarpdata implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final bookRepo bookRepo;
    private final publisherRepo publisherrepo;

    public bootstarpdata(AuthorRepo authorRepo, com.example.demo.repositories.bookRepo bookRepo, publisherRepo publisherrepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherrepo = publisherrepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ali = new Author("Ali","omar");
        book alibook = new book("aliskils","12345");
        ali.getBooks().add(alibook);
        alibook.getAuthors().add(ali);
        authorRepo.save(ali);
        bookRepo.save(alibook);

        Author omar = new Author("omar","ahmad");
        book omarbook = new book("omarhabits","12222");
        omar.getBooks().add(omarbook);
        omarbook.getAuthors().add(omar);
        authorRepo.save(omar);
        bookRepo.save(omarbook);

        System.out.println("the no of book is; "+bookRepo.count());
        publisher publisher1 = new publisher();
        publisher1.setName("aldaar");
        publisher1.setAddress("Riyadh");
        publisher1.getBookSet().add(omarbook);
        publisher1.getBookSet().add(alibook);
        publisherrepo.save(publisher1);

        System.out.println(publisher1.getName()+": no of books "+publisher1.getBookSet().size());

    }
}
