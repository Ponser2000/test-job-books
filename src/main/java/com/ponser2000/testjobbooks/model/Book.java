package com.ponser2000.testjobbooks.model;

import java.nio.file.Path;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.model
 */
public class Book {

  int id;
  String title;
  String description;
  String fileName;
  Path uploadDir;

  public Book(String title, String description, String fileName) {
    this.title = title;
    this.description = description;
    this.fileName = fileName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Path getUploadDir() {
    return uploadDir;
  }

  public void setUploadDir(Path uploadDir) {
    this.uploadDir = uploadDir;
  }
}
