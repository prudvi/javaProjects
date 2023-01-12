package com.prudvi.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prudvi.demo.entity.User;
import com.prudvi.demo.repository.IUserDAO;
import com.prudvi.demo.service.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserDetailsService, IUserService {

    private final IUserDAO iUserDAO;

    @Override
    public void updateStatusLoggedOut(String username) {
        User user =  iUserDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        user.setStatusLogin(false);
        iUserDAO.save(user);
    }

    @Override
    public UserDetails loadUserByUsernameAndStatusLoginTrue(String username) {
        return iUserDAO.findByUsernameAndStatusLoginTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }

    @Override
    public void updateStatusLogged(String username) {
        User user =  iUserDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        user.setStatusLogin(true);
        iUserDAO.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return iUserDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }
}
