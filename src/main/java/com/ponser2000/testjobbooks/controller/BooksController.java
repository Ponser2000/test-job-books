package com.ponser2000.testjobbooks.controller;

import com.ponser2000.testjobbooks.exception.FileStorageException;
import com.ponser2000.testjobbooks.model.Book;
import com.ponser2000.testjobbooks.model.BookTo;
import com.ponser2000.testjobbooks.model.ResultOperation;
import com.ponser2000.testjobbooks.service.BookService;
import com.ponser2000.testjobbooks.service.FileStorageService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.controller
 */
@RestController
public class BooksController {


  private final FileStorageService fileStorageService;

  private final BookService bookService;

  public BooksController(FileStorageService fileStorageService,
      BookService bookService) {
    this.fileStorageService = fileStorageService;
    this.bookService = bookService;
  }

  @PostMapping("/books/add")
  public ResponseEntity<ResultOperation> addNewBook(@RequestParam("title") String title,
      @RequestParam("description") String description, @RequestParam("cover") MultipartFile cover) {

    ResultOperation result = new ResultOperation();
    String fileDownloadUri;
    String fileName = "";
    try {
      fileName = fileStorageService.storeFile(cover);
      fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
          .path("/books/covers/").path(fileName).toUriString();
    } catch (FileStorageException ex) {
      result.setSuccess(false);
      return ResponseEntity.ok().body(result);
    }

    if (!title.equals("") && !description.equals("")) {
      bookService.create(new Book(title, description, fileDownloadUri));
      result.setSuccess(true);
    } else {
      result.setSuccess(false);
    }
    return ResponseEntity.ok().body(result);
  }

  @GetMapping("/books")
  public ResponseEntity<List<BookTo>> lisyAllBooks() {
    List<BookTo> result = bookService.readAll();
    return ResponseEntity.ok().body(result);
  }

}