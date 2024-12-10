package org.sang.mappers.books;

import org.apache.ibatis.annotations.Mapper;
import org.sang.models.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBookById(Book book);
    Book getBookById(Integer id);
    List<Book> getAllBooks();
}
