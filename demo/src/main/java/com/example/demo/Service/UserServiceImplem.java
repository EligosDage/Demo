package com.example.demo.Service;

import com.example.demo.Models.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplem implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public void create(User user){
        userRepo.save(user);
    }

    @Override
    public List<User> readAll(){
       return userRepo.findAll();
    }

    @Override
    public User read(int id){
        return userRepo.getOne(id);
    }

    @Override
    public boolean update(User user, int id){
        if (userRepo.existsById(id)){
            user.setId(id);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id){
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
