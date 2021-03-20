package com.ponser2000.testjobbooks.service;

import com.ponser2000.testjobbooks.model.Book;
import com.ponser2000.testjobbooks.model.BookTo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.service
 */
@Service
public class BookServiceImpl implements BookService {

  private static final Map<Integer, Book> BOOKS_REPOSITORY_MAP = new HashMap<>();
  private static final AtomicInteger BOOKS_ID_HOLDER = new AtomicInteger();

  @Override
  public void create(Book book) {
    final int bookId = BOOKS_ID_HOLDER.incrementAndGet();
    book.setId(bookId);
    BOOKS_REPOSITORY_MAP.put(bookId, book);
  }

  @Override
  public List<BookTo> readAll() {
    List<BookTo> result = new ArrayList<>();
    for (Book value : BOOKS_REPOSITORY_MAP.values()) {
      result.add(new BookTo(value.getTitle(), value.getDescription(),
          value.getFileUri()));
    }
    return result;
  }
}
