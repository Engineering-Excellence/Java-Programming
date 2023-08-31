package edu.kosa.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    // Upload file
    void uploadAjax(MultipartFile multipartFile, String uploadFolder);
}
