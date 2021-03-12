package com.ponser2000.testjobbooks.model;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.model
 */
public class BookTo {

  String title;
  String description;
  String cover;

  public BookTo(String title, String description, String cover) {
    this.title = title;
    this.description = description;
    this.cover = cover;
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

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }
}