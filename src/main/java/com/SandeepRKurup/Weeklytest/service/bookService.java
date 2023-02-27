package com.SandeepRKurup.Weeklytest.service;

import com.SandeepRKurup.Weeklytest.model.Book;
import com.SandeepRKurup.Weeklytest.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class bookService {
    @Autowired
    bookRepository bookRepository;
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public String deleteBook(String bookId) {
        for (Book book : bookRepository.findAll()) {
            if (Objects.equals(book.getBook_Id(), Integer.valueOf(bookId))){
                bookRepository.delete(book);
                return "Deleted";
            }
        }
        return "Not found";
    }


    public String updateBook(Book newbook, String bookid) {

        for (Book book : bookRepository.findAll()) {
            if (Objects.equals(book.getBook_Id(), Integer.valueOf(bookid))){
                book.setDescription(newbook.getDescription());
                book.setAuthor(newbook.getAuthor());
                book.setTitle(newbook.getTitle());
                book.setPrice(newbook.getPrice());
                bookRepository.save(book);
                return "Updated";
            }
        }
        return "Not found";
    }
}

