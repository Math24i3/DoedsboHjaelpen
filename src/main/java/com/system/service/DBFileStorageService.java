package com.system.service;


import com.system.model.DBFile;
import com.system.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class DBFileStorageService {


    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeImage(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());


        DBFile dbFile = null;
        try {
            dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return dbFileRepository.save(dbFile);

    }

    public DBFile storeImageFromPath(String path) throws IOException {


        File fileFromPath = new File(path);

        FileInputStream fis = new FileInputStream(fileFromPath);

        String filename = fileFromPath.getName();


        byte[] data = new byte[(int) fileFromPath.length()];

        fis.read(data);
        fis.close();

        DBFile dbFile = new DBFile(filename, data);

        System.out.println(data);

        return dbFileRepository.save(dbFile);

    }
}
