package com.system.service;

import com.system.model.Notice;
import com.system.model.User;
import com.system.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class NoticeServiceImp {

    @Autowired
    NoticeRepository noticeRepository;

    public List<Notice> fetchAll(){
        List<Notice> notices = noticeRepository.findAll();
        return notices;
    }

    public void createNotice(User user, String date, String message){
        Notice notice = new Notice();
        notice.setUser(user.getId());
        notice.setDate(date);

        notice.setMessage(message);
        noticeRepository.save(notice);


    }
}
