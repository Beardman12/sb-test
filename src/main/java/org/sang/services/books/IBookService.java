package org.sang.services.books;

import org.sang.models.Book;

import java.util.List;

public interface IBookService {
    int addBook(Book book);
    int updateBook(Book book);
    int deleteBookById(Integer id);
    Book getBookById(Integer id);
    List<Book> getAllBooks();
}
