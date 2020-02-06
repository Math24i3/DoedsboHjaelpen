package com.system.controller;

import com.system.model.DBFile;
import com.system.repository.DBFileRepository;
import com.system.service.DBFileStorageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileController {

    @Autowired
    DBFileStorageService dbFileStorageService;

    @Autowired
    DBFileRepository dbFileRepository;

    @GetMapping("/saveImage")
    public String saveImage() {
        return "imageForm";
    }

    @PostMapping("/saveImage")
    public String handleImagePost(@RequestParam("imagefile") MultipartFile file, @RequestParam("address") String address) {

        dbFileStorageService.saveFile(address, file);

        return "redirect:/home";
    }

    @GetMapping("/image/{id}")
    public void getFile(@PathVariable String id, HttpServletResponse response) throws IOException {

        DBFile dbFile = dbFileRepository.getDBFileById(id);

        if (dbFile.getData() != null) {
            byte[] byteArray = new byte[dbFile.getData().length];
            int i = 0;

            for (Byte wrappedByte : dbFile.getData()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }

    }
}
