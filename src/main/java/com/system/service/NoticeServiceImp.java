package com.system.service;

import com.system.model.Notice;
import com.system.model.User;
import com.system.repository.NoticeRepository;
import com.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImp {

    @Autowired
    NoticeRepository noticeRepository;

    @Autowired
    UserRepository userRepository;

    public List<Notice> fetchAll(){
        List<Notice> notices = noticeRepository.findAll();
        List<User> users = userRepository.findAll();
       for (Notice n: notices) {
           for (User u: users) {

               if (u.getId() == n.getUser())
               n.setMessageOwner(u.getName());
           }
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

    public void deleteNotice ()
}
