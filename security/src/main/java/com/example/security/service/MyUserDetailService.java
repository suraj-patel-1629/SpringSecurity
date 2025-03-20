package com.example.security.service;

import com.example.security.model.User;
import com.example.security.model.UserPrinciple;
import com.example.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
      @Autowired
      private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User user = userRepo.findByUserName(userName);

        UserPrinciple userPrinciple = new UserPrinciple(user);
       if(user == null){
           System.out.println("User Not Found ");
           throw new UsernameNotFoundException("User Not Found ");
       }
       return userPrinciple;
    }
}
