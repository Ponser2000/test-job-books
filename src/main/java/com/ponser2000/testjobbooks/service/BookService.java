package com.ponser2000.testjobbooks.service;

import com.ponser2000.testjobbooks.model.Book;
import com.ponser2000.testjobbooks.model.BookTo;
import java.util.List;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.service
 */
public interface BookService {

  List<BookTo> readAll();

  void create(Book book);

}