package com.example.demo.controllers;

import com.example.demo.domain.Author;
import com.example.demo.domain.book;
import com.example.demo.domain.publisher;
import com.example.demo.repositories.AuthorRepo;
import com.example.demo.repositories.bookRepo;
import com.example.demo.repositories.publisherRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Set;

@RestController
@Controller
public class bookController {
    private final AuthorRepo authorRepo;
    private final bookRepo bookRepo;
    private final publisherRepo publisherrepo;

    public bookController(AuthorRepo authorRepo, com.example.demo.repositories.bookRepo bookRepo, publisherRepo publisherrepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherrepo = publisherrepo;
    }



    @GetMapping({"/,/index,/meanu"})
    public String getMeanue(){

        return "index.html";
    }

    @GetMapping("/BooksList")
        public String getBooks(Model model ) {
        model.addAttribute("books", bookRepo.findAll());
        return "BooksList.html";
    }

    @PostMapping ("/BooksList")
    public String postbook(@RequestParam Map<String, String> body, HttpServletRequest request){

        String title = body.get("title");
        String isbn = body.get("isbn");
        String publisher = body.get("publisher");
        String fname = body.get("fname");
        String lastName = body.get("lname");
        Author newAuthor = new Author(fname,lastName);
        publisher newpublisher = new publisher();
        newpublisher.setName(publisher);
        book newbook = new book(title,isbn);
        newbook.setPublisher(newpublisher);
        newbook.getAuthors().clear();
        newbook.getAuthors().add(newAuthor);
        newAuthor.getBooks().add(newbook);

        authorRepo.save(newAuthor);
        publisherrepo.save(newpublisher);
        bookRepo.save(newbook);
        return "redirect:/BooksList";
    }

    @GetMapping("addbook")
    public String addbook(){

        return "AddBook.html";
    }


    @GetMapping("/deletebook{id}")
    public String deleteBook(@PathVariable Long id){

        book deletedBook = bookRepo.findById(id).get();

        publisher theBookPuplisher = deletedBook.getPublisher();
        theBookPuplisher.getBookSet().remove(deletedBook);
        Set<Author> TheBookAuthor = deletedBook.getAuthors();
        for (Author author:TheBookAuthor) {
            author.getBooks().remove(deletedBook);
        }



        bookRepo.delete(deletedBook);
        System.out.println(deletedBook.toString());
        return "redirect:/BooksList";
    }
    @GetMapping("/updatebook{id}")
    public String update(@PathVariable Long id , Model model){

        book updatedbook = bookRepo.findById(id).get();
        model.addAttribute("book",updatedbook);
        return "UpdateBook.html";
    }




    @PostMapping ("/updatebook")
    public String postupdatebook(@RequestParam Map<String, String> body, Model model){
        System.out.println(body.keySet().toString());
        long id = Long.parseLong(body.get("id"));
        String title = body.get("title");
        String isbn = body.get("isbn");
        String publisher = body.get("publisher");
        String fname = body.get("fname");
        String lastName = body.get("lname");
        Author newAuthor = new Author(fname,lastName);
        publisher newpublisher = new publisher();
        newpublisher.setName(publisher);

        book newbook = bookRepo.findById(id).get();
        newbook.setTitle(title);
        newbook.setId(id);
        newbook.setIsbn(isbn);
        newbook.setPublisher(newpublisher);
        newbook.getAuthors().clear();
        newbook.getAuthors().add(newAuthor);
        newAuthor.getBooks().add(newbook);


        model.addAttribute("books",bookRepo.findAll());
        return "BooksList.html" ;
    }



    @GetMapping("AuthorsList")

    public String geAuthors(Model model){

        model.addAttribute("Authors",authorRepo.findAll());
        System.out.println(authorRepo.findAll().toString());

        return "AuthorsList";

    }


    @GetMapping("/PublishersList")
    public String getPublishersList(Model model){

        model.addAttribute("publishers",publisherrepo.findAll());
        System.out.println(publisherrepo.findAll().toString());
        return "PublishersList";

    }

}
