package com.ponser2000.testjobbooks.controller;

import com.ponser2000.testjobbooks.model.Book;
import com.ponser2000.testjobbooks.model.BookTo;
import com.ponser2000.testjobbooks.model.ResultOperation;
import com.ponser2000.testjobbooks.service.BookService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.controller
 */
@RestController
public class BooksController {

  private final BookService bookService;

  public BooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("/books/add")
  public ResponseEntity<ResultOperation> addNewBook() {
    bookService.create(new Book("book1", "descr book 1", "book1.pdf"));
    bookService.create(new Book("book2", "descr book 2", "book2.pdf"));
    bookService.create(new Book("book3", "descr book 3", "book3.pdf"));
    bookService.create(new Book("book4", "descr book 4", "book4.pdf"));
    bookService.create(new Book("book5", "descr book 5", "book5.pdf"));
    ResultOperation result = new ResultOperation();
    result.setSuccess(true);
    return ResponseEntity.ok().body(result);
  }

  @GetMapping("/books")
  public ResponseEntity<List<BookTo>> lisyAllBooks() {
    List<BookTo> result = bookService.readAll();
    return ResponseEntity.ok().body(result);
  }

}