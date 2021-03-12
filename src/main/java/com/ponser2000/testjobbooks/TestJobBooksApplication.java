package com.ponser2000.testjobbooks;

import com.ponser2000.testjobbooks.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class TestJobBooksApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestJobBooksApplication.class, args);
  }

}
