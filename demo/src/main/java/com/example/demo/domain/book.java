package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class book {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String title;
        private String isbn;

        @ManyToOne

        private publisher Publisher;
        @ManyToMany
        @JoinTable( name = "author_book" , joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
        private Set<Author> authors = new HashSet<>();

        public book(String title, String isbn) {
                this.title = title;
                this.isbn = isbn;
        }

        public book(){

        }

        public publisher getPublisher() {
                return Publisher;
        }

        public void setPublisher(publisher publisher) {
                Publisher = publisher;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getIsbn() {
                return isbn;
        }

        public void setIsbn(String isbn) {
                this.isbn = isbn;
        }

        public Set<Author> getAuthors() {
                return authors;
        }

        public void setAuthors(Set<Author> authors) {
                this.authors = authors;
        }
}
