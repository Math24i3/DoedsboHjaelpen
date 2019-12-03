package com.system.service;

import com.system.model.Notice;
import com.system.model.User;
import com.system.repository.NoticeRepository;
import com.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class NoticeServiceImp {

    @Autowired
    NoticeRepository noticeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JdbcTemplate template;

    public List<Notice> fetchAll(){
        List<Notice> notices = noticeRepository.findAll();

       for (Notice n: notices
            ) {
           User user = userRepository.findById(n.getUser());
           n.setMessageOwner(user.getName());
           System.out.println(user.getName());


        }

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
