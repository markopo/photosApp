package com.marko.photosapp;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class FileUploadController {

    private String getUploadPath(String fileName) {
        var rootPath = new FileSystemResource("").getFile().getAbsolutePath();
        var path = Paths.get( rootPath, "/src/main/resources/uploads", fileName);
        return path.toString();
    }

    private String getUploadPath() {
        var rootPath = new FileSystemResource("").getFile().getAbsolutePath();
        var path = Paths.get( rootPath, "/src/main/resources/uploads");
        return path.toString();
    }
    @GetMapping("/fileupload")
    public Set<String> getFileUpload() {
        return Stream.of(new File(getUploadPath()).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    @PostMapping(value = "/fileupload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
    public String postFileUpload(@RequestParam("file") MultipartFile file) {

        if(file.isEmpty()) {
            throw new RuntimeException("Please load a file!");
        }

        var filename = file.getOriginalFilename();

        try {
            file.transferTo(new File(getUploadPath(filename)));
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Failure";
        }

        return "Success";
    }


}
