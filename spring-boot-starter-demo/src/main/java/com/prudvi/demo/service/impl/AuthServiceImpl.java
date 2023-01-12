package com.prudvi.demo.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import com.prudvi.demo.service.IAuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthServiceImpl implements IAuthService {
//    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
//        new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
//    }

	@Override
	public void logout(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, Authentication authentication) {
		// TODO Auto-generated method stub
		
	}
}
