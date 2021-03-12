package com.ponser2000.testjobbooks.exception;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.exception
 */
public class FileStorageException extends RuntimeException {
  public FileStorageException(String message) {
    super(message);
  }

  public FileStorageException(String message, Throwable cause) {
    super(message, cause);
  }
}
