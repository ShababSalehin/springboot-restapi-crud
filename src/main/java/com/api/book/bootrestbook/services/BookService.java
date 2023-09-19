package com.api.book.bootrestbook.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1, "Spring Boot Reference Book", "Shabab"));
    // list.add(new Book(2, "Spring Boot Reference Book2", "Shabab2"));
    // list.add(new Book(3, "Spring Boot Reference Book3", "Shabab3"));
    // list.add(new Book(4, "Spring Boot Reference Book4", "Shabab4"));
    // }

    // get all books
    public List<Book> getAllBooks() {
        // while using fake service there was just return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book
    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    // create book
    public Book addBook(Book book) {
        // list.add(book);
        Book result = bookRepository.save(book);
        // return book;
        return result;
    }

    // update book
    public void updateBook(Book book, int bookId) {
        // list = list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());

        book.setId(bookId);
        bookRepository.save(book);
    }

    // delete book
    public void deleteBook(int bid) {
        // list = list.stream().filter(book -> book.getId() !=
        // bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

}
