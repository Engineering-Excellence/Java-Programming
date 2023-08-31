package edu.kosa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileServiceImpl implements FileService {

    @Override
    public void uploadAjax(MultipartFile multipartFile, String uploadFolder) {

        /*String uploadFileName = multipartFile.getOriginalFilename();
        log.info("업로드 파일명: {}", uploadFileName);
        log.info("업로드 파일 크기: {}", multipartFile.getSize());

        uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
        log.info("파일명: {}", uploadFileName);
        File saveFile = new File(uploadFolder, uploadFileName);
        multipartFile.transferTo(saveFile);*/
    }
}
