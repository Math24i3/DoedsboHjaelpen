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

    public void saveFile(String address, MultipartFile file) {

        try {
            DBFile dbFile = new DBFile();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            dbFile.setData(byteObjects);
            dbFile.setName(file.getOriginalFilename());
            dbFile.setAddress(address);

            dbFileRepository.save(dbFile);
        } catch (IOException e) {
            //todo handle better
            e.printStackTrace();
        }
    }
}
