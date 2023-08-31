package edu.kosa.controller;

import edu.kosa.model.FileVO;
import edu.kosa.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Log4j2
@Controller
@RequestMapping(value = "")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileController {

    FileService fileService;

    private final ServletContext servletContext;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/uploadAjax")
    public String uploadAjax() {
        return "file/uploadAjax";
    }

    @PostMapping(value = "/uploadAjaxAction")
    @ResponseBody
    public ResponseEntity<?> uploadAjaxPost(@RequestPart MultipartFile[] uploadFile,
                                            @RequestPart(value = "info") FileVO fileVO) {

        log.info("fileVO: {}", fileVO);

        String uploadFolder = Paths.get(servletContext.getRealPath("/")).getParent().toString() + File.separator + "upload";
        File uploadDirectory = new File(uploadFolder);
        log.info("uploadPath: {}", uploadFolder);
        if (!uploadDirectory.exists()) {    // 업로드 디렉토리가 없을 경우 생성
            log.info("mkdir: {}", uploadDirectory.mkdirs());
        }

        log.info("uploadFile: {}", uploadFile);
        try {
            for (MultipartFile multipartFile : uploadFile) {
                String uploadFileName = multipartFile.getOriginalFilename();
                log.info("업로드 파일명: {}", uploadFileName);
                log.info("업로드 파일 크기: {}", multipartFile.getSize());

                uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf(File.separator) + 1);
                log.info("파일명: {}", uploadFileName);
                File saveFile = new File(uploadFolder, uploadFileName);
                multipartFile.transferTo(saveFile);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
