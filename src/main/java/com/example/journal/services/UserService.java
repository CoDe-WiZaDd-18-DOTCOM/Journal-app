package com.example.journal.services;

import com.example.journal.Entities.User;
import com.example.journal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository ucon;

    //    finding
    public User findbyusername(String username){
        User user = ucon.findByUserName(username);
        return user!=null?user:null;
    }

    public List<User> getall(){
        return ucon.findAll();
    }


    //    saving
    public User saveuser(User us){
        if(ucon.findByUserName(us.getUserName()) == null) {
            ucon.save(us);
            return us;
        }
        return null;
    }

    public User saveadmin(User us){
        User user = ucon.findByUserName(us.getUserName());
        if(user!=null) ucon.deleteByUserName(user.getUserName());
        List<String> roles = us.getRoles();
        roles.add("USER");
        roles.add("ADMIN");
        us.setRoles(roles);
        ucon.save(us);
        return us;
    }

    public User saveuserjournalentries(User us){
        return ucon.save(us);
    }

    //    update
    public User updateuser(String username,User us){
        User dbuser = ucon.findByUserName(username);
        if(dbuser != null) {
            dbuser.setUserName(us.getUserName()==null? username:us.getUserName());
            dbuser.setPassword(us.getPassword()==null? dbuser.getPassword():us.getPassword());
            ucon.save(dbuser);
            return us;
        }
        return null;
    }

    //    delete
    public String deleteuser(String username){
        User dbuser = ucon.findByUserName(username);
        if(dbuser != null) {
            ucon.delete(dbuser);
            return "True";
        }
        return "False";
    }

}