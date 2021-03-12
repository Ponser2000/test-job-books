package com.ponser2000.testjobbooks.service;

import com.ponser2000.testjobbooks.exception.FileStorageException;
import com.ponser2000.testjobbooks.property.FileStorageProperties;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sergey Ponomarev on 12.03.2021
 * @project test-job-books/com.ponser2000.testjobbooks.controller
 */
@Service
public class FileStorageService {

  private final Path fileStorageLocation;

  @Autowired
  public FileStorageService(FileStorageProperties fileStorageProperties){
    this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

    try{
      Files.createDirectories(this.fileStorageLocation);
    } catch (Exception ex) {
      throw new FileStorageException("Что то не так с директорией");
    }
  }

  public String storeFile(MultipartFile file) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
      if(fileName.contains("..")) {
        throw new FileStorageException("Ошибка в пути " + fileName);
      }

      Path targetLocation = this.fileStorageLocation.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return fileName;
    } catch (IOException ex) {
      throw new FileStorageException("Невозможно сохранить " + fileName + ". Повторяем попытку!", ex);
    }
  }

}
